package br.com.facilpagar.mb.padrao;

import br.com.facilpagar.modelo.dados.Sistema;
import br.com.facilpagar.modelo.dados.Franquia;
import br.com.facilpagar.modelo.dados.Contato;
import br.com.facilpagar.modelo.dados.Uf;
import br.com.facilpagar.modelo.enums.TipoRepasse;
import br.com.facilpagar.modelo.dados.Cliente;
import br.com.facilpagar.modelo.dados.Banco;
import br.com.facilpagar.modelo.enums.TipoPessoa;
import br.com.facilpagar.modelo.dados.Produto;
import br.com.facilpagar.modelo.enums.SituacaoBoleto;
import br.com.facilpagar.modelo.dados.Convenio;
import br.com.facilpagar.modelo.dados.Boleto;
import br.com.facilpagar.modelo.dados.Deposito;
import br.com.facilpagar.modelo.dados.Cidade;
import br.com.facilpagar.modelo.controleacesso.Permissao;
import br.com.facilpagar.modelo.controleacesso.Usuario;
import br.com.facilpagar.modelo.configuracao.ErroSistema;
import br.com.facilpagar.modelo.controleacesso.SituacaoUsuario;
import br.com.facilpagar.modelo.controleacesso.AcessoSistema;
import br.com.facilpagar.modelo.email.ConfiguracaoEmail;
import br.com.facilpagar.modelo.controleacesso.Perfil;
import br.com.facilpagar.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.com.facilpagar.modelo.email.ModeloEmail;
import br.com.facilpagar.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.com.facilpagar.modelo.email.TipoAssuntoEmail;
import br.com.facilpagar.modelo.controleacesso.TipoRecuperacaoSenha;
import br.com.facilpagar.modelo.enums.Ativo;
import br.com.facilpagar.modelo.enums.SituacaoDeposito;
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

    public Class getAtivo() {
        return Ativo.class;
    }

    public Class getSituacaoDeposito() {
        return SituacaoDeposito.class;
    }
    public Class getFranquia() {
        return Franquia.class;
    }

    public Class getSistema() {
        return Sistema.class;
    }

}