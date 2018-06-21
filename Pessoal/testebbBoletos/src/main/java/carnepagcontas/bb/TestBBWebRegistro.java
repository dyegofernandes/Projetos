package carnepagcontas.bb;

import carnepagcontas.bb.model.Requisicao;
import carnepagcontas.bb.model.Resposta;
import java.io.StringReader;
import java.math.BigDecimal;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import org.apache.axis.utils.ByteArrayOutputStream;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

public class TestBBWebRegistro {

    private static String getToken() {
        return "SggxR8LS5S0NgxuCC8VaFDyYWA4RAqGzmWnMSJJwdaRd5eJ0jbx1y_suTMxTrWDoHrUiamT7zDJKhaUqpWFnVQ.dtIIaP0iIO3BJEy-_L9dRdbXjGLtKqRsxmslHY4KgPZNbNQrzHiJk7OP7uuJzCEjEf7eZ21t-o9AJYWX5R7ynTBDUGcWy8WXOwiwkGYMivhs1o07XnXmT-viJqW1W2mvjzoxtkzcR_MqQlRAi93EtfOXeiTjCCQdWMIu5DKQxeOWpjPCGAfXFwg9gvNc8hFTXngGnh-C9fJrQNX3o6BYEdEB_9d9sV-hqRFdAGzq1RTTDivzTHanz8yBYxAo1AiIB5_oo9bM_EQ4IuJByJlpNyAEhbEcY-qCnwNRZWHoDJdcQBmdSe4S4cKmgfMBzPrCa2S2Lk6F0JFXK3VW3aE6bEvIim9meALsW5_Mclqx1lFz1fcfcyZFcwC5OPkP9BLJyCF4ggonmD-a92aopqG_cF9JVB0XGCUXscikTDazJuOacMnfzZY8eRlviVdteDcAkf5MLtx5nCxcP012BXG0gshJT7IY31Eccx1JMb377p405Y4oojLQqWDFmQIuGy2iCtoV3wnAFJ-ulfN676SgX3uTBvp7_FeSgn1STlREPXM9aypjPcNbiYu13Xa5L3usRBJqBsX-ViTLgaUBht6yCBhMp-EyEDcCfJy3oOMH1TViNhUpVdGgCduFi_LZksc3Y4XkB1kYlFt1payH23H2zg.e70RtHWBTSpQGFaKw5YNgpgPlVnDm8tM7ePXoGKUabJerAQBmhHdUsp9ByKtZzQkFC6kpJWsFAgwrFs51PRfQA";
    }

    public static void main(String[] args) throws Exception {

        Requisicao requisicao = new Requisicao();
        requisicao.setNumeroConvenio(2625444);
        requisicao.setNumeroCarteira(new Short("17"));
        requisicao.setNumeroVariacaoCarteira(new Short("19"));
        requisicao.setCodigoModalidadeTitulo(new Short("1"));
        requisicao.setDataEmissaoTitulo("16-05-2018");
        requisicao.setDataVencimentoTitulo("19-06-2018");
        requisicao.setValorOriginalTitulo(new BigDecimal("300"));
        requisicao.setCodigoTipoDesconto(new Short("1"));
        requisicao.setDataDescontoTitulo("16-05-2018");
        requisicao.setPercentualDescontoTitulo(BigDecimal.ZERO);
        requisicao.setValorDescontoTitulo(BigDecimal.TEN);
        requisicao.setValorAbatimentoTitulo(BigDecimal.ZERO);
        requisicao.setQuantidadeDiaProtesto(new Short("0"));
        requisicao.setCodigoTipoJuroMora(new Short("0"));
        requisicao.setPercentualJuroMoraTitulo(BigDecimal.ZERO);
        requisicao.setValorJuroMoraTitulo(BigDecimal.ZERO);
        requisicao.setCodigoTipoMulta(new Short("2"));
        requisicao.setDataMultaTitulo("20-06-2018");
        requisicao.setPercentualMultaTitulo(BigDecimal.TEN);
        requisicao.setValorMultaTitulo(BigDecimal.ZERO);
        requisicao.setCodigoAceiteTitulo("N");
        requisicao.setCodigoTipoTitulo(new Short("2"));
        requisicao.setTextoDescricaoTipoTitulo("DUPLICATA");
        requisicao.setIndicadorPermissaoRecebimentoParcial("N");
        requisicao.setTextoNumeroTituloBeneficiario("987654321987654");
        requisicao.setTextoCampoUtilizacaoBeneficiario("");
        requisicao.setCodigoTipoContaCaucao(new Short("1"));
        requisicao.setTextoNumeroTituloCliente("00026254440000000002"); // NossoNumero (sequencial)
        requisicao.setTextoMensagemBloquetoOcorrencia("Pagamento disponível até a data de Vencimento");
        requisicao.setCodigoTipoInscricaoPagador(new Short("1"));
        requisicao.setNumeroInscricaoPagador(Long.parseLong("92527938523"));
        requisicao.setNomePagador("MERCADO ANDREZA DE MACEDO");
        requisicao.setTextoEnderecoPagador("RUA SEM NOME");
        requisicao.setNumeroCepPagador(64000000);
        requisicao.setNomeMunicipioPagador("TERESINA");
        requisicao.setNomeBairroPagador("CENTRO");
        requisicao.setSiglaUfPagador("PI");
        requisicao.setTextoNumeroTelefonePagador("99999999");
//        requisicao.setCodigoTipoInscricaoAvalista(new Short("1")); // 1-CPF, 2-CNPJ
//        requisicao.setNumeroInscricaoAvalista(Long.parseLong("77447741590"));
//        requisicao.setNomeAvalistaTitulo("Joao da SIlva");
        requisicao.setCodigoChaveUsuario("1");
        requisicao.setCodigoTipoCanalSolicitacao(new Short("5"));

        JAXBContext envioContext = JAXBContext.newInstance(Requisicao.class);
        Marshaller marshaller = envioContext.createMarshaller();

        ByteArrayOutputStream envioBuffer = new ByteArrayOutputStream();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(requisicao, envioBuffer);
        String reqEnvioXML = new String(envioBuffer.toByteArray(), "utf-8");

//        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
//        marshaller.marshal(requisicao, document);
//        
//        SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();
//        soapMessage.addNamespaceDeclaration("sch", "http://www.tibco.com/schemas/bws_registro_cbr/Recursos/XSD/Schema.xsd");
//        soapMessage.getSOAPBody().addDocument(document);
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        soapMessage.writeTo(outputStream);
//        String output = new String(outputStream.toByteArray(), "utf-8");
//        
//        output = output.replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "");
//        output = output.replaceAll("SOAP-ENV", "soapenv");
//        System.out.println("output : " + output);
        reqEnvioXML = reqEnvioXML.replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "");
        reqEnvioXML = reqEnvioXML.replace("xmlns:sch=\"http://www.tibco.com/schemas/bws_registro_cbr/Recursos/XSD/Schema.xsd\"", "");

        String soap = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n"
                + "xmlns:sch=\"http://www.tibco.com/schemas/bws_registro_cbr/Recursos/XSD/Schema.xsd\">\n"
                + "<soapenv:Header/>\n"
                + "<soapenv:Body>";

        soap += reqEnvioXML;

        soap += "</soapenv:Body>\n"
                + "</soapenv:Envelope>";

        System.out.println("request: " + soap);

        HttpClientBuilder builder = HttpClientBuilder.create();
        builder.setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE);

        SSLContextBuilder contextBuilder = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
            public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                return true;
            }
        });

        builder.setSSLContext(contextBuilder.build());

        HttpClient client = builder.build();
        HttpPost request = new HttpPost("https://cobranca.homologa.bb.com.br:7101/registrarBoleto");
        request.setHeader(HttpHeaders.CONTENT_TYPE, "text/xml");
        request.setHeader("SOAPACTION", "registrarBoleto");
        request.setHeader("Authorization", "Bearer " + getToken());

        StringEntity entity = new StringEntity(soap, "utf-8");
        request.setEntity(entity);

        HttpResponse response = client.execute(request);

        // Getting the response body.
        String responseBody = EntityUtils.toString(response.getEntity());

//        
//        SSLSocketFactory sslsf = new SSLSocketFactory(new TrustStrategy() {
//
//            public boolean isTrusted(
//                    final X509Certificate[] chain, String authType) throws CertificateException {
//                // Oh, I am easy...
//                return true;
//            }
//
//        });
        System.out.println("response : " + response.getStatusLine());
        System.out.println("response : " + responseBody);

        XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource streamSource = new StreamSource(new StringReader(responseBody));
        XMLStreamReader xsr = xif.createXMLStreamReader(streamSource);

        JAXBContext jaxbContext = JAXBContext.newInstance(Resposta.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        
        JAXBElement<Resposta> je = unmarshaller.unmarshal(xsr,
                Resposta.class);

//        Resposta resposta = (Resposta) unmarshaller.unmarshal(xsr);
        System.out.println("Last Name:- " + je.getValue().getCodigoRetornoPrograma());

//        RegistroCobrancaServiceServiceagentLocator locator = new RegistroCobrancaServiceServiceagentLocator();
//        System.setProperty("javax.net.ssl.keyStore", "/home/ricardo/.keystore");
//        System.setProperty("javax.net.ssl.keyStore", "/media/ricardo/Dados/Workspace/Criativa/test-apis/jssecacerts");
//        System.setProperty("javax.net.ssl.keyStorePassword", "12345678");
//        
//        AxisProperties.setProperty("org.apache.axis.components.net.SecureSocketFactory", "RegistroTituloCobranca"); 
//        AxisProperties.setProperty("keystore", "/media/ricardo/Dados/TEMP/testes-java/webservice-bb/keystore.jks"); 
//        AxisProperties.setProperty("keystorePassword", "12345678"); 
//        AxisProperties.setProperty("keystoreType", "JKS"); 
//        
//        locator.getRegistroCobrancaEndpoint().registroTituloCobranca(parameters);
    }

//    private static HttpClientConnectionManager buildTrustConnection() {
//        SSLContext sslContext = SSLContext.getInstance("SSL");
//
//        // set up a TrustManager that trusts everything
//        sslContext.init(null, new TrustManager[] { new X509TrustManager() {
//            public X509Certificate[] getAcceptedIssuers() {
//                System.out.println("getAcceptedIssuers =============");
//                return null;
//            }
//
//            public void checkClientTrusted( X509Certificate[] certs ,
//                    String authType ) {
//                System.out.println("checkClientTrusted =============");
//            }
//
//            public void checkServerTrusted( X509Certificate[] certs ,
//                    String authType ) {
//                System.out.println("checkServerTrusted =============");
//            }
//        } }, new SecureRandom());
//
//        SSLSocketFactory sf = new SSLSocketFactory(sslContext);
//        Scheme httpsScheme = new Scheme("https", 443, sf);
//        SchemeRegistry schemeRegistry = new SchemeRegistry();
//        schemeRegistry.register(httpsScheme);
//
//        // apache HttpClient version >4.2 should use BasicClientConnectionManager
//        ClientConnectionManager cm = new SingleClientConnManager(schemeRegistry);
//    }
}
