/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.convertores;

import br.gov.pi.siste.util.Utils;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Juniel
 */
@FacesConverter(value = "periodoConverter")
public class PeriodoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        String periodo = "";
        if (!Utils.isNullOrEmpty(value)) {
            String[] temp = value.split("/");
            periodo = temp[1].concat(temp[0]);
        }

        return periodo;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        String valor = Integer.toString((Integer) value);

        return getMes(valor).concat("/").concat(getAno(valor));

    }

    private String getMes(String periodo) {
        String str = periodo.toString();
        return str.substring(4, 6);
    }

    private String getAno(String periodo) {
        String str = periodo.toString();
        return str.substring(0, 4);
    }

    private String convertMes(int mes) {
        String mesRetorno;
        switch (mes) {
            case 1:
                mesRetorno = "Jan";
                break;
            case 2:
                mesRetorno = "Fev";
                break;
            case 3:
                mesRetorno = "Mar";
                break;
            case 4:
                mesRetorno = "Abr";
                break;
            case 5:
                mesRetorno = "Mai";
                break;
            case 6:
                mesRetorno = "Jun";
                break;
            case 7:
                mesRetorno = "Jul";
                break;
            case 8:
                mesRetorno = "Ago";
                break;
            case 9:
                mesRetorno = "Set";
                break;
            case 10:
                mesRetorno = "Out";
                break;
            case 11:
                mesRetorno = "Nov";
                break;
            case 12:
                mesRetorno = "Dez";
                break;
            default:
                mesRetorno = "Nao";
        }
        return mesRetorno;
    }

    private String getNumDoMes(String mes) {
        if (mes.equals("Jan")) {
            return "01";
        }
        if (mes.equals("Fev")) {
            return "02";
        }
        if (mes.equals("Mar")) {
            return "03";
        }
        if (mes.equals("Abr")) {
            return "04";
        }
        if (mes.equals("Mai")) {
            return "05";
        }
        if (mes.equals("Jun")) {
            return "06";
        }
        if (mes.equals("Jul")) {
            return "07";
        }
        if (mes.equals("Ago")) {
            return "08";
        }
        if (mes.equals("Set")) {
            return "09";
        }
        if (mes.equals("Out")) {
            return "10";
        }
        if (mes.equals("Nov")) {
            return "11";
        }
        if (mes.equals("Dez")) {
            return "12";
        }

        return "00";
    }

    private boolean ehInteiro(String s) {

        // cria um array de char  
        char[] c = s.toCharArray();
        boolean d = true;

        for (int i = 0; i < c.length; i++) // verifica se o char não é um dígito  
        {
            if (!Character.isDigit(c[i])) {
                d = false;
                break;
            }
        }
        return d;
    }

}
