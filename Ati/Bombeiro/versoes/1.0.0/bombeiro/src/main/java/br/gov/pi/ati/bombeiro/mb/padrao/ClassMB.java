package br.gov.pi.ati.bombeiro.mb.padrao;

import br.gov.pi.ati.bombeiro.modelo.enums.Situacao;
import br.gov.pi.ati.bombeiro.modelo.denuncia.Denuncia;
import br.gov.pi.ati.bombeiro.modelo.denuncia.Endereco;
import br.gov.pi.ati.bombeiro.modelo.denuncia.Arquivo;
import br.gov.pi.ati.bombeiro.modelo.controleacesso.Permissao;
import br.gov.pi.ati.bombeiro.modelo.controleacesso.Usuario;
import br.gov.pi.ati.bombeiro.modelo.configuracao.ErroSistema;
import br.gov.pi.ati.bombeiro.modelo.controleacesso.SituacaoUsuario;
import br.gov.pi.ati.bombeiro.modelo.controleacesso.AcessoSistema;
import br.gov.pi.ati.bombeiro.modelo.email.ConfiguracaoEmail;
import br.gov.pi.ati.bombeiro.modelo.controleacesso.Perfil;
import br.gov.pi.ati.bombeiro.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.gov.pi.ati.bombeiro.modelo.email.ModeloEmail;
import br.gov.pi.ati.bombeiro.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.gov.pi.ati.bombeiro.modelo.email.TipoAssuntoEmail;
import br.gov.pi.ati.bombeiro.modelo.controleacesso.TipoRecuperacaoSenha;
import br.gov.pi.ati.bombeiro.modelo.enums.Tipo;
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

    public Class getDenuncia() {
        return Denuncia.class;
    }
    public Class getEndereco() {
        return Endereco.class;
    }
    public Class getArquivo() {
        return Arquivo.class;
    }
    
    public Class getTipo(){
        return Tipo.class;
    }

    public Class getSituacao(){
        return Situacao.class;
    }
}