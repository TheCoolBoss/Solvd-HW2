package com.solvd.hw2.models;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.solvd.hw2.models.abstracts.Model;

@XmlRootElement (name="degree")
@JsonRootName ("degree")
public class Degree extends Model
{
    private static final String DEGREE_ID_COL = "degreeId";
    private static final String DEGREE_NAME_COL = "degreeName";
    private static final String YEAR_COL = "numOfYears";

    private Integer id;
    private String degreeName;
    private Integer numOfYears;

    public Degree(){}
    
    public Degree(Integer id, String degreeName, Integer numOfYears) 
    {
        this.id = id;
        this.degreeName = degreeName;
        this.numOfYears = numOfYears;
        populateFieldsAndVals();
    }

    protected void populateFieldsAndVals()
    {
        if (id != null)
        {
            vals.add(id);
            fields.add(DEGREE_ID_COL);
        }

        if (degreeName != null)
        {
            vals.add(degreeName);
            fields.add(DEGREE_NAME_COL);
        }

        if (numOfYears != null)
        {
            vals.add(numOfYears);
            fields.add(YEAR_COL);
        }
    }

    @JsonGetter ("degreeId")
    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    @JsonGetter ("degreeName")
    public String getDegreeName() 
    {
        return degreeName;
    }

    public void setDegreeName(String degreeName) 
    {
        this.degreeName = degreeName;
    }

    public int getNumOfYears() 
    {
        return numOfYears;
    }

    public void setNumOfYears(int numOfYears) 
    {
        this.numOfYears = numOfYears;
    }

    public String toString()
    {
        return
        "Degree " + degreeName + ":\n"
        + "Years required: " + numOfYears;
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
