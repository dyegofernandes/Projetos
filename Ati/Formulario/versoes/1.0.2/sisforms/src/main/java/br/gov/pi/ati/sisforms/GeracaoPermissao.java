package br.gov.pi.ati.sisforms;

import br.gov.pi.ati.sisforms.dao.controleacesso.PermissaoDAO;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Permissao;
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
         * cadastro básicos
         */
        create(new Permissao("cadastro", "Cadastro", true), null);

        /**
         * cadastro básicos
         */
        create(new Permissao("monitoramento", "Monitoramento", true), null);

        create(new Permissao("monitoramento.noc", "NOC", true), "monitoramento");

        /**
         * Formulários
         */
        create(new Permissao("formularios", "Formulários", true), null);

        create(new Permissao("campos", "Campos", false), null);
        create(new Permissao("campos.usuario", "Filtro/Coluna usuario"), "campos");
        create(new Permissao("campos.orgao", "Filtro/Coluna orgao"), "campos");


        /*
         * Controle de Acesso
         */
        create(new Permissao("controleAcesso", "Controle de Acesso", true), "administracaoSistema");

        create(new Permissao("campos", "Campos", false), null);
        create(new Permissao("campos.situacao", "Campo Situação"), "campos");
        create(new Permissao("campos.fieldAcessoInfoFolha", "Field AcessoInfo Folha"), "campos");
        create(new Permissao("campos.fieldAcessoSFP", "Field Acesso SFP Info Folha"), "campos");

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

        //Submenus de Formulário
        create(new Permissao("formularios.formularios", "Diversos", true), "formularios");
        create(new Permissao("formularios.requerimentos", "Requerimentos", true), "formularios");
        create(new Permissao("formularios.relatorios", "Relatórios", true), "formularios");
        create(new Permissao("formularios.Solicitações", "Solicitações", true), "formularios");
        create(new Permissao("formularios.lgbt", "LGBT", true), "formularios");

        //Requerimento
        create(new Permissao("requerimento", "Diversos", false), "formularios.requerimentos");
        create(new Permissao("requerimento.create", "Cadastro de Requerimento", "/view/formulario/requerimento/createRequerimento.jsf", false), "requerimento");
        create(new Permissao("requerimento.list", "Diversos", "/view/formulario/requerimento/listRequerimento.jsf", true), "formularios.requerimentos");
        create(new Permissao("requerimento.audit", "Auditoria de Requerimento"), "requerimento");
        create(new Permissao("requerimento.delete", "Exclusão de Requerimento"), "requerimento");

        //Form Acesso Conteudo
        create(new Permissao("formAcessoConteudo", "Liberação de Acesso", false), "formularios.formularios");
        create(new Permissao("formAcessoConteudo.create", "Cadastro de Liberação de Acesso a Sites na Internet", "/view/formulario/formAcessoConteudo/createFormAcessoConteudo.jsf", false), "formAcessoConteudo");
        create(new Permissao("formAcessoConteudo.list", "Liberações de Acessos a Sites", "/view/formulario/formAcessoConteudo/listFormAcessoConteudo.jsf", true), "formularios.formularios");
        create(new Permissao("formAcessoConteudo.audit", "Auditoria de Liberação de Acesso a Sites na Internet"), "formAcessoConteudo");
        create(new Permissao("formAcessoConteudo.delete", "Exclusão de Liberação de Acesso a Sites na Internet"), "formAcessoConteudo");

//Form Criacao Email
        create(new Permissao("formCriacaoEmail", "Criação de Email", false), "formularios.formularios");
        create(new Permissao("formCriacaoEmail.create", "Cadastro de Form Criacao Email", "/view/formulario/formCriacaoEmail/createFormCriacaoEmail.jsf", false), "formCriacaoEmail");
        create(new Permissao("formCriacaoEmail.list", "Criacão de Email", "/view/formulario/formCriacaoEmail/listFormCriacaoEmail.jsf", true), "formularios.formularios");
        create(new Permissao("formCriacaoEmail.audit", "Auditoria de Form Criacao Email"), "formCriacaoEmail");
        create(new Permissao("formCriacaoEmail.delete", "Exclusão de Form Criacao Email"), "formCriacaoEmail");

//Form Registro Dominio
        create(new Permissao("formRegistroDominio", "Registro de Domínio", false), "formularios.formularios");
        create(new Permissao("formRegistroDominio.create", "Cadastro de Form Registro Dominio", "/view/formulario/formRegistroDominio/createFormRegistroDominio.jsf", false), "formRegistroDominio");
        create(new Permissao("formRegistroDominio.list", "Registro de Dominio", "/view/formulario/formRegistroDominio/listFormRegistroDominio.jsf", true), "formularios.formularios");
        create(new Permissao("formRegistroDominio.audit", "Auditoria de Form Registro Dominio"), "formRegistroDominio");
        create(new Permissao("formRegistroDominio.delete", "Exclusão de Form Registro Dominio"), "formRegistroDominio");

//Form Selo Atitude Mulher
        create(new Permissao("formSeloAtitudeMulher", "Formulário Selo Atitude Mulher", false), "formularios.formularios");
        create(new Permissao("formSeloAtitudeMulher.create", "Cadastro de Formulário Selo Atitude Mulher", "/view/formulario/formSeloAtitudeMulher/createFormSeloAtitudeMulher.jsf", false), "formSeloAtitudeMulher");
        create(new Permissao("formSeloAtitudeMulher.list", "Selos Atitude Mulher", "/view/formulario/formSeloAtitudeMulher/listFormSeloAtitudeMulher.jsf", true), "formularios.formularios");
        create(new Permissao("formSeloAtitudeMulher.audit", "Auditoria de Form Selo Atitude Mulher"), "formSeloAtitudeMulher");
        create(new Permissao("formSeloAtitudeMulher.delete", "Exclusão de Formulário Selo Atitude Mulher"), "formSeloAtitudeMulher");

//Requisicao De Material
        create(new Permissao("requisicaoDeMaterial", "Requisicao De Material", false), "formularios.requerimentos");
        create(new Permissao("requisicaoDeMaterial.create", "Cadastro de Requisicao De Material", "/view/formulario/requisicaoDeMaterial/createRequisicaoDeMaterial.jsf", false), "requisicaoDeMaterial");
        create(new Permissao("requisicaoDeMaterial.list", "Materiais", "/view/formulario/requisicaoDeMaterial/listRequisicaoDeMaterial.jsf", true), "formularios.requerimentos");
        create(new Permissao("requisicaoDeMaterial.audit", "Auditoria de Requisicao De Material"), "requisicaoDeMaterial");
        create(new Permissao("requisicaoDeMaterial.delete", "Exclusão de Requisicao De Material"), "requisicaoDeMaterial");

        //Relatorio De Viagem
        create(new Permissao("relatorioDeViagem", "Relatorio De Viagem", false), "formularios.relatorios");
        create(new Permissao("relatorioDeViagem.create", "Cadastro de Relatorio De Viagem", "/view/formulario/relatorioDeViagem/createRelatorioDeViagem.jsf", false), "relatorioDeViagem");
        create(new Permissao("relatorioDeViagem.list", "Viagens", "/view/formulario/relatorioDeViagem/listRelatorioDeViagem.jsf", true), "formularios.relatorios");
        create(new Permissao("relatorioDeViagem.audit", "Auditoria de Relatorio De Viagem"), "relatorioDeViagem");
        create(new Permissao("relatorioDeViagem.delete", "Exclusão de Relatorio De Viagem"), "relatorioDeViagem");

        //Relatorio De Visita
        create(new Permissao("relatorioDeVisita", "Relatorio De Visita", false), "formularios.relatorios");
        create(new Permissao("relatorioDeVisita.create", "Cadastro de Relatorio De Visita", "/view/formulario/relatorioDeVisita/createRelatorioDeVisita.jsf", false), "relatorioDeVisita");
        create(new Permissao("relatorioDeVisita.list", "Visitas", "/view/formulario/relatorioDeVisita/listRelatorioDeVisita.jsf", true), "formularios.relatorios");
        create(new Permissao("relatorioDeVisita.audit", "Auditoria de Relatorio De Visita"), "relatorioDeVisita");
        create(new Permissao("relatorioDeVisita.delete", "Exclusão de Relatorio De Visita"), "relatorioDeVisita");

        //Ata De Reuniao
        create(new Permissao("ataDeReuniao", "Ata De Reuniao", false), "formularios.formularios");
        create(new Permissao("ataDeReuniao.create", "Cadastro de Ata De Reuniao", "/view/formulario/ataDeReuniao/createAtaDeReuniao.jsf", false), "ataDeReuniao");
        create(new Permissao("ataDeReuniao.list", "Atas De Reuniões", "/view/formulario/ataDeReuniao/listAtaDeReuniao.jsf", true), "formularios.formularios");
        create(new Permissao("ataDeReuniao.audit", "Auditoria de Ata De Reuniao"), "ataDeReuniao");
        create(new Permissao("ataDeReuniao.delete", "Exclusão de Ata De Reuniao"), "ataDeReuniao");

        //Orgao
        create(new Permissao("orgao", "Orgao", false), "cadastro");
        create(new Permissao("orgao.create", "Cadastro de Orgao", "/view/cadastro/orgao/createOrgao.jsf", false), "orgao");
        create(new Permissao("orgao.list", "Orgãos", "/view/cadastro/orgao/listOrgao.jsf", true), "cadastro");
        create(new Permissao("orgao.audit", "Auditoria de Orgao"), "orgao");
        create(new Permissao("orgao.delete", "Exclusão de Orgao"), "orgao");
        create(new Permissao("orgao.campo", "Campo de Orgao"), "orgao");
        create(new Permissao("orgao.coluna", "Coluna de Orgao"), "orgao");

        //Orgao Certificado
//        create(new Permissao("orgaoCertificado", "Orgao Certificado", false), "cadastro");
//        create(new Permissao("orgaoCertificado.create", "Cadastro de Orgao Certificado", "/view/cadastro/orgaoCertificado/createOrgaoCertificado.jsf", false), "orgaoCertificado");
//        create(new Permissao("orgaoCertificado.list", "Órgãos Certificados", "/view/cadastro/orgaoCertificado/listOrgaoCertificado.jsf", true), "cadastro");
//        create(new Permissao("orgaoCertificado.audit", "Auditoria de Orgao Certificado"), "orgaoCertificado");
//        create(new Permissao("orgaoCertificado.delete", "Exclusão de Orgao Certificado"), "orgaoCertificado");

        //Ponto Acesso
        create(new Permissao("pontoAcesso", "Ponto Acesso", false), "cadastro");
        create(new Permissao("pontoAcesso.create", "Cadastro de Ponto Acesso", "/view/cadastro/pontoAcesso/createPontoAcesso.jsf", false), "pontoAcesso");
        create(new Permissao("pontoAcesso.list", "Pontos Acesso", "/view/cadastro/pontoAcesso/listPontoAcesso.jsf", true), "cadastro");
        create(new Permissao("pontoAcesso.audit", "Auditoria de Ponto Acesso"), "pontoAcesso");
        create(new Permissao("pontoAcesso.delete", "Exclusão de Ponto Acesso"), "pontoAcesso");

        //Tipo Certificado
//        create(new Permissao("tipoCertificado", "Tipo Certificado", false), "cadastro");
//        create(new Permissao("tipoCertificado.create", "Cadastro de Tipo Certificado", "/view/cadastro/tipoCertificado/createTipoCertificado.jsf", false), "tipoCertificado");
//        create(new Permissao("tipoCertificado.list", "Tipos Certificados", "/view/cadastro/tipoCertificado/listTipoCertificado.jsf", true), "cadastro");
//        create(new Permissao("tipoCertificado.audit", "Auditoria de Tipo Certificado"), "tipoCertificado");
//        create(new Permissao("tipoCertificado.delete", "Exclusão de Tipo Certificado"), "tipoCertificado");

        //Arquivo Publico
        create(new Permissao("arquivoPublico", "Arquivo Publico", false), "cadastro");
        create(new Permissao("arquivoPublico.create", "Cadastro de Arquivo Publico", "/view/cadastro/arquivoPublico/createArquivoPublico.jsf", false), "arquivoPublico");
        create(new Permissao("arquivoPublico.list", "Arquivos Publicos", "/view/cadastro/arquivoPublico/listArquivoPublico.jsf", true), "cadastro");
        create(new Permissao("arquivoPublico.audit", "Auditoria de Arquivo Publico"), "arquivoPublico");
        create(new Permissao("arquivoPublico.delete", "Exclusão de Arquivo Publico"), "arquivoPublico");

        //Ficha De Visita Institucional LGBT
        create(new Permissao("fichaDeVisitaInstitucionalLGBT", "Ficha De Visita Institucional LGBT", false), "formularios.lgbt");
        create(new Permissao("fichaDeVisitaInstitucionalLGBT.create", "Cadastro de Ficha De Visita Institucional LGBT", "/view/formulario/fichaDeVisitaInstitucionalLGBT/createFichaDeVisitaInstitucionalLGBT.jsf", false), "fichaDeVisitaInstitucionalLGBT");
        create(new Permissao("fichaDeVisitaInstitucionalLGBT.list", "Fichas Visitas Institucionais", "/view/formulario/fichaDeVisitaInstitucionalLGBT/listFichaDeVisitaInstitucionalLGBT.jsf", true), "formularios.lgbt");
        create(new Permissao("fichaDeVisitaInstitucionalLGBT.audit", "Auditoria de Ficha De Visita Institucional LGBT"), "fichaDeVisitaInstitucionalLGBT");
        create(new Permissao("fichaDeVisitaInstitucionalLGBT.delete", "Exclusão de Ficha De Visita Institucional LGBT"), "fichaDeVisitaInstitucionalLGBT");

//Roteiro De Triagem Do Usuario LGBT
        create(new Permissao("roteiroDeTriagemDoUsuarioLGBT", "Roteiro De Triagem Do Usuario LGBT", false), "formularios.lgbt");
        create(new Permissao("roteiroDeTriagemDoUsuarioLGBT.create", "Cadastro de Roteiro De Triagem Do Usuario LGBT", "/view/formulario/roteiroDeTriagemDoUsuarioLGBT/createRoteiroDeTriagemDoUsuarioLGBT.jsf", false), "roteiroDeTriagemDoUsuarioLGBT");
        create(new Permissao("roteiroDeTriagemDoUsuarioLGBT.list", "Roteiros de Triagens", "/view/formulario/roteiroDeTriagemDoUsuarioLGBT/listRoteiroDeTriagemDoUsuarioLGBT.jsf", true), "formularios.lgbt");
        create(new Permissao("roteiroDeTriagemDoUsuarioLGBT.audit", "Auditoria de Roteiro De Triagem Do Usuario LGBT"), "roteiroDeTriagemDoUsuarioLGBT");
        create(new Permissao("roteiroDeTriagemDoUsuarioLGBT.delete", "Exclusão de Roteiro De Triagem Do Usuario LGBT"), "roteiroDeTriagemDoUsuarioLGBT");

        //Encaminhamento LGBT
        create(new Permissao("encaminhamentoLGBT", "Encaminhamento LGBT", false), "formularios.lgbt");
        create(new Permissao("encaminhamentoLGBT.create", "Cadastro de Encaminhamento LGBT", "/view/formulario/encaminhamentoLGBT/createEncaminhamentoLGBT.jsf", false), "encaminhamentoLGBT");
        create(new Permissao("encaminhamentoLGBT.list", "Encaminhamentos", "/view/formulario/encaminhamentoLGBT/listEncaminhamentoLGBT.jsf", true), "formularios.lgbt");
        create(new Permissao("encaminhamentoLGBT.audit", "Auditoria de Encaminhamento LGBT"), "encaminhamentoLGBT");
        create(new Permissao("encaminhamentoLGBT.delete", "Exclusão de Encaminhamento LGBT"), "encaminhamentoLGBT");

        //Formulario De Denuncia LGBT
        create(new Permissao("formularioDeDenunciaLGBT", "Formulario De Denuncia LGBT", false), "formularios.lgbt");
        create(new Permissao("formularioDeDenunciaLGBT.create", "Cadastro de Formulario De Denuncia LGBT", "/view/formulario/formularioDeDenunciaLGBT/createFormularioDeDenunciaLGBT.jsf", false), "formularioDeDenunciaLGBT");
        create(new Permissao("formularioDeDenunciaLGBT.list", "Formulários de Denúncias", "/view/formulario/formularioDeDenunciaLGBT/listFormularioDeDenunciaLGBT.jsf", true), "formularios.lgbt");
        create(new Permissao("formularioDeDenunciaLGBT.audit", "Auditoria de Formulario De Denuncia LGBT"), "formularioDeDenunciaLGBT");
        create(new Permissao("formularioDeDenunciaLGBT.delete", "Exclusão de Formulario De Denuncia LGBT"), "formularioDeDenunciaLGBT");

        //Ficha De Visita Domiciliar
        create(new Permissao("fichaDeVisitaDomiciliar", "Ficha De Visita Domiciliar", false), "formularios.lgbt");
        create(new Permissao("fichaDeVisitaDomiciliar.create", "Cadastro de Ficha De Visita Domiciliar", "/view/formulario/fichaDeVisitaDomiciliar/createFichaDeVisitaDomiciliar.jsf", false), "fichaDeVisitaDomiciliar");
        create(new Permissao("fichaDeVisitaDomiciliar.list", "Fichas De Visitas Domiciliares", "/view/formulario/fichaDeVisitaDomiciliar/listFichaDeVisitaDomiciliar.jsf", true), "formularios.lgbt");
        create(new Permissao("fichaDeVisitaDomiciliar.audit", "Auditoria de Ficha De Visita Domiciliar"), "fichaDeVisitaDomiciliar");
        create(new Permissao("fichaDeVisitaDomiciliar.delete", "Exclusão de Ficha De Visita Domiciliar"), "fichaDeVisitaDomiciliar");

        //Controle De Certificado
//        create(new Permissao("controleDeCertificado", "Controle De Certificado", false), "formularios.formularios");
//        create(new Permissao("controleDeCertificado.create", "Cadastro de Controle De Certificado", "/view/formulario/controleDeCertificado/createControleDeCertificado.jsf", false), "controleDeCertificado");
//        create(new Permissao("controleDeCertificado.list", "Certificados Emitidos", "/view/formulario/controleDeCertificado/listControleDeCertificado.jsf", true), "formularios.formularios");
//        create(new Permissao("controleDeCertificado.audit", "Auditoria de Controle De Certificado"), "controleDeCertificado");
//        create(new Permissao("controleDeCertificado.delete", "Exclusão de Controle De Certificado"), "controleDeCertificado");

        //Interrupcao Ponto Acesso
        create(new Permissao("interrupcaoPontoAcesso", "Interrupcao Ponto Acesso", false), "monitoramento.noc");
        create(new Permissao("interrupcaoPontoAcesso.create", "Cadastro de Interrupcao Ponto Acesso", "/view/monitoramento/interrupcaoPontoAcesso/createInterrupcaoPontoAcesso.jsf", false), "interrupcaoPontoAcesso");
        create(new Permissao("interrupcaoPontoAcesso.list", "Pontos de Acessos", "/view/monitoramento/interrupcaoPontoAcesso/listInterrupcaoPontoAcesso.jsf", true), "monitoramento.noc");
        create(new Permissao("interrupcaoPontoAcesso.audit", "Auditoria de Interrupcao Ponto Acesso"), "interrupcaoPontoAcesso");
        create(new Permissao("interrupcaoPontoAcesso.delete", "Exclusão de Interrupcao Ponto Acesso"), "interrupcaoPontoAcesso");

        //Local Reserva
        create(new Permissao("localReserva", "Local Reserva", false), "cadastro");
        create(new Permissao("localReserva.create", "Cadastro de Local Reserva", "/view/servicos/localReserva/createLocalReserva.jsf", false), "localReserva");
        create(new Permissao("localReserva.list", "Locais Reserva", "/view/servicos/localReserva/listLocalReserva.jsf", true), "cadastro");
        create(new Permissao("localReserva.audit", "Auditoria de Local Reserva"), "localReserva");
        create(new Permissao("localReserva.delete", "Exclusão de Local Reserva"), "localReserva");
        create(new Permissao("localReserva.orgao", "Filtro de Orgao"), "localReserva");
        
        
    //Reserva Local
        create(new Permissao("reservaLocal", "Reservas", true), "formularios");

        create(new Permissao("reservaLocal.create", "Cadastro de Reserva Local"), "reservaLocal");
        create(new Permissao("reservaLocal.reservar", "Agenda", "/view/servicos/reservaLocal/createReservaLocal.jsf", true), "reservaLocal");
       
        create(new Permissao("reservaLocal.list", "Reservas", "/view/servicos/reservaLocal/listReservaLocal.jsf", true), "reservaLocal");
        create(new Permissao("reservaLocal.audit", "Auditoria de Reserva Local"), "reservaLocal");
        create(new Permissao("reservaLocal.delete", "Exclusão de Reserva Local"), "reservaLocal");
        
        create(new Permissao("reservaLocal.orgao", "Campos de filtro"), "reservaLocal");
        
        //Termo
        create(new Permissao("termo", "Termo", false), "cadastro");
        create(new Permissao("termo.create", "Cadastro de Termo", "/view/cadastro/termo/createTermo.jsf", false), "termo");
        create(new Permissao("termo.list", "Termos", "/view/cadastro/termo/listTermo.jsf", true), "cadastro");
        create(new Permissao("termo.audit", "Auditoria de Termo"), "termo");
        create(new Permissao("termo.delete", "Exclusão de Termo"), "termo");

        //Solicitacao Acesso Sistema
        create(new Permissao("solicitacaoAcessoSistema", "Solicitacao Acesso Sistema", false), "formularios.Solicitações");
        create(new Permissao("solicitacaoAcessoSistema.create", "Cadastro de Solicitacao Acesso Sistema", "/view/servicos/solicitacaoAcessoSistema/createSolicitacaoAcessoSistema.jsf", false), "solicitacaoAcessoSistema");
        create(new Permissao("solicitacaoAcessoSistema.list", "Acesso a Sistemas", "/view/servicos/solicitacaoAcessoSistema/listSolicitacaoAcessoSistema.jsf", true), "formularios.Solicitações");
        create(new Permissao("solicitacaoAcessoSistema.audit", "Auditoria de Solicitacao Acesso Sistema"), "solicitacaoAcessoSistema");
        create(new Permissao("solicitacaoAcessoSistema.delete", "Exclusão de Solicitacao Acesso Sistema"), "solicitacaoAcessoSistema");

        //Solicitacao Acesso SFP
        create(new Permissao("solicitacaoAcessoSFP", "Solicitacao Acesso SFP", false), "formularios.Solicitações");
        create(new Permissao("solicitacaoAcessoSFP.create", "Cadastro de Solicitacao Acesso SFP", "/view/formulario/solicitacaoAcessoSFP/createSolicitacaoAcessoSFP.jsf", false), "solicitacaoAcessoSFP");
        create(new Permissao("solicitacaoAcessoSFP.list", "Acesso SFP", "/view/formulario/solicitacaoAcessoSFP/listSolicitacaoAcessoSFP.jsf", false), "formularios.Solicitações");
        create(new Permissao("solicitacaoAcessoSFP.audit", "Auditoria de Solicitacao Acesso SFP"), "solicitacaoAcessoSFP");
        create(new Permissao("solicitacaoAcessoSFP.delete", "Exclusão de Solicitacao Acesso SFP"), "solicitacaoAcessoSFP");
        create(new Permissao("solicitacaoAcessoSFP.sead", "Acesso SEAD"), "solicitacaoAcessoSFP");

        //Solicitacao Acesso Info Folha
        create(new Permissao("solicitacaoAcessoInfoFolha", "Solicitacao Acesso Info Folha", false), "formularios.Solicitações");
        create(new Permissao("solicitacaoAcessoInfoFolha.create", "Cadastro de Solicitacao Acesso Info Folha", "/view/formulario/solicitacaoAcessoInfoFolha/createSolicitacaoAcessoInfoFolha.jsf", false), "solicitacaoAcessoInfoFolha");
        create(new Permissao("solicitacaoAcessoInfoFolha.list", "Acesso InfoFolha", "/view/formulario/solicitacaoAcessoInfoFolha/listSolicitacaoAcessoInfoFolha.jsf", false), "formularios.Solicitações");
        create(new Permissao("solicitacaoAcessoInfoFolha.audit", "Auditoria de Solicitacao Acesso Info Folha"), "solicitacaoAcessoInfoFolha");
        create(new Permissao("solicitacaoAcessoInfoFolha.delete", "Exclusão de Solicitacao Acesso Info Folha"), "solicitacaoAcessoInfoFolha");
        create(new Permissao("solicitacaoAcessoInfoFolha.sead", "Acesso SEAD"), "solicitacaoAcessoInfoFolha");

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
