package br.com.pagcontascarne.mb.padrao;

import br.com.pagcontascarne.modelo.dados.Contato;
import br.com.pagcontascarne.modelo.dados.Uf;
import br.com.pagcontascarne.modelo.enums.TipoRepasse;
import br.com.pagcontascarne.modelo.dados.Cliente;
import br.com.pagcontascarne.modelo.dados.Banco;
import br.com.pagcontascarne.modelo.enums.TipoPessoa;
import br.com.pagcontascarne.modelo.dados.Produto;
import br.com.pagcontascarne.modelo.enums.SituacaoBoleto;
import br.com.pagcontascarne.modelo.dados.Convenio;
import br.com.pagcontascarne.modelo.dados.Boleto;
import br.com.pagcontascarne.modelo.dados.Deposito;
import br.com.pagcontascarne.modelo.dados.Cidade;
import br.com.pagcontascarne.modelo.controleacesso.Permissao;
import br.com.pagcontascarne.modelo.controleacesso.Usuario;
import br.com.pagcontascarne.modelo.configuracao.ErroSistema;
import br.com.pagcontascarne.modelo.controleacesso.SituacaoUsuario;
import br.com.pagcontascarne.modelo.controleacesso.AcessoSistema;
import br.com.pagcontascarne.modelo.email.ConfiguracaoEmail;
import br.com.pagcontascarne.modelo.controleacesso.Perfil;
import br.com.pagcontascarne.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.com.pagcontascarne.modelo.email.ModeloEmail;
import br.com.pagcontascarne.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.com.pagcontascarne.modelo.email.TipoAssuntoEmail;
import br.com.pagcontascarne.modelo.controleacesso.TipoRecuperacaoSenha;
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
    public Class getContato() {
        return Contato.class;
    }
    public Class getUf() {
        return Uf.class;
    }
    public Class getTipoRepasse() {
        return TipoRepasse.class;
    }
    public Class getCliente() {
        return Cliente.class;
    }
    public Class getBanco() {
        return Banco.class;
    }
    public Class getTipoPessoa() {
        return TipoPessoa.class;
    }
    public Class getProduto() {
        return Produto.class;
    }
    public Class getSituacaoBoleto() {
        return SituacaoBoleto.class;
    }
    public Class getConvenio() {
        return Convenio.class;
    }
    public Class getBoleto() {
        return Boleto.class;
    }
    public Class getDeposito() {
        return Deposito.class;
    }
    public Class getCidade() {
        return Cidade.class;
    }

}