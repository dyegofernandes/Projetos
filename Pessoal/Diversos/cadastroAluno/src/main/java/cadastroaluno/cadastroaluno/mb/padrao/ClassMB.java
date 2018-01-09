package cadastroaluno.cadastroaluno.mb.padrao;

import cadastroaluno.cadastroaluno.modelo.exemplo.PessoaExemplo;
import cadastroaluno.cadastroaluno.modelo.controleacesso.Permissao;
import cadastroaluno.cadastroaluno.modelo.controleacesso.Usuario;
import cadastroaluno.cadastroaluno.modelo.configuracao.ErroSistema;
import cadastroaluno.cadastroaluno.modelo.controleacesso.SituacaoUsuario;
import cadastroaluno.cadastroaluno.modelo.controleacesso.AcessoSistema;
import cadastroaluno.cadastroaluno.modelo.email.ConfiguracaoEmail;
import cadastroaluno.cadastroaluno.modelo.controleacesso.Perfil;
import cadastroaluno.cadastroaluno.modelo.controleacesso.HistoricoSituacaoUsuario;
import cadastroaluno.cadastroaluno.modelo.email.ModeloEmail;
import cadastroaluno.cadastroaluno.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import cadastroaluno.cadastroaluno.modelo.email.TipoAssuntoEmail;
import cadastroaluno.cadastroaluno.modelo.controleacesso.TipoRecuperacaoSenha;
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
    public Class getPessoaExemplo() {
        return PessoaExemplo.class;
    }

}