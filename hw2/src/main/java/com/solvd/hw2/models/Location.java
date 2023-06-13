package com.solvd.hw2.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.solvd.hw2.models.abstracts.Model;

@XmlRootElement (name="location")
@XmlAccessorType (XmlAccessType.FIELD)
public class Location extends Model
{
    private static final String ID_COL = "locId";
    private static final String CITY_COL = "city";
    private static final String COUNTRY_COL = "country";

    @XmlElement (name="locationId")
    private Integer id;

    private String city;
    private String country;

    public Location(){}
    
    public Location(Integer id, String city, String country) 
    {
        this.id = id;
        this.city = city;
        this.country = country;
    }

    protected void populateFieldsAndVals()
    {
        if (id != null)
        {
            vals.add(id);
            fields.add(ID_COL);
        }

        if (city != null)
        {
            vals.add(city);
            fields.add(CITY_COL);
        }

        if (country != null)
        {
            vals.add(country);
            fields.add(COUNTRY_COL);
        }
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

    public String toString()
    {
        return
        "Location " + city + ", " + country + ":\n"
        + "Id: " + id;
    }
}
