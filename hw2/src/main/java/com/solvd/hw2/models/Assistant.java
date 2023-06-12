package com.solvd.hw2.models;

import com.solvd.hw2.models.abstracts.Model;

public class Assistant extends Model
{
    private static final String ID_COL = "assistantId";
    private static final String FIRST_NAME_COL = "firstName";
    private static final String LAST_NAME__COL = "lastName";
    private static final String ASSISTEE_COL = "assisteeId";

    private Integer id;
    private String firstName;
    private String lastName;
    private Scientist assistee;

    public Assistant(Integer id, String firstName, String lastName, Scientist assistee)
    {
        this.id= id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.assistee = assistee;
        populateFieldsAndVals();
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
            fields.add(LAST_NAME__COL);
        }

        if (assistee != null)
        {
            vals.add(assistee.getId());
            fields.add(ASSISTEE_COL);
        }
    }
    
    public Integer getId() 
    {
        return id;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }


    public void setId(Integer id) 
    {
        this.id = id;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }


    public Scientist getAssistee()
    {
        return assistee;
    }

    public void setAssistee(Scientist assistee) 
    {
        this.assistee = assistee;
    }

}
