package br.gov.pi.siste;

import br.gov.pi.siste.dao.controleacesso.PermissaoDAO;
import br.gov.pi.siste.modelo.controleacesso.Permissao;
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
        //Menu movimento
        create(new Permissao("financeiro", "Financeiro", true), null);
        //Menu relatorio
        create(new Permissao("relatorio", "Relatórios", true), null);

        //Menu Tabelas Auxiliares
        create(new Permissao("tabelaAuxiliares", "Tabelas Auxiliares", true), "financeiro");

        //Carga Horaria
        create(new Permissao("cargaHoraria", "Carga Horária - Pai", false), null);
        create(new Permissao("cargaHoraria.create", "Cadastro de Carga Horária", "/view/cadastro/cargaHoraria/createCargaHoraria.jsf", false), "cargaHoraria");
        create(new Permissao("cargaHoraria.list", "Cargas Horárias", "/view/cadastro/cargaHoraria/listCargaHoraria.jsf", true), "cadastro");
        create(new Permissao("cargaHoraria.audit", "Auditoria de Carga Horária"), "cargaHoraria");
        create(new Permissao("cargaHoraria.delete", "Exclusão de Carga Horária"), "cargaHoraria");

//Cargo
        create(new Permissao("cargo", "Cargo - Pai", false), null);
        create(new Permissao("cargo.create", "Cadastro de Cargo", "/view/cadastro/cargo/createCargo.jsf", false), "cargo");
        create(new Permissao("cargo.list", "Cargos", "/view/cadastro/cargo/listCargo.jsf", true), "cadastro");
        create(new Permissao("cargo.audit", "Auditoria de Cargo"), "cargo");
        create(new Permissao("cargo.delete", "Exclusão de Cargo"), "cargo");

//Cidade
        create(new Permissao("cidade", "Cidade - Pai", false), null);
        create(new Permissao("cidade.create", "Cadastro de Cidade", "/view/cadastro/cidade/createCidade.jsf", false), "cidade");
        create(new Permissao("cidade.list", "Cidades", "/view/cadastro/cidade/listCidade.jsf", true), "cadastro");
        create(new Permissao("cidade.audit", "Auditoria de Cidade"), "cidade");
        create(new Permissao("cidade.delete", "Exclusão de Cidade"), "cidade");

////Dados Funcionais
//        create(new Permissao("dadosFuncionais", "Dados Funcionais - Pai", false), null);
//        create(new Permissao("dadosFuncionais.create", "Cadastro de Dados Funcionais", "/view/cadastro/dadosFuncionais/createDadosFuncionais.jsf", false), "dadosFuncionais");
//        create(new Permissao("dadosFuncionais.list", "Consulta de Dados Funcionais", "/view/cadastro/dadosFuncionais/listDadosFuncionais.jsf", true), "cadastro");
//        create(new Permissao("dadosFuncionais.audit", "Auditoria de Dados Funcionais"), "dadosFuncionais");
//        create(new Permissao("dadosFuncionais.delete", "Exclusão de Dados Funcionais"), "dadosFuncionais");
//Estado
        create(new Permissao("estado", "Estado - Pai", false), null);
        create(new Permissao("estado.create", "Cadastro de Estado", "/view/cadastro/estado/createEstado.jsf", false), "estado");
        create(new Permissao("estado.list", "Estados", "/view/cadastro/estado/listEstado.jsf", true), "cadastro");
        create(new Permissao("estado.audit", "Auditoria de Estado"), "estado");
        create(new Permissao("estado.delete", "Exclusão de Estado"), "estado");

//Formacao Profissional
        create(new Permissao("formacaoProfissional", "Formação Profissional - Pai", false), null);
        create(new Permissao("formacaoProfissional.create", "Cadastro de Formação Profissional", "/view/cadastro/formacaoProfissional/createFormacaoProfissional.jsf", false), "formacaoProfissional");
        create(new Permissao("formacaoProfissional.list", "Formacões Profissionais", "/view/cadastro/formacaoProfissional/listFormacaoProfissional.jsf", true), "cadastro");
        create(new Permissao("formacaoProfissional.audit", "Auditoria de Formação Profissional"), "formacaoProfissional");
        create(new Permissao("formacaoProfissional.delete", "Exclusão de Formação Profissional"), "formacaoProfissional");

//Grau De Instrucao
        create(new Permissao("grauDeInstrucao", "Grau De Instrução - Pai", false), null);
        create(new Permissao("grauDeInstrucao.create", "Cadastro de Grau De Instrução", "/view/cadastro/grauDeInstrucao/createGrauDeInstrucao.jsf", false), "grauDeInstrucao");
        create(new Permissao("grauDeInstrucao.list", "Graus de Instruções", "/view/cadastro/grauDeInstrucao/listGrauDeInstrucao.jsf", true), "cadastro");
        create(new Permissao("grauDeInstrucao.audit", "Auditoria de Grau De Instrução"), "grauDeInstrucao");
        create(new Permissao("grauDeInstrucao.delete", "Exclusão de Grau De Instrução"), "grauDeInstrucao");

//Servidor
        create(new Permissao("servidor", "Trabalhador - Pai", false), null);
        create(new Permissao("servidor.create", "Cadastro de Trabalhador", "/view/cadastro/servidor/createServidor.jsf", false), "servidor");
        create(new Permissao("servidor.list", "Trabalhadores", "/view/cadastro/servidor/listServidor.jsf", true), "cadastro");
        create(new Permissao("servidor.audit", "Auditoria de Trabalhador"), "servidor");
        create(new Permissao("servidor.delete", "Exclusão de Trabalhador"), "servidor");

        //Cadastro Pessoal
        create(new Permissao("cadastroPessoal", "Cadastro Pessoal - Pai", false), null);
        create(new Permissao("cadastroPessoal.create", "Cadastro de Cadastro Pessoal", "/view/cadastro/cadastroPessoal/createCadastroPessoal.jsf", false), "cadastroPessoal");
        create(new Permissao("cadastroPessoal.list", "Cadastro Pessoais", "/view/cadastro/cadastroPessoal/listCadastroPessoal.jsf", true), "cadastro");
        create(new Permissao("cadastroPessoal.audit", "Auditoria de Cadastro Pessoal"), "cadastroPessoal");
        create(new Permissao("cadastroPessoal.delete", "Exclusão de Cadastro Pessoal"), "cadastroPessoal");

        //Orgao
        create(new Permissao("orgao", "Orgao - Pai", false), null);
        create(new Permissao("orgao.create", "Cadastro de Orgão", "/view/cadastro/orgao/createOrgao.jsf", false), "orgao");
        create(new Permissao("orgao.list", "Órgãos", "/view/cadastro/orgao/listOrgao.jsf", true), "cadastro");
        create(new Permissao("orgao.audit", "Auditoria de Orgão"), "orgao");
        create(new Permissao("orgao.delete", "Exclusão de Orgão"), "orgao");

        //Unidade
        create(new Permissao("unidade", "Unidade - Pai", false), null);
        create(new Permissao("unidade.create", "Cadastro de Unidade", "/view/cadastro/unidade/createUnidade.jsf", false), "unidade");
        create(new Permissao("unidade.list", "Unidades", "/view/cadastro/unidade/listUnidade.jsf", true), "cadastro");
        create(new Permissao("unidade.audit", "Auditoria de Unidade"), "unidade");
        create(new Permissao("unidade.delete", "Exclusão de Unidade"), "unidade");

////Aliquota Inss
//        create(new Permissao("aliquotaInss", "Aliquota Inss", true), null);
//        create(new Permissao("aliquotaInss.create", "Cadastro de Aliquota Inss", "/view/financeiro/aliquotaInss/createAliquotaInss.jsf", true), "aliquotaInss");
//        create(new Permissao("aliquotaInss.list", "Consulta de Aliquota Inss", "/view/financeiro/aliquotaInss/listAliquotaInss.jsf", true), "aliquotaInss");
//        create(new Permissao("aliquotaInss.audit", "Auditoria de Aliquota Inss"), "aliquotaInss");
//        create(new Permissao("aliquotaInss.delete", "Exclusão de Aliquota Inss"), "aliquotaInss");
//
////Aliquota IRRF
//        create(new Permissao("aliquotaIRRF", "Aliquota IRRF", true), null);
//        create(new Permissao("aliquotaIRRF.create", "Cadastro de Aliquota IRRF", "/view/financeiro/aliquotaIRRF/createAliquotaIRRF.jsf", true), "aliquotaIRRF");
//        create(new Permissao("aliquotaIRRF.list", "Consulta de Aliquota IRRF", "/view/financeiro/aliquotaIRRF/listAliquotaIRRF.jsf", true), "aliquotaIRRF");
//        create(new Permissao("aliquotaIRRF.audit", "Auditoria de Aliquota IRRF"), "aliquotaIRRF");
//        create(new Permissao("aliquotaIRRF.delete", "Exclusão de Aliquota IRRF"), "aliquotaIRRF");
//Movimento
        create(new Permissao("movimento", "Movimento - Pai", false), "financeiro");
        create(new Permissao("movimento.create", "Cadastro de Movimento", "/view/financeiro/movimento/createMovimento.jsf", false), "movimento");
        create(new Permissao("movimento.list", "Movimentos", "/view/financeiro/movimento/listMovimento.jsf", true), "financeiro");
        create(new Permissao("movimento.audit", "Auditoria de Movimento"), "movimento");
        create(new Permissao("movimento.delete", "Exclusão de Movimento"), "movimento");
        create(new Permissao("movimento.recibo", "Gerar Recibo Pagamento"), "movimento");

//Referencia
        create(new Permissao("referencia", "Competência - Pai", false), "financeiro");
        create(new Permissao("referencia.create", "Cadastro de Competência", "/view/financeiro/referencia/createReferencia.jsf", false), "referencia");
        create(new Permissao("referencia.list", "Competência", "/view/financeiro/referencia/listReferencia.jsf", true), "financeiro");
        create(new Permissao("referencia.audit", "Auditoria de Competência"), "referencia");
        create(new Permissao("referencia.delete", "Exclusão de Competência"), "referencia");
        create(new Permissao("referencia.abrir", "Abrir Competência"), "referencia");
        create(new Permissao("referencia.fechar", "Fechar Competência"), "referencia");
        create(new Permissao("referencia.processar", "Processar Competência"), "referencia");
        create(new Permissao("referencia.gerarRelatorio", "Gerar Relatório"), "referencia");
        create(new Permissao("referencia.gerarGfip", "Gerar Gfip"), "referencia");

//Salario Minimo
        create(new Permissao("salarioMinimo", "Salário Minimo -  Pai", false), "tabelaAuxiliares");
        create(new Permissao("salarioMinimo.create", "Cadastro de Salário Minimo", "/view/financeiro/salarioMinimo/createSalarioMinimo.jsf", false), "salarioMinimo");
        create(new Permissao("salarioMinimo.list", "Salários Minimos", "/view/financeiro/salarioMinimo/listSalarioMinimo.jsf", true), "tabelaAuxiliares");
        create(new Permissao("salarioMinimo.audit", "Auditoria de Salário Minimo"), "salarioMinimo");
        create(new Permissao("salarioMinimo.delete", "Exclusão de Salário Minimo"), "salarioMinimo");

//Tabela Inss
        create(new Permissao("tabelaInss", "Tabela Inss - Pai", false), "tabelaAuxiliares");
        create(new Permissao("tabelaInss.create", "Cadastro de Tabela Inss", "/view/financeiro/tabelaInss/createTabelaInss.jsf", false), "tabelaInss");
        create(new Permissao("tabelaInss.list", "Tabelas Inss", "/view/financeiro/tabelaInss/listTabelaInss.jsf", true), "tabelaAuxiliares");
        create(new Permissao("tabelaInss.audit", "Auditoria de Tabela Inss"), "tabelaInss");
        create(new Permissao("tabelaInss.delete", "Exclusão de Tabela Inss"), "tabelaInss");

//Tabela IRRF
        create(new Permissao("tabelaIRRF", "Tabela IRRF - Pai", false), "tabelaAuxiliares");
        create(new Permissao("tabelaIRRF.create", "Cadastro de Tabela IRRF", "/view/financeiro/tabelaIRRF/createTabelaIRRF.jsf", false), "tabelaIRRF");
        create(new Permissao("tabelaIRRF.list", "Tabelas IRRF", "/view/financeiro/tabelaIRRF/listTabelaIRRF.jsf", true), "tabelaAuxiliares");
        create(new Permissao("tabelaIRRF.audit", "Auditoria de Tabela IRRF"), "tabelaIRRF");
        create(new Permissao("tabelaIRRF.delete", "Exclusão de Tabela IRRF"), "tabelaIRRF");

        //Fonte Pagador
        create(new Permissao("fontePagador", "Fonte Pagador - Pai", false), null);
        create(new Permissao("fontePagador.create", "Cadastro de Fonte Pagador", "/view/financeiro/fontePagador/createFontePagador.jsf", false), "fontePagador");
        create(new Permissao("fontePagador.list", "Fontes Pagadoras", "/view/financeiro/fontePagador/listFontePagador.jsf", true), "financeiro");
        create(new Permissao("fontePagador.audit", "Auditoria de Fonte Pagador"), "fontePagador");
        create(new Permissao("fontePagador.delete", "Exclusão de Fonte Pagador"), "fontePagador");

        //Ajuda
        create(new Permissao("ajuda", "Ajuda", false), "administracaoSistema");
        create(new Permissao("ajuda.create", "Cadastro de Ajuda", "/view/configuracao/ajuda/createAjuda.jsf", false), "ajuda");
        create(new Permissao("ajuda.list", "Ajuda", "/view/configuracao/ajuda/listAjuda.jsf", true), "administracaoSistema");
        create(new Permissao("ajuda.audit", "Auditoria de Ajuda"), "ajuda");
        create(new Permissao("ajuda.delete", "Exclusão de Ajuda"), "ajuda");

        create(new Permissao("campos", "Campos", false), null);
        create(new Permissao("campos.unidade", "Campo unidade"), "campos");
        create(new Permissao("campos.orgao", "Campo orgao"), "campos");

        create(new Permissao("relatorio.repasses", "Repasses", "/view/relatorios/relatorioDeRepasses.jsf", true), "relatorio");
        create(new Permissao("relatorio.controleAutonomos", "Controle de Autônomos", "/view/relatorios/relatorioDeControleAutonomos.jsf", true), "relatorio");
        create(new Permissao("relatorio.valorUsadoPorUnidade", "Valor Usado Por Unidade", "/view/relatorios/valorUsadoPorUnidade.jsf", true), "relatorio");

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
