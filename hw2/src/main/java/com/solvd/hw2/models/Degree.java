package com.solvd.hw2.models;

import java.util.ArrayList;
import com.solvd.hw2.models.abstracts.Model;

public class Degree extends Model
{
    private static final String DEGREE_ID_COL = "degreeId";
    private static final String DEGREE_NAME_COL = "degreeName";
    private static final String YEAR_COL = "numOfYears";

    private Integer id;
    private String degreeName;
    private Integer numOfYears;

    public Degree(Integer id, String degreeName, Integer numOfYears) 
    {
        this.id = id;
        this.degreeName = degreeName;
        this.numOfYears = numOfYears;
    }


    public ArrayList<Object> getVals()
    {
        ArrayList<Object> ret = new ArrayList<Object>();

        if (id != null)
        {
            ret.add(id);
        }
        
        if (degreeName != null)
        {
            ret.add(degreeName);
        }

        if (numOfYears != null)
        {
            ret.add(numOfYears);
        }

        return ret;
    }
    
    public ArrayList<String> getFields()
    {
        ArrayList<String> toRet = new ArrayList<String>();

        if (id != null)
        {
            toRet.add(DEGREE_ID_COL);
        }

        if (degreeName != null)
        {
            toRet.add(DEGREE_NAME_COL);
        }

        if (numOfYears != null)
        {
            toRet.add(YEAR_COL);
        }

        return toRet;
    }




    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

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
}
