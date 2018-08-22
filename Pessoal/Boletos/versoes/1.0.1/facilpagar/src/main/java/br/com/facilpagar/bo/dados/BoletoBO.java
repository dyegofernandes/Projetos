package br.com.facilpagar.bo.dados;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.facilpagar.dao.dados.BoletoDAO;
import br.com.facilpagar.mb.dados.SistemaMB;
import br.com.facilpagar.modelo.controleacesso.Usuario;
import br.com.facilpagar.modelo.dados.Banco;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.facilpagar.modelo.dados.Boleto;
import br.com.facilpagar.modelo.dados.Cidade;
import br.com.facilpagar.modelo.dados.Cliente;
import br.com.facilpagar.modelo.dados.Convenio;
import br.com.facilpagar.modelo.dados.Sistema;
import br.com.facilpagar.modelo.dados.TokenBB;
import br.com.facilpagar.modelo.dados.Uf;
import br.com.facilpagar.modelo.dados.vos.ArquivoBancoVO;
import br.com.facilpagar.modelo.dados.vos.RespostaArquivoBancoVO;
import br.com.facilpagar.modelo.vos.FiltrosBusca;
import br.com.facilpagar.util.Utils;
import br.com.facilpagar.util.bb.TestBBWebRegistro;
import br.com.facilpagar.webservices.bancoDoBrasil.homologacao.com.tibco.schemas.bws_registro_cbr.recursos.xsd.schema.Resposta;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
import java.io.IOException;
import java.util.Date;
import javax.persistence.TemporalType;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;

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
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;

/**
 *
 * @author Juniel
 */
@Stateless
public class BoletoBO extends AbstractBusinessObject<Boleto> {

    @EJB
    private BoletoDAO boletoDAO;

    @EJB
    private SistemaBO sistemaBO;

    @Override
    public BoletoDAO getDAO() {
        return boletoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("nossonumero").add("codigobarras");
    }

    @Override
    public void validate(Boleto boleto) throws BusinessException {
        if (boleto.getDt_vencimento().before(new Date())) {
            throw new BusinessException("Data do Vencimento do Boleto não pode ser interior a Data Atual!");
        }

        if (boleto.getQtd_total_parcela() < boleto.getNr_parcela()) {
            throw new BusinessException("Quantidade de Parcelas não pode ser menor que o Número de Parcelas!");
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public String getCodigoDeBarrasSicoob(Boleto boleto) {
        StringBuilder stringBuilder = new StringBuilder();
        if (boleto == null) {
            return null;
        }

        Banco banco = getDAO().getInitialized(boleto.getBanco());
//        Cliente cliente = getDAO().getInitialized(boleto.getCliente());

        stringBuilder.append(Utils.inserirZeroEsquerda(banco.getCodigo(), 3));
        stringBuilder.append(Utils.inserirZeroEsquerda("9", 1));
        stringBuilder.append(Utils.inserirZeroEsquerda(Utils.fatorVencimento(boleto.getDt_vencimento()).toString(), 4));
        stringBuilder.append(Utils.inserirZeroEsquerda(boleto.getVl_nominal().toString().replace(".", "").replace(",", ""), 10));
        stringBuilder.append(Utils.inserirZeroEsquerda("1", 1));
        stringBuilder.append(Utils.inserirZeroEsquerda("4353", 4));
        stringBuilder.append(Utils.inserirZeroEsquerda("1", 2));
        stringBuilder.append(Utils.inserirZeroEsquerda("0031020", 7));
        stringBuilder.append(Utils.inserirZeroEsquerda(boleto.getNossonumero().toString(), 8));
        stringBuilder.append(Utils.inserirZeroEsquerda(boleto.getNr_parcela().toString(), 3));

        String dv = String.valueOf(Utils.getMod11(stringBuilder.toString()));

        return stringBuilder.insert(4, dv).toString();
    }

    public String linhaEditavel(String codigobarras) {

        StringBuilder stringBuilder = new StringBuilder();

        String codigoBanco = codigobarras.substring(0, 4);
        String codigoMoeda = codigobarras.substring(3, 4);
        String dv11 = codigobarras.substring(4, 5);
        String fatorVencimento = codigobarras.substring(5, 9);
        String valorNominal = codigobarras.substring(9, 19);
        String carteira = codigobarras.substring(19, 20);
        String codigoCoper = codigobarras.substring(20, 24);
        String modalidade = codigobarras.substring(24, 26);
        String codigoCliente = codigobarras.substring(26, 33);
        String numeroTitulo = codigobarras.substring(33, 41);
        String parcela = codigobarras.substring(41, 44);

        stringBuilder.append(codigoBanco);
        stringBuilder.append(codigoMoeda);
        stringBuilder.append(carteira);
        stringBuilder.append(codigoCoper);
        stringBuilder.append(modalidade);
        stringBuilder.append(codigoCliente);
        stringBuilder.append(numeroTitulo);
        stringBuilder.append(parcela);

        stringBuilder.insert(9, Utils.getMod10(stringBuilder.substring(0, 9)));
        stringBuilder.insert(5, ".");
        stringBuilder.insert(11, " ");

        stringBuilder.insert(22, Utils.getMod10(stringBuilder.substring(12, 22)));
        stringBuilder.insert(23, " ");
        stringBuilder.insert(34, Utils.getMod10(stringBuilder.substring(24, 34)));

        stringBuilder.insert(29, ".");
        stringBuilder.insert(36, " ");
        stringBuilder.insert(37, dv11);
        stringBuilder.insert(38, " ");
        stringBuilder.append(fatorVencimento);
        stringBuilder.append(valorNominal);

        return stringBuilder.toString();
    }

    public Long proximoNossoNumero() {
        Long nossoNum = 1L;
        Long id = (Long) getDAO().getQueryBuilder().from(Boleto.class).max("id");

        Boleto boletoTemp = getDAO().unique("id", id);

        if (boletoTemp != null) {
            nossoNum = boletoTemp.getNossonumero() + 1;
        }

        return nossoNum;
    }

    public List<Boleto> listar(FiltrosBusca filtros) {

        Restrictions restrictions = new Restrictions();

        if (filtros.getFranquia() != null) {
            restrictions.add("franquia", filtros.getFranquia());
        }

        if (filtros.getConvenio() != null) {
            restrictions.add("convenio", filtros.getConvenio());
        }

        if (filtros.getCliente() != null) {
            restrictions.add("cliente", filtros.getCliente());
        }

        if (filtros.getProduto() != null) {
            restrictions.add("produto", filtros.getProduto());
        }

        if (filtros.getBanco1() != null) {
            restrictions.add("banco", filtros.getBanco1());
        }

        if (filtros.getDeposito() != null) {
            restrictions.add("deposito", filtros.getDeposito());
        }

        if (!Utils.isNullOrEmpty(filtros.getCodigo())) {
            restrictions.add("boleto.nossonumero", new Long(filtros.getCodigo()));
        }

        if (filtros.getDataInicial1() != null) {
            restrictions.greaterEqualsThan("boleto.dt_vencimento", filtros.getDataInicial1(), TemporalType.DATE);
        }

        if (filtros.getDataFinal1() != null) {
            restrictions.lessEqualsThan("boleto.dt_vencimento", filtros.getDataFinal1(), TemporalType.DATE);
        }

        if (filtros.getDataInicial2() != null) {
            restrictions.greaterEqualsThan("boleto.dt_baixado", filtros.getDataInicial2(), TemporalType.DATE);
        }

        if (filtros.getDataFinal2() != null) {
            restrictions.lessEqualsThan("boleto.dt_baixado", filtros.getDataFinal2(), TemporalType.DATE);
        }

        if (filtros.getCidade() != null) {
            restrictions.add("cidade", filtros.getCidade());
        }

        if (filtros.getEstado() != null) {
            restrictions.add("uf", filtros.getEstado());
        }

        if (filtros.getSituacaoBoleto() != null) {
            restrictions.add("boleto.situacao", filtros.getSituacaoBoleto());
        }

        return getDAO().getQueryBuilder().from(Boleto.class, "boleto").leftJoinFetch("boleto.cliente", "cliente")
                .leftJoinFetch("boleto.produto", "produto").leftJoinFetch("boleto.convenio", "convenio").leftJoinFetch("boleto.deposito", "deposito")
                .leftJoinFetch("convenio.franquia", "franquia").leftJoinFetch("boleto.banco", "banco").leftJoinFetch("convenio.cidade", "cidade")
                .leftJoinFetch("cidade.uf", "uf").add(restrictions).orderBy("uf, cidade, boleto.convenio, boleto.dt_vencimento").getResultList();
    }

    /**
     *
     * @param convenio
     * @return boletos vencidos, a vencer e pagos em um mês.
     */
    public Long numeroBoletos(Convenio convenio) {
        Long numero = 0L;

        return numero;
    }

    public void registrarBoleto(Boleto boleto, Usuario usuario) throws JAXBException, UnsupportedEncodingException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, XMLStreamException, IOException, OAuthSystemException, OAuthProblemException {

        Usuario usuarioTemp = getDAO().getInitialized(usuario);
        TokenBB tokenBB = getDAO().getInitialized(usuarioTemp.getTokenBB());

        if (tokenBB != null) {
            if (tokenBB.getTempoRestante() < 5) {
                sistemaBO.gerarToken(usuarioTemp);
            }
        } else {
            sistemaBO.gerarToken(usuarioTemp);
        }

        Cliente clienteTemp = getDAO().getInitialized(boleto.getCliente());

        Sistema sistema = sistemaBO.getDAO().unique("ativo", true);

        Cidade cidade = getDAO().getInitialized(clienteTemp.getCidade());

        Uf estado = getDAO().getInitialized(cidade.getUf());
        
        tokenBB = getDAO().getInitialized(usuarioTemp.getTokenBB());

        Resposta resposta = TestBBWebRegistro.registrar(sistema, boleto, clienteTemp, cidade.getNome(), estado.getSigla(), tokenBB.getToken_BB());
    
    }
}
