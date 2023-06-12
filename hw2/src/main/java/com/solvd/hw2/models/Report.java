package com.solvd.hw2.models;

import com.solvd.hw2.models.abstracts.Model;

public class Report extends Model
{
    private static final String ID_COL = "locId";
    private static final String NAME_COL = "reportName";
    private static final String LINK_COL = "link";

    private Integer id;
    private String name;
    private String link;

    public Report(Integer id, String name, String link) 
    {
        this.id = id;
        this.name = name;
        this.link = link;
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

    public Integer getId() 
    {
        return id;
    }

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getLink() 
    {
        return link;
    }

    public void setLink(String link) 
    {
        this.link = link;
    }

    
}
