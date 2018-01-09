/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import webservices.server.ServerWebservices;
import webservices.server.ServerWebservicesPortType;
import webservices.server.ServidorVO;

/**
 *
 * @author Juniel
 */
public class Teste {

    public static void main(String[] args) throws MalformedURLException, IOException {

        ServerWebservices servicorService = new ServerWebservices();
        ServerWebservicesPortType servidor = servicorService.getServerWebservicesPort();

        String xmlString = servidor.servidorativoxml("10527923320");

        System.out.println(xmlString);

//        xstreamJason.alias("servidor", ServidorVO.class);
//        servidorVO = (ServidorVO) xstreamJason.fromXML(xmlString);
//
//        System.out.println(servidorVO.getNome());
    }

}
