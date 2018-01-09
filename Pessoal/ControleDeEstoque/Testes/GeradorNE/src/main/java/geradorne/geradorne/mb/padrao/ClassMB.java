package geradorne.geradorne.mb.padrao;

import geradorne.geradorne.modelo.controleacesso.Permissao;
import geradorne.geradorne.modelo.controleacesso.Usuario;
import geradorne.geradorne.modelo.configuracao.ErroSistema;
import geradorne.geradorne.modelo.controleacesso.SituacaoUsuario;
import geradorne.geradorne.modelo.controleacesso.AcessoSistema;
import geradorne.geradorne.modelo.email.ConfiguracaoEmail;
import geradorne.geradorne.modelo.controleacesso.Perfil;
import geradorne.geradorne.modelo.controleacesso.HistoricoSituacaoUsuario;
import geradorne.geradorne.modelo.email.ModeloEmail;
import geradorne.geradorne.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import geradorne.geradorne.modelo.email.TipoAssuntoEmail;
import geradorne.geradorne.modelo.controleacesso.TipoRecuperacaoSenha;
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