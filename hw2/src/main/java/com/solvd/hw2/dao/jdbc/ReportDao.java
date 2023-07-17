package com.solvd.hw2.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw2.CustomPool;
import com.solvd.hw2.dao.abstracts.Dao;
import com.solvd.hw2.models.Report;

public class ReportDao extends Dao
{
    private static final Logger LOGGER = LogManager.getLogger("Report DAO");
    private static final String REPORTS_TABLE = "reports";
    private static final String ID_COL = "locId";
    private static final String NAME_COL = "reportName";
    private static final String LINK_COL = "link";

    public List<Report> select(ArrayList<String> fields, Report criteriaVals, String operator)
    {
        try
        {
            ArrayList<Report> ret = new ArrayList<Report>();
            ResultSet results = getSelectResults(fields, criteriaVals, REPORTS_TABLE, operator);

            while (results.next())
            {
                Integer newId = null;
                String name = null;
                String link = null;

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

                    else if (results.getMetaData().getColumnLabel(i).equals(LINK_COL))
                    {
                        link = results.getString(i);
                    }
                }

                ret.add(new Report(newId, name, link));
            }

            return ret;
        }

        catch (SQLException | InterruptedException sqle)
        {
            LOGGER.error(sqle.getMessage());
            return null;
        }

        finally
        {
            CustomPool.releaseConn();
        }
    }    
}
