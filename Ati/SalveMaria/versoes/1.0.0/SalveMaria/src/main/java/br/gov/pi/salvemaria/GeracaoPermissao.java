package br.gov.pi.salvemaria;

import br.gov.pi.salvemaria.dao.controleacesso.PermissaoDAO;
import br.gov.pi.salvemaria.modelo.controleacesso.Permissao;
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
         * Cadastro Básicos do Sistema
         */
        create(new Permissao("cadastrobasico", "Cadastro", true), null);

        /**
         * Denúncias dos Sistema
         */
        create(new Permissao("denunciamenu", "Denúncia", true), null);

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

        /*
         * Configuracao
         */
        create(new Permissao("configuracaoSistema", "Configuração", true), "administracaoSistema");

        //Erro sistema
        create(new Permissao("erroSistema.list", "Relatório de Erros", "/view/configuracao/erroSistema/listErroSistema.jsf", true), "configuracaoSistema");

//Cidade
        create(new Permissao("cidade", "Cidade", false), "cadastrobasico");
        create(new Permissao("cidade.create", "Cadastro de Cidade", "/view/cadastro/cidade/createCidade.jsf", false), "cidade");
        create(new Permissao("cidade.list", "Cidades", "/view/cadastro/cidade/listCidade.jsf", true), "cadastrobasico");
        create(new Permissao("cidade.audit", "Auditoria de Cidade"), "cidade");
        create(new Permissao("cidade.delete", "Exclusão de Cidade"), "cidade");

//Cidade Regiao
        create(new Permissao("cidadeRegiao", "Cidade Regiao", false), "cadastrobasico");
        create(new Permissao("cidadeRegiao.create", "Cadastro de Cidade Regiao", "/view/cadastro/cidadeRegiao/createCidadeRegiao.jsf", false), "cidadeRegiao");
        create(new Permissao("cidadeRegiao.list", "Regiões", "/view/cadastro/cidadeRegiao/listCidadeRegiao.jsf", true), "cadastrobasico");
        create(new Permissao("cidadeRegiao.audit", "Auditoria de Cidade Regiao"), "cidadeRegiao");
        create(new Permissao("cidadeRegiao.delete", "Exclusão de Cidade Regiao"), "cidadeRegiao");

        //Estado
        create(new Permissao("bairro", "Bairro", false), "cadastrobasico");
        create(new Permissao("bairro.create", "Cadastro de Bairro", "/view/cadastro/bairro/createBairro.jsf", false), "bairro");
        create(new Permissao("bairro.list", "Bairros", "/view/cadastro/bairro/listBairro.jsf", true), "cadastrobasico");
        create(new Permissao("bairro.audit", "Auditoria de Estado"), "bairro");
        create(new Permissao("bairro.delete", "Exclusão de Estado"), "bairro");

//Estado
        create(new Permissao("estado", "Estado", false), "cadastrobasico");
        create(new Permissao("estado.create", "Cadastro de Estado", "/view/cadastro/estado/createEstado.jsf", false), "estado");
        create(new Permissao("estado.list", "Estados", "/view/cadastro/estado/listEstado.jsf", true), "cadastrobasico");
        create(new Permissao("estado.audit", "Auditoria de Estado"), "estado");
        create(new Permissao("estado.delete", "Exclusão de Estado"), "estado");

//Unidade
        create(new Permissao("unidade", "Unidade", false), "cadastrobasico");
        create(new Permissao("unidade.create", "Cadastro de Unidade", "/view/cadastro/unidade/createUnidade.jsf", false), "unidade");
        create(new Permissao("unidade.list", "Unidades", "/view/cadastro/unidade/listUnidade.jsf", true), "cadastrobasico");
        create(new Permissao("unidade.audit", "Auditoria de Unidade"), "unidade");
        create(new Permissao("unidade.delete", "Exclusão de Unidade"), "unidade");

        //Denuncia
        create(new Permissao("denuncia", "Denuncia", false), "denunciamenu");
        create(new Permissao("denuncia.create", "Cadastro de Denuncia", "/view/denuncia/denuncia/createDenuncia.jsf", false), "denuncia");
        create(new Permissao("denuncia.list", "Denúncias", "/view/denuncia/denuncia/listDenuncia.jsf", true), "denunciamenu");
        create(new Permissao("denuncia.audit", "Auditoria de Denuncia"), "denuncia");
        create(new Permissao("denuncia.delete", "Exclusão de Denuncia"), "denuncia");
        create(new Permissao("denuncia.monitoramento", "Monitoramento", "/view/denuncia/denuncia/monitoramento.jsf", true), "denunciamenu");

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
