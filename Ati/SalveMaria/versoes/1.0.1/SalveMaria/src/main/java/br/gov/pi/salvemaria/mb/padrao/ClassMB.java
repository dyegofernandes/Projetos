package br.gov.pi.salvemaria.mb.padrao;

import br.gov.pi.salvemaria.modelo.cadastro.Viatura;
import br.gov.pi.salvemaria.modelo.cadastro.Circunscricao_Bairro;
import br.gov.pi.salvemaria.modelo.cadastro.Circunscricao;
import br.gov.pi.salvemaria.modelo.denuncia.Arquivo;
import br.gov.pi.salvemaria.modelo.denuncia.Denuncia;
import br.gov.pi.salvemaria.modelo.enums.FormasDeViolencia;
import br.gov.pi.salvemaria.modelo.enums.Situacao;
import br.gov.pi.salvemaria.modelo.cadastro.Estado;
import br.gov.pi.salvemaria.modelo.cadastro.Unidade;
import br.gov.pi.salvemaria.modelo.cadastro.Cidade;
import br.gov.pi.salvemaria.modelo.cadastro.Bairro;
import br.gov.pi.salvemaria.modelo.cadastro.Endereco;
import br.gov.pi.salvemaria.modelo.controleacesso.Permissao;
import br.gov.pi.salvemaria.modelo.controleacesso.Usuario;
import br.gov.pi.salvemaria.modelo.configuracao.ErroSistema;
import br.gov.pi.salvemaria.modelo.controleacesso.SituacaoUsuario;
import br.gov.pi.salvemaria.modelo.controleacesso.AcessoSistema;
import br.gov.pi.salvemaria.modelo.email.ConfiguracaoEmail;
import br.gov.pi.salvemaria.modelo.controleacesso.Perfil;
import br.gov.pi.salvemaria.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.gov.pi.salvemaria.modelo.email.ModeloEmail;
import br.gov.pi.salvemaria.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.gov.pi.salvemaria.modelo.email.TipoAssuntoEmail;
import br.gov.pi.salvemaria.modelo.controleacesso.TipoRecuperacaoSenha;
import br.gov.pi.salvemaria.modelo.enums.FaixaEtaria;
import br.gov.pi.salvemaria.modelo.enums.TipoDenuncia;
import br.gov.pi.salvemaria.modelo.enums.TipoUnidade;
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

    public Class getEstado() {
        return Estado.class;
    }

    public Class getUnidade() {
        return Unidade.class;
    }

    public Class getCidade() {
        return Cidade.class;
    }

    public Class getBairro() {
        return Bairro.class;
    }

    public Class getEndereco() {
        return Endereco.class;
    }

    public Class getDenuncia() {
        return Denuncia.class;
    }

    public Class getFormasDeViolencia() {
        return FormasDeViolencia.class;
    }

    public Class getSituacao() {
        return Situacao.class;
    }

    public Class getTipoDenuncia() {
        return TipoDenuncia.class;
    }

    public Class getArquivo() {
        return Arquivo.class;
    }

    public Class getTipoUnidade() {
        return TipoUnidade.class;
    }

    public Class getCircunscricao() {
        return Circunscricao.class;
    }

    public Class getCircunscricao_Bairro() {
        return Circunscricao_Bairro.class;
    }

    public Class getViatura() {
        return Viatura.class;
    }

    public Class getFaixaEtaria() {
        return FaixaEtaria.class;
    }
}
