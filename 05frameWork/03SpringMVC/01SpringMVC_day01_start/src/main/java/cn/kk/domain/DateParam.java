package cn.kk.domain;

import java.util.Date;

public class DateParam {

    private Date date;

    @Override
    public String toString() {
        return "DateParam{" +
                "date=" + date +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
