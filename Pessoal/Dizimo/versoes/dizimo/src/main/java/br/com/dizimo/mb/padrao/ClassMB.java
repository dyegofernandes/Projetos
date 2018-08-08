package br.com.dizimo.mb.padrao;

import br.com.dizimo.modelo.financeiro.Caixa;
import br.com.dizimo.modelo.financeiro.Dizimo;
import br.com.dizimo.modelo.enums.StatusCaixa;
import br.com.dizimo.modelo.cadastro.Endereco;
import br.com.dizimo.modelo.cadastro.Estado;
import br.com.dizimo.modelo.cadastro.Cidade;
import br.com.dizimo.modelo.cadastro.Pastoral;
import br.com.dizimo.modelo.cadastro.Sede;
import br.com.dizimo.modelo.enums.Sexo;
import br.com.dizimo.modelo.cadastro.Bairro;
import br.com.dizimo.modelo.cadastro.Membro;
import br.com.dizimo.modelo.enums.EstadoCivil;
import br.com.dizimo.modelo.cadastro.Pais;
import br.com.dizimo.modelo.controleacesso.Permissao;
import br.com.dizimo.modelo.controleacesso.Usuario;
import br.com.dizimo.modelo.configuracao.ErroSistema;
import br.com.dizimo.modelo.controleacesso.SituacaoUsuario;
import br.com.dizimo.modelo.controleacesso.AcessoSistema;
import br.com.dizimo.modelo.email.ConfiguracaoEmail;
import br.com.dizimo.modelo.controleacesso.Perfil;
import br.com.dizimo.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.com.dizimo.modelo.email.ModeloEmail;
import br.com.dizimo.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.com.dizimo.modelo.email.TipoAssuntoEmail;
import br.com.dizimo.modelo.controleacesso.TipoRecuperacaoSenha;
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
    public Class getEstado() {
        return Estado.class;
    }
    public Class getCidade() {
        return Cidade.class;
    }
    public Class getPastoral() {
        return Pastoral.class;
    }
    public Class getSede() {
        return Sede.class;
    }
    public Class getSexo() {
        return Sexo.class;
    }
    public Class getBairro() {
        return Bairro.class;
    }
    public Class getMembro() {
        return Membro.class;
    }
    public Class getEstadoCivil() {
        return EstadoCivil.class;
    }
    public Class getPais() {
        return Pais.class;
    }

    public Class getCaixa() {
        return Caixa.class;
    }
    public Class getDizimo() {
        return Dizimo.class;
    }
    public Class getStatusCaixa() {
        return StatusCaixa.class;
    }

}