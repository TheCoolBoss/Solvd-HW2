package com.solvd.hw2.jaxb.adapters;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date>
{
    private static final ThreadLocal<DateFormat> FORMAT = new ThreadLocal<DateFormat>()
    {
        protected DateFormat initialValue()
        {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public Date unmarshal(String str) throws ParseException
    {
        return FORMAT.get().parse(str);
    }

    public String marshal(Date date)
    {
        return FORMAT.get().format(date);
    }
}
