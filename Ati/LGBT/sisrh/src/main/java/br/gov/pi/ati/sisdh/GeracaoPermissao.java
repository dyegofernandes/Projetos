package br.gov.pi.ati.sisdh;

import br.gov.pi.ati.sisdh.dao.controleacesso.PermissaoDAO;
import br.gov.pi.ati.sisdh.modelo.controleacesso.Permissao;
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
         * Cadastro
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

        //Ficha de Visita Institucional
        create(new Permissao("fichaDeVisitaInstitucional", "Ficha De Visita Institucional", false), "cadastro");
        create(new Permissao("fichaDeVisitaInstitucional.create", "Cadastro de Ficha De Visita Institucional", "/view/cadastro/fichaDeVisitaInstitucional/createFichaDeVisitaInstitucional.jsf", false), "fichaDeVisitaInstitucional");
        create(new Permissao("fichaDeVisitaInstitucional.list", "Fichas Visitas Institucionais", "/view/cadastro/fichaDeVisitaInstitucional/listFichaDeVisitaInstitucional.jsf", true), "cadastro");
        create(new Permissao("fichaDeVisitaInstitucional.audit", "Auditoria de Ficha De Visita Institucional"), "fichaDeVisitaInstitucional");
        create(new Permissao("fichaDeVisitaInstitucional.delete", "Exclusão de Ficha De Visita Institucional"), "fichaDeVisitaInstitucional");

        //Roteiro De Triagem Do Usuario 
        create(new Permissao("roteiroDeTriagemDoUsuario", "Roteiro De Triagem Do Usuario", false), "cadastro");
        create(new Permissao("roteiroDeTriagemDoUsuario.create", "Cadastro de Roteiro De Triagem Do Usuario", "/view/cadastro/roteiroDeTriagemDoUsuario/createRoteiroDeTriagemDoUsuario.jsf", false), "roteiroDeTriagemDoUsuario");
        create(new Permissao("roteiroDeTriagemDoUsuario.list", "Roteiros de Triagens", "/view/cadastro/roteiroDeTriagemDoUsuario/listRoteiroDeTriagemDoUsuario.jsf", true), "cadastro");
        create(new Permissao("roteiroDeTriagemDoUsuario.audit", "Auditoria de Roteiro De Triagem Do Usuario"), "roteiroDeTriagemDoUsuario");
        create(new Permissao("roteiroDeTriagemDoUsuario.delete", "Exclusão de Roteiro De Triagem Do Usuario"), "roteiroDeTriagemDoUsuario");

        //Encaminhamento 
        create(new Permissao("encaminhamento", "Encaminhamento", false), "cadastro");
        create(new Permissao("encaminhamento.create", "Cadastro de Encaminhamento", "/view/cadastro/encaminhamento/createEncaminhamento.jsf", false), "encaminhamento");
        create(new Permissao("encaminhamento.list", "Encaminhamentos", "/view/cadastro/encaminhamento/listEncaminhamento.jsf", true), "cadastro");
        create(new Permissao("encaminhamento.audit", "Auditoria de Encaminhamento"), "encaminhamento");
        create(new Permissao("encaminhamento.delete", "Exclusão de Encaminhamento"), "encaminhamento");

        //Formulario De Denuncia 
//        create(new Permissao("formularioDeDenuncia", "Formulario De Denuncia LGBT", false), "formularios.lgbt");
//        create(new Permissao("formularioDeDenunciaLGBT.create", "Cadastro de Formulario De Denuncia LGBT", "/view/formulario/formularioDeDenunciaLGBT/createFormularioDeDenunciaLGBT.jsf", false), "formularioDeDenunciaLGBT");
//        create(new Permissao("formularioDeDenunciaLGBT.list", "Formulários de Denúncias", "/view/formulario/formularioDeDenunciaLGBT/listFormularioDeDenunciaLGBT.jsf", true), "formularios.lgbt");
//        create(new Permissao("formularioDeDenunciaLGBT.audit", "Auditoria de Formulario De Denuncia LGBT"), "formularioDeDenunciaLGBT");
//        create(new Permissao("formularioDeDenunciaLGBT.delete", "Exclusão de Formulario De Denuncia LGBT"), "formularioDeDenunciaLGBT");
        //Ficha De Visita Domiciliar
        create(new Permissao("fichaDeVisitaDomiciliar", "Ficha De Visita Domiciliar", false), "cadastro");
        create(new Permissao("fichaDeVisitaDomiciliar.create", "Cadastro de Ficha De Visita Domiciliar", "/view/cadastro/fichaDeVisitaDomiciliar/createFichaDeVisitaDomiciliar.jsf", false), "fichaDeVisitaDomiciliar");
        create(new Permissao("fichaDeVisitaDomiciliar.list", "Fichas De Visitas Domiciliares", "/view/cadastro/fichaDeVisitaDomiciliar/listFichaDeVisitaDomiciliar.jsf", true), "cadastro");
        create(new Permissao("fichaDeVisitaDomiciliar.audit", "Auditoria de Ficha De Visita Domiciliar"), "fichaDeVisitaDomiciliar");
        create(new Permissao("fichaDeVisitaDomiciliar.delete", "Exclusão de Ficha De Visita Domiciliar"), "fichaDeVisitaDomiciliar");

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
