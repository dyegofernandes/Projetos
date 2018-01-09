/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste.client;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import webservices.server.ServerWebservices;
import webservices.server.ServerWebservicesPortType;

/**
 *
 * @author Juniel
 */
public class ServidorClient {

    public static void main(String[] args) throws Exception {
        ServerWebservices servicorService = new ServerWebservices();
        ServerWebservicesPortType servidor = servicorService.getServerWebservicesPort();
        
        System.out.println(servidor.servidorativoxml("10527923320"));
    }
}
