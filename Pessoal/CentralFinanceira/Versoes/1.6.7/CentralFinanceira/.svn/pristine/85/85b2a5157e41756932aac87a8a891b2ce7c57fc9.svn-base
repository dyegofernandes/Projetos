/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author killerbee
 */
@FacesConverter(value = "cepConverter")
public class CepConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        return value.replace("-", "");
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        String valor = (String) value;

        String retorno = "";
        if (valor != null && !valor.equals("")) {
            retorno = valor.substring(0, 5).concat("-").concat(valor.substring(5, valor.length()));
        }
        return retorno;

    }

}
