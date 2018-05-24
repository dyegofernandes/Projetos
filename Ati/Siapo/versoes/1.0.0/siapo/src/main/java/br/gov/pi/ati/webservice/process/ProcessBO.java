/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.webservice.process;

import br.gov.pi.ati.webservice.process.vos.ProcessVO;
import com.thoughtworks.xstream.XStream;

/**
 *
 * @author Juniel
 */
public class ProcessBO {

    public static String getDescricao(String numProcesso) {
        ServerWebservices servicorService = new ServerWebservices();
        ServerWebservicesPortType webservice = servicorService.getServerWebservicesPort();

        String xmlString = webservice.processo2Xml(numProcesso.replace(".", "").replace("/", ""));

        ProcessVO processo = new ProcessVO();

        XStream xstream = new XStream();

        xstream.alias("processo", ProcessVO.class);

        String xml = ("<?xml version=\"".concat("1.0\"").concat(" encoding=\"").concat("ISO-8859-1\"").concat("?>").concat("\n"));

        if (!xml.equals(xmlString)) {
            processo = (ProcessVO) xstream.fromXML(xmlString);
            return processo.getAssunto();
        }
        return null;
    }
}
