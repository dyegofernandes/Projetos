package br.com.pagcontascarne;

import br.com.pagcontascarne.dao.controleacesso.PermissaoDAO;
import br.com.pagcontascarne.modelo.controleacesso.Permissao;
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

        create(new Permissao("cadastros", "Cadastros", true), null);

        //Produto
        create(new Permissao("produto", "Produto", false), "cadastros");
        create(new Permissao("produto.create", "Cadastro de Produto/Serviço", "/view/dados/produto/createProduto.jsf", false), "produto");
        create(new Permissao("produto.list", "Produtos/Serviços", "/view/dados/produto/listProduto.jsf", true), "cadastros");
        create(new Permissao("produto.audit", "Auditoria de Produto/Serviço"), "produto");
        create(new Permissao("produto.delete", "Exclusão de Produto/Serviço"), "produto");

//Banco
        create(new Permissao("banco", "Banco", false), "cadastros");
        create(new Permissao("banco.create", "Cadastro de Banco", "/view/dados/banco/createBanco.jsf", false), "banco");
        create(new Permissao("banco.list", "Bancos", "/view/dados/banco/listBanco.jsf", true), "cadastros");
        create(new Permissao("banco.audit", "Auditoria de Banco"), "banco");
        create(new Permissao("banco.delete", "Exclusão de Banco"), "banco");

//Contato
        create(new Permissao("contato", "Contato", false), "cadastros");
        create(new Permissao("contato.create", "Cadastro de Contato", "/view/dados/contato/createContato.jsf", false), "contato");
        create(new Permissao("contato.list", "Contatos", "/view/dados/contato/listContato.jsf", true), "cadastros");
        create(new Permissao("contato.audit", "Auditoria de Contato"), "contato");
        create(new Permissao("contato.delete", "Exclusão de Contato"), "contato");

//Cidade
        create(new Permissao("cidade", "Cidade", false), "cadastros");
        create(new Permissao("cidade.create", "Cadastro de Cidade", "/view/dados/cidade/createCidade.jsf", false), "cidade");
        create(new Permissao("cidade.list", "Cidades", "/view/dados/cidade/listCidade.jsf", true), "cadastros");
        create(new Permissao("cidade.audit", "Auditoria de Cidade"), "cidade");
        create(new Permissao("cidade.delete", "Exclusão de Cidade"), "cidade");

        //Uf
        create(new Permissao("uf", "Uf", false), "cadastros");
        create(new Permissao("uf.create", "Cadastro de Uf", "/view/dados/uf/createUf.jsf", false), "uf");
        create(new Permissao("uf.list", "Ufs", "/view/dados/uf/listUf.jsf", true), "cadastros");
        create(new Permissao("uf.audit", "Auditoria de Uf"), "uf");
        create(new Permissao("uf.delete", "Exclusão de Uf"), "uf");

//Cliente
        create(new Permissao("cliente", "Cliente", false), "cadastros");
        create(new Permissao("cliente.create", "Cadastro de Cliente", "/view/dados/cliente/createCliente.jsf", false), "cliente");
        create(new Permissao("cliente.list", "Clientes", "/view/dados/cliente/listCliente.jsf", true), "cadastros");
        create(new Permissao("cliente.audit", "Auditoria de Cliente"), "cliente");
        create(new Permissao("cliente.delete", "Exclusão de Cliente"), "cliente");

//Convenio
        create(new Permissao("convenio", "Convenio", false), "cadastros");
        create(new Permissao("convenio.create", "Cadastro de Convênio", "/view/dados/convenio/createConvenio.jsf", false), "convenio");
        create(new Permissao("convenio.list", "Convênios", "/view/dados/convenio/listConvenio.jsf", true), "cadastros");
        create(new Permissao("convenio.audit", "Auditoria de Convênio"), "convenio");
        create(new Permissao("convenio.delete", "Exclusão de Convênio"), "convenio");
        create(new Permissao("convenio.coluna", "Visualizar coluna de Convenio"), "convenio");

//Boleto
        create(new Permissao("boleto", "Boleto", false), "cadastros");
        create(new Permissao("boleto.create", "Cadastro de Boleto", "/view/dados/boleto/createBoleto.jsf", false), "boleto");
        create(new Permissao("boleto.list", "Gerar Boletos", "/view/dados/boleto/listBoleto.jsf", true), "cadastros");
        create(new Permissao("boleto.audit", "Auditoria de Boleto"), "boleto");
        create(new Permissao("boleto.delete", "Exclusão de Boleto"), "boleto");

        create(new Permissao("relatorios", "Relatórios", true), null);

        create(new Permissao("relatorios.boletos.imprimir", "Imprimir Boletos", true), "relatorios");
        create(new Permissao("relatorios.boletos.segundaVia", "2a Via de Boletos", true), "relatorios");
        create(new Permissao("relatorios.boletos", "Relação de Boletos", true), "relatorios");

        //Deposito
        create(new Permissao("deposito", "Depósito", false), "relatorios");
        create(new Permissao("deposito.create", "Cadastro de Depósito", "/view/dados/deposito/createDeposito.jsf", false), "deposito");
        create(new Permissao("deposito.list", "Conta Corrente", "/view/dados/deposito/listDeposito.jsf", true), "relatorios");
        create(new Permissao("deposito.audit", "Auditoria de Depósito"), "deposito");
        create(new Permissao("deposito.delete", "Exclusão de Depósito"), "deposito");


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
