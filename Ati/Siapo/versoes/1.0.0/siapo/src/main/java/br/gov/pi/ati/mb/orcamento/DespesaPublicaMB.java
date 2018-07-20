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
import br.gov.pi.ati.modelo.cadastro.Municipio;
import br.gov.pi.ati.modelo.cadastro.NaturezaDeDespesa;
import br.gov.pi.ati.modelo.cadastro.Orgao;
import br.gov.pi.ati.modelo.cadastro.ProgramaDeGoverno;
import br.gov.pi.ati.modelo.cadastro.ProgramaPPA;
import br.gov.pi.ati.modelo.cadastro.SubFuncao;
import br.gov.pi.ati.modelo.cadastro.Territorio;
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
public class DespesaPublicaMB extends AbstractBaseBean<DespesaPublica> implements Serializable {

    @EJB
    private DespesaPublicaBO despesaPublicaBO;

    @EJB
    private MetaProdutoBO produtoBO;

    @EJB
    private UsuarioBO usuarioBO;

    @EJB
    private ExecucaoOrcamentariaBO execucaoBO;

    private ProgramacaoFinanceira programacaoAdd;

    private List<ProgramacaoFinanceira> programacaoFinanceira;

    private List<Municipio> cidades;

    private Territorio territorio;

    private Usuario usuarioAtual;

    private Filtros filtros;

    private List<DespesaPublica> despesas;

    private List<UnidadeOrcamentaria> unidades;

    private List<Integer> anos;

    private FonteDeRecurso fonte;

    private Integer anoAtual;

    private AcaoOrcamentaria acaoOrcamentaria;

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

        anos = new ArrayList<Integer>();

        anoAtual = new Integer(Utils.convertDateToString(new Date(), "yyyy"));

        anos.add(anoAtual);

        anos.add(anoAtual + 1);

        usuarioAtual = SessaoUtils.getUser();

        unidades = getDAO().getInitialized(usuarioAtual.getUnidadesDeAcesso());

        filtros.setUnidadesOrcamentaria(unidades);

        despesas = new ArrayList<DespesaPublica>();

        programacaoFinanceira = new ArrayList<ProgramacaoFinanceira>();

        programacaoAdd = new ProgramacaoFinanceira();

        cidades = new ArrayList<Municipio>();

        if (getEntity().getId() != null) {
            if (getEntity().getExecucaoOrcamentaria() != null) {
                fonte = getDAO().getInitialized(getEntity().getExecucaoOrcamentaria().getFonteDeRecurso());
                acaoOrcamentaria = getDAO().getInitialized(getEntity().getExecucaoOrcamentaria().getAcaoOrcamentaria());
            }
            cidades = getDAO().getInitialized(getEntity().getCidades());
            programacaoFinanceira = getDAO().getInitialized(getEntity().getProgramacaoFinanceira());
            Collections.sort(programacaoFinanceira);
        }
    }

    @Override
    public void save() {

        getEntity().setProgramacaoFinanceira(programacaoFinanceira);
        getEntity().setCidades(cidades);
        super.save();
    }

    @Override
    public void postSave() {

        if (getEntity().getId() != null) {
            ExecucaoOrcamentaria execucao = getDAO().getInitialized(getEntity().getExecucaoOrcamentaria());
            BigDecimal somaTotalSiapo = execucao.getTotalComprometidoSiapo();

            somaTotalSiapo = somaTotalSiapo.add(getTotalAcumulado());

            execucao.setTotalComprometidoSiapo(somaTotalSiapo);

            execucaoBO.getDAO().saveOrMerge(execucao, true);
        }

        super.postSave();
    }

    public ProgramacaoFinanceira getProgramacaoAdd() {
        return programacaoAdd;
    }

    public void setProgramacaoAdd(ProgramacaoFinanceira programacaoAdd) {
        this.programacaoAdd = programacaoAdd;
    }

    public List<ProgramacaoFinanceira> getProgramacaoFinanceira() {
        return programacaoFinanceira;
    }

    public void setProgramacaoFinanceira(List<ProgramacaoFinanceira> programacaoFinanceira) {
        this.programacaoFinanceira = programacaoFinanceira;
    }

    public List<Municipio> getCidades() {
        return cidades;
    }

    public void setCidades(List<Municipio> cidades) {
        this.cidades = cidades;
    }

    public Territorio getTerritorio() {
        return territorio;
    }

    public void setTerritorio(Territorio territorio) {
        this.territorio = territorio;
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

    public List<Integer> getAnos() {
        return anos;
    }

    public void setAnos(List<Integer> anos) {
        this.anos = anos;
    }

    public FonteDeRecurso getFonte() {
        return fonte;
    }

    public void setFonte(FonteDeRecurso fonte) {
        this.fonte = fonte;
    }

    public AcaoOrcamentaria getAcaoOrcamentaria() {
        return acaoOrcamentaria;
    }

    public void setAcaoOrcamentaria(AcaoOrcamentaria acaoOrcamentaria) {
        this.acaoOrcamentaria = acaoOrcamentaria;
    }

    public void adicionarProgramacao() {
        if (programacaoAdd.getMes() != null) {
            if (programacaoAdd.getAno() != null) {
                if (programacaoAdd.getValor() != null) {
                    if (programacaoJahAdd(programacaoAdd)) {
                        FacesMessageUtils.error("Programação com esse Mês e Ano já foram incluidos!");
                    } else {
                        programacaoFinanceira.add(programacaoAdd);
                        Collections.sort(programacaoFinanceira);
                        programacaoAdd = new ProgramacaoFinanceira();
                    }

                } else {
                    FacesMessageUtils.error("Valor é obrigatório!");
                }
            } else {
                FacesMessageUtils.error("Ano é obrigatório!");
            }
        } else {
            FacesMessageUtils.error("Mês é obrigatório!");
        }
    }

    public void removerProgramacao(ProgramacaoFinanceira programcao) {
        programacaoFinanceira.remove(programcao);
    }

    private boolean programacaoJahAdd(ProgramacaoFinanceira programacao) {
        for (ProgramacaoFinanceira pro : programacaoFinanceira) {
            if ((pro.getAno().compareTo(programacao.getAno()) == 0) && (pro.getMes() == programacao.getMes())) {
                return true;
            }
        }
        return false;
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
        despesas = despesaPublicaBO.consultar(filtros);
    }

    public List<Usuario> autocompleteUsuario(String nome) {
        if (getEntity().getUnidadeOrcamentaria() != null) {
            return usuarioBO.usuariosPeloUnidadeOrcamentaria(getEntity().getUnidadeOrcamentaria(), nome);
        }

        return null;
    }

    public List<ExecucaoOrcamentaria> autocompleteExecucaoNatureza(String nome) {
        return execucaoBO.execucaoOrcamentariaNatureza(acaoOrcamentaria, fonte, nome);
    }

    public List<AcaoOrcamentaria> autocompleteAcao(String nome) {
        return execucaoBO.execucaoOrcamentariaAcaoOrcamentaria(getEntity().getUnidadeOrcamentaria(), nome);
    }

    public List<AcaoOrcamentaria> autocompleteAcaoFiltros(String nome) {
        return execucaoBO.execucaoOrcamentariaAcaoOrcamentariaPorUnidades(filtros.getUnidadesOrcamentaria(), nome);
    }

    public List<FonteDeRecurso> autocompleteFonte(String nome) {
        return execucaoBO.execucaoOrcamentariaFonte(acaoOrcamentaria, nome);
    }

    public List<MetaProduto> autocompleteProduto(String nome) {
        if (acaoOrcamentaria != null) {
            AcaoOrcamentaria acaoOrcamentariaTemp = getDAO().getInitialized(acaoOrcamentaria);
            AcaoEstrategica acaoTemp = getDAO().getInitialized(acaoOrcamentariaTemp.getAcaoEstrategica());
            return produtoBO.metaPelaAcaoEstrategica(acaoTemp, nome);
        }

        return null;
    }

    public BigDecimal getTotalExercicioVingente() {
        BigDecimal total = BigDecimal.ZERO;

        for (ProgramacaoFinanceira program : programacaoFinanceira) {
            if (program.getAno().equals(anoAtual)) {
                total = total.add(program.getValor());
            }
        }

        return total;
    }

    public BigDecimal getTotalProximoExercicio() {
        BigDecimal total = BigDecimal.ZERO;

        for (ProgramacaoFinanceira program : programacaoFinanceira) {
            if (!program.getAno().equals(anoAtual)) {
                total = total.add(program.getValor());
            }
        }

        return total;
    }

    public BigDecimal getTotalAcumulado() {
        BigDecimal total = BigDecimal.ZERO;

        for (ProgramacaoFinanceira program : programacaoFinanceira) {
            total = total.add(program.getValor());
        }

        return total;
    }

    public void gerarDeclaracao(DespesaPublica despesa) throws WriterException, IOException {
        HashMap params = new HashMap();
        String caminhoImg = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images");

        params.put("LOGO_ESTADO", caminhoImg.concat("/logGoverno.png"));

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
}
