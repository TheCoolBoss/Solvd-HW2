package com.solvd.hw2.models;

import java.util.ArrayList;
import java.util.List;
import com.solvd.hw2.models.abstracts.Model;

public class Scientist extends Model
{   
    private static final String ID_COL = "scientistId";
    private static final String FIRST_NAME_COL = "firstName";
    private static final String LAST_NAME_COL = "lastName";
    private static final String DEGREE_COL = "degreeId"; 

    private Integer id;
    private String firstName;
    private String lastName;
    private Degree degree;
    private List<Experiment> experiments;

    public Scientist(Integer id, String firstName, String lastName, Degree degree) 
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.degree = degree;
        experiments = new ArrayList<Experiment>();
    }

    
    protected void populateFieldsAndVals()
    {
        if (id != null)
        {
            vals.add(id);
            fields.add(ID_COL);
        }

        if (firstName != null)
        {
            vals.add(firstName);
            fields.add(FIRST_NAME_COL);
        }

        if (lastName != null)
        {
            vals.add(lastName);
            fields.add(LAST_NAME_COL);
        }

        if (degree != null)
        {
            vals.add(degree.getId());
            fields.add(DEGREE_COL);
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

    public String getFirstName() 
    {
        return firstName;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }

    public Degree getDegree() 
    {
        return degree;
    }

    public void setDegree(Degree degree) 
    {
        this.degree = degree;
    }

    public List<Experiment> getExperiments() 
    {
        return experiments;
    }

    public void setExperiments(List<Experiment> experiments) 
    {
        this.experiments = experiments;
    }
}
