package com.solvd.hw2.services.mybatis;

import java.io.IOException;
import com.solvd.hw2.dao.mybatis.ScientistMBDao;
import com.solvd.hw2.models.Scientist;
import com.solvd.hw2.services.abstracts.ServiceMB;
import com.solvd.hw2.services.interfaces.IEmployeeService;

public class EmployeeServiceMB extends ServiceMB implements IEmployeeService
{
    private ScientistMBDao scientistDao;

    public EmployeeServiceMB() throws IOException
    {
        setUpService();
        scientistDao = new ScientistMBDao(factory);
    }

    public void insertScientist(Scientist toInsert)
    {
        scientistDao.insertScientist(toInsert);
    }

    public Scientist getScientistById(int id)
    {
        return scientistDao.getScientistById(id);
    }

    public void updateScientist(Scientist newVals)
    {
        scientistDao.updateScientist(newVals);
    }
}
