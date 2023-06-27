package com.solvd.hw2.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.solvd.hw2.builders.ExperimentTypeBuilder;
import com.solvd.hw2.models.abstracts.Model;

@XmlRootElement (name="experimentType")
@JsonRootName ("experimentType")
public class ExperimentType extends Model
{
    private static final String ID_COL = "expTypeId";
    private static final String TYPE_COL = "expTypeName";

    private Integer id;
    private String typeName;

    public ExperimentType(){}

    public ExperimentType(ExperimentTypeBuilder expTypeBuilder)
    {
        this.id = expTypeBuilder.getId();
        this.typeName = expTypeBuilder.getTypeName();
    }
    
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
    
    @JsonGetter ("experimentTypeId")
    public Integer getId() 
    {
        return id;
    }

    @XmlElement (name="experimentTypeId")
    public void setId(Integer id) 
    {
        this.id = id;
    }

    @JsonGetter ("experimentTypeName")
    public String getTypeName() 
    {
        return typeName;
    }

    @XmlElement (name="experimentTypeName")
    public void setTypeName(String typeName) 
    {
        this.typeName = typeName;
    }

    public String toString()
    {
        return
        "Experiment type " + typeName + ":\n"
        + "Id: " + id;
    }
    
}
