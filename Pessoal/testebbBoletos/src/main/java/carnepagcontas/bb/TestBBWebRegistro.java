package carnepagcontas.bb;

import carnepagcontas.bb.model.Requisicao;
import java.math.BigDecimal;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

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
        return "bLTGouUSn2vJVk_2ahrqGVBe9HSwI73Ihe5rmMSI3RvUnTinULhVW4YoVNCofvN0sBFf8m4Ke1Zfktd4UUFJoA.C3oGs3wLK3LCgy2gMSRkW3CsFglOx9nqlOUzlIMfIaQqcPLQGyKfOYz6fYUsn_XMWzk2XDpx3vwn9YfFVIatJJuAWHIiS68QJwpyyqst50kZU3k5NyfgGPQsdzyFakR5mvX0BaaPcZksl62rnOOeJoBz8ItGO6of3lQM1FXKareZLW8SgRt86E4j7lxN6iQabnIDr0YsZ-OEeXkC5EnCa3bBouGOPI5uwHSnBGy3zpnaQEgwmFoG1ibcN9FD0llGDCkaZfth9UfzLDPCU3fiphOgsXExzIhXoOH7qJRU3GGcUfiCoDg-zNtXUMCB1SCGeded_dG2N4WMv1AT_KRCU_po9jYft8tV7kYBX-cajXJO7reP5_KVVe3NDTXaAksZI6X-DImmVWuTo_d4nxUetyLUlscbzX9Eg3Mz8Pr0_uWtZJoUWzsHsGCsFRw_tan5zm8NN4Vuw98o2ntvzA_RP_pe2kuzFGO3UtLOpeJCFLu1cjB7TEZ208h28oqV4sm5nNu022K1AbnlVaCpTCH4VUZKAFNTl5O-4RHMrBa8-QP88DM79Mt3QZ4Evcou7-swrUtCDH8_IaP4lPSlYYKJ9HVpjVTwAspUPME6OBP-W5v5gme9jyDixkusDmH1ybW5iqaiyDnUeHj659D0NbYNQA.OOwRIi0erUH2jMjqoSbvKUVRp0t-H5Sq4hfBxp4mndcbxP0TeHvT0r9NvBgOKgvPGLHO_6v-n6-de5mqqohgxQ";
    }
    
    public static void main( String[] args ) throws  Exception {
      
        
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
        
        
        String soap = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" + 
                "xmlns:sch=\"http://www.tibco.com/schemas/bws_registro_cbr/Recursos/XSD/Schema.xsd\">\n" + 
                "<soapenv:Header/>\n" + 
                "<soapenv:Body>";
        
        soap += reqEnvioXML;
        
        
        soap += "</soapenv:Body>\n" + 
                "</soapenv:Envelope>";
        
        System.out.println("request: " + soap);
        
        
        HttpClientBuilder builder = HttpClientBuilder.create();
        builder.setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE);
        
        SSLContextBuilder contextBuilder = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy()
        {
            public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException
            {
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
