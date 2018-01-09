/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste.ws;
import javax.jws.WebService;

/**
 *
 * @author Juniel
 */
//Service Implementation
@WebService(endpointInterface = "com.teste.ws.Servidor")
public class ServidorImpl implements Servidor{

    @Override
    public String getServidorAtivoXml(String cpf) {
        return "Cpf: ".concat(cpf);
    }
    
}
