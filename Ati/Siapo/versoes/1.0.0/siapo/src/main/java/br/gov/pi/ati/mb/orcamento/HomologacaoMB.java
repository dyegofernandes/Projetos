package br.gov.pi.ati.mb.orcamento;

import br.gov.pi.ati.bo.controleacesso.UsuarioBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.orcamento.DespesaPublicaBO;
import br.gov.pi.ati.bo.orcamento.ExecucaoOrcamentariaBO;
import br.gov.pi.ati.bo.orcamento.MetaProdutoBO;
import br.gov.pi.ati.modelo.cadastro.AcaoEstrategica;
import br.gov.pi.ati.modelo.cadastro.AcaoOrcamentaria;
import br.gov.pi.ati.modelo.cadastro.FonteDeRecurso;
import br.gov.pi.ati.modelo.cadastro.Funcao;
import br.gov.pi.ati.modelo.cadastro.NaturezaDeDespesa;
import br.gov.pi.ati.modelo.cadastro.Orgao;
import br.gov.pi.ati.modelo.cadastro.ProgramaDeGoverno;
import br.gov.pi.ati.modelo.cadastro.ProgramaPPA;
import br.gov.pi.ati.modelo.cadastro.SubFuncao;
import br.gov.pi.ati.modelo.cadastro.UnidadeOrcamentaria;
import br.gov.pi.ati.modelo.cadastro.vos.Filtros;
import br.gov.pi.ati.modelo.controleacesso.Usuario;
import br.gov.pi.ati.modelo.orcamento.DespesaPublica;
import br.gov.pi.ati.modelo.orcamento.ExecucaoOrcamentaria;
import br.gov.pi.ati.modelo.orcamento.MetaProduto;
import br.gov.pi.ati.modelo.orcamento.ProgramacaoFinanceira;
import br.gov.pi.ati.modelo.orcamento.vos.DespesaPublicaVO;
import br.gov.pi.ati.util.SessaoUtils;
import br.gov.pi.ati.util.Utils;
import br.gov.pi.ati.webservice.process.ProcessBO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.xpert.faces.utils.FacesJasper;
import com.xpert.faces.utils.FacesMessageUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class HomologacaoMB extends AbstractBaseBean<DespesaPublica> implements Serializable {

    @EJB
    private DespesaPublicaBO despesaPublicaBO;

    @EJB
    private MetaProdutoBO produtoBO;

    @EJB
    private ExecucaoOrcamentariaBO execucaoBO;

    private Usuario usuarioAtual;

    private Filtros filtros;

    private List<DespesaPublica> despesas;

    private List<DespesaPublica> despesasSelecionadas;

    private List<UnidadeOrcamentaria> unidades;

    private BigDecimal totalVigente = BigDecimal.ZERO;

    private BigDecimal totalProximo = BigDecimal.ZERO;

    @Override
    public DespesaPublicaBO getBO() {
        return despesaPublicaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        filtros = new Filtros();

        usuarioAtual = SessaoUtils.getUser();

        filtros.setUsuario(usuarioAtual);

        unidades = getDAO().getInitialized(usuarioAtual.getUnidadesDeAcesso());

        filtros.setUnidadesOrcamentaria(unidades);

        despesas = new ArrayList<DespesaPublica>();

        despesasSelecionadas = new ArrayList<DespesaPublica>();
    }

    @Override
    public void save() {
        super.save();
    }

    @Override
    public void postSave() {

        super.postSave();
    }

    public List<UnidadeOrcamentaria> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<UnidadeOrcamentaria> unidades) {
        this.unidades = unidades;
    }

    public Filtros getFiltros() {
        return filtros;
    }

    public void setFiltros(Filtros filtros) {
        this.filtros = filtros;
    }

    public List<DespesaPublica> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<DespesaPublica> despesas) {
        this.despesas = despesas;
    }

    public BigDecimal getTotalVigente() {
        return totalVigente;
    }

    public void setTotalVigente(BigDecimal totalVigente) {
        this.totalVigente = totalVigente;
    }

    public BigDecimal getTotalProximo() {
        return totalProximo;
    }

    public void setTotalProximo(BigDecimal totalProximo) {
        this.totalProximo = totalProximo;
    }

    public BigDecimal getTotalAcumolado() {
        BigDecimal valor = BigDecimal.ZERO;

        if (totalProximo != null) {
            valor = valor.add(totalProximo);
        }

        if (totalVigente != null) {
            valor = valor.add(totalVigente);
        }

        return valor;
    }

    public void pegarDescricao() {
        String descricao = ProcessBO.getDescricao(getEntity().getNumeroProcesso());

        if (descricao != null) {
            getEntity().setDescricaoDespesa(descricao);
        } else {
            FacesMessageUtils.error("Processo não encontrado!");
        }
    }

    public void desmarcaQuantificador() {
        if (!getEntity().isGeraQuantificador()) {
            getEntity().setQuantidadeRealizada(null);
        }
    }

    public void mudarUnidadeOrcamentaria() {
        getEntity().setExecucaoOrcamentaria(null);
        getEntity().setProdutoLDO(null);
    }

    public void mudarAcaoOrcamentaria() {
        getEntity().setExecucaoOrcamentaria(null);
        getEntity().setProdutoLDO(null);
    }

    public void mudarFonteDeRecurso() {
        getEntity().setExecucaoOrcamentaria(null);
    }

    public void desmarcarQuantificador() {
        getEntity().setQuantidadeRealizada(BigDecimal.ZERO);
    }

    public void buscar() {
        filtros.setAtivo(false);
        despesas = despesaPublicaBO.consultar(filtros);
        despesasSelecionadas = new ArrayList<DespesaPublica>();
    }

    public List<ExecucaoOrcamentaria> autocompleteExecucaoNatureza(String nome) {
        return execucaoBO.execucaoOrcamentariaNatureza(filtros.getAcaoOrcamentaria(), filtros.getFonteDeRecurso(), nome);
    }

    public List<AcaoOrcamentaria> autocompleteAcaoFiltros(String nome) {
        return execucaoBO.execucaoOrcamentariaAcaoOrcamentariaPorUnidades(filtros.getUnidadesOrcamentaria(), nome);
    }

    public List<FonteDeRecurso> autocompleteFonte(String nome) {
        return execucaoBO.execucaoOrcamentariaFonte(filtros.getAcaoOrcamentaria(), nome);
    }

    public List<DespesaPublica> getDespesasSelecionadas() {
        return despesasSelecionadas;
    }

    public void setDespesasSelecionadas(List<DespesaPublica> despesasSelecionadas) {
        this.despesasSelecionadas = despesasSelecionadas;
    }

    public List<MetaProduto> autocompleteProduto(String nome) {
        if (filtros.getAcaoOrcamentaria() != null) {
            AcaoOrcamentaria acaoOrcamentariaTemp = getDAO().getInitialized(filtros.getAcaoOrcamentaria());
            AcaoEstrategica acaoTemp = getDAO().getInitialized(acaoOrcamentariaTemp.getAcaoEstrategica());
            return produtoBO.metaPelaAcaoEstrategica(acaoTemp, nome);
        }

        return null;
    }

    public void calcularTotais(List<ProgramacaoFinanceira> programacoes) {

        List<ProgramacaoFinanceira> progracoesTemp = getDAO().getInitialized(programacoes);

        if (progracoesTemp != null) {
            if (progracoesTemp.size() > 0) {
                Collections.sort(progracoesTemp);
                Integer anoInicial = progracoesTemp.get(0).getAno();

                for (ProgramacaoFinanceira progracoesTemp1 : progracoesTemp) {
                    if (anoInicial.equals(progracoesTemp1.getAno())) {
                        totalVigente = totalVigente.add(progracoesTemp1.getValor());
                    } else {
                        totalProximo = totalProximo.add(progracoesTemp1.getValor());
                    }
                }
            }
        }
    }

    public void gerarDeclaracao(DespesaPublica despesa) throws WriterException, IOException {
        HashMap params = new HashMap();
        String caminhoImg = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images");

        params.put("LOGO_ESTADO", caminhoImg.concat("/logGoverno.png"));
        if (!despesa.isHomologado()) {
            params.put("RASCUNHO_IMAGEM", caminhoImg.concat("/rascunho.png"));
        }

        List<DespesaPublicaVO> despesasVO = new ArrayList<DespesaPublicaVO>();

        DespesaPublicaVO despesaVO = new DespesaPublicaVO();

        UnidadeOrcamentaria unidade = getDAO().getInitialized(despesa.getUnidadeOrcamentaria());
        Orgao orgao = getDAO().getInitialized(unidade.getOrgao());
        Usuario responsavel = getDAO().getInitialized(despesa.getResponsavel());
        ExecucaoOrcamentaria execucao = getDAO().getInitialized(despesa.getExecucaoOrcamentaria());
        FonteDeRecurso fonteTemp = getDAO().getInitialized(execucao.getFonteDeRecurso());
        NaturezaDeDespesa natureza = getDAO().getInitialized(execucao.getNaturezaDaDespesa());
        AcaoOrcamentaria acaoOrcamentariaTemp = getDAO().getInitialized(execucao.getAcaoOrcamentaria());
        Funcao funcao = getDAO().getInitialized(acaoOrcamentariaTemp.getFuncao());
        SubFuncao subFuncao = getDAO().getInitialized(acaoOrcamentariaTemp.getSubfuncao());
        ProgramaPPA programaPPA = getDAO().getInitialized(acaoOrcamentariaTemp.getPrograma());
        ProgramaDeGoverno programa = getDAO().getInitialized(programaPPA.getProgramaGov());

        List<ProgramacaoFinanceira> programacoes = getDAO().getInitialized(despesa.getProgramacaoFinanceira());
        List<ProgramacaoFinanceira> programacoesVingente = new ArrayList<ProgramacaoFinanceira>();
        List<ProgramacaoFinanceira> programacoesProxima = new ArrayList<ProgramacaoFinanceira>();

        Collections.sort(programacoes);
        Integer ano = programacoes.get(0).getAno();

        BigDecimal totalProximoExercicio = BigDecimal.ZERO;
        BigDecimal totalExercicioVingente = BigDecimal.ZERO;

        for (ProgramacaoFinanceira programacao : programacoes) {
            if (ano.compareTo(programacao.getAno()) == 0) {
                programacoesVingente.add(programacao);
                totalExercicioVingente = totalExercicioVingente.add(programacao.getValor());
            } else {
                programacoesProxima.add(programacao);
                totalProximoExercicio = totalProximoExercicio.add(programacao.getValor());
            }
        }

        despesaVO.setQrCode(getQRCodeImage("Assinado Eletronicamente por: ".concat(Utils.format("###.###.###-##", responsavel.getCpf()).concat(" - ").
                concat(responsavel.getNome())).concat(" em ").concat(Utils.convertDateToString(despesa.getDataHomologacao(), "dd/MM/yyyy HH:mm:ss")), 300, 300));

        despesaVO.setNumeroProcesso(despesa.getNumeroProcesso());
        despesaVO.setResumoDespesa(despesa.getResumoDaDespesa());
        despesaVO.setDotacaoPrimeiroMes(Utils.moeda(programacoesVingente.get(0).getValor()));
        despesaVO.setTotalExercicioVingente(Utils.moeda(totalExercicioVingente));
        despesaVO.setSomaTotalExercioVingente(Utils.moeda(execucao.getTotalComprometidoSiapo()));
        despesaVO.setTotalProximoExercicio(Utils.moeda(totalProximoExercicio));
        despesaVO.setCodigoOrgao(orgao.getCodigo());
        despesaVO.setCodigoUnidade(unidade.getCodigo());
        despesaVO.setCodigoFuncao(funcao.getCodigo());
        despesaVO.setCodigoSubfuncao(subFuncao.getCodigo());
        despesaVO.setCodigoPrograma(programa.getCodigo());
        despesaVO.setCodigoAcao(acaoOrcamentariaTemp.getCodigo());
        despesaVO.setCodigoNatureza(natureza.getCodigo());
        despesaVO.setCodigoSubelemento(despesa.getSubelemento());
        despesaVO.setCodigoFonte(fonteTemp.getCodigo());
        despesaVO.setDotacaoInicial(Utils.moeda(execucao.getDotacaoInicial()));
        despesaVO.setAlteracaoNaLoa(Utils.moeda(execucao.getAlteracaoNaLoa()));
        despesaVO.setDespesasEmpenhadas(Utils.moeda(execucao.getDespesasEmpenhadas()));
        despesaVO.setSaldoOrcamentariaDisponivel(Utils.moeda(execucao.getSaldoDisponivel()));
        despesaVO.setNomeResponsavel(responsavel.getNome());
        despesaVO.setCargoResponsavel(responsavel.getCargo());
        despesaVO.setCpfResponsavel(Utils.format("###.###.###-##", responsavel.getCpf()));
        despesaVO.setDataHomogacao(Utils.convertDateToString(despesa.getDataHomologacao(), "dd/MM/yyyy HH:mm:ss"));
        despesaVO.setHomologado(despesa.isHomologado());

        despesasVO.add(despesaVO);

        FacesJasper.createJasperReport(despesasVO, params,
                "/WEB-INF/report/declaracao.jasper", "Declaração".concat(".pdf"));

    }

    private InputStream getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();

        InputStream input = new ByteArrayInputStream(pngData);

        return input;
    }

    public void homologarDespesa() {
        if (despesasSelecionadas != null) {
            if (despesasSelecionadas.size() > 0) {
                for (DespesaPublica despesa : despesasSelecionadas) {
                    despesa.setHomologado(true);
                    despesa.setDataHomologacao(new Date());
                    
                    if(despesa.getProdutoLDO()!=null){
                        produtoBO.atualizarMetaRealizada(despesa);
                    }
                    getDAO().saveOrMerge(despesa, true);
                }

                buscar();
                FacesMessageUtils.info("Despesa (s) homologada (s) com Sucesso!!");
            } else {
                FacesMessageUtils.error("Selecione uma ou mais Despesas para Homologação!");
            }
        } else {
            FacesMessageUtils.error("Selecione uma ou mais Despesas para Homologação!");
        }

    }
}
