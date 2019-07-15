package helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Timestamp;
import java.util.TimeZone;

public class Global {

    public static String URL_API = "https://api.darksky.net/forecast/5da6fcf3c2f3678570f6051bd00f1c07/";

    public static String getFecha(int fecha, String timezone){
        Date time = new Date(fecha*1000L);
        SimpleDateFormat jdf = new SimpleDateFormat("HH:mm:ss");
        jdf.setTimeZone(TimeZone.getTimeZone(timezone));

        return jdf.format(time);
    }

    public static String getGrades(double fahrenheit){
        double celsius     = ( 5 *(fahrenheit - 32.0)) / 9.0;
        int celsiusRounded = (int) Math.round(celsius);

        return String.valueOf(celsiusRounded)+"°C";
    }

    public static void chekError(){
        if(Math.random() < 0.1){
            throw new Error("How unfortunate! The API Request Failed");
        }
    }

    public static String getTime(){
        long time = new Date().getTime();
        return new Timestamp(time).toString();
    }

}