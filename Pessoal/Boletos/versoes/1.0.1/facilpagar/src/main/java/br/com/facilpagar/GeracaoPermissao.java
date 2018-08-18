package br.com.facilpagar;

import br.com.facilpagar.dao.controleacesso.PermissaoDAO;
import br.com.facilpagar.modelo.controleacesso.Permissao;
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
        create(new Permissao("permissao.create", "Cadastro", "/view/controleAcesso/permissao/createPermissao.jsf", true), "permissao");
        create(new Permissao("permissao.list", "Consulta", "/view/controleAcesso/permissao/listPermissao.jsf", true), "permissao");
        create(new Permissao("permissao.audit", "Auditoria de Permissão"), "permissao");
        create(new Permissao("permissao.delete", "Exclusão de Permissão"), "permissao");
        create(new Permissao("permissao.ativacao", "Ativação de Permissão"), "permissao");
        create(new Permissao("permissao.inativacao", "Inativação de Permissão"), "permissao");

        //Usuario
        create(new Permissao("usuario", "Usuário", true), "controleAcesso");
        create(new Permissao("usuario.create", "Cadastro", "/view/controleAcesso/usuario/createUsuario.jsf", true), "usuario");
        create(new Permissao("usuario.list", "Consulta", "/view/controleAcesso/usuario/listUsuario.jsf", true), "usuario");
        create(new Permissao("usuario.audit", "Auditoria de Usuário"), "usuario");
        create(new Permissao("usuario.delete", "Exclusão de Usuário"), "usuario");

        //Perfil
        create(new Permissao("perfil", "Perfil", true), "controleAcesso");
        create(new Permissao("perfil.create", "Cadastro", "/view/controleAcesso/perfil/createPerfil.jsf", true), "perfil");
        create(new Permissao("perfil.list", "Consulta", "/view/controleAcesso/perfil/listPerfil.jsf", true), "perfil");
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
        create(new Permissao("modeloEmail.create", "Cadastro", "/view/email/modeloEmail/createModeloEmail.jsf", true), "modeloEmail");
        create(new Permissao("modeloEmail.list", "Consulta", "/view/email/modeloEmail/listModeloEmail.jsf", true), "modeloEmail");
        create(new Permissao("modeloEmail.audit", "Auditoria de Modelo de Email"), "modeloEmail");
        create(new Permissao("modeloEmail.delete", "Exclusão de Modelo de Email"), "modeloEmail");

        //Configuracao email
        create(new Permissao("configuracaoEmail", "Configuração de Email", true), "email");
        create(new Permissao("configuracaoEmail.create", "Cadastro", "/view/email/configuracaoEmail/createConfiguracaoEmail.jsf", true), "configuracaoEmail");
        create(new Permissao("configuracaoEmail.list", "Consulta", "/view/email/configuracaoEmail/listConfiguracaoEmail.jsf", true), "configuracaoEmail");
        create(new Permissao("configuracaoEmail.audit", "Auditoria"), "configuracaoEmail");
        create(new Permissao("configuracaoEmail.delete", "Exclusão de Configuração de Email"), "configuracaoEmail");

        create(new Permissao("cadastros", "Cadastros", true), null);

        //Produto
        create(new Permissao("produto", "Produto", true), "cadastros");
        create(new Permissao("produto.create", "Cadastro", "/view/dados/produto/createProduto.jsf", true), "produto");
        create(new Permissao("produto.list", "Consulta", "/view/dados/produto/listProduto.jsf", true), "produto");
        create(new Permissao("produto.audit", "Auditoria de Produto/Serviço"), "produto");
        create(new Permissao("produto.delete", "Exclusão de Produto/Serviço"), "produto");

//Banco
        create(new Permissao("banco", "Banco", true), "cadastros");
        create(new Permissao("banco.create", "Cadastro", "/view/dados/banco/createBanco.jsf", true), "banco");
        create(new Permissao("banco.list", "Consulta", "/view/dados/banco/listBanco.jsf", true), "banco");
        create(new Permissao("banco.audit", "Auditoria de Banco"), "banco");
        create(new Permissao("banco.delete", "Exclusão de Banco"), "banco");

//Contato
        create(new Permissao("contato", "Contato", true), "cadastros");
        create(new Permissao("contato.create", "Cadastro", "/view/dados/contato/createContato.jsf", true), "contato");
        create(new Permissao("contato.list", "Consulta", "/view/dados/contato/listContato.jsf", true), "contato");
        create(new Permissao("contato.audit", "Auditoria de Contato"), "contato");
        create(new Permissao("contato.delete", "Exclusão de Contato"), "contato");

//Cidade
        create(new Permissao("cidade", "Cidade", true), "cadastros");
        create(new Permissao("cidade.create", "Cadastro", "/view/dados/cidade/createCidade.jsf", true), "cidade");
        create(new Permissao("cidade.list", "Consulta", "/view/dados/cidade/listCidade.jsf", true), "cidade");
        create(new Permissao("cidade.audit", "Auditoria de Cidade"), "cidade");
        create(new Permissao("cidade.delete", "Exclusão de Cidade"), "cidade");

        //Uf
        create(new Permissao("uf", "Estado", true), "cadastros");
        create(new Permissao("uf.create", "Cadastro", "/view/dados/uf/createUf.jsf", true), "uf");
        create(new Permissao("uf.list", "Consulta", "/view/dados/uf/listUf.jsf", true), "uf");
        create(new Permissao("uf.audit", "Auditoria de Estado"), "uf");
        create(new Permissao("uf.delete", "Exclusão de Estado"), "uf");

        //Sistema
        create(new Permissao("sistema", "Configurações Sistema", true), "administracaoSistema");
        create(new Permissao("sistema.create", "Cadastro", "/view/dados/sistema/createSistema.jsf", true), "sistema");
        create(new Permissao("sistema.list", "Consulta", "/view/dados/sistema/listSistema.jsf", true), "sistema");
        create(new Permissao("sistema.audit", "Auditoria de Configurações Sistema"), "sistema");
        create(new Permissao("sistema.delete", "Exclusão de Configurações Sistema"), "sistema");

//Cliente
        create(new Permissao("cliente", "Cliente", true), "cadastros");
        create(new Permissao("cliente.create", "Cadastro", "/view/dados/cliente/createCliente.jsf", true), "cliente");
        create(new Permissao("cliente.list", "Consulta", "/view/dados/cliente/listCliente.jsf", true), "cliente");
        create(new Permissao("cliente.audit", "Auditoria de Cliente"), "cliente");
        create(new Permissao("cliente.delete", "Exclusão de Cliente"), "cliente");

        //Franquia
        create(new Permissao("franquia", "Franquia", true), "cadastros");
        create(new Permissao("franquia.create", "Cadastro", "/view/dados/franquia/createFranquia.jsf", true), "franquia");
        create(new Permissao("franquia.list", "Consulta", "/view/dados/franquia/listFranquia.jsf", true), "franquia");
        create(new Permissao("franquia.audit", "Auditoria de Franquia"), "franquia");
        create(new Permissao("franquia.delete", "Exclusão de Franquia"), "franquia");
        create(new Permissao("franquia.coluna", "Visualizar coluna de Franquia nas Tabelas"), "franquia");
        create(new Permissao("franquia.campo", "Campo Franquia nas Telas"), "franquia");

//Convenio
        create(new Permissao("convenio", "Convênio", true), "cadastros");
        create(new Permissao("convenio.create", "Cadastro", "/view/dados/convenio/createConvenio.jsf", true), "convenio");
        create(new Permissao("convenio.list", "Consulta", "/view/dados/convenio/listConvenio.jsf", true), "convenio");
        create(new Permissao("convenio.audit", "Auditoria de Convênio"), "convenio");
        create(new Permissao("convenio.delete", "Exclusão de Convênio"), "convenio");
        create(new Permissao("convenio.coluna", "Visualizar coluna de Convenio nas Tabelas"), "convenio");
        create(new Permissao("convenio.campo", "Campo de Convenio nas Telas"), "convenio");

        create(new Permissao("financeiro", "Financeiro", true), null);

//Boleto
        create(new Permissao("boleto", "Boleto", false), "financeiro");
        create(new Permissao("boleto.create", "Gerar Boletos", "/view/dados/boleto/createBoleto.jsf", true), "financeiro");
        create(new Permissao("boleto.list", "Relação de Boletos", "/view/dados/boleto/listBoleto.jsf", true), "financeiro");
        create(new Permissao("boleto.audit", "Auditoria de Boleto"), "boleto");
        create(new Permissao("boleto.delete", "Exclusão de Boleto"), "boleto");
        create(new Permissao("boleto.segundaVia", "Gerar segunda Via de Boleto"), "boleto");
        create(new Permissao("boleto.editar", "Editar de Boleto"), "boleto");
        create(new Permissao("boleto.cancelar", "Cancelar de Boleto"), "boleto");

        //Deposito
        create(new Permissao("deposito", "Depósito", false), "financeiro");
        create(new Permissao("deposito.create", "Cadastro de Depósito", "/view/dados/deposito/createDeposito.jsf", false), "deposito");
        create(new Permissao("deposito.list", "Extrato", "/view/dados/deposito/listDeposito.jsf", true), "financeiro");
        create(new Permissao("deposito.audit", "Auditoria de Depósito"), "deposito");
        create(new Permissao("deposito.delete", "Exclusão de Depósito"), "deposito");

        //Categoria
        create(new Permissao("categoria", "Categoria", true), "cadastros");
        create(new Permissao("categoria.create", "Cadastro", "/view/dados/categoria/createCategoria.jsf", true), "categoria");
        create(new Permissao("categoria.list", "Consulta", "/view/dados/categoria/listCategoria.jsf", true), "categoria");
        create(new Permissao("categoria.audit", "Auditoria de Categoria"), "categoria");
        create(new Permissao("categoria.delete", "Exclusão de Categoria"), "categoria");


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
