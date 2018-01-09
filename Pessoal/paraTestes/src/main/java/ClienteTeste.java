
import com.zimbra.wsdl.zimbraservice.ZcsAdminPortType;
import com.zimbra.wsdl.zimbraservice.ZcsAdminService;
import com.zimbra.wsdl.zimbraservice.ZcsPortType;
import com.zimbra.wsdl.zimbraservice.ZcsService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.xml.ws.BindingProvider;
import zimbra.AccountBy;
import zimbra.AccountSelector;
import zimbraaccount.GetInfoRequest;
import zimbraadmin.AccountInfo;
import zimbraadmin.AuthRequest;
import zimbraadmin.AuthResponse;
import zimbraadmin.CreateAccountRequest;
import zimbraadmin.CreateAccountResponse;
import zimbraadmin.GetAccountInfoRequest;
import zimbraadmin.GetAccountRequest;
import zimbraadmin.GetServiceStatusRequest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Juniel
 */
public class ClienteTeste {

    public static void main(String[] args) {

        List<Tipo> tipos = new ArrayList<>(Arrays.asList(Tipo.values()));
        tipos.remove(Tipo.DFPI);
        tipos.remove(Tipo.DPCA);
        for (Tipo tipo : tipos) {
            System.out.println(tipo.getDescricao());
        }
    }

    public static void criarConta() {
        ZcsAdminService service = new ZcsAdminService();
        ZcsAdminPortType cliente = service.getZcsAdminServicePort();

        AuthRequest authRequest = new AuthRequest();
        AuthResponse authResponse = new AuthResponse();
        AccountInfo accountInfo = new AccountInfo();

        AccountSelector conta = new AccountSelector();
        conta.setBy(AccountBy.ADMIN_NAME);
//        conta.setValue("sisforms@ati.pi.gov.br");
        conta.setValue("teste11@ati.pi.gov.br");
        authRequest.setAccount(conta);
//        auth.setPassword("Sysf0rms@");
        authRequest.setPassword("Teste@2017");

        authResponse = cliente.authRequest(authRequest);

        System.out.println(authResponse.getAuthToken());
        System.out.println(authResponse.getCsrfToken());
        System.out.println(authResponse.getLifetime());

        CreateAccountRequest emailRequest = new CreateAccountRequest();

        emailRequest.setName("usuario.pela.api@ati.pi.gov.br");
        emailRequest.setPassword("teste11");

        cliente.createAccountRequest(emailRequest);

    }

}
