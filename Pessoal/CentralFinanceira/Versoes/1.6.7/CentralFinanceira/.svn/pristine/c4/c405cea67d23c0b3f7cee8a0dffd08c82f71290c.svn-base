package br.com.jsoft.centralfinanceira.mb.padrao;

import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.ListaLoja;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.ListaLoja_Loja;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.GrupoLoja;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.CalGuia;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.CalGuiaItem;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ContasAPagarVencimentosBaixas;
import br.com.jsoft.centralfinanceira.modelo.financeiro.Lancamentos;
import br.com.jsoft.centralfinanceira.modelo.enums.OrigemLancamento;
import br.com.jsoft.centralfinanceira.modelo.arquivo.TipoRepasse;
import br.com.jsoft.centralfinanceira.modelo.enums.EstadoCivil;
import br.com.jsoft.centralfinanceira.modelo.enums.Escolaridade;
import br.com.jsoft.centralfinanceira.modelo.enums.Bancos;
import br.com.jsoft.centralfinanceira.modelo.contrato.PagContas;
import br.com.jsoft.centralfinanceira.modelo.contrato.Contrato;
import br.com.jsoft.centralfinanceira.modelo.central.FatosBanPop;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.ConvenioBanPop;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Conveniobb;
import br.com.jsoft.centralfinanceira.modelo.central.Fatosbb;
import br.com.jsoft.centralfinanceira.modelo.central.FatosRecarga;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.ConvenioRecarga;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.ConvenioBoleto;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.ConvenioGas;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.ConvenioSite;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Conveniocredigi;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Conveniop;
import br.com.jsoft.centralfinanceira.modelo.central.DespesaLoja;
import br.com.jsoft.centralfinanceira.modelo.central.FatosBoletoSite;
import br.com.jsoft.centralfinanceira.modelo.central.FatosBoletos;
import br.com.jsoft.centralfinanceira.modelo.central.FatosCreditos;
import br.com.jsoft.centralfinanceira.modelo.central.FatosValeGas;
import br.com.jsoft.centralfinanceira.modelo.central.Fatosops;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Loja;
import br.com.jsoft.centralfinanceira.modelo.central.ReceitaLoja;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Segmento;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.TipoDespesa;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.TipoFloat;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.TipoLoja;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.TipoReceita;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Uf;
import br.com.jsoft.centralfinanceira.modelo.controleacesso.Permissao;
import br.com.jsoft.centralfinanceira.modelo.configuracao.ErroSistema;
import br.com.jsoft.centralfinanceira.modelo.contrato.Endereco;
import br.com.jsoft.centralfinanceira.modelo.contrato.Equipe;
import br.com.jsoft.centralfinanceira.modelo.contrato.Filho;
import br.com.jsoft.centralfinanceira.modelo.controleacesso.SituacaoUsuario;
import br.com.jsoft.centralfinanceira.modelo.controleacesso.AcessoSistema;
import br.com.jsoft.centralfinanceira.modelo.email.ConfiguracaoEmail;
import br.com.jsoft.centralfinanceira.modelo.controleacesso.Perfil;
import br.com.jsoft.centralfinanceira.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.com.jsoft.centralfinanceira.modelo.email.ModeloEmail;
import br.com.jsoft.centralfinanceira.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.com.jsoft.centralfinanceira.modelo.email.TipoAssuntoEmail;
import br.com.jsoft.centralfinanceira.modelo.controleacesso.TipoRecuperacaoSenha;
import br.com.jsoft.centralfinanceira.modelo.controleacesso.Usuario;
import br.com.jsoft.centralfinanceira.modelo.enums.CidadeOuLoja;
import br.com.jsoft.centralfinanceira.modelo.enums.TipoBoletos;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Empresa;
import br.com.jsoft.centralfinanceira.modelo.enums.RegimeCONFINS;
import br.com.jsoft.centralfinanceira.modelo.enums.IndicadorIEDestinatario;
import br.com.jsoft.centralfinanceira.modelo.enums.TipoComissao;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.ContaFinanceira;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Cliente;
import br.com.jsoft.centralfinanceira.modelo.enums.TipoContaBanco;
import br.com.jsoft.centralfinanceira.modelo.enums.TipoHistorico;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.GrupoCliente;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Representante;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.GrupoFornecedor;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.AgenteCobrador;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Estabelecimento;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.GrupoContaFinanceira;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Cidade;
import br.com.jsoft.centralfinanceira.modelo.enums.FinalidadeTed;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ReceitaDespesa;
import br.com.jsoft.centralfinanceira.modelo.enums.Leiaute;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.TabelaDeComissao;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.TipoDocumento;
import br.com.jsoft.centralfinanceira.modelo.enums.FinalidadeDoc;
import br.com.jsoft.centralfinanceira.modelo.financeiro.CentroResultados;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.GrupoReceitaDespesa;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.HistoricoPadrao;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Fornecedor;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Transportadora;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.InstrucaoCobranca;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Banco;
import br.com.jsoft.centralfinanceira.modelo.enums.Destacar;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ContasAPagar;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Pais;
import br.com.jsoft.centralfinanceira.modelo.enums.Ativo;
import br.com.jsoft.centralfinanceira.modelo.enums.CredDeb;
import br.com.jsoft.centralfinanceira.modelo.enums.NaturezaDespesa;
import br.com.jsoft.centralfinanceira.modelo.enums.OrdenacaoContasAPagar;
import br.com.jsoft.centralfinanceira.modelo.enums.Periodicidade;
import br.com.jsoft.centralfinanceira.modelo.enums.Quitado;
import br.com.jsoft.centralfinanceira.modelo.enums.Sexo;
import br.com.jsoft.centralfinanceira.modelo.enums.Situacao;
import br.com.jsoft.centralfinanceira.modelo.enums.TipoDeBusca;
import br.com.jsoft.centralfinanceira.modelo.enums.TipoDePessoa;
import br.com.jsoft.centralfinanceira.modelo.enums.TipoDespesaEnum;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ContasAPagarVencimentos;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ClassMB {

    public Class getLoja() {
        return Loja.class;
    }

    public Class getFatosBoletoSite() {
        return FatosBoletoSite.class;
    }

    public Class getConvenioSite() {
        return ConvenioSite.class;
    }

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

    public Class getTipoFloat() {
        return TipoFloat.class;
    }

    public Class getConvenioBoleto() {
        return ConvenioBoleto.class;
    }

    public Class getUf() {
        return Uf.class;
    }

    public Class getCidade() {
        return Cidade.class;
    }

    public Class getSegmento() {
        return Segmento.class;
    }

    public Class getFatosBoletos() {
        return FatosBoletos.class;
    }

    public Class getConveniop() {
        return Conveniop.class;
    }

    public Class getFatosops() {
        return Fatosops.class;
    }

    public Class getConveniocredigi() {
        return Conveniocredigi.class;
    }

    public Class getFatosCreditos() {
        return FatosCreditos.class;
    }

    public Class getFatosValeGas() {
        return FatosValeGas.class;
    }

    public Class getConvenioGas() {
        return ConvenioGas.class;
    }

    public Class getFatosRecarga() {
        return FatosRecarga.class;
    }

    public Class getConvenioRecarga() {
        return ConvenioRecarga.class;
    }

    public Class getConveniobb() {
        return Conveniobb.class;
    }

    public Class getFatosbb() {
        return Fatosbb.class;
    }

    public Class getFatosBanPop() {
        return FatosBanPop.class;
    }

    public Class getConvenioBanPop() {
        return ConvenioBanPop.class;
    }

    public Class getEstadoCivil() {
        return EstadoCivil.class;
    }

    public Class getCidadeOuLoja() {
        return CidadeOuLoja.class;
    }

    public Class getTipoBoletos() {
        return TipoBoletos.class;
    }

    public Class getEscolaridade() {
        return Escolaridade.class;
    }

    public Class getTipoContaBanco() {
        return TipoContaBanco.class;
    }

    public Class getTipoRepasse() {
        return TipoRepasse.class;
    }

    public Class getBancos() {
        return Bancos.class;
    }

    public Class getPagContas() {
        return PagContas.class;
    }

    public Class getContrato() {
        return Contrato.class;
    }

    public Class getEquipe() {
        return Equipe.class;
    }

    public Class getFilho() {
        return Filho.class;
    }

    public Class getEndereco() {
        return Endereco.class;
    }

    public Class getTipoDespesa() {
        return TipoDespesa.class;
    }

    public Class getReceitaLoja() {
        return ReceitaLoja.class;
    }

    public Class getTipoReceita() {
        return TipoReceita.class;
    }

    public Class getDespesaLoja() {
        return DespesaLoja.class;
    }

    public Class getTipoLoja() {
        return TipoLoja.class;
    }

    public Class getEmpresa() {
        return Empresa.class;
    }

    public Class getRegimeCONFINS() {
        return RegimeCONFINS.class;
    }

    public Class getIndicadorIEDestinatario() {
        return IndicadorIEDestinatario.class;
    }

    public Class getTipoComissao() {
        return TipoComissao.class;
    }

    public Class getContaFinanceira() {
        return ContaFinanceira.class;
    }

    public Class getCliente() {
        return Cliente.class;
    }

    public Class getTipoHistorico() {
        return TipoHistorico.class;
    }

    public Class getGrupoCliente() {
        return GrupoCliente.class;
    }

    public Class getRepresentante() {
        return Representante.class;
    }

    public Class getGrupoFornecedor() {
        return GrupoFornecedor.class;
    }

    public Class getAgenteCobrador() {
        return AgenteCobrador.class;
    }

    public Class getEstabelecimento() {
        return Estabelecimento.class;
    }

    public Class getGrupoContaFinanceira() {
        return GrupoContaFinanceira.class;
    }

    public Class getFinalidadeTed() {
        return FinalidadeTed.class;
    }

    public Class getReceitaDespesa() {
        return ReceitaDespesa.class;
    }

    public Class getLeiaute() {
        return Leiaute.class;
    }
    
    public Class getSituacao() {
        return Situacao.class;
    }

    public Class getTabelaDeComissao() {
        return TabelaDeComissao.class;
    }

    public Class getTipoDocumento() {
        return TipoDocumento.class;
    }

    public Class getFinalidadeDoc() {
        return FinalidadeDoc.class;
    }

    public Class getCentroResultados() {
        return CentroResultados.class;
    }

    public Class getGrupoReceitaDespesa() {
        return GrupoReceitaDespesa.class;
    }

    public Class getHistoricoPadrao() {
        return HistoricoPadrao.class;
    }

    public Class getFornecedor() {
        return Fornecedor.class;
    }

    public Class getTransportadora() {
        return Transportadora.class;
    }

    public Class getInstrucaoCobranca() {
        return InstrucaoCobranca.class;
    }

    public Class getBanco() {
        return Banco.class;
    }

    public Class getDestacar() {
        return Destacar.class;
    }

    public Class getContasAPagar() {
        return ContasAPagar.class;
    }

    public Class getPais() {
        return Pais.class;
    }

    public Class getSexo() {
        return Sexo.class;
    }
    
    public Class getAtivo() {
        return Ativo.class;
    }

    public Class getPeriodicidade() {
        return Periodicidade.class;
    }

    public Class getTipoDePessoa() {
        return TipoDePessoa.class;
    }

    public Class getNaturezaDespesa() {
        return NaturezaDespesa.class;
    }

    public Class getTipoDespesaEnum() {
        return TipoDespesaEnum.class;
    }

    public Class getQuitado() {
        return Quitado.class;
    }

    public Class getContasAPagarVencimentos() {
        return ContasAPagarVencimentos.class;
    }

    public Class getLancamentos() {
        return Lancamentos.class;
    }

    public Class getOrigemLancamento() {
        return OrigemLancamento.class;
    }

    public Class getContasAPagarVencimentosBaixas() {
        return ContasAPagarVencimentosBaixas.class;
    }

    public Class getTipoDeBusca() {
        return TipoDeBusca.class;
    }
    
    public Class getOrdenacaoContasAPagar() {
        return OrdenacaoContasAPagar.class;
    }
    
    public Class getGrupoLoja() {
        return GrupoLoja.class;
    }
    public Class getCalGuia() {
        return CalGuia.class;
    }
    public Class getCalGuiaItem() {
        return CalGuiaItem.class;
    }
    
    public Class getCredDeb() {
        return CredDeb.class;
    }

    public Class getListaLoja() {
        return ListaLoja.class;
    }
    public Class getListaLoja_Loja() {
        return ListaLoja_Loja.class;
    }

}