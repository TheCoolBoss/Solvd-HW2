package com.solvd.hw2.factories;

import java.io.IOException;

import com.solvd.hw2.services.interfaces.*;
import com.solvd.hw2.services.jdbc.*;
import com.solvd.hw2.services.mybatis.*;

public class ServiceFactory 
{
    public static IExperimentService makeExpService(String type) throws IOException
    {
        if (type.equals("jdbc"))
        {
            return new ExperimentService();
        }

        else if (type.equals("mybatis"))
        {
            return new ExperimentServiceMB();
        }

        else
        {
            return null;
        }
    }


    public static IClientService makeClientService(String type) throws IOException
    {
        if (type.equals("jdbc"))
        {
            return new ClientService();
        }

        else if (type.equals("mybatis"))
        {
            return new ClientServiceMB();
        }

        else
        {
            return null;
        } 
    }

    public static IEmployeeService makeEmployeeService(String type) throws IOException
    {
        if (type.equals("jdbc"))
        {
            return new EmployeeService();
        }

        else if (type.equals("mybatis"))
        {
            return new EmployeeServiceMB();
        }

        else
        {
            return null;
        } 
    }
}
