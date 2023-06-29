package com.solvd.hw2.services.interfaces;

import com.solvd.hw2.models.Experiment;

public interface IExperimentService 
{
    public void insertExperiment(Experiment toInsert);
    public Experiment getExperimentById(int id);
    public void updateExperiment(Experiment newVals);
}
