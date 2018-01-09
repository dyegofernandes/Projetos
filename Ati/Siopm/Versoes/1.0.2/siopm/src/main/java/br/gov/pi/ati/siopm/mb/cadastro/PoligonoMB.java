package br.gov.pi.ati.siopm.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.PoligonoBO;
import br.gov.pi.ati.siopm.modelo.cadastro.Poligono;
import br.gov.pi.ati.siopm.modelo.cadastro.Ponto;
import br.gov.pi.ati.siopm.util.GeometryUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Polygon;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class PoligonoMB extends AbstractBaseBean<Poligono> implements Serializable {

    @EJB
    private PoligonoBO poligonoBO;

    private List<Ponto> pontos;

    private MapModel polygonModel;

    private String latLong = "-5.0920108,-42.8037597";

    private String zoom = "12";

    @Override
    public PoligonoBO getBO() {
        return poligonoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "tipo, nome";
    }

    @Override
    public void init() {
        pontos = new ArrayList<Ponto>();

        polygonModel = new DefaultMapModel();

        if (getEntity().getId() != null) {
            carregarPontosPoligono(getEntity());
        }
    }

    @Override
    public void save() {
        getEntity().setPontos(pontos);
        super.save();
    }

    public void carregarPontosPoligono(Poligono poligono) {
        pontos = getBO().getDAO().getInitialized(poligono.getPontos());

        Polygon polygon = new Polygon();
        polygon.setStrokeColor("#FF9900");
        polygon.setFillColor("#FF9900");
        polygon.setStrokeOpacity(0.7);
        polygon.setFillOpacity(0.7);
        int size = pontos.size();
        double[] x = new double[size];
        double[] y = new double[size];
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                x[i] = pontos.get(i).getLatitude();
                y[i] = pontos.get(i).getLongitude();
                LatLng coord = new LatLng(x[i], y[i]);
                polygon.getPaths().add(coord);

            }
            double[] centroPoligono = GeometryUtils.computePolygonCentroid(x, y);
            latLong = centroPoligono[0] + "," + centroPoligono[1];
            zoom = "10";
            polygonModel.addOverlay(polygon);
        }
    }

    public void upload(FileUploadEvent event) throws FileNotFoundException, IOException {
        UploadedFile uploadedFile = event.getFile();
        pontos = parsingFileKmlForString(uploadedFile.getInputstream());

        polygonModel = new DefaultMapModel();

        int size = pontos.size();

        if (size > 0) {
            double[] x = new double[size];
            double[] y = new double[size];

            Polygon polygon = new Polygon();
            polygon.setStrokeColor("#FF9900");
            polygon.setFillColor("#FF9900");
            polygon.setStrokeOpacity(0.7);
            polygon.setFillOpacity(0.7);
            for (int i = 0; i < size; i++) {
                x[i] = pontos.get(i).getLatitude();
                y[i] = pontos.get(i).getLongitude();
                LatLng coord = new LatLng(x[i], y[i]);
                polygon.getPaths().add(coord);

            }
            double[] centroPoligono = GeometryUtils.computePolygonCentroid(x, y);
            latLong = centroPoligono[0] + "," + centroPoligono[1];
            zoom = "10";
            polygonModel.addOverlay(polygon);

        }

    }

    private List<Ponto> parsingFileKmlForString(InputStream inputFile) {

        List<Ponto> pontosTemp = new ArrayList<Ponto>();
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList placemarks = doc.getElementsByTagName("Placemark");

            for (int temp = 0; temp < placemarks.getLength(); temp++) {
                Node placemark = placemarks.item(temp);
                if (placemark.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) placemark;
                    getEntity().setNome(eElement.getElementsByTagName("name").item(0).getTextContent());

                    Element polygon = (Element) eElement.getElementsByTagName("LineString").item(0);

                    Element coordinates = (Element) polygon.getElementsByTagName("coordinates").item(0);

                    String[] coordenadas = coordinates.getTextContent().replace(" ", "").replace("  ", "").replace("   ", "").replace("    ", "").split(Pattern.quote("\n"));

                    for (String coordenada : coordenadas) {
                        if (!coordenada.equals("")) {
                            String[] ltdLng = coordenada.split(Pattern.quote(","));
                            if (ltdLng.length > 2) {
                                Ponto ponto = new Ponto(new Double(ltdLng[1].replace(" ", "")), new Double(ltdLng[0].replace(" ", "")));
                                pontosTemp.add(ponto);
                            }
                        }
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pontosTemp;
    }

    public List<Ponto> getPontos() {
        return pontos;
    }

    public void setPontos(List<Ponto> pontos) {
        this.pontos = pontos;
    }

    public MapModel getPolygonModel() {
        return polygonModel;
    }

    public void setPolygonModel(MapModel polygonModel) {
        this.polygonModel = polygonModel;
    }

    public String getLatLong() {
        return latLong;
    }

    public void setLatLong(String latLong) {
        this.latLong = latLong;
    }

    public String getZoom() {
        return zoom;
    }

    public void setZoom(String zoom) {
        this.zoom = zoom;
    }

}
