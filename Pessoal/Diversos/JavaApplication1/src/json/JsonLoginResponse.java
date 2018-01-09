/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

/**
 *
 * @author KillerBeeTwo
 */
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Classe que define um objeto que mapeia a resposta do método Tinebase.login
 * TODO: Definir classe abstrata GenericResponse e especializar a classe result
 * para cada método a ser tratado
 *
 * @author "Mário César Kolling" <mario.kolling@serpro.gov.br>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonLoginResponse {
// Classe que Mapeia um Objeto Account 
// TODO: Defininir como uma classe do pacote json, ao invés de uma classe 
// interna da Classe JsonLoginResponse 

    public static class Account {

        private String _accountId, _accountDisplayName, _accountFullName,
                _accountFirstName,
                _accountLastName, _contact_id;

        public String getAccountDisplayName() {
            return _accountDisplayName;
        }

        public String getAccountFirstName() {
            return _accountFirstName;
        }

        public String getAccountFullName() {
            return _accountFullName;
        }

        public String getAccountId() {
            return _accountId;
        }

        public String getAccountLastName() {
            return _accountLastName;
        }

        public String getContact_id() {
            return _contact_id;
        }

        public void setAccountDisplayName(String _accountDisplayName) {
            this._accountDisplayName = _accountDisplayName;
        }

        public void setAccountFirstName(String _accountFirstName) {
            this._accountFirstName = _accountFirstName;
        }

        public void setAccountFullName(String _accountFullName) {
            this._accountFullName = _accountFullName;
        }

        public void setAccountId(String _accountId) {
            this._accountId = _accountId;
        }

        public void setAccountLastName(String _accountLastName) {
            this._accountLastName = _accountLastName;
        }

        public void setContact_id(String _contact_id) {
            this._contact_id = _contact_id;
        }
    }
// Classe que mapeia o resultado 

    public static class Result {

        private String _jsonKey, _welcomeMessage, _errorMessage;
        private boolean _success;
        private Account _account;

        public Account getAccount() {
            return _account;
        }

        public String getJsonKey() {
            return _jsonKey;
        }

        public boolean getSuccess() {
            return _success;
        }

        public String getWelcomeMessage() {
            return _welcomeMessage;
        }

        public String getErrorMessage() {
            return _errorMessage;
        }

        public void setAccount(Account _account) {
            this._account = _account;
        }

        public void setJsonKey(String _jsonKey) {
            this._jsonKey = _jsonKey;
        }

        public void setSuccess(boolean _success) {
            this._success = _success;
        }

        public void setWelcomeMessage(String _welcomeMessage) {
            this._welcomeMessage = _welcomeMessage;
        }

        public void setErrorMessage(String _errorMessage) {
            this._errorMessage = _errorMessage;
        }
    }
    private int _id;
    private String _jsonrpc;
    private Result _result;

    public int getId() {
        return _id;
    }

    public String getJsonrpc() {
        return _jsonrpc;
    }

    public Result getResult() {
        return _result;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public void setJsonrpc(String _jsonrpc) {
        this._jsonrpc = _jsonrpc;
    }

    public void setResult(Result _result) {
        this._result = _result;
    }
}
