package br.gov.pi.ati.sccd.mb.padrao;

import br.gov.pi.ati.sccd.modelo.cadastro.AutoridadeCertificadora;
import br.gov.pi.ati.sccd.modelo.cadastro.TipoCertificadoAux;
import br.gov.pi.ati.sccd.modelo.cadastro.TipoCertificado;
import br.gov.pi.ati.sccd.modelo.certificado.ContratoFornecedor;
import br.gov.pi.ati.sccd.modelo.cadastro.Cliente;
import br.gov.pi.ati.sccd.modelo.cadastro.Fornecedor;
import br.gov.pi.ati.sccd.modelo.certificado.ContratoCliente;
import br.gov.pi.ati.sccd.modelo.enums.TipoPessoa;
import br.gov.pi.ati.sccd.modelo.controleacesso.Permissao;
import br.gov.pi.ati.sccd.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sccd.modelo.configuracao.ErroSistema;
import br.gov.pi.ati.sccd.modelo.controleacesso.SituacaoUsuario;
import br.gov.pi.ati.sccd.modelo.controleacesso.AcessoSistema;
import br.gov.pi.ati.sccd.modelo.email.ConfiguracaoEmail;
import br.gov.pi.ati.sccd.modelo.controleacesso.Perfil;
import br.gov.pi.ati.sccd.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.gov.pi.ati.sccd.modelo.email.ModeloEmail;
import br.gov.pi.ati.sccd.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.gov.pi.ati.sccd.modelo.email.TipoAssuntoEmail;
import br.gov.pi.ati.sccd.modelo.controleacesso.TipoRecuperacaoSenha;
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
    

    public Class getTipoCertificado() {
        return TipoCertificado.class;
    }
    public Class getContratoFornecedor() {
        return ContratoFornecedor.class;
    }
    public Class getCliente() {
        return Cliente.class;
    }
    public Class getFornecedor() {
        return Fornecedor.class;
    }
    public Class getContratoCliente() {
        return ContratoCliente.class;
    }
    public Class getTipoPessoa() {
        return TipoPessoa.class;
    }

    public Class getTipoCertificadoAux() {
        return TipoCertificadoAux.class;
    }

    public Class getAutoridadeCertificadora() {
        return AutoridadeCertificadora.class;
    }

}