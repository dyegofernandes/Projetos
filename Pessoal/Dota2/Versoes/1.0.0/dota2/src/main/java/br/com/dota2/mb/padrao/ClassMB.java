package br.com.dota2.mb.padrao;

import br.com.dota2.modelo.exemplo.PessoaExemplo;
import br.com.dota2.modelo.controleacesso.Permissao;
import br.com.dota2.modelo.controleacesso.Usuario;
import br.com.dota2.modelo.configuracao.ErroSistema;
import br.com.dota2.modelo.controleacesso.SituacaoUsuario;
import br.com.dota2.modelo.controleacesso.AcessoSistema;
import br.com.dota2.modelo.email.ConfiguracaoEmail;
import br.com.dota2.modelo.controleacesso.Perfil;
import br.com.dota2.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.com.dota2.modelo.email.ModeloEmail;
import br.com.dota2.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.com.dota2.modelo.email.TipoAssuntoEmail;
import br.com.dota2.modelo.controleacesso.TipoRecuperacaoSenha;
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