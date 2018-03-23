package br.gov.pi.ati.cfcpm.mb.padrao;

import br.gov.pi.ati.cfcpm.modelo.cadastro.Arquivo;
import br.gov.pi.ati.cfcpm.modelo.cadastro.FormularioInscricaoSAV;
import br.gov.pi.ati.cfcpm.modelo.enums.CidadeSAV;
import br.gov.pi.ati.cfcpm.modelo.enums.Sexo;
import br.gov.pi.ati.cfcpm.modelo.enums.Situacao;
import br.gov.pi.ati.cfcpm.modelo.cadastro.FormularioDeInscricao;
import br.gov.pi.ati.cfcpm.modelo.controleacesso.Permissao;
import br.gov.pi.ati.cfcpm.modelo.controleacesso.Usuario;
import br.gov.pi.ati.cfcpm.modelo.configuracao.ErroSistema;
import br.gov.pi.ati.cfcpm.modelo.controleacesso.SituacaoUsuario;
import br.gov.pi.ati.cfcpm.modelo.controleacesso.AcessoSistema;
import br.gov.pi.ati.cfcpm.modelo.email.ConfiguracaoEmail;
import br.gov.pi.ati.cfcpm.modelo.controleacesso.Perfil;
import br.gov.pi.ati.cfcpm.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.gov.pi.ati.cfcpm.modelo.email.ModeloEmail;
import br.gov.pi.ati.cfcpm.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.gov.pi.ati.cfcpm.modelo.email.TipoAssuntoEmail;
import br.gov.pi.ati.cfcpm.modelo.controleacesso.TipoRecuperacaoSenha;
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

    public Class getSexo() {
        return Sexo.class;
    }

    public Class getFormularioDeInscricao() {
        return FormularioDeInscricao.class;
    }

    public Class getSituacao() {
        return Situacao.class;
    }
    public Class getFormularioInscricaoSAV() {
        return FormularioInscricaoSAV.class;
    }
    public Class getCidadeSAV() {
        return CidadeSAV.class;
    }

    public Class getArquivo() {
        return Arquivo.class;
    }

}