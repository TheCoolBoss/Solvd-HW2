package com.solvd.hw2.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.solvd.hw2.models.abstracts.Model;


@XmlRootElement (name="scientist")
@XmlAccessorType (XmlAccessType.FIELD)
@JsonRootName (value="scientist")
@JsonInclude (JsonInclude.Include.NON_NULL)
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

    public Scientist(){}

    public Scientist(Integer id, String firstName, String lastName, Degree degree) 
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.degree = degree;
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

    public String toString()
    {
        return
        "Scientist " + firstName + " " + lastName + ":\n"
        + "Id: " + id + "\n"
        + "Degree: " + degree.getDegreeName();
    }
}
