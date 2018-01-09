/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.mb;

import br.gov.pi.salvemaria.util.Utils;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author KillerBeeTwo
 */
@ManagedBean
public class UtilsMB implements Serializable {

    public BigDecimal porcengatemPeloValor(Integer total, Integer valor) {
        return Utils.calcularPorcPeloValor(total, valor);
    }

}
