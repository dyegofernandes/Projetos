package br.gov.pi.ati.salvavidas.mb.padrao;

import br.gov.pi.ati.salvavidas.modelo.cadastro.FonteRecurso;
import br.gov.pi.ati.salvavidas.modelo.cadastro.Poligono;
import br.gov.pi.ati.salvavidas.modelo.enums.TipoPoligono;
import br.gov.pi.ati.salvavidas.modelo.cadastro.Ponto;
import br.gov.pi.ati.salvavidas.modelo.enums.Situacao;
import br.gov.pi.ati.salvavidas.modelo.denuncia.Denuncia;
import br.gov.pi.ati.salvavidas.modelo.denuncia.Arquivo;
import br.gov.pi.ati.salvavidas.modelo.enums.Tipo;
import br.gov.pi.ati.salvavidas.modelo.denuncia.Endereco;
import br.gov.pi.ati.salvavidas.modelo.controleacesso.Permissao;
import br.gov.pi.ati.salvavidas.modelo.controleacesso.Usuario;
import br.gov.pi.ati.salvavidas.modelo.configuracao.ErroSistema;
import br.gov.pi.ati.salvavidas.modelo.controleacesso.SituacaoUsuario;
import br.gov.pi.ati.salvavidas.modelo.controleacesso.AcessoSistema;
import br.gov.pi.ati.salvavidas.modelo.email.ConfiguracaoEmail;
import br.gov.pi.ati.salvavidas.modelo.controleacesso.Perfil;
import br.gov.pi.ati.salvavidas.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.gov.pi.ati.salvavidas.modelo.email.ModeloEmail;
import br.gov.pi.ati.salvavidas.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.gov.pi.ati.salvavidas.modelo.email.TipoAssuntoEmail;
import br.gov.pi.ati.salvavidas.modelo.controleacesso.TipoRecuperacaoSenha;
import br.gov.pi.ati.salvavidas.modelo.enums.Anonimo;
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

    public Class getArquivo() {
        return Arquivo.class;
    }

    public Class getEndereco() {
        return Endereco.class;
    }

    public Class getPoligono() {
        return Poligono.class;
    }

    public Class getTipoPoligono() {
        return TipoPoligono.class;
    }

    public Class getPonto() {
        return Ponto.class;
    }

    public Class getSituacao() {
        return Situacao.class;
    }

    public Class getTipo() {
        return Tipo.class;
    }

    public Class getAnonimo() {
        return Anonimo.class;
    }
    public Class getFonteRecurso() {
        return FonteRecurso.class;
    }

}