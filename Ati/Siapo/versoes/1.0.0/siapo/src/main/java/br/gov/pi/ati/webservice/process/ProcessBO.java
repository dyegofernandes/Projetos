/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.webservice.process;

import br.gov.pi.ati.util.Utils;
import br.gov.pi.ati.webservice.process.vos.ProcessVO;
import com.thoughtworks.xstream.XStream;

/**
 *
 * @author Juniel
 */
public class ProcessBO {

    public static String getDescricao(String numProcesso) {

        if (!Utils.isNullOrEmpty(numProcesso)) {
            if (numProcesso.equals("__.___._.______/__")) {
                return null;
            } else {
                if (numProcesso.matches("^[a-zA-Z]{2}\\.\\d{3}\\.\\d\\.\\d{6}\\/\\d{2}$")) {
                    ServerWebservices servicorService = new ServerWebservices();
                    ServerWebservicesPortType webservice = servicorService.getServerWebservicesPort();

                    String xmlString = webservice.processo2Xml((numProcesso.replace(".", "").replace("/", "").toUpperCase()));

                    ProcessVO processo = new ProcessVO();

                    XStream xstream = new XStream();

                    xstream.alias("processo", ProcessVO.class);

                    String xml = ("<?xml version=\"".concat("1.0\"").concat(" encoding=\"").concat("ISO-8859-1\"").concat("?>").concat("\n"));

                    if (!xml.equals(xmlString)) {
//                        System.out.println(numProcesso);
//                        System.out.println(xmlString);
                        processo = (ProcessVO) xstream.fromXML(xmlString);
                        return processo.getAssunto();
                    }
                } else {
                    return null;
                }
            }
        } else {
            return null;
        }

        return null;
    }
}
