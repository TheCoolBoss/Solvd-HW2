package com.solvd.hw2.services.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import com.solvd.hw2.CustomPool;
import com.solvd.hw2.builders.ExperimentBuilder;
import com.solvd.hw2.dao.jdbc.ExperimentDao;
import com.solvd.hw2.models.Experiment;
import com.solvd.hw2.models.Scientist;
import com.solvd.hw2.services.interfaces.IExperimentService;

public class ExperimentService implements IExperimentService
{
    private static final ExperimentDao EXP_DAO = new ExperimentDao();
    private static final String EXP_TABLE = "experiments";
    private static final String GROUP_TABLE = "experimentGroups";

    //Inserts data into experiment group table 
    public void insertIntoGroups(Experiment experiment) throws SQLException, InterruptedException
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

    public void insertExperiment(Experiment toInsert)
    {
        EXP_DAO.insert(toInsert, EXP_TABLE);
        try
        {
            insertIntoGroups(toInsert); 
        }

        catch (SQLException | InterruptedException e)
        {
            //Do nothing for now
        }
    }

    public Experiment getExperimentById(int id)
    {
        Experiment criteria = new ExperimentBuilder().withId(id).build();
        return EXP_DAO.select(new ArrayList<String>(), criteria, EXP_TABLE).get(0);
    }

    public void updateExperiment(Experiment newVals)
    {
        Experiment criteria = new ExperimentBuilder().withId(newVals.getId()).build();
        EXP_DAO.update(newVals, criteria, EXP_TABLE, " = ");
    }

    public void deleteExperiment(Experiment toDelete)
    {
        Experiment criteria = new ExperimentBuilder().withId(toDelete.getId()).build();
        EXP_DAO.delete(criteria, GROUP_TABLE, " = ");
        EXP_DAO.delete(criteria, EXP_TABLE, " = ");
    }
}
