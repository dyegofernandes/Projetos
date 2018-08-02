package br.com.ejccard;

import br.com.ejccard.dao.controleacesso.PermissaoDAO;
import br.com.ejccard.modelo.controleacesso.Permissao;
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

        //Menu Cadastro
        create(new Permissao("cadastro", "Cadastro", true), null);

        //Produto
        create(new Permissao("produto", "Produto", true), "cadastro");
        create(new Permissao("produto.create", "Cadastro de Produto", "/view/cadastro/produto/createProduto.jsf", true), "produto");
        create(new Permissao("produto.list", "Consulta de Produto", "/view/cadastro/produto/listProduto.jsf", true), "produto");
        create(new Permissao("produto.audit", "Auditoria de Produto"), "produto");
        create(new Permissao("produto.delete", "Exclusão de Produto"), "produto");

        //Equipe
        create(new Permissao("equipe", "Equipe", true), "cadastro");
        create(new Permissao("equipe.create", "Cadastro de Equipe", "/view/cadastro/equipe/createEquipe.jsf", true), "equipe");
        create(new Permissao("equipe.list", "Consulta de Equipe", "/view/cadastro/equipe/listEquipe.jsf", true), "equipe");
        create(new Permissao("equipe.audit", "Auditoria de Equipe"), "equipe");
        create(new Permissao("equipe.delete", "Exclusão de Equipe"), "equipe");

        //Membro
        create(new Permissao("membro", "Membro", true), "cadastro");
        create(new Permissao("membro.create", "Cadastro de Membro", "/view/cadastro/membro/createMembro.jsf", true), "membro");
        create(new Permissao("membro.list", "Consulta de Membro", "/view/cadastro/membro/listMembro.jsf", true), "membro");
        create(new Permissao("membro.audit", "Auditoria de Membro"), "membro");
        create(new Permissao("membro.delete", "Exclusão de Membro"), "membro");

        //Menu Financeiro
        create(new Permissao("financeiro", "Financeiro", true), null);

        //Ejc Card
        create(new Permissao("ejcCard", "EJC Card", true), "financeiro");
        create(new Permissao("ejcCard.create", "Cadastro de Ejc Card", "/view/financeiro/ejcCard/createEjcCard.jsf", true), "ejcCard");
        create(new Permissao("ejcCard.list", "Consulta de Ejc Card", "/view/financeiro/ejcCard/listEjcCard.jsf", true), "ejcCard");
        create(new Permissao("ejcCard.audit", "Auditoria de Ejc Card"), "ejcCard");
        create(new Permissao("ejcCard.delete", "Exclusão de Ejc Card"), "ejcCard");

//Estoque
        create(new Permissao("estoque", "Estoque", true), "financeiro");
        create(new Permissao("estoque.create", "Cadastro de Estoque", "/view/financeiro/estoque/createEstoque.jsf", true), "estoque");
        create(new Permissao("estoque.list", "Consulta de Estoque", "/view/financeiro/estoque/listEstoque.jsf", true), "estoque");
        create(new Permissao("estoque.audit", "Auditoria de Estoque"), "estoque");
        create(new Permissao("estoque.delete", "Exclusão de Estoque"), "estoque");

//Caixa
        create(new Permissao("caixa", "Caixa", true), "financeiro");
        create(new Permissao("caixa.create", "Cadastro de Caixa", "/view/financeiro/caixa/createCaixa.jsf", true), "caixa");
        create(new Permissao("caixa.list", "Consulta de Caixa", "/view/financeiro/caixa/listCaixa.jsf", true), "caixa");
        create(new Permissao("caixa.audit", "Auditoria de Caixa"), "caixa");
        create(new Permissao("caixa.delete", "Exclusão de Caixa"), "caixa");

//Movimento
        create(new Permissao("movimento", "Movimento", true), "financeiro");
        create(new Permissao("movimento.create", "Cadastro de Movimento", "/view/financeiro/movimento/createMovimento.jsf", true), "movimento");
        create(new Permissao("movimento.list", "Consulta de Movimento", "/view/financeiro/movimento/listMovimento.jsf", true), "movimento");
        create(new Permissao("movimento.audit", "Auditoria de Movimento"), "movimento");
        create(new Permissao("movimento.delete", "Exclusão de Movimento"), "movimento");


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
            permissaoDB.setPermissaoPai(permissao.getPermissaoPai());
            permissaoDB.setPossuiMenu(permissao.isPossuiMenu());
            permissaoDB.setGlobal(permissao.isGlobal());
            permissao = permissaoDB;
        }

        permissaoDAO.merge(permissao, false);
    }
}
