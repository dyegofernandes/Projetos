package br.gov.pi.siste.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.text.MaskFormatter;
import br.gov.pi.siste.modelo.cadastro.enums.Formato;
import java.math.RoundingMode;
import java.util.Calendar;

public class Utils {

    public String retiraCaracteresEspeciais(String stringFonte) {
        String passa = stringFonte.toUpperCase();
        passa = passa.replaceAll("[ÂÀÁÄÃ]", "A");
        passa = passa.replaceAll("[âãàáä]", "a");
        passa = passa.replaceAll("[ÊÈÉË]", "E");
        passa = passa.replaceAll("[êèéë]", "e");
        passa = passa.replaceAll("[ÎÍÌÏ]", "I");
        passa = passa.replaceAll("[îíìï]", "i");
        passa = passa.replaceAll("[ÔÕÒÓÖ]", "O");
        passa = passa.replaceAll("[ôõòóö]", "o");
        passa = passa.replaceAll("[ÛÙÚÜ]", "U");
        passa = passa.replaceAll("[ûúùü]", "u");
        passa = passa.replaceAll("Ç", "C");
        passa = passa.replaceAll("ç", "c");
        passa = passa.replaceAll("[ýÿ]", "y");
        passa = passa.replaceAll("Ý", "Y");
        passa = passa.replaceAll("ñ", "n");
        passa = passa.replaceAll("Ñ", "N");
        passa = passa.replaceAll("[-+=*&amp;%$#@!_º?´]", "");
        passa = passa.replaceAll("['\"]", "");
        passa = passa.replaceAll("[<>()\\{\\}]", "");
        passa = passa.replaceAll("['\\\\.,()|/]", "");
        passa = passa.replaceAll("[^!-ÿ]{1}[^ -ÿ]{0,}[^!-ÿ]{1}|[^!-ÿ]{1}", " ");
        return passa;
    }

    public boolean validatePIS(String plPIS) {
        int liTamanho = 0;
        StringBuffer lsAux = null;
        StringBuffer lsMultiplicador = new StringBuffer("3298765432");
        int liTotalizador = 0;
        int liResto = 0;
        int liMultiplicando = 0;
        int liMultiplicador = 0;
        boolean lbRetorno = true;
        int liDigito = 99;
        lsAux = new StringBuffer().append(plPIS.replace(".", "").replace("-", ""));
        liTamanho = lsAux.length();
        if (liTamanho != 11) {
            lbRetorno = false;
        }
        if (lbRetorno) {
            for (int i = 0; i < 10; i++) {
                liMultiplicando = Integer.parseInt(lsAux.substring(i, i + 1));
                liMultiplicador = Integer.parseInt(lsMultiplicador.substring(i, i + 1));
                liTotalizador += liMultiplicando * liMultiplicador;
            }
            liResto = 11 - liTotalizador % 11;
            liResto = liResto == 10 || liResto == 11 ? 0 : liResto;
            liDigito = Integer.parseInt("" + lsAux.charAt(10));
            lbRetorno = liResto == liDigito;
        }
        return lbRetorno;
    }

    public String inserirCaractere(String input, int width, Formato formato) {

        char ch = ' ';

        if (formato == Formato.NUM) {
            ch = '0';
        }

        String strPad = "";

        if (input == null) {
            input = "";
        }

        StringBuilder sb = new StringBuilder(input.trim());

        if (formato == Formato.NUM) {
            while (sb.length() < width) {
                sb.insert(0, ch);
            }
            strPad = sb.toString();

            if (strPad.length() > width) {

                strPad = strPad.substring(0, width);
            }
        } else {
            int total = sb.length() - 1;
            while (sb.length() < width) {
                sb.append(ch);
            }
            strPad = sb.toString();

            if (strPad.length() > width) {

                strPad = strPad.substring(0, width);
            }
        }

        return strPad;
    }

    public Integer getMesEmUmPeriodo(Integer periodo) {
        String str = periodo.toString();
        return new Integer(str.substring(4, 6));
    }

    public Integer getAnoEmUmPeriodo(Integer periodo) {
        String str = periodo.toString();

        return new Integer(str.substring(0, 4));
    }

    public String convertDateToString(Date date, int tipo) {
        SimpleDateFormat formataData = null;

        if (date == null) {
            return "";
        }
        if (tipo == 1) {
            formataData = new SimpleDateFormat("dd/MM/yyyy");
        }

        if (tipo == 2) {
            formataData = new SimpleDateFormat("yyyy-MM-dd");
        }

        if (tipo == 3) {
            formataData = new SimpleDateFormat("HH:mm");
        }

        if (tipo == 4) {
            formataData = new SimpleDateFormat("MMyy");
        }
        if (tipo == 5) {
            formataData = new SimpleDateFormat("HH:mm:ss");
        }
        if (tipo == 6) {
            formataData = new SimpleDateFormat("yyMM");
        }
        if (tipo == 7) {
            formataData = new SimpleDateFormat("yyMMdd");
        }
        if (tipo == 8) {
            formataData = new SimpleDateFormat("MM/yyyy");
        }
        if (tipo == 9) {
            formataData = new SimpleDateFormat("yyyyMM");
        }
        if (tipo == 10) {
            formataData = new SimpleDateFormat("ddMMyyyy");
        }
        if (tipo == 11) {
            formataData = new SimpleDateFormat("yyyy");
        }

        String data = formataData.format(date);

        return data;
    }

    public String format(String pattern, Object value) {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String moeda(BigDecimal num) {
        NumberFormat formatter = new DecimalFormat("##,###,###,###,###,###,###,##0.00");

        return formatter.format(num.doubleValue());
    }

    public Integer periodoAnterior(Integer periodo) {

        String anterior = "";

        Integer mes = getMesEmUmPeriodo(periodo);
        Integer ano = getAnoEmUmPeriodo(periodo);

        if (mes == 1) {
            mes = 12;
            ano = ano - 1;
        } else {
            mes = mes - 1;
        }
        anterior = (ano.toString().concat(inserirCaractere(mes.toString(), 2, Formato.NUM)));

        return new Integer(anterior);
    }

    public String valorPorExtenso(double vlr) {
        if (vlr == 0) {
            return ("zero".toUpperCase());
        }

        long inteiro = (long) Math.abs(vlr); // parte inteira do valor
        double resto = vlr - inteiro;       // parte fracionária do valor

        String vlrS = String.valueOf(inteiro);
        if (vlrS.length() > 15) {
            return ("Erro: valor superior a 999 trilhões.");
        }

        String s = "", saux, vlrP;
        String centavos = String.valueOf((int) Math.round(resto * 100));

        String[] unidade = {"", "um", "dois", "três", "quatro", "cinco",
            "seis", "sete", "oito", "nove", "dez", "onze",
            "doze", "treze", "quatorze", "quinze", "dezesseis",
            "dezessete", "dezoito", "dezenove"};
        String[] centena = {"", "cento", "duzentos", "trezentos",
            "quatrocentos", "quinhentos", "seiscentos",
            "setecentos", "oitocentos", "novecentos"};
        String[] dezena = {"", "", "vinte", "trinta", "quarenta", "cinquenta",
            "sessenta", "setenta", "oitenta", "noventa"};
        String[] qualificaS = {"", "mil", "milhão", "bilhão", "trilhão"};
        String[] qualificaP = {"", "mil", "milhões", "bilhões", "trilhões"};

// definindo o extenso da parte inteira do valor
        int n, unid, dez, cent, tam, i = 0;
        boolean umReal = false, tem = false;
        while (!vlrS.equals("0")) {
            tam = vlrS.length();
// retira do valor a 1a. parte, 2a. parte, por exemplo, para 123456789:
// 1a. parte = 789 (centena)
// 2a. parte = 456 (mil)
// 3a. parte = 123 (milhões)
            if (tam > 3) {
                vlrP = vlrS.substring(tam - 3, tam);
                vlrS = vlrS.substring(0, tam - 3);
            } else { // última parte do valor
                vlrP = vlrS;
                vlrS = "0";
            }
            if (!vlrP.equals("000")) {
                saux = "";
                if (vlrP.equals("100")) {
                    saux = "cem";
                } else {
                    n = Integer.parseInt(vlrP, 10);  // para n = 371, tem-se:
                    cent = n / 100;                  // cent = 3 (centena trezentos)
                    dez = (n % 100) / 10;            // dez  = 7 (dezena setenta)
                    unid = (n % 100) % 10;           // unid = 1 (unidade um)
                    if (cent != 0) {
                        saux = centena[cent];
                    }
                    if ((n % 100) <= 19) {
                        if (saux.length() != 0) {
                            saux = saux + " e " + unidade[n % 100];
                        } else {
                            saux = unidade[n % 100];
                        }
                    } else {
                        if (saux.length() != 0) {
                            saux = saux + " e " + dezena[dez];
                        } else {
                            saux = dezena[dez];
                        }
                        if (unid != 0) {
                            if (saux.length() != 0) {
                                saux = saux + " e " + unidade[unid];
                            } else {
                                saux = unidade[unid];
                            }
                        }
                    }
                }
                if (vlrP.equals("1") || vlrP.equals("001")) {
                    if (i == 0) // 1a. parte do valor (um real)
                    {
                        umReal = true;
                    } else {
                        saux = saux + " " + qualificaS[i];
                    }
                } else if (i != 0) {
                    saux = saux + " " + qualificaP[i];
                }
                if (s.length() != 0) {
                    s = saux + ", " + s;
                } else {
                    s = saux;
                }
            }
            if (((i == 0) || (i == 1)) && s.length() != 0) {
                tem = true; // tem centena ou mil no valor
            }
            i = i + 1; // próximo qualificador: 1- mil, 2- milhão, 3- bilhão, ...
        }

        if (s.length() != 0) {
            if (umReal) {
                s = s + " real";
            } else if (tem) {
                s = s + " reais";
            } else {
                s = s + " de reais";
            }
        }

// definindo o extenso dos centavos do valor
        if (!centavos.equals("0")) { // valor com centavos
            if (s.length() != 0) // se não é valor somente com centavos
            {
                s = s + " e ";
            }
            if (centavos.equals("1")) {
                s = s + "um centavo";
            } else {
                n = Integer.parseInt(centavos, 10);
                if (n <= 19) {
                    s = s + unidade[n];
                } else {             // para n = 37, tem-se:
                    unid = n % 10;   // unid = 37 % 10 = 7 (unidade sete)
                    dez = n / 10;    // dez  = 37 / 10 = 3 (dezena trinta)
                    s = s + dezena[dez];
                    if (unid != 0) {
                        s = s + " e " + unidade[unid];
                    }
                }
                s = s + " centavos";
            }
        }
        return (s.toUpperCase());
    }

    public BigDecimal calcularPorcentagem(BigDecimal porcentagem, BigDecimal valor) {
        BigDecimal retorno = BigDecimal.ZERO;

        if (valor == null || porcentagem == null) {
            return BigDecimal.ZERO;
        }

        retorno = valor.multiply(porcentagem).divide(new BigDecimal(100), 2, RoundingMode.DOWN);

        return retorno;
    }

    public BigDecimal calcularPorcPeloValor(BigDecimal total, BigDecimal valor) {
        BigDecimal retorno = BigDecimal.ZERO;

        if (valor == null || total == null) {
            return BigDecimal.ZERO;
        }

        if (total.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }

        retorno = valor.multiply(new BigDecimal(100)).divide(total, 2, RoundingMode.UP);

        return retorno;
    }
}
