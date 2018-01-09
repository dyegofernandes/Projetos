package br.gov.pi.ati.siopm.mb.padrao;

import br.gov.pi.ati.siopm.modelo.cadastro.ParametroSistema;
import br.gov.pi.ati.siopm.modelo.cadastro.GuardaMunicipal;
import br.gov.pi.ati.siopm.modelo.cadastro.PoliciaRodoviariaFederal;
import br.gov.pi.ati.siopm.modelo.cadastro.PoliciaFederal;
import br.gov.pi.ati.siopm.modelo.cadastro.OrgaoRecebedor;
import br.gov.pi.ati.siopm.modelo.cadastro.Samu;
import br.gov.pi.ati.siopm.modelo.cadastro.Transito;
import br.gov.pi.ati.siopm.modelo.cadastro.Bombeiro;
import br.gov.pi.ati.siopm.modelo.cadastro.Ponto;
import br.gov.pi.ati.siopm.modelo.cadastro.Poligono;
import br.gov.pi.ati.siopm.modelo.cadastro.ResultadoOcorrencia;
import br.gov.pi.ati.siopm.modelo.cadastro.GrupoResultadoOcorrencia;
import br.gov.pi.ati.siopm.modelo.enums.SituacaoOcorrencia;
import br.gov.pi.ati.siopm.modelo.enums.ClassificacaoChamada;
import br.gov.pi.ati.siopm.modelo.cadastro.LocalIntermediarioAux;
import br.gov.pi.ati.siopm.modelo.ocorrencia.Ocorrencia;
import br.gov.pi.ati.siopm.modelo.enums.ClassificacaoOcorrencia;
import br.gov.pi.ati.siopm.modelo.cadastro.Arquivo;
import br.gov.pi.ati.siopm.modelo.cadastro.Cargo;
import br.gov.pi.ati.siopm.modelo.cadastro.ObjetoApreendido;
import br.gov.pi.ati.siopm.modelo.cadastro.DrogaOcorrencia;
import br.gov.pi.ati.siopm.modelo.cadastro.DrogaOcorrenciaItem;
import br.gov.pi.ati.siopm.modelo.enums.UnidadeDeMedida;
import br.gov.pi.ati.siopm.modelo.cadastro.Setor;
import br.gov.pi.ati.siopm.modelo.cadastro.Solicitante;
import br.gov.pi.ati.siopm.modelo.cadastro.MarcaDeArma;
import br.gov.pi.ati.siopm.modelo.enums.ArmaPolicia;
import br.gov.pi.ati.siopm.modelo.cadastro.Arma;
import br.gov.pi.ati.siopm.modelo.enums.TipoDeArma;
import br.gov.pi.ati.siopm.modelo.enums.CorCabelo;
import br.gov.pi.ati.siopm.modelo.enums.CorOlho;
import br.gov.pi.ati.siopm.modelo.enums.TipoPessoa;
import br.gov.pi.ati.siopm.modelo.cadastro.ModeloVeiculo;
import br.gov.pi.ati.siopm.modelo.enums.ClassificacaoPessoaOcorrencia;
import br.gov.pi.ati.siopm.modelo.enums.Sexo;
import br.gov.pi.ati.siopm.modelo.cadastro.PessoaEnvolvida;
import br.gov.pi.ati.siopm.modelo.enums.CorVeiculo;
import br.gov.pi.ati.siopm.modelo.enums.SituacaoVeiculo;
import br.gov.pi.ati.siopm.modelo.enums.TipoVeiculo;
import br.gov.pi.ati.siopm.modelo.enums.Raca;
import br.gov.pi.ati.siopm.modelo.cadastro.QualificacaoDeVeiculo;
import br.gov.pi.ati.siopm.modelo.cadastro.MarcaVeiculo;
import br.gov.pi.ati.siopm.modelo.cadastro.Cabina;
import br.gov.pi.ati.siopm.modelo.enums.TipoCabine;
import br.gov.pi.ati.siopm.modelo.enums.PatentePM;
import br.gov.pi.ati.siopm.modelo.cadastro.ItemViatura;
import br.gov.pi.ati.siopm.modelo.cadastro.Patrulha;
import br.gov.pi.ati.siopm.modelo.cadastro.GuarnicaoViatura;
import br.gov.pi.ati.siopm.modelo.cadastro.Operacao;
import br.gov.pi.ati.siopm.modelo.cadastro.StatusViatura;
import br.gov.pi.ati.siopm.modelo.cadastro.Viatura;
import br.gov.pi.ati.siopm.modelo.cadastro.NaturezaOcorrencia;
import br.gov.pi.ati.siopm.modelo.cadastro.Opc;
import br.gov.pi.ati.siopm.modelo.cadastro.Organizacao;
import br.gov.pi.ati.siopm.modelo.cadastro.Bairro;
import br.gov.pi.ati.siopm.modelo.cadastro.Logradouro;
import br.gov.pi.ati.siopm.modelo.cadastro.TerritorioPorCidade;
import br.gov.pi.ati.siopm.modelo.cadastro.Cidade;
import br.gov.pi.ati.siopm.modelo.cadastro.Opm;
import br.gov.pi.ati.siopm.modelo.enums.TipoTelefone;
import br.gov.pi.ati.siopm.modelo.cadastro.Endereco;
import br.gov.pi.ati.siopm.modelo.cadastro.Telefone;
import br.gov.pi.ati.siopm.modelo.cadastro.Circunscricao;
import br.gov.pi.ati.siopm.modelo.cadastro.Estado;
import br.gov.pi.ati.siopm.modelo.cadastro.LocalIntermediario;
import br.gov.pi.ati.siopm.modelo.cadastro.Territorio;
import br.gov.pi.ati.siopm.modelo.controleacesso.Permissao;
import br.gov.pi.ati.siopm.modelo.controleacesso.Usuario;
import br.gov.pi.ati.siopm.modelo.configuracao.ErroSistema;
import br.gov.pi.ati.siopm.modelo.controleacesso.SituacaoUsuario;
import br.gov.pi.ati.siopm.modelo.controleacesso.AcessoSistema;
import br.gov.pi.ati.siopm.modelo.email.ConfiguracaoEmail;
import br.gov.pi.ati.siopm.modelo.controleacesso.Perfil;
import br.gov.pi.ati.siopm.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.gov.pi.ati.siopm.modelo.email.ModeloEmail;
import br.gov.pi.ati.siopm.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.gov.pi.ati.siopm.modelo.email.TipoAssuntoEmail;
import br.gov.pi.ati.siopm.modelo.controleacesso.TipoRecuperacaoSenha;
import br.gov.pi.ati.siopm.modelo.enums.Anonimo;
import br.gov.pi.ati.siopm.modelo.enums.BairroGoogle;
import br.gov.pi.ati.siopm.modelo.enums.IconeViatura;
import br.gov.pi.ati.siopm.modelo.enums.ModalidadePoliciamento;
import br.gov.pi.ati.siopm.modelo.enums.OperacaoEnum;
import br.gov.pi.ati.siopm.modelo.enums.SimOuNao;
import br.gov.pi.ati.siopm.modelo.enums.SituacaoObjeto;
import br.gov.pi.ati.siopm.modelo.enums.StatusViaturaEnum;
import br.gov.pi.ati.siopm.modelo.enums.TipoApoio;
import br.gov.pi.ati.siopm.modelo.enums.TipoChamada;
import br.gov.pi.ati.siopm.modelo.enums.TipoPoliciamento;
import br.gov.pi.ati.siopm.modelo.enums.TipoPoligono;
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

    public Class getBairro() {
        return Bairro.class;
    }

    public Class getLogradouro() {
        return Logradouro.class;
    }

    public Class getTerritorioPorCidade() {
        return TerritorioPorCidade.class;
    }

    public Class getCidade() {
        return Cidade.class;
    }

    public Class getOpm() {
        return Opm.class;
    }

    public Class getTipoTelefone() {
        return TipoTelefone.class;
    }

    public Class getEndereco() {
        return Endereco.class;
    }

    public Class getTelefone() {
        return Telefone.class;
    }

    public Class getCircunscricao() {
        return Circunscricao.class;
    }

    public Class getEstado() {
        return Estado.class;
    }

    public Class getBairroGoogle() {
        return BairroGoogle.class;
    }

    public Class getOpc() {
        return Opc.class;
    }

    public Class getOrganizacaoPolicial() {
        return Organizacao.class;
    }

    public Class getOperacao() {
        return Operacao.class;
    }

    public Class getStatusViatura() {
        return StatusViatura.class;
    }

    public Class getViatura() {
        return Viatura.class;
    }

    public Class getNaturezaOcorrencia() {
        return NaturezaOcorrencia.class;
    }

    public Class getPatentePM() {
        return PatentePM.class;
    }

    public Class getItemViatura() {
        return ItemViatura.class;
    }

    public Class getPatrulha() {
        return Patrulha.class;
    }

    public Class getComponenteViatura() {
        return GuarnicaoViatura.class;
    }

    public Class getCabina() {
        return Cabina.class;
    }

    public Class getTipoCabine() {
        return TipoCabine.class;
    }

    public Class getCorCabelo() {
        return CorCabelo.class;
    }

    public Class getCorOlho() {
        return CorOlho.class;
    }

    public Class getTipoPessoa() {
        return TipoPessoa.class;
    }

    public Class getModeloVeiculo() {
        return ModeloVeiculo.class;
    }

    public Class getClassificacaoPessoaOcorrencia() {
        return ClassificacaoPessoaOcorrencia.class;
    }

    public Class getSexo() {
        return Sexo.class;
    }

    public Class getAnonimo() {
        return Anonimo.class;
    }

    public Class getPessoaEnvolvida() {
        return PessoaEnvolvida.class;
    }

    public Class getCorVeiculo() {
        return CorVeiculo.class;
    }

    public Class getSituacaoVeiculo() {
        return SituacaoVeiculo.class;
    }

    public Class getTipoVeiculo() {
        return TipoVeiculo.class;
    }

    public Class getCorPele() {
        return Raca.class;
    }

    public Class getQualificacaoDeVeiculo() {
        return QualificacaoDeVeiculo.class;
    }

    public Class getMarcaVeiculo() {
        return MarcaVeiculo.class;
    }

    public Class getMarcaDeArma() {
        return MarcaDeArma.class;
    }

    public Class getArmaPolicia() {
        return ArmaPolicia.class;
    }

    public Class getArma() {
        return Arma.class;
    }

    public Class getTipoDeArma() {
        return TipoDeArma.class;
    }

    public Class getSolicitante() {
        return Solicitante.class;
    }

    public Class getSetor() {
        return Setor.class;
    }

    public Class getDrogaOcorrencia() {
        return DrogaOcorrencia.class;
    }

    public Class getDrogaOcorrenciaItem() {
        return DrogaOcorrenciaItem.class;
    }

    public Class getUnidadeDeMedida() {
        return UnidadeDeMedida.class;
    }

    public Class getCargo() {
        return Cargo.class;
    }

    public Class getObjetoApreendido() {
        return ObjetoApreendido.class;
    }

    public Class getArquivo() {
        return Arquivo.class;
    }

    public Class getSituacaoOcorrencia() {
        return SituacaoOcorrencia.class;
    }

    public Class getClassificacaoChamada() {
        return ClassificacaoChamada.class;
    }

    public Class getLocalIntermediarioAux() {
        return LocalIntermediarioAux.class;
    }

    public Class getOcorrencia() {
        return Ocorrencia.class;
    }

    public Class getClassificacaoOcorrencia() {
        return ClassificacaoOcorrencia.class;
    }

    public Class getResultadoOcorrencia() {
        return ResultadoOcorrencia.class;
    }

    public Class getGrupoResultadoOcorrencia() {
        return GrupoResultadoOcorrencia.class;
    }

    public Class getRaca() {
        return Raca.class;
    }

    public Class getSituacaoObjeto() {
        return SituacaoObjeto.class;
    }

    public Class getModalidadePoliciamento() {
        return ModalidadePoliciamento.class;
    }

    public Class getOperacaoEnum() {
        return OperacaoEnum.class;
    }

    public Class getStatusViaturaEnum() {
        return StatusViaturaEnum.class;
    }

    public Class getTipoPoliciamento() {
        return TipoPoliciamento.class;
    }

    public Class getSimOuNao() {
        return SimOuNao.class;
    }

    public Class getPonto() {
        return Ponto.class;
    }

    public Class getPoligono() {
        return Poligono.class;
    }

    public Class getTipoPoligono() {
        return TipoPoligono.class;
    }

    public Class getTipoChamada() {
        return TipoChamada.class;
    }

    public Class getSamu() {
        return Samu.class;
    }

    public Class getTransito() {
        return Transito.class;
    }

    public Class getBombeiro() {
        return Bombeiro.class;
    }

    public Class getOrganizacao() {
        return Organizacao.class;
    }

    public Class getTerritorio() {
        return Territorio.class;
    }

    public Class getLocalIntermediario() {
        return LocalIntermediario.class;
    }

    public Class getOrgaoRecebedor() {
        return OrgaoRecebedor.class;
    }

    public Class getTipoApoio() {
        return TipoApoio.class;
    }

    public Class getGuardaMunicipal() {
        return GuardaMunicipal.class;
    }

    public Class getPoliciaRodoviariaFederal() {
        return PoliciaRodoviariaFederal.class;
    }

    public Class getPoliciaFederal() {
        return PoliciaFederal.class;
    }

    public Class getParametroSistema() {
        return ParametroSistema.class;
    }

    public Class getIconeViatura() {
        return IconeViatura.class;
    }
}
