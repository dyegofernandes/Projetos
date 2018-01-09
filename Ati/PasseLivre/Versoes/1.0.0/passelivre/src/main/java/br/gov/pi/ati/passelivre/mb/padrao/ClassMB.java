package br.gov.pi.ati.passelivre.mb.padrao;

import br.gov.pi.ati.passelivre.modelo.cadastro.Teste;
import br.gov.pi.ati.passelivre.modelo.controleacesso.Permissao;
import br.gov.pi.ati.passelivre.modelo.controleacesso.Usuario;
import br.gov.pi.ati.passelivre.modelo.configuracao.ErroSistema;
import br.gov.pi.ati.passelivre.modelo.controleacesso.SituacaoUsuario;
import br.gov.pi.ati.passelivre.modelo.controleacesso.AcessoSistema;
import br.gov.pi.ati.passelivre.modelo.email.ConfiguracaoEmail;
import br.gov.pi.ati.passelivre.modelo.controleacesso.Perfil;
import br.gov.pi.ati.passelivre.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.gov.pi.ati.passelivre.modelo.email.ModeloEmail;
import br.gov.pi.ati.passelivre.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.gov.pi.ati.passelivre.modelo.email.TipoAssuntoEmail;
import br.gov.pi.ati.passelivre.modelo.controleacesso.TipoRecuperacaoSenha;
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

    public Class getTeste() {
        return Teste.class;
    }

}