package com.solvd.hw2.models;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.solvd.hw2.models.abstracts.Model;

@XmlRootElement (name="report")
@XmlAccessorType (XmlAccessType.FIELD)
public class Report extends Model
{
    private static final String ID_COL = "reportId";
    private static final String NAME_COL = "reportName";
    private static final String LINK_COL = "link";

    @XmlElement (name="reportId")
    private Integer id;
    
    @XmlElement (name="reportName")
    private String name;

    private String link;

    public Report(){}

    public Report(Integer id, String name, String link) 
    {
        this.id = id;
        this.name = name;
        this.link = link;
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

        if (link != null)
        {
            vals.add(link);
            fields.add(LINK_COL);
        }
    }

    @JsonGetter ("reportId")
    public Integer getId() 
    {
        return id;
    }

    public void setId(Integer id) 
    {
        this.id = id;
    }

    @JsonGetter ("reportName")
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    @JsonGetter ("link")
    public String getLink() 
    {
        return link;
    }

    public void setLink(String link) 
    {
        this.link = link;
    }

    public String toString()
    {
        return
        "Report " + name + ":\n"
        + "Id: " + id + "\n"
        + "URL: " + link;
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
