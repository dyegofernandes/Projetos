package com.ebol.mb.padrao;

import com.ebol.modelo.cadastro.Banco;
import com.ebol.modelo.venda.Acrescimo;
import com.ebol.modelo.enuns.SituacaoCredito;
import com.ebol.modelo.venda.OpLancada;
import com.ebol.modelo.enuns.SituacaoDebito;
import com.ebol.modelo.venda.Venda;
import com.ebol.modelo.venda.Desconto;
import com.ebol.modelo.venda.Boleto;
import com.ebol.modelo.enuns.SituacaoOpLancada;
import com.ebol.modelo.venda.Item;
import com.ebol.modelo.cadastro.Loja;
import com.ebol.modelo.venda.Item_Vendido;
import com.ebol.modelo.enuns.SituacaoBoleto;
import com.ebol.modelo.venda.Debito;
import com.ebol.modelo.venda.Credito;
import com.ebol.modelo.cadastro.Cliente;
import com.ebol.modelo.cadastro.Cidade;
import com.ebol.modelo.enuns.TipoPessoa;
import com.ebol.modelo.cadastro.Socio;
import com.ebol.modelo.enuns.TipoRepasse;
import com.ebol.modelo.cadastro.Convenio;
import com.ebol.modelo.cadastro.Contato;
import com.ebol.modelo.cadastro.PessoaOp;
import com.ebol.modelo.cadastro.Familiar;
import com.ebol.modelo.cadastro.Uf;
import com.ebol.modelo.cadastro.Padrao_Cobranca;
import com.ebol.modelo.controleacesso.Permissao;
import com.ebol.modelo.controleacesso.Usuario;
import com.ebol.modelo.configuracao.ErroSistema;
import com.ebol.modelo.controleacesso.SituacaoUsuario;
import com.ebol.modelo.controleacesso.AcessoSistema;
import com.ebol.modelo.email.ConfiguracaoEmail;
import com.ebol.modelo.controleacesso.Perfil;
import com.ebol.modelo.controleacesso.HistoricoSituacaoUsuario;
import com.ebol.modelo.email.ModeloEmail;
import com.ebol.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import com.ebol.modelo.email.TipoAssuntoEmail;
import com.ebol.modelo.controleacesso.TipoRecuperacaoSenha;
import com.ebol.modelo.enuns.Meses;
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

    public Class getCliente() {
        return Cliente.class;
    }
    public Class getCidade() {
        return Cidade.class;
    }
    public Class getTipoPessoa() {
        return TipoPessoa.class;
    }
    public Class getSocio() {
        return Socio.class;
    }
    public Class getTipoRepasse() {
        return TipoRepasse.class;
    }
    public Class getConvenio() {
        return Convenio.class;
    }
    public Class getContato() {
        return Contato.class;
    }
    public Class getPessoaOp() {
        return PessoaOp.class;
    }
    public Class getFamiliar() {
        return Familiar.class;
    }
    public Class getUf() {
        return Uf.class;
    }
    public Class getPadrao_Cobranca() {
        return Padrao_Cobranca.class;
    }

    public Class getAcrescimo() {
        return Acrescimo.class;
    }
    public Class getSituacaoCredito() {
        return SituacaoCredito.class;
    }
    public Class getOpLancada() {
        return OpLancada.class;
    }
    public Class getSituacaoDebito() {
        return SituacaoDebito.class;
    }
    public Class getVenda() {
        return Venda.class;
    }
    public Class getDesconto() {
        return Desconto.class;
    }
    public Class getBoleto() {
        return Boleto.class;
    }
    public Class getSituacaoOpLancada() {
        return SituacaoOpLancada.class;
    }
    public Class getItem() {
        return Item.class;
    }
    public Class getLoja() {
        return Loja.class;
    }
    public Class getItem_Vendido() {
        return Item_Vendido.class;
    }
    public Class getSituacaoBoleto() {
        return SituacaoBoleto.class;
    }
    public Class getDebito() {
        return Debito.class;
    }
    public Class getCredito() {
        return Credito.class;
    }

    public Class getMeses() {
        return Meses.class;
    }
    public Class getBanco() {
        return Banco.class;
    }

}