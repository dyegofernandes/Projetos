/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poligono;

import br.com.poligonoProducao.Poligono;
import br.com.poligonoProducao.Ponto;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author KillerBeeTwo
 */
public class ReadKMZ {

    public static void main(String[] args) {
        String arquivo = "/Users/KillerBeeTwo/Downloads/2ªCIPM.kmz.kml.xml";
        File inputFile = new File(arquivo);
        List<Poligono> poligonos = parsingFileKmlForString(inputFile);

        for (Poligono poligono : poligonos) {
            System.out.println(poligono.getNome());

            for (Ponto ponto : poligono.getPontos()) {
                System.out.println(ponto.getLatitude() + "," + ponto.getLongitude());
            }
        }
    }

    public static List<Poligono> parsingFileKmlForString(File inputFile) {

        List<Poligono> poligonos = new ArrayList<Poligono>();
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
                        
            NodeList placemarks = doc.getElementsByTagName("Placemark");
            
            for (int temp = 0; temp < placemarks.getLength(); temp++) {
                Node placemark = placemarks.item(temp);
                if (placemark.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) placemark;
                    Poligono poligono = new Poligono();
                    poligono.setNome(eElement.getElementsByTagName("name").item(0).getTextContent());

                    Element polygon = (Element) eElement.getElementsByTagName("LineString").item(0);

                    Element coordinates = (Element) polygon.getElementsByTagName("coordinates").item(0);

                    String[] coordenadas = coordinates.getTextContent().replace(" ", "").split(Pattern.quote("\n"));

                    List<Ponto> pontos = new ArrayList<Ponto>();

                    for (String coordenada : coordenadas) {
                        if (!coordenada.equals("")) {
                            String[] ltdLng = coordenada.split(Pattern.quote(","));
                            Ponto ponto = new Ponto(new Double(ltdLng[0]), new Double(ltdLng[1]));
                            pontos.add(ponto);
                        }
                    }

                    poligono.setPontos(pontos);

                    poligonos.add(poligono);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return poligonos;
    }

}
