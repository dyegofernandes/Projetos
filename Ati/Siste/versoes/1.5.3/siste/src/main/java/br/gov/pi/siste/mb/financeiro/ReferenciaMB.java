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
import br.gov.pi.siste.modelo.cadastro.Unidade;
import br.gov.pi.siste.modelo.cadastro.enums.StatusReferencia;
import br.gov.pi.siste.modelo.controleacesso.Usuario;
import br.gov.pi.siste.modelo.financeiro.Referencia;
import br.gov.pi.siste.modelo.vos.FiltrosVO;
import br.gov.pi.siste.util.SessaoUtils;
import java.util.ArrayList;
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
            getEntity().setCodigo(referenciaBO.pegarProximaReferencia());
        }
        filtros = new FiltrosVO();

        filtros.setUsuario(usuarioAtual);

    }

    @Override
    public void postSave() {
        setEntity(new Referencia());
    }

    @Override
    public void save() {
        if (referenciaBO.verificarReferenciaAnterior(getEntity(), StatusReferencia.ABERTA)) {
            FacesMessageUtils.error("Não pode existir duas Competência em Aberto!");
        } else {
            super.save();;
        }
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

}
