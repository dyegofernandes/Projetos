package br.gov.pi.ati.adapi.mb.padrao;

import br.gov.pi.ati.adapi.constante.Constantes;
import javax.faces.bean.ManagedBean;

/**
 * class que retorna o valor das constantes
 *
 * @author Ayslan
 */
@ManagedBean
public class ConstantesMB {
    
    public int getMinutosRecuperacaoSenha(){
        return Constantes.MINUTOS_VALIDADE_RECUPERACAO_SENHA;
    }
    
}
