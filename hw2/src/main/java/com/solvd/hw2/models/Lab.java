package com.solvd.hw2.models;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.solvd.hw2.models.abstracts.Model;

@XmlRootElement (name="lab")
@XmlAccessorType (XmlAccessType.FIELD)
@JsonRootName("lab")
public class Lab extends Model
{
    private static final String ID_COL = "labId";
    private static final String NAME_COL = "labName";
    private static final String LOCATION_COL = "locationId";
    private static final String INST_COL = "institutionId";

    @XmlElement (name="labId")
    private Integer id;

    @XmlElement (name="labName")
    private String name;
    
    private Location location;
    private Institution institution;

    public Lab(){}

    public Lab(Integer id, String name, Location location, Institution institution) 
    {
        this.id = id;
        this.name = name;
        this.location = location;
        this.institution = institution;
        populateFieldsAndVals();
    }

    protected void populateFieldsAndVals()
    {
        if (id != null)
        {
            vals.add(id);
            fields.add(ID_COL);
        }

        if (name != null)
        {
            vals.add(name);
            fields.add(NAME_COL);
        }

        if (location != null)
        {
            vals.add(location.getId());
            fields.add(LOCATION_COL);
        }

        if (institution != null)
        {
            vals.add(institution.getId());
            fields.add(INST_COL);
        }
    }
    
    @JsonGetter ("labId")
    public Integer getId() 
    {
        return id;
    }

    public void setId(Integer id) 
    {
        this.id = id;
    }

    @JsonGetter ("labName")
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public Location getLocation() 
    {
        return location;
    }

    public void setLocation(Location location) 
    {
        this.location = location;
    }

    public Institution getInstitution() 
    {
        return institution;
    }

    public void setInstitution(Institution institution) 
    {
        this.institution = institution;
    }

    public String toString()
    {
        return
        "Lab " + name + " of institution " + institution.getName() + ":\n"
        + "Id: " + id + "\n"
        + "Location: " + location.getCity() + ", " + location.getCountry();
    }

    public ArrayList<String> getFields()
    {
        return this.fields;
    }

    public ArrayList<Object> getVals()
    {
        return this.vals;
    }
}
