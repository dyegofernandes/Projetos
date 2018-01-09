package br.gov.pi.ati.agendacultural.mb.padrao;

import br.gov.pi.ati.agendacultural.constante.Constantes;
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
