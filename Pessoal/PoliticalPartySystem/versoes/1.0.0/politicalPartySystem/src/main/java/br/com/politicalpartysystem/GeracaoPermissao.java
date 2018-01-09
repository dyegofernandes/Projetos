package br.com.politicalpartysystem;

import br.com.politicalpartysystem.dao.controleacesso.PermissaoDAO;
import br.com.politicalpartysystem.modelo.controleacesso.Permissao;
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

        /**
         * Cadastros Básicos
         */
        create(new Permissao("cadastro", "Cadastro", true), null);


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

        //Country
        create(new Permissao("country", "Pais", false), "cadastro");
        create(new Permissao("country.create", "Cadastro de Pais", "/view/cadastro/country/createCountry.jsf", false), "country");
        create(new Permissao("country.list", "Paises", "/view/cadastro/country/listCountry.jsf", true), "cadastro");
        create(new Permissao("country.audit", "Auditoria de Pais"), "country");
        create(new Permissao("country.delete", "Exclusão de Pais"), "country");

        //State
        create(new Permissao("state", "Estado", false), "cadastro");
        create(new Permissao("state.create", "Cadastro de Estado", "/view/cadastro/state/createState.jsf", false), "state");
        create(new Permissao("state.list", "Estados", "/view/cadastro/state/listState.jsf", true), "cadastro");
        create(new Permissao("state.audit", "Auditoria de Estado"), "state");
        create(new Permissao("state.delete", "Exclusão de Estado"), "state");

        //City
        create(new Permissao("city", "Cidade", false), "cadastro");
        create(new Permissao("city.create", "Cadastro de Cidade", "/view/cadastro/city/createCity.jsf", false), "city");
        create(new Permissao("city.list", "Cidades", "/view/cadastro/city/listCity.jsf", true), "cadastro");
        create(new Permissao("city.audit", "Auditoria de Cidade"), "city");
        create(new Permissao("city.delete", "Exclusão de Cidade"), "city");

        //Neighborhood
        create(new Permissao("neighborhood", "Bairro", false), "cadastro");
        create(new Permissao("neighborhood.create", "Cadastro de Bairro", "/view/cadastro/neighborhood/createNeighborhood.jsf", false), "neighborhood");
        create(new Permissao("neighborhood.list", "Bairros", "/view/cadastro/neighborhood/listNeighborhood.jsf", true), "cadastro");
        create(new Permissao("neighborhood.audit", "Auditoria de Bairro"), "neighborhood");
        create(new Permissao("neighborhood.delete", "Exclusão de Bairro"), "neighborhood");

        //Individual Person
        create(new Permissao("individualPerson", "Pessoa Física", false), "cadastro");
        create(new Permissao("individualPerson.create", "Cadastro de Pessoa Física", "/view/cadastro/individualPerson/createIndividualPerson.jsf", false), "individualPerson");
        create(new Permissao("individualPerson.list", "Pessoas Físicas", "/view/cadastro/individualPerson/listIndividualPerson.jsf", true), "individualPerson");
        create(new Permissao("individualPerson.audit", "Auditoria de Pessoa Física"), "individualPerson");
        create(new Permissao("individualPerson.delete", "Exclusão de Pessoa Física"), "individualPerson");

        //Legal Person
        create(new Permissao("legalPerson", "Pessoa Jurídica", false), "cadastro");
        create(new Permissao("legalPerson.create", "Cadastro de Pessoa Jurídica", "/view/cadastro/legalPerson/createLegalPerson.jsf", false), "legalPerson");
        create(new Permissao("legalPerson.list", "Pessoas Jurídicas", "/view/cadastro/legalPerson/listLegalPerson.jsf", true), "cadastro");
        create(new Permissao("legalPerson.audit", "Auditoria de Pessoa Jurídica"), "legalPerson");
        create(new Permissao("legalPerson.delete", "Exclusão de Pessoa Jurídica"), "legalPerson");

        //Member Political Party
        create(new Permissao("memberPoliticalParty", "Membro Partido Político", false), "cadastro");
        create(new Permissao("memberPoliticalParty.create", "Cadastro de Membro Partido Político", "/view/cadastro/memberPoliticalParty/createMemberPoliticalParty.jsf", false), "memberPoliticalParty");
        create(new Permissao("memberPoliticalParty.list", "Membros partidos políticos", "/view/cadastro/memberPoliticalParty/listMemberPoliticalParty.jsf", true), "cadastro");
        create(new Permissao("memberPoliticalParty.audit", "Auditoria de Membro Partido Político"), "memberPoliticalParty");
        create(new Permissao("memberPoliticalParty.delete", "Exclusão de Membro Partido Político"), "memberPoliticalParty");

//Political Party
        create(new Permissao("politicalParty", "Partido Político", false), "cadastro");
        create(new Permissao("politicalParty.create", "Cadastro de Partido Político", "/view/cadastro/politicalParty/createPoliticalParty.jsf", false), "politicalParty");
        create(new Permissao("politicalParty.list", "Partidos políticos", "/view/cadastro/politicalParty/listPoliticalParty.jsf", true), "cadastro");
        create(new Permissao("politicalParty.audit", "Auditoria de Partido Político"), "politicalParty");
        create(new Permissao("politicalParty.delete", "Exclusão de Partido Político"), "politicalParty");

//User Political Party
        create(new Permissao("userPoliticalParty", "Usuário Partido Político", false), "cadastro");
        create(new Permissao("userPoliticalParty.create", "Cadastro de Usuário Partido Político", "/view/cadastro/userPoliticalParty/createUserPoliticalParty.jsf", false), "userPoliticalParty");
        create(new Permissao("userPoliticalParty.list", "Usuários Partido Político", "/view/cadastro/userPoliticalParty/listUserPoliticalParty.jsf", true), "cadastro");
        create(new Permissao("userPoliticalParty.audit", "Auditoria de Usuário Partido Político"), "userPoliticalParty");
        create(new Permissao("userPoliticalParty.delete", "Exclusão de Usuário Partido Político"), "userPoliticalParty");

//Mail Box
        create(new Permissao("mailBox", "Mensagens", true), null);
        create(new Permissao("mailBoxUsers", "Mensagens", false), "mailBox");
        create(new Permissao("mailBoxUsers.create", "Cadastro de Mail Box", "/view/mensagem/mailBox/createMailBox.jsf", false), "mailBoxUsers");
        create(new Permissao("mailBoxUsers.list", "Caixa de Entrada", "/view/mensagem/mailBox/listMailBox.jsf", true), "mailBox");
        create(new Permissao("mailBoxUsers.audit", "Auditoria de Mail Box"), "mailBoxUsers");
        create(new Permissao("mailBoxUsers.delete", "Exclusão de Mail Box"), "mailBoxUsers");
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
