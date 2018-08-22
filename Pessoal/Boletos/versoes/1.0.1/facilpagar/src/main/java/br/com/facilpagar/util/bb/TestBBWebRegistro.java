package br.com.facilpagar.util.bb;

import br.com.facilpagar.modelo.dados.Boleto;
import br.com.facilpagar.modelo.dados.Cliente;
import br.com.facilpagar.modelo.dados.Sistema;
import br.com.facilpagar.util.Utils;
import br.com.facilpagar.webservices.bancoDoBrasil.homologacao.com.tibco.schemas.bws_registro_cbr.recursos.xsd.schema.Requisicao;
import br.com.facilpagar.webservices.bancoDoBrasil.homologacao.com.tibco.schemas.bws_registro_cbr.recursos.xsd.schema.Resposta;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
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
    
    public static Resposta registrar(Sistema sistema, Boleto boleto, Cliente cliente, String cidade, String estado, String token) throws JAXBException, UnsupportedEncodingException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException, XMLStreamException {
        Requisicao requisicao = new Requisicao();
        
        requisicao.setNumeroConvenio(new Integer(sistema.getNumeroConvenio_BB()));
        requisicao.setNumeroCarteira(new Short(sistema.getNumeroCarteira_BB()));
        requisicao.setNumeroVariacaoCarteira(new Short(sistema.getNumeroVariacaoCarteira_BB()));
        requisicao.setCodigoModalidadeTitulo(new Short("1"));
        requisicao.setDataEmissaoTitulo(Utils.convertDateToString(boleto.getDt_criacao(), "dd.MM.yyyy"));
        requisicao.setDataVencimentoTitulo(Utils.convertDateToString(boleto.getDt_vencimento(), "dd.MM.yyyy"));
        requisicao.setValorOriginalTitulo(new BigDecimal(boleto.getVl_nominal().toString()));
        requisicao.setCodigoTipoDesconto(new Short(boleto.getVl_desconto() != null ? boleto.getVl_desconto().compareTo(BigDecimal.ZERO) > 0 ? "1" : "0" : "0"));
        requisicao.setDataDescontoTitulo(boleto.getVl_desconto() != null ? boleto.getVl_desconto().compareTo(BigDecimal.ZERO) > 0 ? Utils.convertDateToString(boleto.getDt_vencimento(), "dd.MM.yyyy") : "" : "");
        requisicao.setPercentualDescontoTitulo(BigDecimal.ZERO);
        requisicao.setValorDescontoTitulo(boleto.getVl_desconto() != null ? boleto.getVl_desconto().compareTo(BigDecimal.ZERO) > 0 ? boleto.getVl_desconto() != null ? boleto.getVl_desconto() : BigDecimal.ZERO : BigDecimal.ZERO : BigDecimal.ZERO);
        requisicao.setValorAbatimentoTitulo(BigDecimal.ZERO);
        requisicao.setQuantidadeDiaProtesto(new Short("0"));
        requisicao.setCodigoTipoJuroMora(new Short("1"));
        requisicao.setPercentualJuroMoraTitulo(BigDecimal.ZERO);
        requisicao.setValorJuroMoraTitulo(boleto.getVl_juros());
        requisicao.setCodigoTipoMulta(new Short("1"));
        requisicao.setDataMultaTitulo(Utils.convertDateToString(Utils.addDiaParaUmaData(boleto.getDt_vencimento(), 1), "dd.MM.yyyy"));
        requisicao.setPercentualMultaTitulo(BigDecimal.TEN);
        requisicao.setValorMultaTitulo(boleto.getVl_multa());
        requisicao.setCodigoAceiteTitulo("N");
        requisicao.setCodigoTipoTitulo(new Short("2"));
        requisicao.setTextoDescricaoTipoTitulo("DM");
        requisicao.setIndicadorPermissaoRecebimentoParcial("N");
//        requisicao.setTextoNumeroTituloBeneficiario("987654321987654");
        requisicao.setTextoCampoUtilizacaoBeneficiario("");
        requisicao.setCodigoTipoContaCaucao(new Short("1"));
        requisicao.setTextoNumeroTituloCliente("000".concat(sistema.getNumeroConvenio_BB().concat(Utils.lpadTo(boleto.getNossonumero().toString(), 10, '0')))); // NossoNumero (sequencial)
        requisicao.setTextoMensagemBloquetoOcorrencia("Pagamento disponível até a data de Vencimento");
        requisicao.setCodigoTipoInscricaoPagador(new Short(cliente.getTipo_pessoa().getNum() + ""));
        requisicao.setNumeroInscricaoPagador(Long.parseLong(cliente.getCpf_cnpj()));
        requisicao.setNomePagador(cliente.getCompleto_razao_social().length() <= 60 ? cliente.getCompleto_razao_social() : cliente.getCompleto_razao_social().substring(1, 60));
        requisicao.setTextoEnderecoPagador(Utils.isNullOrEmpty(cliente.getEndereco()) ? cliente.getEndereco() : "Não informado");
        requisicao.setNumeroCepPagador(Utils.isNullOrEmpty(cliente.getCep()) ? null : new Integer(cliente.getCep().replace("-", "")));
        requisicao.setNomeMunicipioPagador(Utils.isNullOrEmpty(cidade) ? cidade : "Não Informado");
        requisicao.setNomeBairroPagador(Utils.isNullOrEmpty(cliente.getBairro()) ? cliente.getBairro() : "Não Informado");
        requisicao.setSiglaUfPagador(Utils.isNullOrEmpty(estado) ? estado : "NN");
        requisicao.setTextoNumeroTelefonePagador(cliente.getTelefones());
        
        requisicao.setCodigoChaveUsuario(sistema.getChaveUsuario_BB());
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
        request.setHeader("Authorization", "Bearer " + token);
        
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
        
        return null;
        
    }
    
}
