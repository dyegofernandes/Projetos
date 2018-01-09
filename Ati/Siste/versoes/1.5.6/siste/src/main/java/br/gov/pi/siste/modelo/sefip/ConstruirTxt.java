/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.modelo.sefip;

import br.gov.pi.siste.modelo.cadastro.enums.Formato;
import br.gov.pi.siste.util.Utils;

/**
 *
 * @author Juniel
 */
public class ConstruirTxt {

    Utils util = new Utils();

    public String setRegistroTipo00(RegistroTipo00 registro) {
        String linha = "";

        linha = linha + util.inserirCaractere(registro.get01_tipoRegistro(), 2, Formato.NUM);
        linha = linha + util.inserirCaractere(registro.get02_branco(), 51, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get03_tipoRemessa(), 1, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get04_tipoInscricaoResp(), 1, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get05_inscricaoResp(), 14, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get06_nomeResp(), 30, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get07_nomePessContato(), 20, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get08_endereco(), 50, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get09_bairro(), 20, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get10_cep(), 8, Formato.NUM);
        linha = linha + util.inserirCaractere(registro.get11_cidade(), 20, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get12_unidadeFederacao(), 2, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get13_telefoneContato().replace(" ", ""), 12, Formato.NUM);
        linha = linha + util.inserirCaractere(registro.get14_endInternContato(), 60, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get15_competencia(), 6, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get16_codRecolhimento(), 3, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get17_indRecolhFGTS(), 1, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get18_modalidadeArquivo(), 1, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get19_dataRecolhFGTS(), 8, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get20_indRecolhPrevSocial(), 1, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get21_dataRecolhPrevSocial(), 8, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get22_indRecolhAtrasoPrevSocial(), 7, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get23_tipoInscFornFolhaPag(), 1, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get24_inscFornFolhaPag(), 14, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get25_branco(), 18, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get26_finalLinha(), 1, Formato.ALFA);

        return (linha + "\r\n");
    }

    public String setRegistroTipo10(RegistroTipo10 registro) {
        String linha = "";
        linha = linha + util.inserirCaractere(registro.get01_tipoRegistro(), 2, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get02_tipoInscricao_Empresa(), 1, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get03_inscricaoEmpresa(), 14, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get04_zeros(), 36, Formato.NUM);
        linha = linha + util.inserirCaractere(registro.get05_nomeEmpresa(), 40, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get06_logradouro(), 50, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get07_bairro(), 20, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get08_cep(), 8, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get09_cidade(), 20, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get10_unidadeFederacao(), 2, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get11_telefone().replace(" ", ""), 12, Formato.NUM);
        linha = linha + util.inserirCaractere(registro.get12_indAlterEndereco(), 1, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get13_cnae(), 7, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get14_indAlterCnae(), 1, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get15_aliquota_RAT(), 2, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get16_codigo_Centralizacao(), 1, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get17_simples(), 1, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get18_fpas(), 3, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get19_codOutrasEntidades(), 4, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get20_codigoPagGps(), 4, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get21_percInsenFilantropia(), 5, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get22_salarioFamilia(), 15, Formato.NUM);
        linha = linha + util.inserirCaractere(registro.get23_salarioMaternidade(), 15, Formato.NUM);
        linha = linha + util.inserirCaractere(registro.get24_contribDescEmpComp13(), 15, Formato.NUM);
        linha = linha + util.inserirCaractere(registro.get25_indValorNegatOuPosit(), 1, Formato.NUM);
        linha = linha + util.inserirCaractere(registro.get26_valorDevidPrevSocialComp13(), 14, Formato.NUM);
        linha = linha + util.inserirCaractere(registro.get27_banco(), 3, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get28_agencia(), 4, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get29_contaCorrente(), 9, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get30_zeros(), 45, Formato.NUM);
        linha = linha + util.inserirCaractere(registro.get31_brancos(), 4, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get32_finalLinha(), 1, Formato.ALFA);

        return (linha + "\r\n");
    }

    public String setRegistroTipo30(RegistroTipo30 registro) {
        String linha = "";
        linha = linha + util.inserirCaractere(registro.get01_tipoRegistro(), 2, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get02_tipoInscEmpresa(), 1, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get03_inscEmpresa(), 14, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get04_tipoInscTomadorObraConstCivil(), 1, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get05_inscInscTomadorObraConstCivil(), 14, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get06_pisPasepCI(), 11, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get07_dataAdmissao(), 8, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get08_categoriaTrabalhador(), 2, Formato.NUM);
        linha = linha + util.inserirCaractere(registro.get09_nomeTrabalhador(), 70, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get10_matriculaEmpregado(), 11, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get11_numeroCTPS(), 7, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get12_serieCTPS(), 5, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get13_dataOpcao(), 8, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get14_dataNascimento(), 8, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get15_cbo(), 5, Formato.NUM);
        linha = linha + util.inserirCaractere(registro.get16_remuneracaoSem13(), 15, Formato.NUM);
        linha = linha + util.inserirCaractere(registro.get17_remuneracao13(), 15, Formato.NUM);
        linha = linha + util.inserirCaractere(registro.get18_classeContribuicao(), 2, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get19_ocorrencia(), 2, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get20_valorDesconDoSegurado(), 15, Formato.NUM);
        linha = linha + util.inserirCaractere(registro.get21_remuneracaoBCalcContribPrevidenciaria(), 15, Formato.NUM);
        linha = linha + util.inserirCaractere(registro.get22_baseCalc13SalPrevSocialMov(), 15, Formato.NUM);
        linha = linha + util.inserirCaractere(registro.get23_BaseCalc13SalPrevSocialGPS(), 15, Formato.NUM);
        linha = linha + util.inserirCaractere(registro.get24_brancos(), 98, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get25_finalLinha(), 1, Formato.ALFA);

        return (linha + "\r\n");
    }

    public String setRegistroTipo90(RegistroTipo90 registro) {
        String linha = "";
        linha = linha + util.inserirCaractere(registro.get01_tipoRegistro(), 2, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get02_marcaFinalRegistro(), 51, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get03_brancos(), 306, Formato.ALFA);
        linha = linha + util.inserirCaractere(registro.get04_finalLinha(), 1, Formato.ALFA);

        return linha;
    }

}
