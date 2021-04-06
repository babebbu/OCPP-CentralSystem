package dev.babebbu.ev.ocpp.centralsystem.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateFormatter {

    public static String parseISO8601(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Bangkok"));
        return simpleDateFormat.format(date);
    }

}
