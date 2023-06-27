package com.solvd.hw2.builders;

public class ExperimentTypeBuilder 
{
    private Integer id;
    private String typeName;

    public ExperimentTypeBuilder withId(int id)
    {
        this.id = id;
        return this;
    }

    public ExperimentTypeBuilder withName(String name)
    {
        typeName = name;
        return this;
    }

    public Integer getId() 
    {
        return id;
    }

    public String getTypeName() 
    {
        return typeName;
    }

    
}
