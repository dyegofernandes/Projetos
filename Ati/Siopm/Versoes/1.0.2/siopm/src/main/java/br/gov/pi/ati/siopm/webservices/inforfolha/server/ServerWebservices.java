
package br.gov.pi.ati.siopm.webservices.inforfolha.server;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "server.webservices", targetNamespace = "urn:server.webservices", wsdlLocation = "http://www.srh.pi.gov.br/sfp/webserver/serverWEB2.php?wsdl")
public class ServerWebservices
    extends Service
{

    private final static URL SERVERWEBSERVICES_WSDL_LOCATION;
    private final static WebServiceException SERVERWEBSERVICES_EXCEPTION;
    private final static QName SERVERWEBSERVICES_QNAME = new QName("urn:server.webservices", "server.webservices");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://www.srh.pi.gov.br/sfp/webserver/serverWEB2.php?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVERWEBSERVICES_WSDL_LOCATION = url;
        SERVERWEBSERVICES_EXCEPTION = e;
    }

    public ServerWebservices() {
        super(__getWsdlLocation(), SERVERWEBSERVICES_QNAME);
    }

    public ServerWebservices(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVERWEBSERVICES_QNAME, features);
    }

    public ServerWebservices(URL wsdlLocation) {
        super(wsdlLocation, SERVERWEBSERVICES_QNAME);
    }

    public ServerWebservices(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVERWEBSERVICES_QNAME, features);
    }

    public ServerWebservices(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServerWebservices(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ServerWebservicesPortType
     */
    @WebEndpoint(name = "server.webservicesPort")
    public ServerWebservicesPortType getServerWebservicesPort() {
        return super.getPort(new QName("urn:server.webservices", "server.webservicesPort"), ServerWebservicesPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServerWebservicesPortType
     */
    @WebEndpoint(name = "server.webservicesPort")
    public ServerWebservicesPortType getServerWebservicesPort(WebServiceFeature... features) {
        return super.getPort(new QName("urn:server.webservices", "server.webservicesPort"), ServerWebservicesPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVERWEBSERVICES_EXCEPTION!= null) {
            throw SERVERWEBSERVICES_EXCEPTION;
        }
        return SERVERWEBSERVICES_WSDL_LOCATION;
    }

}