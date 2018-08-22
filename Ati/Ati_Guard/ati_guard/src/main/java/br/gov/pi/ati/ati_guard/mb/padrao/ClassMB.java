package br.gov.pi.ati.ati_guard.mb.padrao;

import br.gov.pi.ati.ati_guard.modelo.controleacesso.Permissao;
import br.gov.pi.ati.ati_guard.modelo.controleacesso.Usuario;
import br.gov.pi.ati.ati_guard.modelo.configuracao.ErroSistema;
import br.gov.pi.ati.ati_guard.modelo.controleacesso.SituacaoUsuario;
import br.gov.pi.ati.ati_guard.modelo.controleacesso.AcessoSistema;
import br.gov.pi.ati.ati_guard.modelo.email.ConfiguracaoEmail;
import br.gov.pi.ati.ati_guard.modelo.controleacesso.Perfil;
import br.gov.pi.ati.ati_guard.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.gov.pi.ati.ati_guard.modelo.email.ModeloEmail;
import br.gov.pi.ati.ati_guard.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.gov.pi.ati.ati_guard.modelo.email.TipoAssuntoEmail;
import br.gov.pi.ati.ati_guard.modelo.controleacesso.TipoRecuperacaoSenha;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ClassMB {

    public Class getAcessoSistema() {
        return AcessoSistema.class;
    }

    public Class getErroSistema() {
        return ErroSistema.class;
    }

    public Class getHistoricoSituacaoUsuario() {
        return HistoricoSituacaoUsuario.class;
    }

    public Class getPerfil() {
        return Perfil.class;
    }

    public Class getPermissao() {
        return Permissao.class;
    }

    public Class getSituacaoUsuario() {
        return SituacaoUsuario.class;
    }

    public Class getUsuario() {
        return Usuario.class;
    }

    public Class getTipoAssuntoEmail() {
        return TipoAssuntoEmail.class;
    }

    public Class getModeloEmail() {
        return ModeloEmail.class;
    }

    public Class getSolicitacaoRecuperacaoSenha() {
        return SolicitacaoRecuperacaoSenha.class;
    }

    public Class getTipoRecuperacaoSenha() {
        return TipoRecuperacaoSenha.class;
    }

    public Class getConfiguracaoEmail() {
        return ConfiguracaoEmail.class;
    }
    

}