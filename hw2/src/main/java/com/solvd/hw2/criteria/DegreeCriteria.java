package com.solvd.hw2.criteria;
import java.util.ArrayList;

public class DegreeCriteria extends Criteria
{
    private Integer id;
    private String name;
    private Integer years;
    private static final String DEGREE_ID_COL = "degreeId";
    private static final String DEGREE_NAME_COL = "degreeName";
    private static final String YEAR_COL = "numOfYears";

    public DegreeCriteria(int id, String name, Integer years)
    {
        this.id = id;
        this.name = name;
        this.years = years;
    }

    public ArrayList<Object> getVals()
    {
        ArrayList<Object> ret = new ArrayList<Object>();
        ret.add(Integer.valueOf(id));
        ret.add(name);
        ret.add(years);

        return ret;
    }
    
    public ArrayList<String> getFields()
    {
        ArrayList<String> toRet = new ArrayList<String>();
        if (id != null)
        {
            toRet.add(DEGREE_ID_COL);
        }

        if (name != null)
        {
            toRet.add(DEGREE_NAME_COL);
        }

        if (years != null)
        {
            toRet.add(YEAR_COL);
        }

        return toRet;
    }

    public String getName()
    {
        return name;
    }

    public int getYears()
    {
        return years;
    }

}
