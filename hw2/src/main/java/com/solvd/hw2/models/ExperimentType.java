package com.solvd.hw2.models;

import com.solvd.hw2.models.abstracts.Model;

public class ExperimentType extends Model
{
    private static final String ID_COL = "expTypeId";
    private static final String TYPE_COL = "expTypeName";

    private Integer id;
    private String typeName;

    public ExperimentType(Integer id, String typeName) 
    {
        this.id = id;
        this.typeName = typeName;
        populateFieldsAndVals();
    }

    
    protected void populateFieldsAndVals()
    {
        if (id != null)
        {
            vals.add(id);
            fields.add(ID_COL);
        }

        if (typeName != null)
        {
            vals.add(typeName);
            fields.add(TYPE_COL);
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

    public String getTypeName() 
    {
        return typeName;
    }

    public void setTypeName(String typeName) 
    {
        this.typeName = typeName;
    }
    
}
