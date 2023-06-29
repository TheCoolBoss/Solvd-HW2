package com.solvd.hw2.models.abstracts;

import java.util.ArrayList;

public abstract class Model 
{
    protected ArrayList<Object> vals = new ArrayList<Object>();
    protected ArrayList<String> fields = new ArrayList<String>();

    public abstract ArrayList<String> getFields();
    public abstract ArrayList<Object> getVals();
    protected abstract void populateFieldsAndVals();
}
