package br.com.ejccard.mb.padrao;

import br.com.ejccard.modelo.financeiro.Estoque;
import br.com.ejccard.modelo.enums.TipoPagamento;
import br.com.ejccard.modelo.financeiro.Caixa;
import br.com.ejccard.modelo.financeiro.Pedido;
import br.com.ejccard.modelo.financeiro.Movimento;
import br.com.ejccard.modelo.financeiro.EjcCard;
import br.com.ejccard.modelo.cadastro.Equipe;
import br.com.ejccard.modelo.cadastro.Produto;
import br.com.ejccard.modelo.cadastro.Membro;
import br.com.ejccard.modelo.controleacesso.Permissao;
import br.com.ejccard.modelo.controleacesso.Usuario;
import br.com.ejccard.modelo.configuracao.ErroSistema;
import br.com.ejccard.modelo.controleacesso.SituacaoUsuario;
import br.com.ejccard.modelo.controleacesso.AcessoSistema;
import br.com.ejccard.modelo.email.ConfiguracaoEmail;
import br.com.ejccard.modelo.controleacesso.Perfil;
import br.com.ejccard.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.com.ejccard.modelo.email.ModeloEmail;
import br.com.ejccard.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.com.ejccard.modelo.email.TipoAssuntoEmail;
import br.com.ejccard.modelo.controleacesso.TipoRecuperacaoSenha;
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
    

    public Class getEquipe() {
        return Equipe.class;
    }
    public Class getProduto() {
        return Produto.class;
    }
    public Class getMembro() {
        return Membro.class;
    }

    public Class getEstoque() {
        return Estoque.class;
    }
    public Class getTipoPagamento() {
        return TipoPagamento.class;
    }
    public Class getCaixa() {
        return Caixa.class;
    }
    public Class getPedido() {
        return Pedido.class;
    }
    public Class getMovimento() {
        return Movimento.class;
    }
    public Class getEjcCard() {
        return EjcCard.class;
    }

}