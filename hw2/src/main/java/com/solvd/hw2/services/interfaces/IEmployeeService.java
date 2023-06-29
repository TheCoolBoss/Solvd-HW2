package com.solvd.hw2.services.interfaces;

import com.solvd.hw2.models.Scientist;

public interface IEmployeeService 
{
    public Scientist getScientistById(int id);
    public void insertScientist(Scientist toInsert);
    public void updateScientist(Scientist newVals);
}
