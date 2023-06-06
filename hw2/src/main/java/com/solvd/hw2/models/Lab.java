package com.solvd.hw2.models;

//Does not include a col added from part 2's update
public class Lab 
{
    private int id;
    private String name;
    private Location location;
    private Institution institution;

    public Lab(int id, String name, Location location, Institution institution) 
    {
        this.id = id;
        this.name = name;
        this.location = location;
        this.institution = institution;
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

    public Location getLocation() 
    {
        return location;
    }

    public void setLocation(Location location) 
    {
        this.location = location;
    }

    public Institution getInstitution() 
    {
        return institution;
    }

    public void setInstitution(Institution institution) 
    {
        this.institution = institution;
    }



}
