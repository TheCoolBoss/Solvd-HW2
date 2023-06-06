package com.solvd.hw2.models;

//Does not include a col added from part 2
public class Lab 
{
    private int id;
    private String name;
    private int locationId;
    private int institutionId;

    public Lab(int id, String name, int locationId, int institutionId) 
    {
        this.id = id;
        this.name = name;
        this.locationId = locationId;
        this.institutionId = institutionId;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
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

    public int getLocationId() 
    {
        return locationId;
    }

    public void setLocationId(int locationId) 
    {
        this.locationId = locationId;
    }

    public int getInstitutionId() 
    {
        return institutionId;
    }

    public void setInstitutionId(int institutionId) 
    {
        this.institutionId = institutionId;
    }

}
