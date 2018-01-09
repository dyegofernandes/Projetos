package com.opfacil.bo.pagamento;

import com.opfacil.VOs.EmpresaInforAdicionaisVO;
import com.opfacil.VOs.FiltroDeBusca;
import com.opfacil.VOs.PagamentoVO;
import com.opfacil.bo.email.ConfiguracaoEmailBO;
import com.opfacil.bo.email.EmailBO;
import com.opfacil.dao.cadastro.EmpresaDAO;
import com.opfacil.dao.controleacesso.UsuarioDAO;
import com.opfacil.dao.documento.ArquivoDAO;
import com.opfacil.dao.documento.DownloadArquivosDAO;
import com.xpert.core.crud.AbstractBusinessObject;
import com.opfacil.dao.pagamento.PagamentoDAO;
import com.opfacil.modelo.arquivoBanco.ConstruirTxt;
import com.opfacil.modelo.arquivoBanco.Detalhe;
import com.opfacil.modelo.arquivoBanco.DetalheItem;
import com.opfacil.modelo.arquivoBanco.HeaderArquivo;
import com.opfacil.modelo.arquivoBanco.HeaderLote;
import com.opfacil.modelo.arquivoBanco.TrailerArquivo;
import com.opfacil.modelo.arquivoBanco.TrailerLote;
import com.opfacil.modelo.cadastro.Empresa;
import com.opfacil.modelo.cadastro.Funcionario;
import com.opfacil.modelo.cadastro.MotivoPagamento;
import com.opfacil.modelo.cadastro.Uf;
import com.opfacil.modelo.controleacesso.Usuario;
import com.opfacil.modelo.documentos.Arquivo;
import com.opfacil.modelo.documentos.DownloadArquivos;
import com.opfacil.modelo.email.Attachment;
import com.opfacil.modelo.enums.SituacaoOp;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.opfacil.modelo.pagamento.Pagamento;
import com.opfacil.util.SessaoUtils;
import com.xpert.persistence.query.QueryBuilder;
import com.xpert.persistence.query.Restrictions;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.activation.DataSource;
import javax.mail.util.ByteArrayDataSource;
import javax.persistence.TemporalType;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class PagamentoBO extends AbstractBusinessObject<Pagamento> {

    @EJB
    private PagamentoDAO pagamentoDAO;

    @EJB
    private EmpresaDAO empresaDAO;

    @EJB
    private EmailBO emailBO;

    @EJB
    private ConfiguracaoEmailBO configuracao;

    @EJB
    private UsuarioDAO usuarioDAO;

    @EJB
    private DownloadArquivosDAO downloadArquivoDAO;

    @EJB
    private ArquivoDAO arquivoDAO;

    @Override
    public PagamentoDAO getDAO() {
        return pagamentoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Pagamento pagamento) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Pagamento> listPagamentos(FiltroDeBusca filtros) {

        List<Pagamento> pagamentos;
        QueryBuilder builder = pagamentoDAO.getQueryBuilder();

        builder.select("p").from(Pagamento.class, "p").leftJoinFetch("p.empresa", "e").leftJoinFetch("p.funcionario", "f").leftJoinFetch("p.usuario", "u")
                .leftJoinFetch("p.motivoPagamento", "mp").leftJoinFetch("p.lote", "l");

        if (filtros.getEmpresa() != null) {
            builder.equals("e", filtros.getEmpresa());
        } else {
            Empresa empresa = pagamentoDAO.getInitialized(filtros.getUsuario().getEmpresa());
            builder.equals("e", empresa);
        }

        if (filtros.getFuncionario() != null) {
            builder.equals("f", filtros.getFuncionario());
        }

        if (filtros.getMotivo() != null) {
            builder.equals("mp", filtros.getMotivo());
        }

        if (filtros.getCpf() != null) {
            if (!filtros.getCpf().equals("")) {
                builder.equals("f.cpf", filtros.getCpf());
            }
        }

        if (filtros.getNome() != null) {
            if (!filtros.getNome().equals("")) {
                builder.like("f.nome", filtros.getNome());
            }
        }

        if (filtros.getDataInicial() != null) {
            builder.greaterEqualsThan("p.dtPagamento", filtros.getDataInicial(), TemporalType.TIMESTAMP);
        }

        if (filtros.getDataFinal() != null) {
            builder.lessEqualsThan("p.dtPagamento", filtros.getDataFinal(), TemporalType.TIMESTAMP);
        }

        if (filtros.getSituacao() != null) {
            builder.equals("p.situacao", filtros.getSituacao());
        }

        if (filtros.getNumOp() != null) {
            if (!filtros.getNumOp().equals("")) {
                builder.equals("p.op", filtros.getNumOp());
            }
        }

        if (filtros.getLote() != null) {
            builder.equals("l", filtros.getLote());
        }

        pagamentos = builder.orderBy("p.situacao DESC").getResultList();

        return pagamentos;

    }

    public List<PagamentoVO> getPagamentosRealizados(FiltroDeBusca filtros) {

        return pagamentoDAO.getPagamentosRealizados(filtros);
    }

    public List<Pagamento> listarPagamentosPorSituacao(Usuario usuario, Empresa empresa, Date dataInicial, Date dataFinal, SituacaoOp situacao) {

        Usuario usuarioInicializado = null;
        if (usuario != null) {
            usuarioInicializado = pagamentoDAO.getInitialized(usuario);
        }
        Empresa empresaInicializado = null;
        if (empresa != null) {
            empresaInicializado = pagamentoDAO.getInitialized(empresa);
        }

        return pagamentoDAO.listarPagamentosPorStatus(usuarioInicializado != null ? usuarioInicializado.getId() : null,
                empresaInicializado != null ? empresaInicializado.getId() : null, dataInicial, dataFinal, situacao);

    }

    public void gerarPagamento(List<Pagamento> pagamentos) throws IOException, BusinessException {
        BigDecimal valorTotalPagamentos = BigDecimal.ZERO;

        String corpo = "";
        Usuario usuario = pagamentoDAO.getInitialized(SessaoUtils.getUser());
        Empresa empresa = pagamentoDAO.getInitialized(usuario.getEmpresa());
        EmpresaInforAdicionaisVO empresaInfAdicionais = empresaDAO.listarInformacoesAdicEmpresa(Integer.valueOf(empresa.getCdBanco()));
        Long seqArquivo = ((Long) pagamentoDAO.getQueryBuilder().from(DownloadArquivos.class).max("id", 0)) + 1;

        ConstruirTxt builder = new ConstruirTxt();
        HeaderArquivo hA = new HeaderArquivo();
        HeaderLote hL = new HeaderLote();
        TrailerLote tL = new TrailerLote();
        TrailerArquivo tA = new TrailerArquivo();

        hA.setCampo1_0(empresa.getCdBanco());//Código do Convenio Fornecido pelo Pag Contas esse numero esta em empresa e usuario
        hA.setCampo2_0("0"); // Lote ver como gera = 0000
        hA.setCampo3_0("0");
        hA.setCampo4_0("");
        hA.setCampo5_0("2");
        hA.setCampo6_0(empresa.getCnpj());
        hA.setCampo7_0(empresa.getCdBanco()); // duvida
        hA.setCampo8_0("");
        hA.setCampo9_0("0");
        hA.setCampo10_0("0");
        hA.setCampo11_0("0");
        hA.setCampo12_0("0");
        hA.setCampo13_0(empresa.getNomeFantasia() != null ? empresa.getNomeFantasia().toUpperCase() : "");
        hA.setCampo14_0("LEMON BANK");
        hA.setCampo15_0("");
        hA.setCampo16_0("1");
        hA.setCampo17_0(convertDateToString(new Date(), 8));
        hA.setCampo18_0(convertDateToString(new Date(), 9));
        hA.setCampo19_0(seqArquivo.toString()); // id do arquivo
        hA.setCampo20_0("050");
        hA.setCampo21_0("0");
        hA.setCampo22_0("");
        hA.setCampo23_0("");
        hA.setCampo24_0("");

        corpo = corpo + builder.setHeaderArquivo(hA);

        int lote = 1;

        for (Pagamento pagamento : pagamentos) {

            hL.setCampo1_1(empresa.getCdBanco());
            hL.setCampo2_1("0");
            hL.setCampo3_1("1");
            hL.setCampo4_1("C");
            hL.setCampo5_1("98");
            hL.setCampo6_1("10");
            hL.setCampo7_1("030");
            hL.setCampo8_1("");
            hL.setCampo9_1("2");
            hL.setCampo10_1(empresa.getCnpj());
            hL.setCampo11_1("0");
            hL.setCampo12_1(empresaInfAdicionais != null ? empresaInfAdicionais.getNuAgencia() : "");
            hL.setCampo13_1(empresaInfAdicionais != null ? empresaInfAdicionais.getDvAgencia() : "");
            hL.setCampo14_1(empresaInfAdicionais != null ? empresaInfAdicionais.getNuConta() : "");
            hL.setCampo15_1(empresaInfAdicionais != null ? empresaInfAdicionais.getDvConta() : "");
            hL.setCampo16_1(empresaInfAdicionais != null ? empresaInfAdicionais.getDvAgenciaConta() : "");
            hL.setCampo17_1(empresa.getNomeFantasia());
            hL.setCampo18_1("");
            hL.setCampo19_1(empresa.getEndereco().toUpperCase());
            hL.setCampo20_1(empresa.getNroLocal());
            hL.setCampo21_1(empresa.getComplemento());
            hL.setCampo22_1(empresa.getCidade().toUpperCase());
            hL.setCampo23_1(empresa.getCep());
            Uf uf = pagamentoDAO.getInitialized(empresa.getUf());
            hL.setCampo24_1(uf.getSigla().toUpperCase());
            hL.setCampo25_1("");
            hL.setCampo26_1("");

            corpo = corpo + builder.setHeaderLote(hL);

            Detalhe dT = new Detalhe();

            dT.setCampo1_3(empresa.getCdBanco());
            dT.setCampo2_3("0"); //0000
            dT.setCampo3_3("4");
            dT.setCampo4_3(String.valueOf(lote)); // Numero sequencial??????
            dT.setCampo5_3("A");
            dT.setCampo6_3("0");// tipo de movimento???? nao seria C?
            dT.setCampo7_3("0");
            dT.setCampo8_3("010");
            dT.setCampo9_3(empresa.getCdBanco()); // esse codigo eh para todos?
            dT.setCampo10_3(empresaInfAdicionais.getNuAgencia());
            dT.setCampo11_3(empresaInfAdicionais.getDvAgencia());
            dT.setCampo12_3(empresaInfAdicionais.getNuConta());
            dT.setCampo13_3(empresaInfAdicionais.getDvConta());
            dT.setCampo14_3(empresaInfAdicionais.getDvAgenciaConta());
            Funcionario funcionario = pagamentoDAO.getInitialized(pagamento.getFuncionario());
            dT.setCampo15_3(funcionario.getNome());
            dT.setCampo16_3(pagamento.getOp()); // codigo Op definido com sendo a data (yyyyMMdd) + id
            dT.setCampo17_3(funcionario.getNascimento() != null ? convertDateToString(funcionario.getNascimento(), 7) : "");
            dT.setCampo18_3("BRL");
            dT.setCampo19_3(pagamento.getValorPagto().toString().replaceAll("\\.", "").replaceAll("\\,", ""));
            dT.setCampo20_3("0");
            dT.setCampo21_3("");
            dT.setCampo22_3("0");
            dT.setCampo23_3(funcionario.getRg() != null ? funcionario.getRg().replaceAll("\\.", "") : "");
            dT.setCampo24_3(funcionario.getRgEmissor() != null ? funcionario.getRgEmissor().toUpperCase() : "");
            dT.setCampo25_3("1");
            dT.setCampo26_3(funcionario.getCpf() != null ? funcionario.getCpf() : "");
            dT.setCampo27_3("001");
            dT.setCampo28_3("");
            dT.setCampo29_3("0");
            dT.setCampo30_3("");
            dT.setCampo31_3("S");
            MotivoPagamento motivo = pagamentoDAO.getInitialized(pagamento.getMotivoPagamento());
            dT.setCampo32_3(motivo.getNome().toUpperCase());
            dT.setCampo33_3(funcionario.getFuncao() != null ? funcionario.getFuncao().toUpperCase() : "");

            corpo = corpo + builder.setDetalhe(dT);

            for (int j = 0; j < 20; j++) {
                DetalheItem dTiTem = new DetalheItem();
                corpo = corpo + builder.setDetalheItem(dTiTem);
            }
            corpo = corpo + System.getProperty("line.separator");

            tL.setCampo1_5(empresa.getCdBanco());
            tL.setCampo2_5(String.valueOf(lote));
            tL.setCampo3_5("5");
            tL.setCampo4_5("");
            tL.setCampo5_5(String.valueOf(pagamentos.size()));
            tL.setCampo6_5(pagamento.getValorPagto().toString().replaceAll("\\.", "").replaceAll("\\,", ""));
            tL.setCampo7_5("0");
            //           tL.setCampo8_5(corpo); // campo nao existe no doc do layout do arquivo
            tL.setCampo9_5("");
            tL.setCampo10_5("");

            corpo = corpo + builder.setTrailerLote(tL);

            valorTotalPagamentos = valorTotalPagamentos.add(pagamento.getValorPagto());
            lote++;

            pagamento.setSituacao(SituacaoOp.GERADA);

            //pagamento.setOp(seqArquivo.toString());

            pagamentoDAO.saveOrMerge(pagamento);
        }

        tA.setCampo1_9(empresa.getCdBanco());
        tA.setCampo2_9("9999");
        tA.setCampo3_9("9");
        tA.setCampo4_9("");
        tA.setCampo5_9(String.valueOf(pagamentos.size()));
        tA.setCampo6_9(valorTotalPagamentos.toString().replaceAll("\\.", "").replaceAll("\\,", ""));
        tA.setCampo7_9("0");
        tA.setCampo8_9("");

        corpo = corpo + builder.setTrailerArquivo(tA);

        String nomeDoArquivo = empresa.getRazaosocial().concat("_").concat(usuario.getNome()).concat("_").concat(seqArquivo.toString()).concat(".txt");

//        arquivoSalvar(caminho, nomeDoArquivo, corpo);
        upload(empresa, new Date(), nomeDoArquivo, ".txt", corpo);

        enviarEmail(pagamentos, nomeDoArquivo);

    }

    private void arquivoSalvar(String endereco, String nome, String conteudo) throws IOException {
        File diretorio = new File(endereco);
        diretorio.mkdir();

        if (diretorio.isDirectory()) {
            FileWriter arquivo = new FileWriter(endereco + nome + ".txt", false);
            arquivo.write(conteudo);
            arquivo.close();

        }
    }

    private void upload(Empresa empresa, Date dataPublicacao, String nomeArquivo, String extensao, String conteudo) throws FileNotFoundException, IOException {
        Arquivo arquivo = new Arquivo();
        DownloadArquivos upload = new DownloadArquivos();
        arquivo.setNome(nomeArquivo);
        arquivo.setExtensao(extensao);
//        arquivo.setConteudo(conteudo.getBytes("UTF-8"));
        arquivo.setConteudo(conteudo.getBytes("Cp1252"));
        
        arquivoDAO.saveOrMerge(arquivo,true);

        upload.setEmpresa(empresa);
        upload.setDataPublicao(dataPublicacao);
        upload.setArquivo(arquivo);

        downloadArquivoDAO.saveOrMerge(upload, true);
    }

    private String arquivoAbrir() throws IOException {
        FileReader arquivo = new FileReader("/Users/KillerBeeTwo/Documents/Projetos/OpFacil/src/main/webapp/arquivosTxt/teste.txt");
        String conteudo = "";
        int i;
        while ((i = arquivo.read()) != -1) {
            conteudo += (char) (i);
        }

        arquivo.close();
        return conteudo;
    }

    private void enviarEmail(List<Pagamento> pagamentos, String caminhoArquivo) throws BusinessException, IOException {
        StringBuilder mensagem = new StringBuilder("<h2>OP FÁCIL - Alerta de geração de arquivos de pagamentos.</h2> <br/> "
                + "<TABLE BORDER=\"1\" cellspacing=\"0\" cellpadding=\"0\" WIDTH=\"100%\">");
        mensagem.append("<tr BGCOLOR=\"SILVER\"> "
                + "<td width=\"22%\"> <Strong>Empresa</Strong> </td>"
                + "<td width=\"24%\"><Strong>Nº de pagamentos </Strong></td>"
                + "<td width=\"8%\"><Strong>Nº OP</Strong></td>"
                + "<td width=\"14%\"><Strong>Valor total</Strong></td>"
                + "<td width=\"16%\"><Strong>Valor total tarifa</Strong></td>"
                + "<td width=\"16%\"><Strong>Valor total c/ tarifa</Strong></td>"
                + "</tr>");
        BigDecimal valorTotal = BigDecimal.ZERO;
        BigDecimal valorTotalTarifas = BigDecimal.ZERO;
        Empresa empresa = new Empresa();
        for (Pagamento pagamento : pagamentos) {
            valorTotal = valorTotal.add(pagamento.getValorPagto());
            empresa = pagamentoDAO.getInitialized(pagamento.getEmpresa());
            valorTotalTarifas = valorTotalTarifas.add(empresa.getValorTarifa());
        }

        List<Attachment> anexos = new ArrayList<Attachment>();

        Arquivo arquivo = arquivoDAO.getArquivo(caminhoArquivo);

        DataSource dataSource = new ByteArrayDataSource(arquivo.getConteudo(), "text/plain");

        anexos.add(new Attachment(dataSource, "Anexos contem os arquivos de importaçao de OPs", caminhoArquivo));

        mensagem.append("<tr> <td width=\"22%\">").append(empresa.getNomeFantasia()).append("</td>").
                append("<td width=\"24%\">").append(pagamentos.size()).append("</td>").
                append("<td width=\"8%\">").append(arquivo.getId()).append("</td>").
                append("<td width=\"14%\">").append("R$ ".concat(valorTotal.toString())).append("</td>").
                append("<td width=\"16%\">").append("R$ ".concat(valorTotalTarifas.toString())).append("</td>").
                append("<td width=\"16%\">").append("R$ ".concat(valorTotal.add(valorTotalTarifas).toString())).append("</td>").
                append("</tr>");
        List<Usuario> usuarios = usuarioDAO.listAll();

        for (Usuario usuario : usuarios) {
            if (usuario.isReceberEmail()) {
                emailBO.enviar("[OP FÁCIL] - Alerta de geração de arquivos de pagamentos", mensagem.append("</TABLE>").toString(), configuracao.getDAO().find(1L), usuario.getEmail(), anexos);
            }
        }

    }

    private String convertDateToString(Date date, int tipo) {
        SimpleDateFormat formataData = null;
        if (tipo == 1) {
            formataData = new SimpleDateFormat("dd/MM/yyyy");
        }

        if (tipo == 2) {
            formataData = new SimpleDateFormat("yyyy-MM-dd");
        }

        if (tipo == 3) {
            formataData = new SimpleDateFormat("HH:mm");
        }

        if (tipo == 4) {
            formataData = new SimpleDateFormat("MMyy");
        }
        if (tipo == 5) {
            formataData = new SimpleDateFormat("HH:mm:ss");
        }
        if (tipo == 6) {
            formataData = new SimpleDateFormat("yyMM");
        }
        if (tipo == 7) {
            formataData = new SimpleDateFormat("yyyyMMdd");
        }

        if (tipo == 8) {
            formataData = new SimpleDateFormat("ddMMyyyy");
        }

        if (tipo == 9) {
            formataData = new SimpleDateFormat("HHmmss");
        }

        String data = formataData.format(date);

        return data;
    }

}
