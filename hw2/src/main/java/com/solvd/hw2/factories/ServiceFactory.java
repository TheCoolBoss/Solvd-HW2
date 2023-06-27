package com.solvd.hw2.factories;

import com.solvd.hw2.models.Assistant;
import com.solvd.hw2.models.Client;
import com.solvd.hw2.models.Scientist;
import com.solvd.hw2.models.interfaces.Person;

public class ServiceFactory 
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
