package com.he.utill;

import org.bson.codecs.jsr310.LocalDateCodec;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormatUtill {


    // 定义日期格式化器，指定日期格式
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年-MM月-dd日");

    //将数据解析为LocalDate
    public static LocalDate myLocalDateParse(Integer year,Integer month ,Integer date) throws ParseException {
        System.out.println("转换======》"+"year:"+year+"month:"+month+"date:"+date);
        LocalDate parselocalDate = LocalDate.of(year,month,date);
        System.out.println("转换结果======》"+parselocalDate);

        return parselocalDate;
    }
    //将数据解析为LocalDate
    public static LocalDate myLocalDateParse(String dateStr) throws ParseException {
        System.out.println("转换======》"+"dateStr:"+dateStr);
        LocalDate parselocalDate = LocalDate.parse(dateStr);
        System.out.println("转换结果======》"+parselocalDate);

        return parselocalDate;
    }
    //LocalDate设置日期格式,并返回对应格式字符串
    public static String myLocalDateFormat(LocalDate localDate) throws ParseException {
        System.out.println("转换======》"+localDate);
        String dateString = formatter.format(localDate);
        System.out.println("转换结果======》"+dateString);

        return dateString;
    }

    public static void main(String[] args) throws ParseException {


        System.out.println(myLocalDateParse("2021-08-04"));
        System.out.println(myLocalDateParse(2021,8,4));
//        System.out.println(myLocalDateFormat());
    }
}
