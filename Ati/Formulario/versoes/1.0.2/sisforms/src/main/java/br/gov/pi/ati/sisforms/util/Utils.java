package br.gov.pi.ati.sisforms.util;

import br.gov.pi.ati.sisforms.modelo.enums.Conversao;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.text.MaskFormatter;

public class Utils {

    public static String gerarDomain(String login) {
        //String usuarioZimbra = "uid=juniel.silva,ou=people,dc=ati,dc=pi,dc=gov,dc=br";
        //"uid=juniel.silva,ou=ati,ou=usuarios,dc=pi,dc=gov,dc=br"
        String domainLDap = "uid=USUARIO_LDAP,ou=people,dc=ORGAO,dc=pi,dc=gov,dc=br";
        String[] loginPartes = new String[2];
        loginPartes = login.toLowerCase().split("@");
        String usuario = loginPartes[0];

        String domain = loginPartes[1].toString();

        String[] domainPedacos = new String[4];
        domainPedacos = domain.split("\\.");
        String orgao = domainPedacos[0];

        domainLDap = domainLDap.replace("USUARIO_LDAP", usuario).replace("ORGAO", orgao);

        return domainLDap;
    }

    public static String retiraCaracteresEspeciais(String stringFonte) {
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

    public static Integer getAnoAtual() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy");
        Integer ano = new Integer(formato.format(new Date()));
        return ano;
    }

    public static String convertDateToString(Date date, int tipo) {
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
        if (tipo == 12) {
            formataData = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        }

        String data = formataData.format(date);

        return data;
    }

    public static String format(String pattern, Object value) {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String moeda(BigDecimal num) {
        NumberFormat formatter = new DecimalFormat("##,###,###,###,###,###,###,##0.00");

        return formatter.format(num.doubleValue());
    }

    public static String valorPorExtenso(double vlr) {
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

    public static BigDecimal calcularPorcentagem(BigDecimal porcentagem, BigDecimal valor) {
        BigDecimal retorno = BigDecimal.ZERO;

        if (valor == null || porcentagem == null) {
            return BigDecimal.ZERO;
        }

        retorno = valor.multiply(porcentagem).divide(new BigDecimal(100), 2, RoundingMode.DOWN);

        return retorno;
    }

    public static BigDecimal calcularPorcPeloValor(BigDecimal total, BigDecimal valor) {
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

    public static String getTextoUmSFP() {
        String texto = "          Solicito acesso ao  <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">Sistema de Folha de Pagamento - SFP</style>"
                + "de acordo com as condições descritas\n"
                + "no termo abaixo e ciente das responsabilidades de acordo com a legislação atual em vigor.";
        return (texto);
    }

    public static String getTextoDoisSFP() {
        String texto = "<style size=\"10\" align=\"Justify\">"
                + "Todas e quaisquer  informações contidas no Sistema <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">SFP</style>, "
                + "ou em  qualquer  outro banco de dados ou\n"
                + "software  vinculados direta ou  indiretamento ao Estado do Piauí, deverão ser utilizadas única e\n"
                + "exclusivamente no  âmbito do interesse público,  resguardando o sigilo de todos e quaisquer dados;\n"
                + "fica vedada a permissão de uso, sem autorização prévia escrita e expressa do superior hierárquico, por\n"
                + "terceiros, de todas e quaisquer  informações condidas neste Sistema, ou em  qualquer outro banco de\n"
                + "dados ou software vinculados direta ou  indiretamente ao Estado do Piauí;  o uso da senha de acesso ao\n"
                + "sistema é pessoal e intransferível,  sendo vedado o repasse ou a utilização por  qualquer forma e modo\n"
                + "por terceiros,sob pena de responsabilidade.\n"
                + "Desta forma, DECLARO, para os  devidos fins de  direito que  li e estou ciente, e concordo, por livre e\n"
                + "espontânea vontade, como o que está previsto no presente termo, assumindo a responsabilidade pelo\n"
                + "uso indevido, incorreto, ilícito e/ou ilegal de toda e quaisquer informações contidas neste Sistema, em\n"
                + "qualquer outro banco de dados ou software inculados direta ou indiretamente ao Estado do Piauí, ou\n"
                + "na forma da Lei, em especial os arts. 313-A, 313-B, 316, 319, 320, 321 e 325, do Código Penal, e os art.\n"
                + "137, II, III, VIII, e art. 138, IX, XII, XV, XVII da Lei Complementar Estadual nº 13, de 03 de janeiro de 1994.\n"
                + "</style>";
        return (texto);
    }

    public static String getTextoUmINFOFOLHA() {
        String texto = "          Solicito acesso ao  "
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">Sistema de Informações Gerenciais da Folha de Pagamento - INFOFOLHA</style> "
                + "de \n acordo com as condições descritas no termo abaixo e "
                + "ciente das responsabilidades de acordo com a \n legislação atual em vigor.";
        return (texto);
    }

    public static String getTextoDoisINFOFOLHA() {
        String texto = "<style size=\"10\" align=\"Justify\">"
                + "Todas e quaisquer  informações  contidas  no  Sistema <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">INFOFOLHA</style>, "
                + "ou  em qualquer  outro  banco  de\n"
                + "dados ou software vinculados direta ou indiretamento ao Estado do Piauí, deverão ser utilizadas única\n"
                + "e  exclusivamente no  âmbito do interesse  público, resguardando o sigilo de todos e quaisquer dados;\n"
                + "fica vedada a  permissão de uso, sem autorização  prévia  escrita e expressa  do  superior hierárquico,\n"
                + "por terceiros, de todas e  quaisquer informações condidas neste Sistema,  ou em qualquer outro banco\n"
                + "de dados ou software vinculados direta ou indiretamente ao Estado do Piauí; o uso da senha de acesso\n"
                + "ao sistema é pessoal e  intransferível,  sendo vedado o  repasse ou a utilização por qualquer forma  e\n"
                + "modo por terceiros, sob pena de responsabilidade. \n"
                + "Desta forma, DECLARO, para os devidos fins de direito que li e estou  ciente, e concordo, por livre e\n"
                + "espontânea  vontade, como o  que está  previsto  no presente  termo, assumindo a  responsabilidade\n"
                + "pelo uso indevido, incorreto, ilícito e/ou ilegal de toda e quaisquer informações contidas neste Sistema,\n"
                + "ou em qualquer outro banco de dados ou  software inculados direta ou  indiretamente ao  Estado do,\n"
                + "Piauí na forma  da Lei, em  especial os arts. 313-A, 313-B, 316, 319, 320, 321 e 325, do  Código Penal,\n"
                + "e os art. 137, II, III, VIII, e art. 138, IX, XII, XV, XVII da Lei  Complementar  Estadual nº 13, de 03 de\n"
                + "janeiro de 1994.</style>";
        return (texto);
    }

    public static boolean isNullOrEmpty(String s) {
        return (s == null || s.equals(""));
    }

    public static BigDecimal diferencaEntreDadas(Date dataInicial, Date dataFinal, Conversao conversao) {

        BigDecimal tempo = BigDecimal.ZERO;

        Calendar dataInicialTemp = Calendar.getInstance();
        dataInicialTemp.setTime(dataInicial);

        Calendar dataFinalTemp = Calendar.getInstance();

        if (dataFinal != null) {
            dataFinalTemp.setTime(dataFinal);
        } else {
            dataFinalTemp.setTime(new Date());
        }

        Long milisegundos = (dataFinalTemp.getTimeInMillis() - dataInicialTemp.getTimeInMillis());

        if (conversao == Conversao.MINUTO) {
            tempo = (new BigDecimal(milisegundos)).divide(new BigDecimal(60000), RoundingMode.HALF_UP);
        }

        if (conversao == Conversao.HORA) {
            tempo = (new BigDecimal(milisegundos)).divide(new BigDecimal(3600000), RoundingMode.HALF_UP);
        }

        if (conversao == Conversao.DIA) {
            tempo = (new BigDecimal(milisegundos)).divide(new BigDecimal(86400000), RoundingMode.HALF_UP);
        }

        return tempo;
    }

    /**
     * Retorna a data passada como parametro por extenso
     *
     * @param data
     * @return
     */
    public static String getDataPorExtenso(Date data) {
        DateFormat dfmt = new SimpleDateFormat("d 'de' MMMM 'de' yyyy");
        return dfmt.format(data);
    }

    /**
     * Retorna a data passada como parametro por extenso
     *
     * @param dataInicial
     * @param dataFinal
     * @return
     */
    public static String getPeriodoPorExtenso(Date dataInicial, Date dataFinal) {

        DateFormat dfmt = new SimpleDateFormat("HH:mm 'do dia'  dd/MM/yyyy");

        String periodo = "Período: ";

        if (dataInicial != null) {
            periodo = periodo.concat(dfmt.format(dataInicial));
        } else {
            periodo = periodo.concat(" --");
        }

        periodo = periodo.concat(" as ");

        if (dataFinal != null) {
            periodo = periodo.concat(dfmt.format(dataFinal));
        } else {
            periodo = periodo.concat(" -- ");
        }

        return periodo;
    }
    
    public static boolean stringEhDoobleValido (String s) {
    try {
        Double.parseDouble (s); 
        return true;
    } catch (NumberFormatException ex) {
        return false;
    }
}
}
