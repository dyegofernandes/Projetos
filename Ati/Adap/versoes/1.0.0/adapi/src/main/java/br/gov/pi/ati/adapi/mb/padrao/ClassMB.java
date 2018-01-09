package br.gov.pi.ati.adapi.mb.padrao;

import br.gov.pi.ati.adapi.modelo.enums.SimOuNao;
import br.gov.pi.ati.adapi.modelo.notificacao.Notificacao;
import br.gov.pi.ati.adapi.modelo.cadastro.ResponsavelNotificacao;
import br.gov.pi.ati.adapi.modelo.cadastro.Endereco;
import br.gov.pi.ati.adapi.modelo.cadastro.Especie;
import br.gov.pi.ati.adapi.modelo.cadastro.Animal;
import br.gov.pi.ati.adapi.modelo.cadastro.SinalClinico;
import br.gov.pi.ati.adapi.modelo.controleacesso.Permissao;
import br.gov.pi.ati.adapi.modelo.controleacesso.Usuario;
import br.gov.pi.ati.adapi.modelo.configuracao.ErroSistema;
import br.gov.pi.ati.adapi.modelo.controleacesso.SituacaoUsuario;
import br.gov.pi.ati.adapi.modelo.controleacesso.AcessoSistema;
import br.gov.pi.ati.adapi.modelo.email.ConfiguracaoEmail;
import br.gov.pi.ati.adapi.modelo.controleacesso.Perfil;
import br.gov.pi.ati.adapi.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.gov.pi.ati.adapi.modelo.email.ModeloEmail;
import br.gov.pi.ati.adapi.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.gov.pi.ati.adapi.modelo.email.TipoAssuntoEmail;
import br.gov.pi.ati.adapi.modelo.controleacesso.TipoRecuperacaoSenha;
import br.gov.pi.ati.adapi.modelo.enums.AreaDeAtuacao;
import br.gov.pi.ati.adapi.modelo.enums.PerfilNotificador;
import br.gov.pi.ati.adapi.modelo.enums.TipoProfissional;
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

    public Class getEspecie() {
        return Especie.class;
    }

    public Class getAnimal() {
        return Animal.class;
    }

    public Class getSinalClinico() {
        return SinalClinico.class;
    }

    public Class getSimOuNao() {
        return SimOuNao.class;
    }

    public Class getNotificacao() {
        return Notificacao.class;
    }

    public Class getResponsavelNotificacao() {
        return ResponsavelNotificacao.class;
    }

    public Class getEndereco() {
        return Endereco.class;
    }

    public Class getAreaDeAtuacao() {
        return AreaDeAtuacao.class;
    }

    public Class getTipoProfissional() {
        return TipoProfissional.class;
    }
    
    public Class getPerfilNotificador(){
        return PerfilNotificador.class;
    }
}
