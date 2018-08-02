package br.gov.pi.ati.sisdh.mb.padrao;

import br.gov.pi.ati.sisdh.modelo.cadastro.enums.Raca;
import br.gov.pi.ati.sisdh.modelo.cadastro.NaturezaDaViolacao;
import br.gov.pi.ati.sisdh.modelo.cadastro.GrupoDeViolacao;
import br.gov.pi.ati.sisdh.modelo.cadastro.Estado;
import br.gov.pi.ati.sisdh.modelo.cadastro.Bairro;
import br.gov.pi.ati.sisdh.modelo.cadastro.Cidade;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.FaixaEtaria;
import br.gov.pi.ati.sisdh.modelo.cadastro.TerritorioCidade;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.TipoUnidade;
import br.gov.pi.ati.sisdh.modelo.cadastro.TerritorioBairro;
import br.gov.pi.ati.sisdh.modelo.cadastro.Unidade;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.FormasDeViolencia;
import br.gov.pi.ati.sisdh.modelo.denuncia.Arquivo;
import br.gov.pi.ati.sisdh.modelo.denuncia.Denuncia;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.TipoDenuncia;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.Demandante;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.Situacao;
import br.gov.pi.ati.sisdh.modelo.cadastro.Endereco;
import br.gov.pi.ati.sisdh.modelo.formulario.AtaDeReuniao;
import br.gov.pi.ati.sisdh.modelo.formulario.RelatorioDeVisita;
import br.gov.pi.ati.sisdh.modelo.cadastro.Orgao;
import br.gov.pi.ati.sisdh.modelo.formulario.FormAcessoConteudo;
import br.gov.pi.ati.sisdh.modelo.formulario.PendenciaIdentificada;
import br.gov.pi.ati.sisdh.modelo.formulario.FormCriacaoEmail;
import br.gov.pi.ati.sisdh.modelo.formulario.Participante;
import br.gov.pi.ati.sisdh.modelo.cadastro.AcolhimentoTriagemLgbt;
import br.gov.pi.ati.sisdh.modelo.cadastro.AgendamentoTriagem;
import br.gov.pi.ati.sisdh.modelo.cadastro.ArquivoLGBT;
import br.gov.pi.ati.sisdh.modelo.cadastro.EncaminhamentoLGBT;
import br.gov.pi.ati.sisdh.modelo.cadastro.FichaDeVisitaDomiciliar;
import br.gov.pi.ati.sisdh.modelo.cadastro.FichaDeVisitaInstitucionalLGBT;
import br.gov.pi.ati.sisdh.modelo.cadastro.ProcedimentoFichaDeVisitaLgbt;
import br.gov.pi.ati.sisdh.modelo.cadastro.ProfissionalDeReferenciaFichaVisita;
import br.gov.pi.ati.sisdh.modelo.cadastro.RoteiroDeTriagemDoUsuarioLGBT;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.AreaAtuacao;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.ComQuemMora;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.EstadoCivil;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.Etnia;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.IdentidadeGenero;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.OrientacaoSexual;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.Religiao;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.RendaFamiliar;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.ResideEm;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.Sexo;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.SimOuNao;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.SimOuNaoOutros;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.Solicitante;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.TipoDeServicoLgbt;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.TipoMoradia;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.TipoProfissional;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.TodosDocumento;
import br.gov.pi.ati.sisdh.modelo.controleacesso.Permissao;
import br.gov.pi.ati.sisdh.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisdh.modelo.configuracao.ErroSistema;
import br.gov.pi.ati.sisdh.modelo.controleacesso.SituacaoUsuario;
import br.gov.pi.ati.sisdh.modelo.controleacesso.AcessoSistema;
import br.gov.pi.ati.sisdh.modelo.email.ConfiguracaoEmail;
import br.gov.pi.ati.sisdh.modelo.controleacesso.Perfil;
import br.gov.pi.ati.sisdh.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.gov.pi.ati.sisdh.modelo.email.ModeloEmail;
import br.gov.pi.ati.sisdh.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.gov.pi.ati.sisdh.modelo.email.TipoAssuntoEmail;
import br.gov.pi.ati.sisdh.modelo.controleacesso.TipoRecuperacaoSenha;
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

    public Class getAreaAtuacao(){
        return AreaAtuacao.class;
    }
    
    public Class getComQuemMora(){
        return ComQuemMora.class;
    }
    
    public Class getEstadoCivil(){
        return EstadoCivil.class;
    }
    
    public Class getEtnia(){
        return Etnia.class;
    }
    
    public Class getIdentidadeGenero(){
        return IdentidadeGenero.class;
    }
    
    public Class getOrientacaoSexual(){
        return OrientacaoSexual.class;
    }
    
    public Class getReligiao(){
        return Religiao.class;
    }
    
    public Class getRendaFamiliar(){
        return RendaFamiliar.class;
    }
    
    public Class getResideEm(){
        return ResideEm.class;
    }
    
    public Class getSexo(){
        return Sexo.class;
    }
    
    public Class getSimOuNao(){
        return SimOuNao.class;
    }
    
    public Class getSimOuNaoOutros(){
        return SimOuNaoOutros.class;
    }
    
    public Class getSolicitante(){
        return Solicitante.class;
    }
    
    public Class getTipoDeServicoLgbt(){
        return TipoDeServicoLgbt.class;
    }
    
    public Class getTipoMoradia(){
        return TipoMoradia.class;
    }
    
    public Class getTipoProfissional(){
        return TipoProfissional.class;
    }
    
    public Class getTodosDocumento(){
        return TodosDocumento.class;
    }
    
    public Class getAcolhimentoTriagemLgbt(){
        return AcolhimentoTriagemLgbt.class;
    }
    
    public Class getAgendamentoTriagem(){
        return AgendamentoTriagem.class;
    }
    
    public Class getArquivoLGBT(){
        return ArquivoLGBT.class;
    }
    
    public Class getEncaminhamentoLGBT(){
        return EncaminhamentoLGBT.class;
    }
    
    public Class getFichaDeVisitaDomiciliar(){
        return FichaDeVisitaDomiciliar.class;
    }
    
    public Class getFichaDeVisitaInstitucionalLGBT(){
        return FichaDeVisitaInstitucionalLGBT.class;
    }
    
    public Class getProcedimentoFichaDeVisitaLgbt(){
        return ProcedimentoFichaDeVisitaLgbt.class;
    }
    
    public Class getProfissionalDeReferenciaFichaVisita(){
        return ProfissionalDeReferenciaFichaVisita.class;
    }
    
    public Class getRoteiroDeTriagemDoUsuarioLGBT(){
        return RoteiroDeTriagemDoUsuarioLGBT.class;
    }
    public Class getAtaDeReuniao() {
        return AtaDeReuniao.class;
    }
    public Class getRelatorioDeVisita() {
        return RelatorioDeVisita.class;
    }
    public Class getOrgao() {
        return Orgao.class;
    }
    public Class getFormAcessoConteudo() {
        return FormAcessoConteudo.class;
    }
    public Class getPendenciaIdentificada() {
        return PendenciaIdentificada.class;
    }
    public Class getFormCriacaoEmail() {
        return FormCriacaoEmail.class;
    }
    public Class getParticipante() {
        return Participante.class;
    }

    public Class getUnidade() {
        return Unidade.class;
    }
      public Class getSituacao() {
        return Situacao.class;
    }
   public Class getArquivo() {
        return Arquivo.class;
    }

    public Class getFormasDeViolencia() {
        return FormasDeViolencia.class;
    }
    public Class getDenuncia() {
        return Denuncia.class;
    }
    public Class getTipoDenuncia() {
        return TipoDenuncia.class;
    }
    public Class getDemandante() {
        return Demandante.class;
    }
    public Class getEndereco() {
        return Endereco.class;
    }

    public Class getFaixaEtaria() {
        return FaixaEtaria.class;
    }
   
    public Class getTipoUnidade() {
        return TipoUnidade.class;
    }
   

    public Class getCidade() {
        return Cidade.class;
    }

    public Class getBairro() {
        return Bairro.class;
    }
 public Class getEstado() {
        return Estado.class;
    }

    public Class getTerritorioCidade() {
        return TerritorioCidade.class;
    }

    public Class getTerritorioBairro() {
        return TerritorioBairro.class;
    }

    public Class getNaturezaDaViolacao() {
        return NaturezaDaViolacao.class;
    }
    public Class getGrupoDeViolacao() {
        return GrupoDeViolacao.class;
    }

    public Class getRaca() {
        return Raca.class;
    }

}