package com.solvd.hw2.services;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.solvd.hw2.CustomPool;
import com.solvd.hw2.dao.ExperimentDao;
import com.solvd.hw2.models.Experiment;
import com.solvd.hw2.models.Scientist;

public class ExperimentService 
{
    private static final ExperimentDao EXP_DAO = new ExperimentDao();
    private static final String EXP_TABLE = "experiments";
    private static final String GROUP_TABLE = "experimentGroups";

    //Inserts data into experiment group table 
    public void insertIntoGroups(List<Experiment> list) throws SQLException
    {
        for (Experiment experiment : list) 
        {
            for (Scientist scientist : experiment.getScientists()) 
            {
                String query = "insert into " + GROUP_TABLE + " (scientistId, experimentId) values (?, ?)";
                PreparedStatement stmt = CustomPool.getConn().prepareStatement(query);
                stmt.setInt(1, scientist.getId());
                stmt.setInt(2, experiment.getId());
                stmt.executeUpdate();
            }

        }
    }

    public void insertExp(Experiment toAdd)
    {
        EXP_DAO.insert(toAdd, EXP_TABLE);
    }
}
