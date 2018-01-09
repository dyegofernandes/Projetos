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
@FacesConverter(value = "foneConverter")
public class FoneConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        return value.replace("-", "").replace("(", "").replace(")", "").replace(" ", "");
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        String valor = (String) value;

        String retorno = "";
        if (valor != null && !valor.equals("")) {
            retorno = valor.substring(0, 0).concat("(")
                    .concat(valor.substring(0, 2).concat(")"))
                    .concat(valor.substring(2, 2).concat(" "))
                    .concat(valor.substring(2, 6).concat("-"))
                    .concat(valor.substring(6, valor.length()));
        }
        return retorno;

    }

}
