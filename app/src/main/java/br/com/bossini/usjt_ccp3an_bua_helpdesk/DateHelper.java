package br.com.bossini.usjt_ccp3an_bua_helpdesk;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    private static SimpleDateFormat sdf =
            new SimpleDateFormat("dd/MM/yy hh:mm");

    public static String format (Date date){
        return sdf.format(date);
    }
}
