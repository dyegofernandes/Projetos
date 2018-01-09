package br.gov.pi.siste.mb.padrao;

import br.gov.pi.siste.modelo.configuracao.Ajuda;
import br.gov.pi.siste.modelo.financeiro.FontePagador;
import br.gov.pi.siste.modelo.cadastro.CadastroPessoal;
import br.gov.pi.siste.modelo.financeiro.AliquotaInss;
import br.gov.pi.siste.modelo.cadastro.enums.StatusReferencia;
import br.gov.pi.siste.modelo.financeiro.Movimento;
import br.gov.pi.siste.modelo.financeiro.AliquotaIRRF;
import br.gov.pi.siste.modelo.financeiro.SalarioMinimo;
import br.gov.pi.siste.modelo.financeiro.Referencia;
import br.gov.pi.siste.modelo.financeiro.TabelaIRRF;
import br.gov.pi.siste.modelo.cadastro.enums.FinanceiroMovimento;
import br.gov.pi.siste.modelo.financeiro.TabelaInss;
import br.gov.pi.siste.modelo.controleacesso.UsuarioUnidade;
import br.gov.pi.siste.modelo.cadastro.Orgao;
import br.gov.pi.siste.modelo.cadastro.enums.Categoria;
import br.gov.pi.siste.modelo.cadastro.enums.Previdencia;
import br.gov.pi.siste.modelo.cadastro.Cidade;
import br.gov.pi.siste.modelo.cadastro.GrauDeInstrucao;
import br.gov.pi.siste.modelo.cadastro.CarteiraTrabalho;
import br.gov.pi.siste.modelo.cadastro.Rg;
import br.gov.pi.siste.modelo.cadastro.TituloEleitoral;
import br.gov.pi.siste.modelo.cadastro.enums.Ocorrencia;
import br.gov.pi.siste.modelo.cadastro.FormacaoProfissional;
import br.gov.pi.siste.modelo.cadastro.Servidor;
import br.gov.pi.siste.modelo.cadastro.enums.Sexo;
import br.gov.pi.siste.modelo.cadastro.enums.EstadoCivil;
import br.gov.pi.siste.modelo.cadastro.Cargo;
import br.gov.pi.siste.modelo.cadastro.enums.TipoEndereco;
import br.gov.pi.siste.modelo.cadastro.CargaHoraria;
import br.gov.pi.siste.modelo.cadastro.Estado;
import br.gov.pi.siste.modelo.cadastro.Endereco;
import br.gov.pi.siste.modelo.cadastro.DadosFuncionais;
import br.gov.pi.siste.modelo.cadastro.Unidade;
import br.gov.pi.siste.modelo.cadastro.enums.TipoPessoa;
import br.gov.pi.siste.modelo.controleacesso.Permissao;
import br.gov.pi.siste.modelo.controleacesso.Usuario;
import br.gov.pi.siste.modelo.configuracao.ErroSistema;
import br.gov.pi.siste.modelo.controleacesso.SituacaoUsuario;
import br.gov.pi.siste.modelo.controleacesso.AcessoSistema;
import br.gov.pi.siste.modelo.email.ConfiguracaoEmail;
import br.gov.pi.siste.modelo.controleacesso.Perfil;
import br.gov.pi.siste.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.gov.pi.siste.modelo.email.ModeloEmail;
import br.gov.pi.siste.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.gov.pi.siste.modelo.email.TipoAssuntoEmail;
import br.gov.pi.siste.modelo.controleacesso.TipoRecuperacaoSenha;
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

    public Class getEndereco() {
        return Endereco.class;
    }
    public Class getDadosFuncionais() {
        return DadosFuncionais.class;
    }
    public Class getUnidade() {
        return Unidade.class;
    }

    public Class getCategoria() {
        return Categoria.class;
    }
    public Class getPrevidencia() {
        return Previdencia.class;
    }
    public Class getCidade() {
        return Cidade.class;
    }
    public Class getGrauDeInstrucao() {
        return GrauDeInstrucao.class;
    }
    public Class getCarteiraTrabalho() {
        return CarteiraTrabalho.class;
    }
    public Class getRg() {
        return Rg.class;
    }
    public Class getTituloEleitoral() {
        return TituloEleitoral.class;
    }
    public Class getOcorrencia() {
        return Ocorrencia.class;
    }
    public Class getFormacaoProfissional() {
        return FormacaoProfissional.class;
    }
    public Class getServidor() {
        return Servidor.class;
    }
    public Class getSexo() {
        return Sexo.class;
    }
    public Class getTipoPessoa() {
        return TipoPessoa.class;
    }
    public Class getEstadoCivil() {
        return EstadoCivil.class;
    }
    public Class getCargo() {
        return Cargo.class;
    }
    public Class getTipoEndereco() {
        return TipoEndereco.class;
    }
    public Class getCargaHoraria() {
        return CargaHoraria.class;
    }
    public Class getEstado() {
        return Estado.class;
    }

    public Class getOrgao() {
        return Orgao.class;
    }

    public Class getUsuarioUnidade() {
        return UsuarioUnidade.class;
    }

    public Class getAliquotaInss() {
        return AliquotaInss.class;
    }
    public Class getStatusReferencia() {
        return StatusReferencia.class;
    }
    public Class getMovimento() {
        return Movimento.class;
    }
    public Class getAliquotaIRRF() {
        return AliquotaIRRF.class;
    }
    public Class getSalarioMinimo() {
        return SalarioMinimo.class;
    }
    public Class getReferencia() {
        return Referencia.class;
    }
    public Class getTabelaIRRF() {
        return TabelaIRRF.class;
    }
    public Class getFinanceiroMovimento() {
        return FinanceiroMovimento.class;
    }
    public Class getTabelaInss() {
        return TabelaInss.class;
    }

    public Class getCadastroPessoal() {
        return CadastroPessoal.class;
    }

    public Class getFontePagador() {
        return FontePagador.class;
    }

    public Class getAjuda() {
        return Ajuda.class;
    }

}