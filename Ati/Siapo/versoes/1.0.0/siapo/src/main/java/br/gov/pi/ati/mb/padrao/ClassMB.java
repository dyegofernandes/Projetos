package br.gov.pi.ati.mb.padrao;

import br.gov.pi.ati.modelo.cadastro.Municipio;
import br.gov.pi.ati.modelo.cadastro.CompentenciaPPA;
import br.gov.pi.ati.modelo.cadastro.AreaTematica;
import br.gov.pi.ati.modelo.cadastro.AcaoOrcamentaria;
import br.gov.pi.ati.modelo.cadastro.Produto;
import br.gov.pi.ati.modelo.cadastro.AcaoEstrategica;
import br.gov.pi.ati.modelo.cadastro.NaturezaDeReceita;
import br.gov.pi.ati.modelo.cadastro.ModalidadeDeAplicacao;
import br.gov.pi.ati.modelo.cadastro.Territorio;
import br.gov.pi.ati.modelo.cadastro.enums.IndicadorResultado;
import br.gov.pi.ati.modelo.cadastro.GrupoDeDespesa;
import br.gov.pi.ati.modelo.cadastro.enums.TipoDeNaturezaReceita;
import br.gov.pi.ati.modelo.cadastro.DiretrizeDeGoverno;
import br.gov.pi.ati.modelo.cadastro.ElementoDeDespesa;
import br.gov.pi.ati.modelo.cadastro.CategoriaDeDespesa;
import br.gov.pi.ati.modelo.cadastro.UnidadeDeMedida;
import br.gov.pi.ati.modelo.cadastro.UnidadeOrcamentaria;
import br.gov.pi.ati.modelo.cadastro.Orgao;
import br.gov.pi.ati.modelo.cadastro.UnidadeGestora;
import br.gov.pi.ati.modelo.cadastro.FonteDeRecurso;
import br.gov.pi.ati.modelo.cadastro.Funcao;
import br.gov.pi.ati.modelo.cadastro.SubFuncao;
import br.gov.pi.ati.modelo.cadastro.GrupoDeFonte;
import br.gov.pi.ati.modelo.cadastro.enums.TipoGrupoFonte;
import br.gov.pi.ati.modelo.cadastro.NaturezaDeDespesa;
import br.gov.pi.ati.modelo.cadastro.enums.TipoDePoder;
import br.gov.pi.ati.modelo.cadastro.ProgramaDeGoverno;
import br.gov.pi.ati.modelo.cadastro.ClassificacaoDaDespesa;
import br.gov.pi.ati.modelo.cadastro.enums.DiretrizPPA;
import br.gov.pi.ati.modelo.cadastro.enums.TipoDeFonte;
import br.gov.pi.ati.modelo.cadastro.enums.TipoDePrograma;
import br.gov.pi.ati.modelo.controleacesso.Permissao;
import br.gov.pi.ati.modelo.controleacesso.Usuario;
import br.gov.pi.ati.modelo.configuracao.ErroSistema;
import br.gov.pi.ati.modelo.controleacesso.SituacaoUsuario;
import br.gov.pi.ati.modelo.controleacesso.AcessoSistema;
import br.gov.pi.ati.modelo.email.ConfiguracaoEmail;
import br.gov.pi.ati.modelo.controleacesso.Perfil;
import br.gov.pi.ati.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.gov.pi.ati.modelo.email.ModeloEmail;
import br.gov.pi.ati.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.gov.pi.ati.modelo.email.TipoAssuntoEmail;
import br.gov.pi.ati.modelo.controleacesso.TipoRecuperacaoSenha;
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

    public Class getFonteDeRecurso() {
        return FonteDeRecurso.class;
    }

    public Class getFuncao() {
        return Funcao.class;
    }

    public Class getSubFuncao() {
        return SubFuncao.class;
    }

    public Class getGrupoDeFonte() {
        return GrupoDeFonte.class;
    }

    public Class getTipoGrupoFonte() {
        return TipoGrupoFonte.class;
    }

    public Class getNaturezaDeDespesa() {
        return NaturezaDeDespesa.class;
    }

    public Class getTipoDePoder() {
        return TipoDePoder.class;
    }

    public Class getProgramaDeGoverno() {
        return ProgramaDeGoverno.class;
    }

    public Class getClassificacaoDaDespesa() {
        return ClassificacaoDaDespesa.class;
    }

    public Class getUnidadeOrcamentaria() {
        return UnidadeOrcamentaria.class;
    }

    public Class getOrgao() {
        return Orgao.class;
    }

    public Class getUnidadeGestora() {
        return UnidadeGestora.class;
    }

    public Class getUnidadeDeMedida() {
        return UnidadeDeMedida.class;
    }

    public Class getTipoDeFonte() {
        return TipoDeFonte.class;
    }

    public Class getDiretrizeDeGoverno() {
        return DiretrizeDeGoverno.class;
    }

    public Class getElementoDeDespesa() {
        return ElementoDeDespesa.class;
    }

    public Class getCategoriaDeDespesa() {
        return CategoriaDeDespesa.class;
    }

    public Class getNaturezaDeReceita() {
        return NaturezaDeReceita.class;
    }

    public Class getModalidadeDeAplicacao() {
        return ModalidadeDeAplicacao.class;
    }

    public Class getTerritorio() {
        return Territorio.class;
    }

    public Class getIndicadorResultado() {
        return IndicadorResultado.class;
    }

    public Class getGrupoDeDespesa() {
        return GrupoDeDespesa.class;
    }

    public Class getTipoDeNaturezaReceita() {
        return TipoDeNaturezaReceita.class;
    }

    public Class getProduto() {
        return Produto.class;
    }

    public Class getAcaoEstrategica() {
        return AcaoEstrategica.class;
    }

    public Class getAcaoOrcamentaria() {
        return AcaoOrcamentaria.class;
    }

    public Class getDiretrizPPA() {
        return DiretrizPPA.class;
    }

    public Class getTipoDePrograma() {
        return TipoDePrograma.class;
    }
    public Class getCompentenciaPPA() {
        return CompentenciaPPA.class;
    }
    public Class getAreaTematica() {
        return AreaTematica.class;
    }

    public Class getMunicipio() {
        return Municipio.class;
    }

}