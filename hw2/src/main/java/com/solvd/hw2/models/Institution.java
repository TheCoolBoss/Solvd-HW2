package com.solvd.hw2.models;

import java.util.ArrayList;
import com.solvd.hw2.models.abstracts.Model;

public class Institution extends Model
{
    private static final String ID_COL = "institutionId";
    private static final String NAME_COL = "institutionName";

    private Integer id;
    private String name;

    private ArrayList<Object> vals = new ArrayList<Object>();
    private ArrayList<String> fields = new ArrayList<String>();

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
}
