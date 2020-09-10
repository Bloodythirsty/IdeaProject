package cn.kk.utils;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
        把字符串转换成日期
 */
@Component("stringToDate")
public class StringToDate implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        try {
            if (source == null) {
                throw new RuntimeException("source should not null");
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("格式错误");
        }
    }
}
