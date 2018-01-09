package br.gov.pi.ati.siopm.mb.padrao;

import br.gov.pi.ati.siopm.constante.Constantes;
import javax.faces.bean.ManagedBean;

/**
 * class que retorna o valor das constantes
 *
 * @author Ayslan
 */
@ManagedBean
public class ConstantesMB {

    public int getMinutosRecuperacaoSenha() {
        return Constantes.MINUTOS_VALIDADE_RECUPERACAO_SENHA;
    }

    public String getChaveApiGoogleMaps() {
        return Constantes.CHAVE_API_GOOGLE_MAPS;
    }

    public String getChaveApiAtendimentoGoogleMaps() {
        return Constantes.CHAVE_API_ATENDIMENTO_GOOGLE_MAPS;
    }

    public String getChaveApiDespachoGoogleMaps() {
        return Constantes.CHAVE_API_DESPACHO_GOOGLE_MAPS;
    }

    public String getChaveApiSupervisaoGoogleMaps() {
        return Constantes.CHAVE_API_SUPERVISAO_GOOGLE_MAPS;
    }
}
