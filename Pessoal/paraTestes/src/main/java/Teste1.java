
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author KillerBeeTwo
 */
public class Teste1 {

    public static void main(String[] args) {
        Calendar dataInicial = Calendar.getInstance();

        dataInicial.set(Calendar.DAY_OF_MONTH, 19);
        dataInicial.set(Calendar.MONTH, 5);
        dataInicial.set(Calendar.YEAR, 2017);

        Calendar horaInicial = Calendar.getInstance();

        horaInicial.set(Calendar.HOUR, 6);
        horaInicial.set(Calendar.MINUTE, 00);
        horaInicial.set(Calendar.SECOND, 00);

        System.out.println(new Date());
        System.out.println(getDataComHora(dataInicial.getTime(), horaInicial.getTime()));

        System.out.println(getTempoAtendimentoEmMinutos(getDataComHora(dataInicial.getTime(), horaInicial.getTime())));
    }

    public static Date getDataComHora(Date dataInicial, Date horaInicial) {

        SimpleDateFormat hours = new SimpleDateFormat("hh");
        SimpleDateFormat minutes = new SimpleDateFormat("mm");
        SimpleDateFormat secounds = new SimpleDateFormat("ss");

        Calendar dataInicialTemp = Calendar.getInstance();
        dataInicialTemp.setTime(dataInicial);

        dataInicialTemp.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hours.format(horaInicial)));
        dataInicialTemp.set(Calendar.MINUTE, Integer.parseInt(minutes.format(horaInicial)));
        dataInicialTemp.set(Calendar.SECOND, Integer.parseInt(secounds.format(horaInicial)));

        return dataInicialTemp.getTime();
    }

    public static Long getTempoAtendimentoEmMinutos(Date dataInicial) {

        if (dataInicial == null) {
            return 0L;
        }

        Calendar dataInicialTemp = Calendar.getInstance();
        dataInicialTemp.setTime(dataInicial);

        Calendar dataFinalTemp = Calendar.getInstance();
        dataFinalTemp.setTime(new Date());

        Long milisegundos = (dataFinalTemp.getTimeInMillis() - dataInicialTemp.getTimeInMillis());

        return (milisegundos / 60000);
    }

}
