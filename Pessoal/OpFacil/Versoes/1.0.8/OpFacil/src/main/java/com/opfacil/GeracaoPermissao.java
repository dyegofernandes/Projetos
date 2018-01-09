package com.opfacil;

import com.opfacil.dao.controleacesso.PermissaoDAO;
import com.opfacil.modelo.controleacesso.Permissao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Classe para geracao das permissoes iniciais do sistema
 *
 * @author Ayslan
 */
@Stateless
public class GeracaoPermissao {

    private static final Logger logger = Logger.getLogger(GeracaoPermissao.class.getName());
    @EJB
    private PermissaoDAO permissaoDAO;

    public void generate() {

        /**
         * Administracao Sistema
         */
        create(new Permissao("administracaoSistema", "Sistema", true), null);


        /*
         * Controle de Acesso
         */
        create(new Permissao("controleAcesso", "Controle de Acesso", true), "administracaoSistema");

        //Permissao
        create(new Permissao("permissao", "Permissão", true), "controleAcesso");
        create(new Permissao("permissao.create", "Cadastro de Permissão", "/view/controleAcesso/permissao/createPermissao.jsf", true), "permissao");
        create(new Permissao("permissao.list", "Consulta de Permissão", "/view/controleAcesso/permissao/listPermissao.jsf", true), "permissao");
        create(new Permissao("permissao.audit", "Auditoria de Permissão"), "permissao");
        create(new Permissao("permissao.delete", "Exclusão de Permissão"), "permissao");
        create(new Permissao("permissao.ativacao", "Ativação de Permissão"), "permissao");
        create(new Permissao("permissao.inativacao", "Inativação de Permissão"), "permissao");

        //Usuario
        create(new Permissao("usuario", "Usuário", true), "controleAcesso");
        create(new Permissao("usuario.create", "Cadastro de Usuário", "/view/controleAcesso/usuario/createUsuario.jsf", true), "usuario");
        create(new Permissao("usuario.list", "Consulta de Usuário", "/view/controleAcesso/usuario/listUsuario.jsf", true), "usuario");
        create(new Permissao("usuario.audit", "Auditoria de Usuário"), "usuario");
        create(new Permissao("usuario.delete", "Exclusão de Usuário"), "usuario");

        //Perfil
        create(new Permissao("perfil", "Perfil", true), "controleAcesso");
        create(new Permissao("perfil.create", "Cadastro de Perfil", "/view/controleAcesso/perfil/createPerfil.jsf", true), "perfil");
        create(new Permissao("perfil.list", "Consulta de Perfil", "/view/controleAcesso/perfil/listPerfil.jsf", true), "perfil");
        create(new Permissao("perfil.audit", "Auditoria de Perfil"), "perfil");
        create(new Permissao("perfil.delete", "Exclusão de Perfil"), "perfil");

        //Acessos do Sistema
        create(new Permissao("acessoSistema.list", "Relatório de Acessos", "/view/controleAcesso/acessoSistema/listAcessoSistema.jsf", true), "controleAcesso");

        //Solicitacao recuperacao senha
        create(new Permissao("solicitacaoRecuperacaoSenha", "Recuperação de Senha", true), "controleAcesso");
        create(new Permissao("solicitacaoRecuperacaoSenha.list", "Consulta Recuperação de Senha", "/view/controleAcesso/solicitacaoRecuperacaoSenha/listSolicitacaoRecuperacaoSenha.jsf", true), "solicitacaoRecuperacaoSenha");
        create(new Permissao("solicitacaoRecuperacaoSenha.audit", "Auditoria de Recuperação de Senha"), "solicitacaoRecuperacaoSenha");

        /*
         * Email
         */
        create(new Permissao("email", "Email", true), "administracaoSistema");

        //Modelo email
        create(new Permissao("modeloEmail", "Modelo de Email", true), "email");
        create(new Permissao("modeloEmail.create", "Cadastro de Modelo de Email", "/view/email/modeloEmail/createModeloEmail.jsf", true), "modeloEmail");
        create(new Permissao("modeloEmail.list", "Consulta de Modelo de Email", "/view/email/modeloEmail/listModeloEmail.jsf", true), "modeloEmail");
        create(new Permissao("modeloEmail.audit", "Auditoria de Modelo de Email"), "modeloEmail");
        create(new Permissao("modeloEmail.delete", "Exclusão de Modelo de Email"), "modeloEmail");

        //Configuracao email
        create(new Permissao("configuracaoEmail", "Configuração de Email", true), "email");
        create(new Permissao("configuracaoEmail.create", "Cadastro de Configuração de Email", "/view/email/configuracaoEmail/createConfiguracaoEmail.jsf", true), "configuracaoEmail");
        create(new Permissao("configuracaoEmail.list", "Consulta de Configuração de Email", "/view/email/configuracaoEmail/listConfiguracaoEmail.jsf", true), "configuracaoEmail");
        create(new Permissao("configuracaoEmail.audit", "Auditoria de Configuração de Email"), "configuracaoEmail");
        create(new Permissao("configuracaoEmail.delete", "Exclusão de Configuração de Email"), "configuracaoEmail");

        create(new Permissao("cadastrosBasicos", "Cadastro", true), null);
        create(new Permissao("pagamento", "Ordem de Pagamento", true), null);

        //Empresa
        create(new Permissao("empresa", "Empresa", true), "cadastrosBasicos");
        create(new Permissao("empresa.create", "Cadastro de Empresa", "/view/cadastro/empresa/createEmpresa.jsf", true), "empresa");
        create(new Permissao("empresa.list", "Consulta de Empresa", "/view/cadastro/empresa/listEmpresa.jsf", true), "empresa");
        create(new Permissao("empresa.audit", "Auditoria de Empresa"), "empresa");
        create(new Permissao("empresa.delete", "Exclusão de Empresa"), "empresa");

//Funcionario
        create(new Permissao("funcionario", "Funcionario", true), "cadastrosBasicos");
        create(new Permissao("funcionario.create", "Cadastro de Funcionario", "/view/cadastro/funcionario/createFuncionario.jsf", true), "funcionario");
        create(new Permissao("funcionario.list", "Consulta de Funcionario", "/view/cadastro/funcionario/listFuncionario.jsf", true), "funcionario");
        create(new Permissao("funcionario.audit", "Auditoria de Funcionario"), "funcionario");
        create(new Permissao("funcionario.delete", "Exclusão de Funcionario"), "funcionario");

//Motivo Pagamento
        create(new Permissao("motivoPagamento", "Motivo Pagamento", true), "cadastrosBasicos");
        create(new Permissao("motivoPagamento.create", "Cadastro de Motivo Pagamento", "/view/cadastro/motivoPagamento/createMotivoPagamento.jsf", true), "motivoPagamento");
        create(new Permissao("motivoPagamento.list", "Consulta de Motivo Pagamento", "/view/cadastro/motivoPagamento/listMotivoPagamento.jsf", true), "motivoPagamento");
        create(new Permissao("motivoPagamento.audit", "Auditoria de Motivo Pagamento"), "motivoPagamento");
        create(new Permissao("motivoPagamento.delete", "Exclusão de Motivo Pagamento"), "motivoPagamento");

//Estado
        create(new Permissao("uf", "Estado", true), "cadastrosBasicos");
        create(new Permissao("uf.create", "Cadastro de Estado", "/view/cadastro/uf/createUf.jsf", true), "uf");
        create(new Permissao("uf.list", "Consulta de Estado", "/view/cadastro/uf/listUf.jsf", true), "uf");
        create(new Permissao("uf.audit", "Auditoria de Estado"), "uf");
        create(new Permissao("uf.delete", "Exclusão de Estado"), "uf");

        //Lote
        create(new Permissao("lote", "OP em Lote", true), "pagamento");
        create(new Permissao("lote.create", "Cadastro de OP em Lote", "/view/pagamento/lote/createLote.jsf", true), "lote");
        create(new Permissao("lote.list", "Consulta de OP em Lote", "/view/pagamento/lote/listLote.jsf", true), "lote");
        create(new Permissao("lote.audit", "Auditoria de OP em Lote"), "lote");
        create(new Permissao("lote.delete", "Exclusão de OP em Lote"), "lote");

        //Pagamento
        create(new Permissao("pagamentoOps", "Solicitação de OP", true), "pagamento");
        create(new Permissao("pagamentoOps.create", "Cadastro de Solicitação de OP", "/view/pagamento/pagamento/createPagamento.jsf", true), "pagamentoOps");
        create(new Permissao("pagamentoOps.list", "Consulta de Solicitação de OP", "/view/pagamento/pagamento/listPagamento.jsf", true), "pagamentoOps");
        create(new Permissao("pagamentoOps.audit", "Auditoria de Solicitação de OP"), "pagamentoOps");
        create(new Permissao("pagamentoOps.delete", "Exclusão de Solicitação de OP"), "pagamentoOps");
        
        create(new Permissao("pagamentoOpsRelatorio.list", "Consultar Situação OP", "/view/pagamento/pagamento/listPagamentosRealizados.jsf", true), "pagamento");

        //Download Arquivos
        create(new Permissao("downloadArquivos", "Download Arquivos", true), null);
        create(new Permissao("downloadArquivos.create", "Cadastro Download Arquivos", "/view/documentos/downloadArquivos/createDownloadArquivos.jsf", true), "downloadArquivos");
        create(new Permissao("downloadArquivos.list", "Consulta Download Arquivos", "/view/documentos/downloadArquivos/listDownloadArquivos.jsf", true), "downloadArquivos");
        create(new Permissao("downloadArquivos.audit", "Auditoria Download Arquivos"), "downloadArquivos");
        create(new Permissao("downloadArquivos.delete", "Exclusão Download Arquivos"), "downloadArquivos");

        /*
         * Configuracao
         */
        create(new Permissao("configuracaoSistema", "Configuração", true), "administracaoSistema");

        //Erro sistema
        create(new Permissao("erroSistema.list", "Relatório de Erros", "/view/configuracao/erroSistema/listErroSistema.jsf", true), "configuracaoSistema");

        /**
         * Permissoes Globais (essas permissoes todos terao acessos)
         */
        //Alterar Senha
        createGlobal(new Permissao("usuario.alterarSenha", "Alterar Senha", "/view/controleAcesso/password/alterPassword.jsf", true), "controleAcesso");
        createGlobal(new Permissao("usuario.ultimosAcessos", "Últimos Acessos", "/view/controleAcesso/acessoSistema/ultimosAcessoSistema.jsf", true), "controleAcesso");

    }

    private void createGlobal(Permissao permissao, String pai) {
        permissao.setGlobal(true);
        create(permissao, pai);
    }

    private void create(Permissao permissao, String pai) {

        if (pai != null && pai.equals(permissao.getKey())) {
            logger.log(Level.WARNING, "Permissao ''{0}'' pai dela mesmo. Esta permissao nao sera salva.", permissao.getKey());
            return;
        }

        Permissao permissaoDB = permissaoDAO.unique("key", permissao.getKey());

        if (pai != null && !pai.isEmpty()) {
            Permissao permissaoPai = permissaoDAO.unique("key", pai);
            if (permissaoPai == null) {
                logger.log(Level.WARNING, "Permissao ''{0}'' pai nao encontrada.", pai);
            }
            permissao.setPermissaoPai(permissaoPai);
        }

        if (permissaoDB != null) {
            permissaoDB.setUrl(permissao.getUrl());
            permissaoDB.setDescricao(permissao.getDescricao());
//            permissaoDB.setPermissaoPai(permissao.getPermissaoPai());
            permissaoDB.setPossuiMenu(permissao.isPossuiMenu());
            permissaoDB.setGlobal(permissao.isGlobal());
            permissao = permissaoDB;
        }

        permissaoDAO.merge(permissao, false);
    }
}
