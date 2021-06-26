package br.com.wscomvix.myapp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

public class Utils {

    /**
     * Recebe uma data e retorna uma string formatada
     * @author Wanderlei Silva do Carmo <wander.silva@gmail.com>
     * @param date
     * @return
     */
    public static String fromDateToString(Date date){

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String retorno = formato.format(date);

        return retorno;
    }

    /**
     * Retorna uma data a partir de uma string no formato dd/MM/yyyy
     * @author Wanderlei Silva do Carmo <wander.silva@gmail.com>
     * @param dateString
     * @return
     */
    public static Date fromStringToDate(String dateString){
        Date dataFormatada = null;

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        try {
            dataFormatada = formato.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dataFormatada;
    }

}
