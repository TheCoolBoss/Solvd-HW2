package com.solvd.hw2.models.abstracts;

import java.util.ArrayList;

public abstract class Model 
{
    protected ArrayList<Object> vals = new ArrayList<Object>();
    protected ArrayList<String> fields = new ArrayList<String>();

    public ArrayList<String> getFields()
    {
        return fields;
    }

    public ArrayList<Object> getVals()
    {
        return vals;
    }

    protected abstract void populateFieldsAndVals();
}
