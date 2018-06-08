package br.gov.pi.siste.mb.financeiro;

import br.gov.pi.siste.bo.cadastro.UnidadeBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import com.xpert.core.exception.BusinessException;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.faces.utils.FacesUtils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.siste.bo.financeiro.MovimentoBO;
import br.gov.pi.siste.bo.financeiro.ReferenciaBO;
import br.gov.pi.siste.modelo.cadastro.Orgao;
import br.gov.pi.siste.modelo.cadastro.Unidade;
import br.gov.pi.siste.modelo.cadastro.enums.Mes;
import br.gov.pi.siste.modelo.cadastro.enums.StatusReferencia;
import br.gov.pi.siste.modelo.controleacesso.Usuario;
import br.gov.pi.siste.modelo.financeiro.Referencia;
import br.gov.pi.siste.modelo.vos.FiltrosVO;
import br.gov.pi.siste.util.SessaoUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ReferenciaMB extends AbstractBaseBean<Referencia> implements Serializable {

    @EJB
    private ReferenciaBO referenciaBO;

    @EJB
    private MovimentoBO movimentoBO;

    @EJB
    private UnidadeBO unidadeBO;

    private FiltrosVO filtros;

    private Usuario usuarioAtual = SessaoUtils.getUser();

    private List<Unidade> unidades;

    private List<Unidade> unidadesFiltros;

    private List<Referencia> referencias;

    private Mes mes;
    private Integer ano;
    
    @Override
    public ReferenciaBO getBO() {
        return referenciaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "codigo DESC";
    }

    @Override
    public void init() {
        if (getEntity().getId() == null) {

            getEntity().setOrgao(usuarioAtual.getOrgao());

            if (getEntity().getOrgao() != null) {
                getEntity().setCodigo(referenciaBO.pegarProximaReferencia(usuarioAtual.getOrgao()));
            }
        }else{
            String aux = getEntity().getCodigo().toString();
            
            mes =  switchMes(new Integer(aux.subSequence(4,6).toString()));
            ano =  new Integer(aux.subSequence(0,4).toString());
        }
        filtros = new FiltrosVO();

        filtros.setUsuario(usuarioAtual);

        referencias = referenciaBO.listarReferencias(filtros);
        
        

    }
    
    public Mes switchMes(Integer mes){
        switch (mes){
                case 1:
                    return Mes.JANEIRO;
                case 2:
                    return Mes.FEVEREIRO;
                case 3:
                    return Mes.MARCO;
                case 4:
                    return Mes.ABRIL;
                case 5:
                    return Mes.MAIO;
                case 6:
                    return Mes.JUNHO;
                case 7:
                    return Mes.JULHO;
                case 8:
                    return Mes.AGOSTO;
                case 9:
                    return Mes.SETEMBRO;
                case 10:
                    return Mes.OUTUBRO;
                case 11:
                    return Mes.NOVEMBRO;
                case 12:
                    return Mes.DEZEMBRO;
                
        }
        System.out.println("Esse é um mês invalido");
        return null;
                
    }

    public void buscar() {

        filtros.setUsuario(usuarioAtual);

        referencias = referenciaBO.listarReferencias(filtros);

    }

    public List<Orgao> orgaoAutocompletePeloNome(String nome) {
        return getBO().orgaoPeloNome(nome);
    }

    @Override
    public void postSave() {
        setEntity(new Referencia());
    }

    @Override
    public void save() {
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        Calendar dateCodigo = Calendar.getInstance();
        dateCodigo.set(ano, new Integer(mes.getNum()),1);
        if(dateCodigo.after(today)){
            FacesMessageUtils.error("Competência não pode conter data após a atual");
        }else{
            getEntity().setCodigo(new Integer(ano.toString()+mes.getNum()));
            super.save();
            
        }
    }

    @Override
    public void delete() {
        super.delete(); //To change body of generated methods, choose Tools | Templates.
        filtros = new FiltrosVO();

        filtros.setUsuario(usuarioAtual);

        referencias = referenciaBO.listarReferencias(filtros);

    }
    
    

    public void gerarGfip(Referencia referencia) throws InterruptedException, UnsupportedEncodingException {
        if (referencia != null) {
            filtros.setReferencia(referencia);
            String texto = "";
            Charset charset = Charset.forName("US-ASCII");
            filtros.setGfip(true);
            texto = referenciaBO.montarSefip(filtros);

            FacesUtils.download(texto.getBytes(charset), "text/plain", "SEFIP".concat(".RE"));
        }
    }

    public void abrir(Referencia referencia) throws BusinessException {
        if (referenciaBO.verificarReferenciaAnterior(referencia, StatusReferencia.ABERTA)) {
            FacesMessageUtils.error("Não pode existir duas Competência em Aberto!");
        } else {
            if (referencia.getStatus() != StatusReferencia.ABERTA || referencia.getStatus() != StatusReferencia.PROCESSADA) {
                referencia.setStatus(StatusReferencia.ABERTA);
                referenciaBO.getDAO().saveOrMerge(referencia, true);
                movimentoBO.destravarMovimento(referencia);
                FacesMessageUtils.info("Competência Aberta com Sucesso");
            }

        }
    }

    public void fechar(Referencia referencia) {
        if (referencia.getStatus() == StatusReferencia.ABERTA || referencia.getStatus() == StatusReferencia.PROCESSADA) {

            if (referenciaBO.verificarReferenciaAnterior(referencia, StatusReferencia.FECHADA)) {
                FacesMessageUtils.error("Só pode fechar uma Competência se a anterior estiver Processada!");
            } else {
                // Não pode fechar uma Competencia se a anterior tiver fechada
                referencia.setStatus(StatusReferencia.FECHADA);

                if (movimentoBO.travarMovimentos(referencia)) {//trava os movimentos
                    referenciaBO.getDAO().saveOrMerge(referencia, true);
//                    gerarRelatorioRepasses(referencia);
                    FacesMessageUtils.info("Competência Fechada com Sucesso");
                } else {
                    FacesMessageUtils.error("Não pode Fechar uma Competência sem movimentos!!");
                }
            }
        } else {
            FacesMessageUtils.error("Só pode fechar uma Competência Aberta!");
        }
    }

    public void processar(Referencia referencia) throws InterruptedException {
        if (referencia.getStatus() == StatusReferencia.FECHADA) {
            if (referenciaBO.verificarReferenciaAnterior(referencia, StatusReferencia.PROCESSADA)) {
                FacesMessageUtils.error("Existe uma Competência ainda não processada!");
            } else {
                referencia.setStatus(StatusReferencia.PROCESSADA);
                referenciaBO.getDAO().saveOrMerge(referencia, true);
                FacesMessageUtils.info("Competência Processada com Sucesso");
//                gerarGfip(referencia);
            }
        } else {
            FacesMessageUtils.error("Só pode Processar uma Competência Fechada!");
        }
    }

    public void gerarRelatorioRepasses(Referencia referencia) {
        if (referencia != null) {
            filtros.setReferencia(referencia);
            if (referenciaBO.relatorioRepasses(filtros)) {
                FacesMessageUtils.error("Não existe movimentos dessa (s) unidade (s) para essa Competência!");
            }
        }
    }

    public void carregarUnidadesPorOrgao() {
        if (filtros.getOrgao() != null) {
            unidades = unidadeBO.unidadesPorOrgao(filtros.getOrgao());
        } else {
            filtros.setUnidade(new Unidade());
            unidades = new ArrayList<Unidade>();
        }
    }

    public void gerarCodigo() {
        if (getEntity().getOrgao() != null) {
            getEntity().setCodigo(referenciaBO.pegarProximaReferencia(getEntity().getOrgao()));
        }
    }
    
    

    public FiltrosVO getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosVO filtros) {
        this.filtros = filtros;
    }

    public List<Unidade> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidade> unidades) {
        this.unidades = unidades;
    }

    public List<Unidade> getUnidadesFiltros() {
        return unidadesFiltros;
    }

    public void setUnidadesFiltros(List<Unidade> unidadesFiltros) {
        this.unidadesFiltros = unidadesFiltros;
    }

    public ReferenciaBO getReferenciaBO() {
        return referenciaBO;
    }

    public void setReferenciaBO(ReferenciaBO referenciaBO) {
        this.referenciaBO = referenciaBO;
    }

    public MovimentoBO getMovimentoBO() {
        return movimentoBO;
    }

    public void setMovimentoBO(MovimentoBO movimentoBO) {
        this.movimentoBO = movimentoBO;
    }

    public UnidadeBO getUnidadeBO() {
        return unidadeBO;
    }

    public void setUnidadeBO(UnidadeBO unidadeBO) {
        this.unidadeBO = unidadeBO;
    }

    public Usuario getUsuarioAtual() {
        return usuarioAtual;
    }

    public void setUsuarioAtual(Usuario usuarioAtual) {
        this.usuarioAtual = usuarioAtual;
    }

    public List<Referencia> getReferencias() {
        return referencias;
    }

    public void setReferencias(List<Referencia> referencias) {
        this.referencias = referencias;
    }

    public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }
 

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
    
}
