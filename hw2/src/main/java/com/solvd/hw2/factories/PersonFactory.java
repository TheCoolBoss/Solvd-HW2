package com.solvd.hw2.factories;

import com.solvd.hw2.models.*;
import com.solvd.hw2.models.interfaces.Person;

public class PersonFactory 
{
    public static Person getPerson(String type)
    {
        if (type.equals("assistant"))
        {
            return new Assistant();
        }

        else if (type.equals("client"))
        {
            return new Client();
        }

        else if (type.equals("scientist"))
        {
            return new Scientist();
        }
        
        else
        {
            return null;
        }
    }
}
