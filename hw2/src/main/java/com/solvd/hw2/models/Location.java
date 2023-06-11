package com.solvd.hw2.models;

import java.util.ArrayList;

public class Location 
{
    private static final String ID_COL = "locId";
    private static final String CITY_COL = "city";
    private static final String COUNTRY_COL = "country";

    private Integer id;
    private String city;
    private String country;


    public Location(Integer id, String city, String country) 
    {
        this.id = id;
        this.city = city;
        this.country = country;
    }


    public ArrayList<Object> getVals()
    {
        ArrayList<Object> ret = new ArrayList<Object>();

        if (id != null)
        {
            ret.add(id);
        }

        if (city != null)
        {
            ret.add(city);
        }

        if (country != null)
        {
            ret.add(city);
        }

        return ret;
    }
    

    public ArrayList<String> getFields()
    {
        ArrayList<String> toRet = new ArrayList<String>();
        
        if (id != null)
        {
            toRet.add(ID_COL);
        }

        if (city != null)
        {
            toRet.add(CITY_COL);
        }

        if (country != null)
        {
            toRet.add(CITY_COL);
        }

        return toRet;
    }


    public Integer getId() 
    {
        return id;
    }

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public String getCity() 
    {
        return city;
    }

    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCountry() 
    {
        return country;
    }

    public void setCountry(String country) 
    {
        this.country = country;
    }

    
}
