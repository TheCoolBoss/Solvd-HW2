package com.solvd.hw2.models;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.solvd.hw2.models.abstracts.Model;

@XmlRootElement (name="institution")
@XmlAccessorType (XmlAccessType.FIELD)
public class Institution extends Model
{
    private static final String ID_COL = "institutionId";
    private static final String NAME_COL = "institutionName";

    @XmlElement (name="institutionId")
    private Integer id;

    @XmlElement (name="institutionName")
    private String name;

    private ArrayList<Object> vals = new ArrayList<Object>();
    private ArrayList<String> fields = new ArrayList<String>();

    public Institution(){}
    
    public Institution(Integer id, String name)
    {
        this.id = id;
        this.name = name;
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
    }

    public Integer getId() 
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String toString()
    {
        return
        "Institution " + name + ":\n"
        + "Id: " + id;
    }
}
