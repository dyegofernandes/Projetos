package br.com.facilpagar.bo.dados;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.facilpagar.dao.dados.SistemaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.facilpagar.modelo.dados.Sistema;
import br.com.facilpagar.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restriction;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;

/**
 *
 * @author Juniel
 */
@Stateless
public class SistemaBO extends AbstractBusinessObject<Sistema> {
    
    @EJB
    private SistemaDAO sistemaDAO;
    
    @Override
    public SistemaDAO getDAO() {
        return sistemaDAO;
    }
    
    @Override
    public List<UniqueField> getUniqueFields() {
        UniqueFields uniqueFields = new UniqueFields();
        
        UniqueField unique = new UniqueField(Restriction.equals("ativo", true)).setMessage("Já existe uma Configuração de Sistemas Ativo!");
        
        uniqueFields.add(unique);
        
        return uniqueFields;
    }
    
    @Override
    public void validate(Sistema sistema) throws BusinessException {
    }
    
    @Override
    public boolean isAudit() {
        return true;
    }
    
    public void gerarToken(Sistema sistema) throws OAuthSystemException, OAuthProblemException {
        OAuthClientRequest request = OAuthClientRequest.tokenLocation(sistema.getTokenRequestURL_BB())
                .setGrantType(GrantType.CLIENT_CREDENTIALS)
                .setClientId(sistema.getClienteID_BB())
                .setClientSecret(sistema.getClienteSecret_BB())
                .setScope("cobranca.registro-boletos")
                .buildBodyMessage();
        
        String auth = sistema.getClienteID_BB() + ":" + sistema.getClienteSecret_BB();
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
        String authHeader = "Basic " + new String(encodedAuth);
        request.setHeader("Authorization", authHeader);

        //create OAuth client that uses custom http client under the hood
        OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
        
        OAuthJSONAccessTokenResponse oAuthResponse = oAuthClient.accessToken(request);
        
        String accessToken = oAuthResponse.getAccessToken();
        Long expiresIn = oAuthResponse.getExpiresIn();
        
        if (oAuthResponse.getResponseCode() == 200) {
            sistema.setToken_BB(accessToken);
            sistema.setObservacaoToken_BB("Token gerado correntamente na data: ".concat(Utils.convertDateToString(new Date(), "dd/MM/yyy HH:mm")).concat(", válido por: ").concat(expiresIn + " segundos."));
            sistema.setDataGeracaoToken(new Date());
            sistema.setTempoValidadeEmSegundos_BB(expiresIn);
        } else {
            sistema.setToken_BB(null);
            sistema.setObservacaoToken_BB("Erro na geração do Token com seguinte retorno de Código: " + oAuthResponse.getResponseCode());
            sistema.setDataGeracaoToken(null);
            sistema.setTempoValidadeEmSegundos_BB(null);
        }
        
        getDAO().saveOrMerge(sistema, true);
    }
    
}
