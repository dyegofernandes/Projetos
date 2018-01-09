package br.gov.pi.ati.sisforms.mb.padrao;

import br.gov.pi.ati.sisforms.modelo.cadastro.TipoCertificado;
import br.gov.pi.ati.sisforms.modelo.cadastro.OrgaoCertificado;
import br.gov.pi.ati.sisforms.modelo.servicos.ReservaLocal;
import br.gov.pi.ati.sisforms.modelo.servicos.LocalReserva;
import br.gov.pi.ati.sisforms.modelo.enums.TipoLocal;
import br.gov.pi.ati.sisforms.modelo.monitoramento.InterrupcaoPontoAcesso;
import br.gov.pi.ati.sisforms.modelo.cadastro.PontoAcesso;
import br.gov.pi.ati.sisforms.modelo.enums.StatusPontoAcesso;
import br.gov.pi.ati.sisforms.modelo.enums.AutoridadeCertificadora;
import br.gov.pi.ati.sisforms.modelo.enums.DocumentacaoCertificado;
import br.gov.pi.ati.sisforms.modelo.formulario.ControleDeCertificado;
import br.gov.pi.ati.sisforms.modelo.enums.TipoCertificadoEnum;
import br.gov.pi.ati.sisforms.modelo.formulario.ProcedimentoFichaDeVisitaLgbt;
import br.gov.pi.ati.sisforms.modelo.enums.Solicitante;
import br.gov.pi.ati.sisforms.modelo.formulario.FichaDeVisitaDomiciliar;
import br.gov.pi.ati.sisforms.modelo.enums.FormasDeViolencia;
import br.gov.pi.ati.sisforms.modelo.enums.SimOuNao;
import br.gov.pi.ati.sisforms.modelo.formulario.FormularioDeDenunciaLGBT;
import br.gov.pi.ati.sisforms.modelo.enums.TipoViolencia;
import br.gov.pi.ati.sisforms.modelo.formulario.PessoaDenuncia;
import br.gov.pi.ati.sisforms.modelo.enums.LgbtSituacaoViolencia;
import br.gov.pi.ati.sisforms.modelo.enums.Adulto;
import br.gov.pi.ati.sisforms.modelo.enums.UsoDeDrogas;
import br.gov.pi.ati.sisforms.modelo.formulario.EncaminhamentoLGBT;
import br.gov.pi.ati.sisforms.modelo.formulario.ProfissionalDeReferenciaFichaVisita;
import br.gov.pi.ati.sisforms.modelo.formulario.FichaDeVisitaInstitucionalLGBT;
import br.gov.pi.ati.sisforms.modelo.formulario.RoteiroDeTriagemDoUsuarioLGBT;
import br.gov.pi.ati.sisforms.modelo.enums.TipoMoradia;
import br.gov.pi.ati.sisforms.modelo.enums.Sexo;
import br.gov.pi.ati.sisforms.modelo.enums.Etnia;
import br.gov.pi.ati.sisforms.modelo.enums.ComQuemMora;
import br.gov.pi.ati.sisforms.modelo.enums.RendaFamiliar;
import br.gov.pi.ati.sisforms.modelo.enums.OrientacaoSexual;
import br.gov.pi.ati.sisforms.modelo.enums.IdentidadeGenero;
import br.gov.pi.ati.sisforms.modelo.enums.TodosDocumento;
import br.gov.pi.ati.sisforms.modelo.enums.Religiao;
import br.gov.pi.ati.sisforms.modelo.enums.EstadoCivil;
import br.gov.pi.ati.sisforms.modelo.enums.ResideEm;
import br.gov.pi.ati.sisforms.modelo.enums.TipoFormulario;
import br.gov.pi.ati.sisforms.modelo.cadastro.ArquivoPublico;
import br.gov.pi.ati.sisforms.modelo.cadastro.ArquivoRelatorioDeViagem;
import br.gov.pi.ati.sisforms.modelo.cadastro.ArquivoRelatorioDeVisita;
import br.gov.pi.ati.sisforms.modelo.formulario.FormSeloAtitudeMulher;
import br.gov.pi.ati.sisforms.modelo.formulario.ItemFormAcessoConteudo;
import br.gov.pi.ati.sisforms.modelo.formulario.ItemFormCriacaoEmail;
import br.gov.pi.ati.sisforms.modelo.cadastro.Orgao;
import br.gov.pi.ati.sisforms.modelo.formulario.Participante;
import br.gov.pi.ati.sisforms.modelo.formulario.AtaDeReuniao;
import br.gov.pi.ati.sisforms.modelo.formulario.PendenciaIdentificada;
import br.gov.pi.ati.sisforms.modelo.formulario.PautaDaReuniao;
import br.gov.pi.ati.sisforms.modelo.formulario.Observacao;
import br.gov.pi.ati.sisforms.modelo.formulario.Deliberacao;
import br.gov.pi.ati.sisforms.modelo.formulario.RelatorioDeVisita;
import br.gov.pi.ati.sisforms.modelo.formulario.RelatorioDeViagem;
import br.gov.pi.ati.sisforms.modelo.formulario.AtividadeRelatorioViagem;
import br.gov.pi.ati.sisforms.modelo.formulario.ModuloInfoFolha;
import br.gov.pi.ati.sisforms.modelo.formulario.SolicitacaoAcessoInfoFolha;
import br.gov.pi.ati.sisforms.modelo.formulario.ModuloSFP;
import br.gov.pi.ati.sisforms.modelo.formulario.ModuloSFPOcorrencia;
import br.gov.pi.ati.sisforms.modelo.formulario.SolicitacaoAcessoSFP;
import br.gov.pi.ati.sisforms.modelo.formulario.ItemDaRequisicaoDeMaterial;
import br.gov.pi.ati.sisforms.modelo.formulario.RequisicaoDeMaterial;
import br.gov.pi.ati.sisforms.modelo.formulario.FormCriacaoEmail;
import br.gov.pi.ati.sisforms.modelo.formulario.FormRegistroDominio;
import br.gov.pi.ati.sisforms.modelo.formulario.FormAcessoConteudo;
import br.gov.pi.ati.sisforms.modelo.formulario.Requerimento;
import br.gov.pi.ati.sisforms.modelo.enums.Situacao;
import br.gov.pi.ati.sisforms.modelo.enums.AssuntoRequerimento;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Permissao;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisforms.modelo.configuracao.ErroSistema;
import br.gov.pi.ati.sisforms.modelo.controleacesso.SituacaoUsuario;
import br.gov.pi.ati.sisforms.modelo.controleacesso.AcessoSistema;
import br.gov.pi.ati.sisforms.modelo.email.ConfiguracaoEmail;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Perfil;
import br.gov.pi.ati.sisforms.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.gov.pi.ati.sisforms.modelo.email.ModeloEmail;
import br.gov.pi.ati.sisforms.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.gov.pi.ati.sisforms.modelo.email.TipoAssuntoEmail;
import br.gov.pi.ati.sisforms.modelo.controleacesso.TipoRecuperacaoSenha;
import br.gov.pi.ati.sisforms.modelo.enums.AreaAtuacao;
import br.gov.pi.ati.sisforms.modelo.enums.NaturezaEmpresa;
import br.gov.pi.ati.sisforms.modelo.enums.SimOuNaoOutros;
import br.gov.pi.ati.sisforms.modelo.enums.SituacaoCertificadoEmitido;
import br.gov.pi.ati.sisforms.modelo.enums.SituacaoDeRua;
import br.gov.pi.ati.sisforms.modelo.enums.StatusDominio;
import br.gov.pi.ati.sisforms.modelo.enums.TipoDeAcesso;
import br.gov.pi.ati.sisforms.modelo.enums.TipoDeServicoLgbt;
import br.gov.pi.ati.sisforms.modelo.enums.TipoPessoa;
import br.gov.pi.ati.sisforms.modelo.enums.TipoProfissional;
import br.gov.pi.ati.sisforms.modelo.enums.TrabalhadorTipo;
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

    public Class getRequerimento() {
        return Requerimento.class;
    }

    public Class getAssuntoRequerimento() {
        return AssuntoRequerimento.class;
    }

    public Class getSituacao() {
        return Situacao.class;
    }

    public Class getStatusDominio() {
        return StatusDominio.class;
    }

    public Class getTrabalhadorTipo() {
        return TrabalhadorTipo.class;
    }

    public Class getNaturezaEmpresa() {
        return NaturezaEmpresa.class;
    }

    public Class getFormCriacaoEmail() {
        return FormCriacaoEmail.class;
    }

    public Class getFormRegistroDominio() {
        return FormRegistroDominio.class;
    }

    public Class getFormAcessoConteudo() {
        return FormAcessoConteudo.class;
    }

    public Class getItemDaRequisicaoDeMaterial() {
        return ItemDaRequisicaoDeMaterial.class;
    }

    public Class getRequisicaoDeMaterial() {
        return RequisicaoDeMaterial.class;
    }

    public Class getModuloSFP() {
        return ModuloSFP.class;
    }

    public Class getModuloSFPOcorrencia() {
        return ModuloSFPOcorrencia.class;
    }

    public Class getSolicitacaoAcessoSFP() {
        return SolicitacaoAcessoSFP.class;
    }

    public Class getModuloInfoFolha() {
        return ModuloInfoFolha.class;
    }

    public Class getSolicitacaoAcessoInfoFolha() {
        return SolicitacaoAcessoInfoFolha.class;
    }

    public Class getRelatorioDeViagem() {
        return RelatorioDeViagem.class;
    }

    public Class getAtividadeRelatorioViagem() {
        return AtividadeRelatorioViagem.class;
    }

    public Class getRelatorioDeVisita() {
        return RelatorioDeVisita.class;
    }

    public Class getParticipante() {
        return Participante.class;
    }

    public Class getAtaDeReuniao() {
        return AtaDeReuniao.class;
    }

    public Class getPendenciaIdentificada() {
        return PendenciaIdentificada.class;
    }

    public Class getPautaDaReuniao() {
        return PautaDaReuniao.class;
    }

    public Class getObservacao() {
        return Observacao.class;
    }

    public Class getDeliberacao() {
        return Deliberacao.class;
    }

    public Class getOrgao() {
        return Orgao.class;
    }

    public Class getItemFormCriacaoEmail() {
        return ItemFormCriacaoEmail.class;
    }

    public Class getItemFormAcessoConteudo() {
        return ItemFormAcessoConteudo.class;
    }

    public Class getFormSeloAtitudeMulher() {
        return FormSeloAtitudeMulher.class;
    }

    public Class getArquivoRelatorioDeVisita() {
        return ArquivoRelatorioDeVisita.class;
    }

    public Class getArquivoRelatorioDeViagem() {
        return ArquivoRelatorioDeViagem.class;
    }

    public Class getTipoFormulario() {
        return TipoFormulario.class;
    }

    public Class getArquivoPublico() {
        return ArquivoPublico.class;
    }

    public Class getProfissionalDeReferenciaFichaVisita() {
        return ProfissionalDeReferenciaFichaVisita.class;
    }

    public Class getFichaDeVisitaInstitucionalLGBT() {
        return FichaDeVisitaInstitucionalLGBT.class;
    }

    public Class getRoteiroDeTriagemDoUsuarioLGBT() {
        return RoteiroDeTriagemDoUsuarioLGBT.class;
    }

    public Class getTipoMoradia() {
        return TipoMoradia.class;
    }

    public Class getSexo() {
        return Sexo.class;
    }

    public Class getEtnia() {
        return Etnia.class;
    }

    public Class getComQuemMora() {
        return ComQuemMora.class;
    }

    public Class getRendaFamiliar() {
        return RendaFamiliar.class;
    }

    public Class getOrientacaoSexual() {
        return OrientacaoSexual.class;
    }

    public Class getIdentidadeGenero() {
        return IdentidadeGenero.class;
    }

    public Class getTodosDocumento() {
        return TodosDocumento.class;
    }

    public Class getReligiao() {
        return Religiao.class;
    }

    public Class getEstadoCivil() {
        return EstadoCivil.class;
    }

    public Class getResideEm() {
        return ResideEm.class;
    }

    public Class getEncaminhamentoLGBT() {
        return EncaminhamentoLGBT.class;
    }

    public Class getFormasDeViolencia() {
        return FormasDeViolencia.class;
    }

    public Class getSimOuNao() {
        return SimOuNao.class;
    }

    public Class getSimOuNaoOutros() {
        return SimOuNaoOutros.class;
    }

    public Class getFormularioDeDenunciaLGBT() {
        return FormularioDeDenunciaLGBT.class;
    }

    public Class getTipoViolencia() {
        return TipoViolencia.class;
    }

    public Class getPessoaDenuncia() {
        return PessoaDenuncia.class;
    }

    public Class getLgbtSituacaoViolencia() {
        return LgbtSituacaoViolencia.class;
    }

    public Class getAdulto() {
        return Adulto.class;
    }

    public Class getUsoDeDrogas() {
        return UsoDeDrogas.class;
    }

    public Class getSituacaoDeRua() {
        return SituacaoDeRua.class;
    }

    public Class getAreaAtuacao() {
        return AreaAtuacao.class;
    }

    public Class getTipoProfissional() {
        return TipoProfissional.class;
    }

    public Class getTipoDeServicoLgbt() {
        return TipoDeServicoLgbt.class;
    }

    public Class getProcedimentoFichaDeVisitaLgbt() {
        return ProcedimentoFichaDeVisitaLgbt.class;
    }

    public Class getSolicitante() {
        return Solicitante.class;
    }

    public Class getFichaDeVisitaDomiciliar() {
        return FichaDeVisitaDomiciliar.class;
    }

    public Class getAutoridadeCertificadora() {
        return AutoridadeCertificadora.class;
    }

    public Class getDocumentacaoCertificado() {
        return DocumentacaoCertificado.class;
    }

    public Class getControleDeCertificado() {
        return ControleDeCertificado.class;
    }

    public Class getTipoCertificadoEnum() {
        return TipoCertificadoEnum.class;
    }

    public Class getTipoCertificado() {
        return TipoCertificado.class;
    }

    public Class getPontoAcesso() {
        return PontoAcesso.class;
    }

    public Class getStatusPontoAcesso() {
        return StatusPontoAcesso.class;
    }

    public Class getInterrupcaoPontoAcesso() {
        return InterrupcaoPontoAcesso.class;
    }

    public Class getTipoDeAcesso() {
        return TipoDeAcesso.class;
    }

    public Class getSituacaoCertificadoEmitido() {
        return SituacaoCertificadoEmitido.class;
    }

    public Class getReservaLocal() {
        return ReservaLocal.class;
    }

    public Class getLocalReserva() {
        return LocalReserva.class;
    }

    public Class getTipoLocal() {
        return TipoLocal.class;
    }

    public Class getOrgaoCertificado() {
        return OrgaoCertificado.class;
    }

    public Class getTipoPessoa() {
        return TipoPessoa.class;
    }

}
