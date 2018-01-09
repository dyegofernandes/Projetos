package br.gov.pi.ati.agendacultural.mb.padrao;

import br.gov.pi.ati.agendacultural.modelo.eventos.CategoriaEvento;
import br.gov.pi.ati.agendacultural.modelo.eventos.DiaVisitacaoPortfolio;
import br.gov.pi.ati.agendacultural.modelo.eventos.HistoricoPortfolio;
import br.gov.pi.ati.agendacultural.modelo.eventos.Portfolio;
import br.gov.pi.ati.agendacultural.modelo.eventos.Evento;
import br.gov.pi.ati.agendacultural.modelo.eventos.AgendaEvento;
import br.gov.pi.ati.agendacultural.modelo.eventos.LinkPortfolio;
import br.gov.pi.ati.agendacultural.modelo.cadastro.LocalEvento;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Estado;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Bairro;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Endereco;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Setor;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Cidade;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Assento;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Fone;
import br.gov.pi.ati.agendacultural.modelo.cadastro.TipoLocal;
import br.gov.pi.ati.agendacultural.modelo.enums.TipoEndereco;
import br.gov.pi.ati.agendacultural.modelo.enums.EstiloArquitetonico;
import br.gov.pi.ati.agendacultural.modelo.controleacesso.Permissao;
import br.gov.pi.ati.agendacultural.modelo.controleacesso.Usuario;
import br.gov.pi.ati.agendacultural.modelo.configuracao.ErroSistema;
import br.gov.pi.ati.agendacultural.modelo.controleacesso.SituacaoUsuario;
import br.gov.pi.ati.agendacultural.modelo.controleacesso.AcessoSistema;
import br.gov.pi.ati.agendacultural.modelo.email.ConfiguracaoEmail;
import br.gov.pi.ati.agendacultural.modelo.controleacesso.Perfil;
import br.gov.pi.ati.agendacultural.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.gov.pi.ati.agendacultural.modelo.email.ModeloEmail;
import br.gov.pi.ati.agendacultural.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.gov.pi.ati.agendacultural.modelo.email.TipoAssuntoEmail;
import br.gov.pi.ati.agendacultural.modelo.controleacesso.TipoRecuperacaoSenha;
import br.gov.pi.ati.agendacultural.modelo.enums.DiaSemana;
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

    public Class getEstado() {
        return Estado.class;
    }

    public Class getBairro() {
        return Bairro.class;
    }

    public Class getEndereco() {
        return Endereco.class;
    }

    public Class getSetor() {
        return Setor.class;
    }

    public Class getCidade() {
        return Cidade.class;
    }

    public Class getAssento() {
        return Assento.class;
    }

    public Class getTipoEndereco() {
        return TipoEndereco.class;
    }

    public Class getEstiloArquitetonico() {
        return EstiloArquitetonico.class;
    }

    public Class getLocalEvento() {
        return LocalEvento.class;
    }

    public Class getFone() {
        return Fone.class;
    }

    public Class getDiaSemana() {
        return DiaSemana.class;
    }

    public Class getDiaVisitacaoPortfolio() {
        return DiaVisitacaoPortfolio.class;
    }

    public Class getHistoricoPortfolio() {
        return HistoricoPortfolio.class;
    }

    public Class getPortfolio() {
        return Portfolio.class;
    }

    public Class getEvento() {
        return Evento.class;
    }

    public Class getAgendaEvento() {
        return AgendaEvento.class;
    }

    public Class getLinkPortfolio() {
        return LinkPortfolio.class;
    }

    public Class getTipoLocal() {
        return TipoLocal.class;
    }
    public Class getCategoriaEvento() {
        return CategoriaEvento.class;
    }

}