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
        create(new Permissao("cadastro", "Cadastro", false), null);
//Orgao
        create(new Permissao("orgao", "Orgão - Menu", false), "cadastro");
        create(new Permissao("orgao.create", "Cadastro de Órgão", "/view/cadastro/orgao/createOrgao.jsf", false), "orgao");
        create(new Permissao("orgao.list", "Órgãos", "/view/cadastro/orgao/listOrgao.jsf", true), "cadastro");
        create(new Permissao("orgao.audit", "Auditoria de Órgão"), "orgao");
        create(new Permissao("orgao.delete", "Exclusão de Órgão"), "orgao");

//Unidade
        create(new Permissao("unidade", "Unidade", false), "cadastro");
        create(new Permissao("unidade.create", "Cadastro de Unidade", "/view/cadastro/unidade/createUnidade.jsf", false), "unidade");
        create(new Permissao("unidade.list", "Unidades", "/view/cadastro/unidade/listUnidade.jsf", true), "cadastro");
        create(new Permissao("unidade.audit", "Auditoria de Unidade"), "unidade");
        create(new Permissao("unidade.delete", "Exclusão de Unidade"), "unidade");

//Cidade
        create(new Permissao("cidade", "Cidade", false), "cadastro");
        create(new Permissao("cidade.create", "Cadastro de Cidade", "/view/cadastro/cidade/createCidade.jsf", false), "cidade");
        create(new Permissao("cidade.list", "Cidades", "/view/cadastro/cidade/listCidade.jsf", true), "cadastro");
        create(new Permissao("cidade.audit", "Auditoria de Cidade"), "cidade");
        create(new Permissao("cidade.delete", "Exclusão de Cidade"), "cidade");

//Estado
        create(new Permissao("estado", "Estado", false), "cadastro");
        create(new Permissao("estado.create", "Cadastro de Estado", "/view/cadastro/estado/createEstado.jsf", false), "estado");
        create(new Permissao("estado.list", "Estados", "/view/cadastro/estado/listEstado.jsf", true), "cadastro");
        create(new Permissao("estado.audit", "Auditoria de Estado"), "estado");
        create(new Permissao("estado.delete", "Exclusão de Estado"), "estado");

        //Territorio Cidade
        create(new Permissao("territorios", "Territorios", false), "cadastro");

//Territorio Cidade
        create(new Permissao("territorioCidade", "Territorio Cidade", false), "territorios");
        create(new Permissao("territorioCidade.create", "Cadastro de Territorio Cidade", "/view/cadastro/territorioCidade/createTerritorioCidade.jsf", false), "territorioCidade");
        create(new Permissao("territorioCidade.list", "Cidades", "/view/cadastro/territorioCidade/listTerritorioCidade.jsf", true), "territorios");
        create(new Permissao("territorioCidade.audit", "Auditoria de Territorio Cidade"), "territorioCidade");
        create(new Permissao("territorioCidade.delete", "Exclusão de Territorio Cidade"), "territorioCidade");

//Territorio Bairro
        create(new Permissao("territorioBairro", "Territorio Bairro", false), "territorios");
        create(new Permissao("territorioBairro.create", "Cadastro de Territorio Bairro", "/view/cadastro/territorioBairro/createTerritorioBairro.jsf", false), "territorioBairro");
        create(new Permissao("territorioBairro.list", "Bairros", "/view/cadastro/territorioBairro/listTerritorioBairro.jsf", true), "territorios");
        create(new Permissao("territorioBairro.audit", "Auditoria de Territorio Bairro"), "territorioBairro");
        create(new Permissao("territorioBairro.delete", "Exclusão de Territorio Bairro"), "territorioBairro");

//Bairro
        create(new Permissao("bairro", "Bairro", false), "cadastro");
        create(new Permissao("bairro.create", "Cadastro de Bairro", "/view/cadastro/bairro/createBairro.jsf", false), "bairro");
        create(new Permissao("bairro.list", "Bairros", "/view/cadastro/bairro/listBairro.jsf", true), "cadastro");
        create(new Permissao("bairro.audit", "Auditoria de Bairro"), "bairro");
        create(new Permissao("bairro.delete", "Exclusão de Bairro"), "bairro");

        //Violação Menu
        create(new Permissao("violacao", "Violação", true), "cadastro");
        //Natureza Da Violacao
        create(new Permissao("naturezaDaViolacao", "Natureza Da Violação", false), "violacao");
        create(new Permissao("naturezaDaViolacao.create", "Cadastro de Natureza Da Violação", "/view/cadastro/naturezaDaViolacao/createNaturezaDaViolacao.jsf", false), "naturezaDaViolacao");
        create(new Permissao("naturezaDaViolacao.list", "Naturezas", "/view/cadastro/naturezaDaViolacao/listNaturezaDaViolacao.jsf", true), "violacao");
        create(new Permissao("naturezaDaViolacao.audit", "Auditoria de Natureza Da Violação"), "naturezaDaViolacao");
        create(new Permissao("naturezaDaViolacao.delete", "Exclusão de Natureza Da Violação"), "naturezaDaViolacao");

//Grupo De Violacao
        create(new Permissao("grupoDeViolacao", "Grupo De Violação", false), "violacao");
        create(new Permissao("grupoDeViolacao.create", "Cadastro de Grupo De Violação", "/view/cadastro/grupoDeViolacao/createGrupoDeViolacao.jsf", false), "grupoDeViolacao");
        create(new Permissao("grupoDeViolacao.list", "Grupos", "/view/cadastro/grupoDeViolacao/listGrupoDeViolacao.jsf", true), "violacao");
        create(new Permissao("grupoDeViolacao.audit", "Auditoria de Grupo De Violação"), "grupoDeViolacao");
        create(new Permissao("grupoDeViolacao.delete", "Exclusão de Grupo De Violação"), "grupoDeViolacao");

//        //Identidade De Genero
//        create(new Permissao("identidadeDeGenero", "Identidade De Genero", false), "cadastro");
//        create(new Permissao("identidadeDeGenero.create", "Cadastro de Identidade De Genero", "/view/cadastro/identidadeDeGenero/createIdentidadeDeGenero.jsf", false), "identidadeDeGenero");
//        create(new Permissao("identidadeDeGenero.list", "Identidades de Genero", "/view/cadastro/identidadeDeGenero/listIdentidadeDeGenero.jsf", true), "cadastro");
//        create(new Permissao("identidadeDeGenero.audit", "Auditoria de Identidade De Genero"), "identidadeDeGenero");
//        create(new Permissao("identidadeDeGenero.delete", "Exclusão de Identidade De Genero"), "identidadeDeGenero");
//
////Orientacao Sexual
//        create(new Permissao("orientacaoSexual", "Orientacao Sexual", false), "cadastro");
//        create(new Permissao("orientacaoSexual.create", "Cadastro de Orientacao Sexual", "/view/cadastro/orientacaoSexual/createOrientacaoSexual.jsf", false), "orientacaoSexual");
//        create(new Permissao("orientacaoSexual.list", "Orientações Sexuais", "/view/cadastro/orientacaoSexual/listOrientacaoSexual.jsf", true), "cadastro");
//        create(new Permissao("orientacaoSexual.audit", "Auditoria de Orientacao Sexual"), "orientacaoSexual");
//        create(new Permissao("orientacaoSexual.delete", "Exclusão de Orientacao Sexual"), "orientacaoSexual");

        create(new Permissao("menu_denuncia", "Denúncia", true), null);
        //Denuncia
        create(new Permissao("denuncia", "Denúncia", false), "menu_denuncia");
        create(new Permissao("denuncia.create", "Cadastro de Denuncia", "/view/denuncia/denuncia/createDenuncia.jsf", false), "denuncia");
        create(new Permissao("denuncia.list", "Denúncias", "/view/denuncia/denuncia/listDenuncia.jsf", true), "menu_denuncia");
        create(new Permissao("denuncia.audit", "Auditoria de Denuncia"), "denuncia");
        create(new Permissao("denuncia.delete", "Exclusão de Denuncia"), "denuncia");
        /**
         * Administracao Sistema
         */
        create(new Permissao("administracaoSistema", "Sistema", true), null);

        /**
         * Cadastro
         */
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

        create(new Permissao("cadastro", "Cadastro", true), null);

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
