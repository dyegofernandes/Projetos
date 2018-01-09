package com.ebol;

import com.ebol.dao.controleacesso.PermissaoDAO;
import com.ebol.modelo.controleacesso.Permissao;
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

        //Menu Cadastro Básicos
        create(new Permissao("cadastrosbasicos", "Cadastros Básicos", true), null);
        create(new Permissao("cidadeEstado", "Cidade e Estado", true), "cadastrosbasicos");

        //Cidade
        create(new Permissao("cidade", "Cidade - Pai", false), "cidadeEstado");
        //create(new Permissao("cidade.create", "Cadastro de Cidade", "/view/cadastro/cidade/createCidade.jsf", false), "cidadeEstado");
        create(new Permissao("cidade.list", "Cidades", "/view/cadastro/cidade/listCidade.jsf", true), "cidadeEstado");
//        create(new Permissao("cidade.audit", "Auditoria de Cidade"), "cidadeEstado");
//        create(new Permissao("cidade.delete", "Exclusão de Cidade"), "cidadeEstado");

        //Cliente
        create(new Permissao("cliente", "Cliente - Pai", false), "cadastrosbasicos");
        create(new Permissao("cliente.create", "Cadastro de Cliente", "/view/cadastro/cliente/createCliente.jsf", false), "cliente");
        create(new Permissao("cliente.list", "Clientes", "/view/cadastro/cliente/listCliente.jsf", true), "cadastrosbasicos");
        create(new Permissao("cliente.audit", "Auditoria de Cliente"), "cliente");
        create(new Permissao("cliente.delete", "Exclusão de Cliente"), "cliente");

        //Contato
//        create(new Permissao("contato", "Contato - Pai", false), "cadastrosbasicos");
//        create(new Permissao("contato.create", "Cadastro de Contato", "/view/cadastro/contato/createContato.jsf", false), "contato");
//        create(new Permissao("contato.list", "Contato", "/view/cadastro/contato/listContato.jsf", true), "cadastrosbasicos");
//        create(new Permissao("contato.audit", "Auditoria de Contato"), "contato");
//        create(new Permissao("contato.delete", "Exclusão de Contato"), "contato");
        //Convenio
        create(new Permissao("convenio", "Convênio - Pai", false), "cadastrosbasicos");
        create(new Permissao("convenio.create", "Cadastro de Convênio", "/view/cadastro/convenio/createConvenio.jsf", false), "convenio");
        create(new Permissao("convenio.list", "Convênios", "/view/cadastro/convenio/listConvenio.jsf", true), "cadastrosbasicos");
        create(new Permissao("convenio.audit", "Auditoria de Convênio"), "convenio");
        create(new Permissao("convenio.delete", "Exclusão de Convênio"), "convenio");

//Familiar
//        create(new Permissao("familiar", "Familiar - Pai", false), "cadastrosbasicos");
//        create(new Permissao("familiar.create", "Cadastro de Familiar", "/view/cadastro/familiar/createFamiliar.jsf", false), "familiar");
//        create(new Permissao("familiar.list", "Familiar", "/view/cadastro/familiar/listFamiliar.jsf", true), "cadastrosbasicos");
//        create(new Permissao("familiar.audit", "Auditoria de Familiar"), "familiar");
//        create(new Permissao("familiar.delete", "Exclusão de Familiar"), "familiar");
//Padrao Cobranca
//        create(new Permissao("padrao_Cobranca", "Padrão Cobrança - Pai", false), "cadastrosbasicos");
//        create(new Permissao("padrao_Cobranca.create", "Cadastro de Padrão Cobrança", "/view/cadastro/padrao_Cobranca/createPadrao_Cobranca.jsf", false), "padrao_Cobranca");
//        create(new Permissao("padrao_Cobranca.list", "Padrão Cobrança", "/view/cadastro/padrao_Cobranca/listPadrao_Cobranca.jsf", true), "cadastrosbasicos");
//        create(new Permissao("padrao_Cobranca.audit", "Auditoria de Padrão Cobrança"), "padrao_Cobranca");
//        create(new Permissao("padrao_Cobranca.delete", "Exclusão de Padrão Cobrança"), "padrao_Cobranca");
//Pessoa Op
//        create(new Permissao("pessoaOp", "Pessoa Op - Pai", false), "cadastrosbasicos");
//        create(new Permissao("pessoaOp.create", "Cadastro de Pessoa Op", "/view/cadastro/pessoaOp/createPessoaOp.jsf", false), "pessoaOp");
//        create(new Permissao("pessoaOp.list", "Pessoa Op", "/view/cadastro/pessoaOp/listPessoaOp.jsf", true), "cadastrosbasicos");
//        create(new Permissao("pessoaOp.audit", "Auditoria de Pessoa Op"), "pessoaOp");
//        create(new Permissao("pessoaOp.delete", "Exclusão de Pessoa Op"), "pessoaOp");

//Socio
//        create(new Permissao("socio", "Sócio - Pai", false), "cadastrosbasicos");
//        create(new Permissao("socio.create", "Cadastro de Sócio", "/view/cadastro/socio/createSocio.jsf", false), "socio");
//        create(new Permissao("socio.list", "Sócio", "/view/cadastro/socio/listSocio.jsf", true), "cadastrosbasicos");
//        create(new Permissao("socio.audit", "Auditoria de Sócio"), "socio");
//        create(new Permissao("socio.delete", "Exclusão de Sócio"), "socio");

//Uf
        create(new Permissao("uf", "Estado - Pai", false), "cidadeEstado");
//        create(new Permissao("uf.create", "Cadastro de Uf", "/view/cadastro/uf/createUf.jsf", true), "cidadeEstado");
        create(new Permissao("uf.list", "Estados", "/view/cadastro/uf/listUf.jsf", true), "cidadeEstado");
//        create(new Permissao("uf.audit", "Auditoria de Uf"), "cidadeEstado");
//        create(new Permissao("uf.delete", "Exclusão de Uf"), "cidadeEstado");

        //Banco
        create(new Permissao("banco", "Banco - Pai", false), null);
        create(new Permissao("banco.create", "Cadastro de Banco", "/view/cadastro/banco/createBanco.jsf", false), "banco");
        create(new Permissao("banco.list", "Bancos", "/view/cadastro/banco/listBanco.jsf", true), "cadastrosbasicos");
        create(new Permissao("banco.audit", "Auditoria de Banco"), "banco");
        create(new Permissao("banco.delete", "Exclusão de Banco"), "banco");

        //Loja
        create(new Permissao("loja", "Loja - Pai", false), null);
        create(new Permissao("loja.create", "Cadastro de Loja", "/view/cadastro/loja/createLoja.jsf", false), "loja");
        create(new Permissao("loja.list", "Lojas", "/view/cadastro/loja/listLoja.jsf", true), "cadastrosbasicos");
        create(new Permissao("loja.audit", "Auditoria de Loja"), "loja");
        create(new Permissao("loja.delete", "Exclusão de Loja"), "loja");

        //Menu Venda
        create(new Permissao("menuVenda", "Venda", true), null);

//Acrescimo
//        create(new Permissao("acrescimo", "Acrescimo - Pai", false), null);
//        create(new Permissao("acrescimo.create", "Cadastro de Acrescimo", "/view/venda/acrescimo/createAcrescimo.jsf", false), "acrescimo");
//        create(new Permissao("acrescimo.list", "Acrescimo", "/view/venda/acrescimo/listAcrescimo.jsf", true), "menuVenda");
//        create(new Permissao("acrescimo.audit", "Auditoria de Acrescimo"), "acrescimo");
//        create(new Permissao("acrescimo.delete", "Exclusão de Acrescimo"), "acrescimo");
//Boleto
        create(new Permissao("boleto", "Boleto - Pai", false), null);
        create(new Permissao("boleto.create", "Cadastro de Boleto", "/view/venda/boleto/createBoleto.jsf", false), "boleto");
        create(new Permissao("boleto.list", "Boletos", "/view/venda/boleto/listBoleto.jsf", true), "menuVenda");
        create(new Permissao("boleto.audit", "Auditoria de Boleto"), "boleto");
        create(new Permissao("boleto.delete", "Exclusão de Boleto"), "boleto");

//Credito
//        create(new Permissao("credito", "Credito - Pai", false), null);
//        create(new Permissao("credito.create", "Cadastro de Credito", "/view/venda/credito/createCredito.jsf", false), "credito");
//        create(new Permissao("credito.list", "Credito", "/view/venda/credito/listCredito.jsf", true), "menuVenda");
//        create(new Permissao("credito.audit", "Auditoria de Credito"), "credito");
//        create(new Permissao("credito.delete", "Exclusão de Credito"), "credito");
//Debito
//        create(new Permissao("debito", "Debito - Pai", false), null);
//        create(new Permissao("debito.create", "Cadastro de Debito", "/view/venda/debito/createDebito.jsf", false), "debito");
//        create(new Permissao("debito.list", "Debito", "/view/venda/debito/listDebito.jsf", true), "menuVenda");
//        create(new Permissao("debito.audit", "Auditoria de Debito"), "debito");
//        create(new Permissao("debito.delete", "Exclusão de Debito"), "debito");
//Desconto
//        create(new Permissao("desconto", "Desconto - Pai", false), null);
//        create(new Permissao("desconto.create", "Cadastro de Desconto", "/view/venda/desconto/createDesconto.jsf", false), "desconto");
//        create(new Permissao("desconto.list", "Desconto", "/view/venda/desconto/listDesconto.jsf", true), "menuVenda");
//        create(new Permissao("desconto.audit", "Auditoria de Desconto"), "desconto");
//        create(new Permissao("desconto.delete", "Exclusão de Desconto"), "desconto");
//Item
        create(new Permissao("item", "Produto/Serviço - Pai", false), null);
        create(new Permissao("item.create", "Cadastro de Produto/Serviço", "/view/venda/item/createItem.jsf", false), "item");
        create(new Permissao("item.list", "Produtos/Serviços", "/view/venda/item/listItem.jsf", true), "menuVenda");
        create(new Permissao("item.audit", "Auditoria de Produto/Serviço"), "item");
        create(new Permissao("item.delete", "Exclusão de Produto/Serviço"), "item");

//Item Vendido
//        create(new Permissao("item_Vendido", "Item Vendido - Pai", false), null);
//        create(new Permissao("item_Vendido.create", "Cadastro de Item Vendido", "/view/venda/item_Vendido/createItem_Vendido.jsf", false), "item_Vendido");
//        create(new Permissao("item_Vendido.list", "Item Vendido", "/view/venda/item_Vendido/listItem_Vendido.jsf", true), "menuVenda");
//        create(new Permissao("item_Vendido.audit", "Auditoria de Item Vendido"), "item_Vendido");
//        create(new Permissao("item_Vendido.delete", "Exclusão de Item Vendido"), "item_Vendido");
//Op Lancada
        create(new Permissao("opLancada", "Op Lancada - Pai", false), null);
        create(new Permissao("opLancada.create", "Cadastro de Op Lancada", "/view/venda/opLancada/createOpLancada.jsf", false), "opLancada");
        create(new Permissao("opLancada.list", "Ops Lancadas", "/view/venda/opLancada/listOpLancada.jsf", true), "menuVenda");
        create(new Permissao("opLancada.audit", "Auditoria de Op Lancada"), "opLancada");
        create(new Permissao("opLancada.delete", "Exclusão de Op Lancada"), "opLancada");

//Venda
        create(new Permissao("venda", "Venda - Pai", false), null);
        create(new Permissao("venda.create", "Cadastro de Venda", "/view/venda/venda/createVenda.jsf", false), "venda");
        create(new Permissao("venda.list", "Vendas", "/view/venda/venda/listVenda.jsf", true), "menuVenda");
        create(new Permissao("venda.audit", "Auditoria de Venda"), "venda");
        create(new Permissao("venda.delete", "Exclusão de Venda"), "venda");


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
