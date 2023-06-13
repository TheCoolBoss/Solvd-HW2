package com.solvd.hw2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw2.CustomPool;
import com.solvd.hw2.dao.abstracts.Dao;
import com.solvd.hw2.models.*;

public class ExperimentDao extends Dao
{
    private static final Logger LOGGER = LogManager.getLogger("Exp DAO");
    private static final String EXP_TABLE = "experiments";
    private static final String ID_COL = "scientistId";
    private static final String NAME_COL = "firstName";
    private static final String STATUS_COL = "status";
    private static final String START_COL = "startDate";
    private static final String END_COL = "endDate";
    private static final String TYPE_COL = "experimentTypes"; 
    private static final String INVEST_COL = "investments";
    private static final String REPORT_COL = "reports"; 
    private static final String LAB_COL = "investments";

    public List<Experiment> select(ArrayList<String> fields, Experiment criteriaVals, String operator)
    {
        try
        {
            ArrayList<Experiment> ret = new ArrayList<Experiment>();
            ResultSet results = getSelectResults(fields, criteriaVals, EXP_TABLE, operator);

            while (results.next())
            {
                Integer newId = null;
                String name = null;
                String status = null;
                Date start = null;
                Date end = null;
                ExperimentType type = new ExperimentType(null, null);
                Investment investment = new Investment(null, null, null, null);
                Report report = new Report(null, null, null);
                Lab lab = new Lab(null, null, null, null);

                for (int i = 1; i <= results.getMetaData().getColumnCount(); i++)
                {
                    if (results.getMetaData().getColumnLabel(i).equals(ID_COL))
                    {
                        newId = results.getInt(i);
                    }

                    else if (results.getMetaData().getColumnLabel(i).equals(NAME_COL))
                    {
                        name = results.getString(i);
                    }

                    else if (results.getMetaData().getColumnLabel(i).equals(STATUS_COL))
                    {
                        status = results.getString(i);
                    }

                    else if (results.getMetaData().getColumnLabel(i).equals(START_COL))
                    {
                        start = results.getDate(i);
                    }     
                    
                    else if (results.getMetaData().getColumnLabel(i).equals(END_COL))
                    {
                        end = results.getDate(i);
                    } 

                    else if (results.getMetaData().getColumnLabel(i).equals(TYPE_COL))
                    {
                        type.setId(results.getInt(i));
                    } 

                    else if (results.getMetaData().getColumnLabel(i).equals(INVEST_COL))
                    {
                        investment.setId(results.getInt(i));
                    } 

                    else if (results.getMetaData().getColumnLabel(i).equals(REPORT_COL))
                    {
                        report.setId(results.getInt(i));
                    }         
                    
                    else if (results.getMetaData().getColumnLabel(i).equals(LAB_COL))
                    {
                        lab.setId(results.getInt(i));
                    } 
                }

                ret.add(new Experiment(newId, name, status, start, end, type, investment, report, lab));
            }
            
            CustomPool.releaseConn();
            return ret;
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
            return null;
        }
    }   
}
