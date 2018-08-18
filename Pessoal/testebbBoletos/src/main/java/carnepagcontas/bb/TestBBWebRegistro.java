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
        return "gAjf3j18XWm8D-tEf68BhC-8TwRDBSrCXbiKBoL-sLuoo-MLGv2Je3kTLKT6XbuginOdJDGki4ZV7QCwxNFGDw.5vBpw2hn5gZzB3POUkdWa6umfJDLzWEmwil3hxlzoYyKTa1qFCYmCilnRC0YwYexbDsyTsS12Mon9-WNJMX892mi5MamR0-5jUqwXAX3QOzxj7nEBcmItt_8qqCA3KVc-lsToc5Gc-44KtvKKyEkcqQ5sKAmnftk_M-qBarsx5QDAV6XS2D2Hxiv9WVJKpnXbTvwnQGBvLoMOncM6XiPjzElTQ8zwmN4jzECBAPi790gkklceZ4pR_28ndvjJlSSse0LD9twmmOonOOoAuEIJ0WXZ5APHOvUpw3fSyPd4LfWBUkQI5LDoEplSpGqenKByQ1ZPhkhIaPdcqI3DRuNhuxgB3dLl35NQkb7_nGvyjiYLuZ9bPrs3qge-bToYpIWnBOk8u8dlUoPVy9lWtMDqER0DB9n7bpPIffTnXlh258vvJfQBkwKi72EqjFOeMcAMH2nsSI0lptnnD6lEISKPGTvM7eJ2Bfev3P658U8sSzPTq9Uh8N8Qxcpfz1oHJCumWpL_FdIu0zLtdpHWFbfBsmvi-6dyVQ-JMzgrRmEnCSCR8i1gqBmqsxpIdSBP7K_nXFs7yPy0Qd_eBhJed-dWf4UWYFpPq4SGHtjDM1KsElA7-MviV1YsfbAtMheXz1VX2b_N5YastuTSx5IIe-gLA.R1FOzUvpJ2x80MPOkReq00SzqGmSsn0hs7SxRMTnuXiQeeWz87whPmDlQVWyIVMXWfEJqtJm9HsrDNxTwdvsqA";
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

        System.out.println("response : " + response.getStatusLine());
        System.out.println("response : " + responseBody);

        XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource streamSource = new StreamSource(new StringReader(responseBody));
        XMLStreamReader xsr = xif.createXMLStreamReader(streamSource);

        JAXBContext jaxbContext = JAXBContext.newInstance(Resposta.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        
        JAXBElement<Resposta> je = unmarshaller.unmarshal(xsr,
                Resposta.class);

        System.out.println("Last Name:- " + je.getValue().getCodigoRetornoPrograma());


    }


}
