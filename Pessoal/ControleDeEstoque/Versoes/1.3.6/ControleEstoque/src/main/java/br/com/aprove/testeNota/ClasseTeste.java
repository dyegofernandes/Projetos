/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprove.testeNota;

import com.fincatto.nfe310.classes.NFUnidadeFederativa;
import com.fincatto.nfe310.classes.statusservico.consulta.NFStatusServicoConsultaRetorno;
import com.fincatto.nfe310.webservices.WSFacade;
import java.io.IOException;

/**
 *
 * @author Juniel
 */
public class ClasseTeste {

    public static void main(String[] args) throws IOException, Exception {
        ConfiguracaoSefaz config = new ConfiguracaoSefaz(true);
        NFStatusServicoConsultaRetorno retorno = new WSFacade(config).consultaStatus(NFUnidadeFederativa.SC);
        System.out.println(retorno.getStatus());
        System.out.println(retorno.getMotivo());
    }

}
