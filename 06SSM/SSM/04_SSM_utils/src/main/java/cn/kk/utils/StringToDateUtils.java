package cn.kk.utils;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateUtils implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        try {
            if (source == null){
                throw new RuntimeException("source is null");
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("format wrong");
        }
    }
}
