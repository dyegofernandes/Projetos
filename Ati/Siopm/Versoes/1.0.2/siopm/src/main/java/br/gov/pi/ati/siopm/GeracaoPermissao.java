package br.gov.pi.ati.siopm;

import br.gov.pi.ati.siopm.dao.controleacesso.PermissaoDAO;
import br.gov.pi.ati.siopm.modelo.controleacesso.Permissao;
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
         * Menu Administracao Sistema
         */
        create(new Permissao("administracaoSistema", "Sistema", true), null);

        /*
         * Cadastro Básico
         */
        create(new Permissao("cadastrobasico", "Cadastro", true), null);

        /*
         * Menu Ocorrência
         */
        create(new Permissao("ocorrencia", "Ocorrência", true), null);

        /*
         * Menu Relatórios
         */
        create(new Permissao("relatorio", "Relatórios", true), null);

        /*
         * Cartografia
         */
//        create(new Permissao("cartografia", "Cartografia", true), "cadastrobasico");

        /*
         * Controle de Acesso
         */
        create(new Permissao("controleAcesso", "Controle de Acesso", true), "administracaoSistema");

        /*
         * Permissão campos
         */
        create(new Permissao("campos", "Campos", false), null);
        create(new Permissao("campos.Opm", "Campo Opm"), "campos");
        create(new Permissao("campos.atendente", "Permissão Atendente"), "campos");
        create(new Permissao("campos.despachador", "Permissão Despachador"), "campos");
        create(new Permissao("campos.supervisao", "Permissão Supervisão"), "campos");

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

        //OPC
        create(new Permissao("op", "Organizações", true), "cadastrobasico");

        //Territorio
        create(new Permissao("territorio", "Território", true), "cadastrobasico");
        create(new Permissao("territorio.create", "Cadastro de Território", "/view/cadastro/territorio/createTerritorio.jsf", false), "territorio");
        create(new Permissao("territorio.list", "Territórios", "/view/cadastro/territorio/listTerritorio.jsf", true), "territorio");
        create(new Permissao("territorio.audit", "Auditoria de Território"), "territorio");
        create(new Permissao("territorio.delete", "Exclusão de Território"), "territorio");

        //Poligono
        create(new Permissao("poligono", "Polígono", false), "territorio");
        create(new Permissao("poligono.create", "Cadastro de Polígono", "/view/cadastro/poligono/createPoligono.jsf", false), "poligono");
        create(new Permissao("poligono.list", "Polígonos", "/view/cadastro/poligono/listPoligono.jsf", true), "territorio");
        create(new Permissao("poligono.audit", "Auditoria de Polígono"), "poligono");
        create(new Permissao("poligono.delete", "Exclusão de Polígono"), "poligono");

//OPM
        create(new Permissao("oPM", "Polícia Militar", false), "op");
        create(new Permissao("oPM.create", "Cadastro de Polícia Militar", "/view/cadastro/oPM/createOPM.jsf", false), "oPM");
        create(new Permissao("oPM.list", "Polícia Militar", "/view/cadastro/oPM/listOPM.jsf", true), "op");
        create(new Permissao("oPM.audit", "Auditoria de Polícia Militar"), "oPM");
        create(new Permissao("oPM.delete", "Exclusão de Polícia Militar"), "oPM");

        //OPC
        create(new Permissao("oPC", "Polícia Civil", false), "op");
        create(new Permissao("oPC.create", "Cadastro de Polícia Civil", "/view/cadastro/oPC/createOPC.jsf", false), "oPC");
        create(new Permissao("oPC.list", "Polícia Civil", "/view/cadastro/oPC/listOPC.jsf", true), "op");
        create(new Permissao("oPC.audit", "Auditoria de Polícia Civil"), "oPC");
        create(new Permissao("oPC.delete", "Exclusão de Polícia Civil"), "oPC");

        //Bombeiro
        create(new Permissao("bombeiro", "Bombeiro", false), "op");
        create(new Permissao("bombeiro.create", "Cadastro de Bombeiro", "/view/cadastro/bombeiro/createBombeiro.jsf", false), "bombeiro");
        create(new Permissao("bombeiro.list", "Bombeiro", "/view/cadastro/bombeiro/listBombeiro.jsf", true), "op");
        create(new Permissao("bombeiro.audit", "Auditoria de Bombeiro"), "bombeiro");
        create(new Permissao("bombeiro.delete", "Exclusão de Bombeiro"), "bombeiro");

//Samu
        create(new Permissao("samu", "Samu", false), "op");
        create(new Permissao("samu.create", "Cadastro de Samu", "/view/cadastro/samu/createSamu.jsf", false), "samu");
        create(new Permissao("samu.list", "Samu", "/view/cadastro/samu/listSamu.jsf", true), "op");
        create(new Permissao("samu.audit", "Auditoria de Samu"), "samu");
        create(new Permissao("samu.delete", "Exclusão de Samu"), "samu");

//Transito
        create(new Permissao("transito", "Trânsito", false), "op");
        create(new Permissao("transito.create", "Cadastro de Transito", "/view/cadastro/transito/createTransito.jsf", false), "transito");
        create(new Permissao("transito.list", "Trânsito", "/view/cadastro/transito/listTransito.jsf", true), "op");
        create(new Permissao("transito.audit", "Auditoria de Transito"), "transito");
        create(new Permissao("transito.delete", "Exclusão de Transito"), "transito");

        //Guarda Municipal
        create(new Permissao("guardaMunicipal", "Guarda Municipal", false), "op");
        create(new Permissao("guardaMunicipal.create", "Cadastro de Guarda Municipal", "/view/cadastro/guardaMunicipal/createGuardaMunicipal.jsf", false), "guardaMunicipal");
        create(new Permissao("guardaMunicipal.list", "Guarda Municipal", "/view/cadastro/guardaMunicipal/listGuardaMunicipal.jsf", true), "op");
        create(new Permissao("guardaMunicipal.audit", "Auditoria de Guarda Municipal"), "guardaMunicipal");
        create(new Permissao("guardaMunicipal.delete", "Exclusão de Guarda Municipal"), "guardaMunicipal");

//Policia Federal
        create(new Permissao("policiaFederal", "Policia Federal", false), "op");
        create(new Permissao("policiaFederal.create", "Cadastro de Policia Federal", "/view/cadastro/policiaFederal/createPoliciaFederal.jsf", false), "policiaFederal");
        create(new Permissao("policiaFederal.list", "Policia Federal", "/view/cadastro/policiaFederal/listPoliciaFederal.jsf", true), "op");
        create(new Permissao("policiaFederal.audit", "Auditoria de Policia Federal"), "policiaFederal");
        create(new Permissao("policiaFederal.delete", "Exclusão de Policia Federal"), "policiaFederal");

//Policia Rodoviaria Federal
        create(new Permissao("policiaRodoviariaFederal", "Policia Rodoviaria Federal", false), "op");
        create(new Permissao("policiaRodoviariaFederal.create", "Cadastro de Policia Rodoviaria Federal", "/view/cadastro/policiaRodoviariaFederal/createPoliciaRodoviariaFederal.jsf", false), "policiaRodoviariaFederal");
        create(new Permissao("policiaRodoviariaFederal.list", "Policia Rodoviaria Federal", "/view/cadastro/policiaRodoviariaFederal/listPoliciaRodoviariaFederal.jsf", true), "op");
        create(new Permissao("policiaRodoviariaFederal.audit", "Auditoria de Policia Rodoviaria Federal"), "policiaRodoviariaFederal");
        create(new Permissao("policiaRodoviariaFederal.delete", "Exclusão de Policia Rodoviaria Federal"), "policiaRodoviariaFederal");

        create(new Permissao("auxiliares", "Tabelas Auxiliares", true), "cadastrobasico");

        //Orgao Recebedor
        create(new Permissao("orgaoRecebedor", "Orgao Recebedor", false), "auxiliares");
        create(new Permissao("orgaoRecebedor.create", "Cadastro de Orgao Recebedor", "/view/cadastro/orgaoRecebedor/createOrgaoRecebedor.jsf", false), "orgaoRecebedor");
        create(new Permissao("orgaoRecebedor.list", "Órgãos Recebedores", "/view/cadastro/orgaoRecebedor/listOrgaoRecebedor.jsf", true), "auxiliares");
        create(new Permissao("orgaoRecebedor.audit", "Auditoria de Orgao Recebedor"), "orgaoRecebedor");
        create(new Permissao("orgaoRecebedor.delete", "Exclusão de Orgao Recebedor"), "orgaoRecebedor");

        //Natureza Ocorrencia
        create(new Permissao("naturezaOcorrencia", "Natureza Ocorrência", false), "auxiliares");
        create(new Permissao("naturezaOcorrencia.create", "Cadastro de Natureza Ocorrência", "/view/cadastro/naturezaOcorrencia/createNaturezaOcorrencia.jsf", false), "naturezaOcorrencia");
        create(new Permissao("naturezaOcorrencia.list", "Naturezas da Ocorrência", "/view/cadastro/naturezaOcorrencia/listNaturezaOcorrencia.jsf", true), "auxiliares");
        create(new Permissao("naturezaOcorrencia.audit", "Auditoria de Natureza Ocorrência"), "naturezaOcorrencia");
        create(new Permissao("naturezaOcorrencia.delete", "Exclusão de Natureza Ocorrência"), "naturezaOcorrencia");

        //Operacao
        create(new Permissao("operacao", "Operação", false), "auxiliares");
        create(new Permissao("operacao.create", "Cadastro de Operação", "/view/cadastro/operacao/createOperacao.jsf", false), "operacao");
        create(new Permissao("operacao.list", "Operações", "/view/cadastro/operacao/listOperacao.jsf", false), "auxiliares");
        create(new Permissao("operacao.audit", "Auditoria de Operação"), "operacao");
        create(new Permissao("operacao.delete", "Exclusão de Operação"), "operacao");

        //Status Viatura
        create(new Permissao("viaturas", "Viaturas", false), "auxiliares");

        //Status Viatura
        create(new Permissao("statusViatura", "Status Viatura", false), "viaturas");
        create(new Permissao("statusViatura.create", "Cadastro de Status Viatura", "/view/cadastro/statusViatura/createStatusViatura.jsf", false), "statusViatura");
        create(new Permissao("statusViatura.list", "Status", "/view/cadastro/statusViatura/listStatusViatura.jsf", false), "viaturas");
        create(new Permissao("statusViatura.audit", "Auditoria de Status Viatura"), "statusViatura");
        create(new Permissao("statusViatura.delete", "Exclusão de Status Viatura"), "statusViatura");

        //Viatura
        create(new Permissao("viatura", "Viatura", false), "auxiliares");
        create(new Permissao("viatura.create", "Cadastro de Viatura", "/view/cadastro/viatura/createViatura.jsf", false), "viatura");
        create(new Permissao("viatura.list", "Viaturas", "/view/cadastro/viatura/listViatura.jsf", true), "auxiliares");
        create(new Permissao("viatura.audit", "Auditoria de Viatura"), "viatura");
        create(new Permissao("viatura.delete", "Exclusão de Viatura"), "viatura");

        //Patrulha
        create(new Permissao("patrulha", "Guarnição", false), "cadastrobasico");
        create(new Permissao("patrulha.create", "Cadastro de Guarnição", "/view/cadastro/patrulha/createPatrulha.jsf", false), "patrulha");
        create(new Permissao("patrulha.list", "Guarnições", "/view/cadastro/patrulha/listPatrulha.jsf", true), "cadastrobasico");
        create(new Permissao("patrulha.audit", "Auditoria de Guarnição"), "patrulha");
        create(new Permissao("patrulha.delete", "Exclusão de Guarnição"), "patrulha");

        //Viatura
        create(new Permissao("drogaOcorrencia", "Droga", false), "auxiliares");
        create(new Permissao("drogaOcorrencia.create", "Cadastro de Droga", "/view/cadastro/drogaOcorrencia/createDrogaOcorrencia.jsf", false), "drogaOcorrencia");
        create(new Permissao("drogaOcorrencia.list", "Drogas", "/view/cadastro/drogaOcorrencia/listDrogaOcorrencia.jsf", true), "auxiliares");
        create(new Permissao("drogaOcorrencia.audit", "Auditoria de Droga"), "drogaOcorrencia");
        create(new Permissao("drogaOcorrencia.delete", "Exclusão de Droga"), "drogaOcorrencia");

        //Veiculos
        create(new Permissao("veiculos", "Veiculos", true), "auxiliares");

        //Marca Veiculo
        create(new Permissao("marcaVeiculo", "Marca Veiculo", false), "veiculos");
        create(new Permissao("marcaVeiculo.create", "Cadastro de Marca Veiculo", "/view/cadastro/marcaVeiculo/createMarcaVeiculo.jsf", false), "marcaVeiculo");
        create(new Permissao("marcaVeiculo.list", "Marcas", "/view/cadastro/marcaVeiculo/listMarcaVeiculo.jsf", true), "veiculos");
        create(new Permissao("marcaVeiculo.audit", "Auditoria de Marca Veiculo"), "marcaVeiculo");
        create(new Permissao("marcaVeiculo.delete", "Exclusão de Marca Veiculo"), "marcaVeiculo");

        //Modelo Veiculo
        create(new Permissao("modeloVeiculo", "Modelo Veiculo", false), "veiculos");
        create(new Permissao("modeloVeiculo.create", "Cadastro de Modelo Veiculo", "/view/cadastro/modeloVeiculo/createModeloVeiculo.jsf", false), "modeloVeiculo");
        create(new Permissao("modeloVeiculo.list", "Modelos", "/view/cadastro/modeloVeiculo/listModeloVeiculo.jsf", true), "veiculos");
        create(new Permissao("modeloVeiculo.audit", "Auditoria de Modelo Veiculo"), "modeloVeiculo");
        create(new Permissao("modeloVeiculo.delete", "Exclusão de Modelo Veiculo"), "modeloVeiculo");

        //Arma
        create(new Permissao("armas", "Armas", true), "auxiliares");

        //Marca De Arma
        create(new Permissao("marcaDeArma", "Marca de Arma", false), "armas");
        create(new Permissao("marcaDeArma.create", "Cadastro de Marca De Arma", "/view/cadastro/marcaDeArma/createMarcaDeArma.jsf", false), "marcaDeArma");
        create(new Permissao("marcaDeArma.list", "Marcas", "/view/cadastro/marcaDeArma/listMarcaDeArma.jsf", true), "armas");
        create(new Permissao("marcaDeArma.audit", "Auditoria de Marca De Arma"), "marcaDeArma");
        create(new Permissao("marcaDeArma.delete", "Exclusão de Marca De Arma"), "marcaDeArma");

        //Local Intermediario
        create(new Permissao("localIntermediario", "Local Intermediario", false), "auxiliares");
        create(new Permissao("localIntermediario.create", "Cadastro de Local Intermediario", "/view/cadastro/localIntermediario/createLocalIntermediario.jsf", false), "localIntermediario");
        create(new Permissao("localIntermediario.list", "Locais Intermediários", "/view/cadastro/localIntermediario/listLocalIntermediario.jsf", true), "auxiliares");
        create(new Permissao("localIntermediario.audit", "Auditoria de Local Intermediario"), "localIntermediario");
        create(new Permissao("localIntermediario.delete", "Exclusão de Local Intermediario"), "localIntermediario");

        //Parametro Sistema
        create(new Permissao("parametroSistema", "Parametro Sistema", false), "auxiliares");
        create(new Permissao("parametroSistema.create", "Cadastro de Parametro Sistema", "/view/cadastro/parametroSistema/createParametroSistema.jsf", false), "parametroSistema");
        create(new Permissao("parametroSistema.list", "Parametros Sistema", "/view/cadastro/parametroSistema/listParametroSistema.jsf", true), "auxiliares");
        create(new Permissao("parametroSistema.audit", "Auditoria de Parametro Sistema"), "parametroSistema");
        create(new Permissao("parametroSistema.delete", "Exclusão de Parametro Sistema"), "parametroSistema");

        //Ocorrencia
        create(new Permissao("ocorrencia", "Ocorrência", false), "ocorrencia");
        create(new Permissao("ocorrencia.create", "Cadastro de Ocorrência", "/view/ocorrencia/ocorrencia/createOcorrencia.jsf", false), "ocorrencia");
        create(new Permissao("ocorrencia.atendimento", "Atendimento", "/view/ocorrencia/ocorrencia/atendimentoOcorrencia.jsf", true), "ocorrencia");
        create(new Permissao("ocorrencia.despacho", "Rádio Operador", "/view/ocorrencia/ocorrencia/despachoOcorrencia.jsf", true), "ocorrencia");
        create(new Permissao("ocorrencia.audit", "Auditoria de Ocorrência"), "ocorrencia");
        create(new Permissao("ocorrencia.delete", "Exclusão de Ocorrência"), "ocorrencia");
        create(new Permissao("ocorrencia.createDespacho", "Cadastro de Ocorrência Despacho"), "ocorrencia");
        create(new Permissao("ocorrencia.crieateAtendente", "Cadastro de Ocorrência Atendente"), "ocorrencia");

        //Grupo Resultado Ocorrencia
        create(new Permissao("grupoResultadoOcorrencia", "Grupo Resultado Ocorrência", false), "auxiliares");
        create(new Permissao("grupoResultadoOcorrencia.create", "Cadastro de Grupo Resultado Ocorrência", "/view/cadastro/grupoResultadoOcorrencia/createGrupoResultadoOcorrencia.jsf", false), "grupoResultadoOcorrencia");
        create(new Permissao("grupoResultadoOcorrencia.list", "Grupos de Resultados", "/view/cadastro/grupoResultadoOcorrencia/listGrupoResultadoOcorrencia.jsf", true), "auxiliares");
        create(new Permissao("grupoResultadoOcorrencia.audit", "Auditoria de Grupo Resultado Ocorrência"), "grupoResultadoOcorrencia");
        create(new Permissao("grupoResultadoOcorrencia.delete", "Exclusão de Grupo Resultado Ocorrência"), "grupoResultadoOcorrencia");

        //Resultado Ocorrencia
        create(new Permissao("resultadoOcorrencia", "Resultado Ocorrência", false), "auxiliares");
        create(new Permissao("resultadoOcorrencia.create", "Cadastro de Resultado Ocorrência", "/view/cadastro/resultadoOcorrencia/createResultadoOcorrencia.jsf", false), "resultadoOcorrencia");
        create(new Permissao("resultadoOcorrencia.list", "Resultados Ocorrências", "/view/cadastro/resultadoOcorrencia/listResultadoOcorrencia.jsf", true), "auxiliares");
        create(new Permissao("resultadoOcorrencia.audit", "Auditoria de Resultado Ocorrência"), "resultadoOcorrencia");
        create(new Permissao("resultadoOcorrencia.delete", "Exclusão de Resultado Ocorrência"), "resultadoOcorrencia");

        //Consultas
        create(new Permissao("consultas", "Consultas", true), "ocorrencia");

        create(new Permissao("ocorrencia.list", "Ocorrências", "/view/ocorrencia/ocorrencia/listOcorrencia.jsf", true), "consultas");

        create(new Permissao("consultas.veiculos", "Veiculos", "/view/ocorrencia/consultas/listVeiculo.jsf", true), "consultas");
        create(new Permissao("consultas.pessoas", "Pessoas Envolvidas", "/view/ocorrencia/consultas/listPessoaEnvolvida.jsf", true), "consultas");
        create(new Permissao("consultas.armas", "Armas", "/view/ocorrencia/consultas/listArma.jsf", true), "consultas");

        create(new Permissao("relatorio.opm", "Relatório Por OPM", "/view/ocorrencia/relatorios/ocorrenciaPorOpm.jsf", true), "relatorio");
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
