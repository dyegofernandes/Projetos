/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sccd.webservices.inforfolha;

import br.gov.pi.ati.sccd.webservices.inforfolha.server.ServerWebservices;
import br.gov.pi.ati.sccd.webservices.inforfolha.server.ServerWebservicesPortType;
import com.thoughtworks.xstream.XStream;

/**
 *
 * @author JUniel
 */
public class Teste {

    public static void main(String[] args) {
        ServerWebservices servicorService = new ServerWebservices();
        ServerWebservicesPortType servidor = servicorService.getServerWebservicesPort();

        String xmlString = servidor.servidorativoxml("79234690320");
        
         ServidorVO servidorVO = new ServidorVO();
         
          XStream xstreamJason = new XStream();

        xstreamJason.alias("servidor", ServidorVO.class);
        
        String xml = ("<?xml version=\"".concat("1.0\"").concat(" encoding=\"").concat("ISO-8859-1\"").concat("?>").concat("\n"));
        if (!xml.equals(xmlString)) {
            servidorVO = (ServidorVO) xstreamJason.fromXML(xmlString);
            
            System.out.println(servidorVO.getNome());
        }else{
            System.out.println("Não é servidor ou comissionado do estado!!");
        }
    }
}
