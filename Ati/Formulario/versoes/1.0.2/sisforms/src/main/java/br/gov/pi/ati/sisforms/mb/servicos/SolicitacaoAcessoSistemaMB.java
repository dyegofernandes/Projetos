package br.gov.pi.ati.sisforms.mb.servicos;

import br.gov.pi.ati.sisforms.bo.cadastro.TermoBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.servicos.SolicitacaoAcessoSistemaBO;
import br.gov.pi.ati.sisforms.modelo.cadastro.Termo;
import br.gov.pi.ati.sisforms.modelo.cadastro.TermoAceito;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisforms.modelo.enums.TrabalhadorTipo;
import br.gov.pi.ati.sisforms.modelo.formulario.PerfilInfoFolha;
import br.gov.pi.ati.sisforms.modelo.formulario.PerfilSFP;
import br.gov.pi.ati.sisforms.modelo.servicos.SolicitacaoAcessoSistema;
import br.gov.pi.ati.sisforms.util.SessaoUtils;
import br.gov.pi.ati.sisforms.util.Utils;
import br.gov.pi.ati.sisforms.webservices.inforfolha.ServidorVO;
import com.xpert.faces.utils.FacesMessageUtils;
import java.util.ArrayList;
import java.util.Date;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class SolicitacaoAcessoSistemaMB extends AbstractBaseBean<SolicitacaoAcessoSistema> implements Serializable {

    @EJB
    private SolicitacaoAcessoSistemaBO solicitacaoAcessoSistemaBO;

    @EJB
    private TermoBO termoBO;

    private Termo termoResponsabilidadeAtivo;

    private Usuario usuarioAtual = SessaoUtils.getUser();

    private boolean renderizarAceite;

    @Override
    public SolicitacaoAcessoSistemaBO getBO() {
        return solicitacaoAcessoSistemaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        renderizarAceite = false;
        termoResponsabilidadeAtivo = termoBO.termoAtivoPorNome("TERMO DE RESPONSABILIDADE");

        if (getEntity().getId() == null) {
            getEntity().setUsuario(usuarioAtual);

            ServidorVO servidor = Utils.consultarServidorPeloCPF(usuarioAtual.getCpf());

            if (servidor != null) {
                getEntity().setTipo(TrabalhadorTipo.SERVIDOR);
                getEntity().setTelefone(servidor.getTelefone());
                getEntity().setCargoFuncao(servidor.getCargo());
            } else {
                getEntity().setTipo(TrabalhadorTipo.TERCEIRIZADO);
            }

        }
    }

    public void renderAceitar() {
        renderizarAceite = true;
    }

    public void aceitar() {

        if (termoResponsabilidadeAtivo != null) {
            TermoAceito termoAceito = new TermoAceito();
            termoAceito.setTermo(termoResponsabilidadeAtivo);
            getEntity().setTermoAceito(termoAceito);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('widgetTermoDetail').hide();");
            FacesMessageUtils.info("Termo de Responsabilidade aceito em: ".concat(Utils.convertDateToString(new Date(), "dd/MM/yyy HH:mm")));
        } else {
            FacesMessageUtils.error("Termo de Responsabilidade é obrigatório!");
        }

    }

    public Termo getTermoResponsabilidadeAtivo() {
        return termoResponsabilidadeAtivo;
    }

    public void setTermoResponsabilidadeAtivo(Termo termoResponsabilidadeAtivo) {
        this.termoResponsabilidadeAtivo = termoResponsabilidadeAtivo;
    }

    public boolean isRenderizarAceite() {
        return renderizarAceite;
    }

    public void setRenderizarAceite(boolean renderizarAceite) {
        this.renderizarAceite = renderizarAceite;
    }

    public void chanceSistema() {
        getEntity().setPerfilsInfofolha(new ArrayList<PerfilInfoFolha>());
        getEntity().setPerfilsSFP(new ArrayList<PerfilSFP>());
    }
}
