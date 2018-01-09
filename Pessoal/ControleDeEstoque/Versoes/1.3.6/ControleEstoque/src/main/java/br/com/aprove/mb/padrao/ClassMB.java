package br.com.aprove.mb.padrao;

import br.com.aprove.modelo.cadastro.enums.LoteIndicadorProcessamento;
import br.com.aprove.modelo.cadastro.enums.Ambiente;
import br.com.aprove.modelo.faturamento.LoteEnvio;
import br.com.aprove.modelo.cadastro.enums.UnidadeFederativa;
import br.com.aprove.modelo.faturamento.ItemVenda;
import br.com.aprove.modelo.faturamento.Venda;
import br.com.aprove.modelo.faturamento.Estoque;
import br.com.aprove.modelo.faturamento.ItemPedido;
import br.com.aprove.modelo.cadastro.enums.FormaDePagamento;
import br.com.aprove.modelo.faturamento.Pedido;
import br.com.aprove.modelo.cadastro.NaturezasDeOperacoes;
import br.com.aprove.modelo.cadastro.Banco;
import br.com.aprove.modelo.cadastro.Fornecedor;
import br.com.aprove.modelo.cadastro.Loja_Filial;
import br.com.aprove.modelo.cadastro.Produto;
import br.com.aprove.modelo.cadastro.enums.TipoFornecedor;
import br.com.aprove.modelo.cadastro.GruposDeSecoes;
import br.com.aprove.modelo.cadastro.SecoesProduto;
import br.com.aprove.modelo.cadastro.GrupoLoja;
import br.com.aprove.modelo.cadastro.SituacaoTributaria;
import br.com.aprove.modelo.cadastro.enums.TipoLoja;
import br.com.aprove.modelo.cadastro.enums.TipoEndereco;
import br.com.aprove.modelo.cadastro.enums.TipoCliente;
import br.com.aprove.modelo.cadastro.Pais;
import br.com.aprove.modelo.cadastro.enums.EstadoCivil;
import br.com.aprove.modelo.cadastro.Cidade;
import br.com.aprove.modelo.cadastro.Estado;
import br.com.aprove.modelo.cadastro.Cliente;
import br.com.aprove.modelo.cadastro.ContaBancaria;
import br.com.aprove.modelo.cadastro.enums.TipoDePessoa;
import br.com.aprove.modelo.cadastro.enums.Sexo;
import br.com.aprove.modelo.cadastro.Convenio;
import br.com.aprove.modelo.cadastro.enums.ModalidadeFrete;
import br.com.aprove.modelo.cadastro.enums.StatusNF;
import br.com.aprove.modelo.cadastro.enums.TipoDeConta;
import br.com.aprove.modelo.cadastro.enums.TipoInsencaoCliente;
import br.com.aprove.modelo.cadastro.enums.TipoPedido;
import br.com.aprove.modelo.cadastro.enums.UnidadeDeMedida;
import br.com.aprove.modelo.controleacesso.Permissao;
import br.com.aprove.modelo.controleacesso.Usuario;
import br.com.aprove.modelo.configuracao.ErroSistema;
import br.com.aprove.modelo.controleacesso.SituacaoUsuario;
import br.com.aprove.modelo.controleacesso.AcessoSistema;
import br.com.aprove.modelo.email.ConfiguracaoEmail;
import br.com.aprove.modelo.controleacesso.Perfil;
import br.com.aprove.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.com.aprove.modelo.email.ModeloEmail;
import br.com.aprove.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.com.aprove.modelo.email.TipoAssuntoEmail;
import br.com.aprove.modelo.controleacesso.TipoRecuperacaoSenha;
import br.com.aprove.modelo.faturamento.NotaFiscal;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ClassMB {

    public Class getAcessoSistema() {
        return AcessoSistema.class;
    }

    public Class getModalidadeFrete() {
        return ModalidadeFrete.class;
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

    public Class getTipoEndereco() {
        return TipoEndereco.class;
    }

    public Class getTipoCliente() {
        return TipoCliente.class;
    }

    public Class getPais() {
        return Pais.class;
    }

    public Class getEstadoCivil() {
        return EstadoCivil.class;
    }

    public Class getCidade() {
        return Cidade.class;
    }

    public Class getEstado() {
        return Estado.class;
    }

    public Class getCliente() {
        return Cliente.class;
    }

    public Class getTipoInsencaoCliente() {
        return TipoInsencaoCliente.class;
    }

    public Class getTipoDePessoa() {
        return TipoDePessoa.class;
    }

    public Class getSexo() {
        return Sexo.class;
    }

    public Class getConvenio() {
        return Convenio.class;
    }

    public Class getFornecedor() {
        return Fornecedor.class;
    }

    public Class getLoja_Filial() {
        return Loja_Filial.class;
    }

    public Class getProduto() {
        return Produto.class;
    }

    public Class getTipoFornecedor() {
        return TipoFornecedor.class;
    }

    public Class getUnidadeDeMedita() {
        return UnidadeDeMedida.class;
    }

    public Class getGruposDeSocoes() {
        return GruposDeSecoes.class;
    }

    public Class getSecoesProduto() {
        return SecoesProduto.class;
    }

    public Class getGrupoLoja() {
        return GrupoLoja.class;
    }

    public Class getSituacaoTributaria() {
        return SituacaoTributaria.class;
    }

    public Class getTipoLoja() {
        return TipoLoja.class;
    }

    public Class getNaturezasDeOperacoes() {
        return NaturezasDeOperacoes.class;
    }

    public Class getBanco() {
        return Banco.class;
    }

    public Class getFormaDePagamento() {
        return FormaDePagamento.class;
    }

    public Class getUnidadeDeMedida() {
        return UnidadeDeMedida.class;
    }

    public Class getPedido() {
        return Pedido.class;
    }

    public Class getItemPedido() {
        return ItemPedido.class;
    }

    public Class getEstoque() {
        return Estoque.class;
    }

    public Class getItemVenda() {
        return ItemVenda.class;
    }

    public Class getVenda() {
        return Venda.class;
    }

    public Class getContaBancaria() {
        return ContaBancaria.class;
    }

    public Class getTipoDeConta() {
        return TipoDeConta.class;
    }

    public Class getTipoPedido() {
        return TipoPedido.class;
    }

    public Class getNotaFiscal() {
        return NotaFiscal.class;
    }

    public Class getStatusNF() {
        return StatusNF.class;
    }

    public Class getLoteIndicadorProcessamento() {
        return LoteIndicadorProcessamento.class;
    }
    public Class getAmbiente() {
        return Ambiente.class;
    }
    public Class getLoteEnvio() {
        return LoteEnvio.class;
    }
    public Class getUnidadeFederativa() {
        return UnidadeFederativa.class;
    }

}