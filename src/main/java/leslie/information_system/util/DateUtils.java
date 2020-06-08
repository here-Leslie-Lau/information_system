package epidemic.epidemic_system.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


//日期的工具类
public class DateUtils {
    public static Timestamp getSqlTimestamp(){
        Date date = new Date();

        Timestamp timestamp = new Timestamp(date.getTime());

        return timestamp;
    }

    public static Timestamp getSqlTimestamp(Date date){

        Timestamp timestamp = new Timestamp(date.getTime());

        return timestamp;
    }

    public static java.sql.Date getSqlDate(){
        Date date = new Date();

        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        return sqlDate;
    }

    public static java.sql.Date getSqlDate(Date date){

        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        return sqlDate;
    }

    public static String getFormatDate(){
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public static String getFormatDate(Date date){
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

}