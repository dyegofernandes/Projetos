package com.opfacil.mb.padrao;

import com.opfacil.modelo.documentos.DownloadArquivos;
import com.opfacil.modelo.documentos.Arquivo;
import com.opfacil.modelo.enums.SituacaoOp;
import com.opfacil.modelo.pagamento.Pagamento;
import com.opfacil.modelo.pagamento.Lote;
import com.opfacil.modelo.cadastro.MotivoPagamento;
import com.opfacil.modelo.cadastro.Empresa;
import com.opfacil.modelo.cadastro.Uf;
import com.opfacil.modelo.cadastro.Funcionario;
import com.opfacil.modelo.exemplo.PessoaExemplo;
import com.opfacil.modelo.controleacesso.Permissao;
import com.opfacil.modelo.controleacesso.Usuario;
import com.opfacil.modelo.configuracao.ErroSistema;
import com.opfacil.modelo.controleacesso.SituacaoUsuario;
import com.opfacil.modelo.controleacesso.AcessoSistema;
import com.opfacil.modelo.email.ConfiguracaoEmail;
import com.opfacil.modelo.controleacesso.Perfil;
import com.opfacil.modelo.controleacesso.HistoricoSituacaoUsuario;
import com.opfacil.modelo.email.ModeloEmail;
import com.opfacil.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import com.opfacil.modelo.email.TipoAssuntoEmail;
import com.opfacil.modelo.controleacesso.TipoRecuperacaoSenha;
import com.opfacil.modelo.enums.Ativo;
import com.opfacil.modelo.enums.SituacaoOpRealizadas;
import com.opfacil.modelo.enums.TipoArquivo;
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
    public Class getPessoaExemplo() {
        return PessoaExemplo.class;
    }

    public Class getLote() {
        return Lote.class;
    }
    public Class getMotivoPagamento() {
        return MotivoPagamento.class;
    }
    public Class getEmpresa() {
        return Empresa.class;
    }
    public Class getUf() {
        return Uf.class;
    }
    public Class getFuncionario() {
        return Funcionario.class;
    }

    public Class getSituacaoOp() {
        return SituacaoOp.class;
    }
    
    public Class getTipoArquivo() {
        return TipoArquivo.class;
    }
    
    public Class getSituacaoOpRealizadas() {
        return SituacaoOpRealizadas.class;
    }
    
    public Class getPagamento() {
        return Pagamento.class;
    }

    public Class getDownloadArquivos() {
        return DownloadArquivos.class;
    }
    public Class getArquivo() {
        return Arquivo.class;
    }
    
    public Class getAtivo() {
        return Ativo.class;
    }

}