package com.solvd.hw2.services.jdbc;

import java.util.ArrayList;
import java.util.List;
import com.solvd.hw2.dao.jdbc.AssistantDao;
import com.solvd.hw2.dao.jdbc.ScientistDao;
import com.solvd.hw2.models.*;
import com.solvd.hw2.services.interfaces.IEmployeeService;

public class EmployeeService implements IEmployeeService
{
    private static final String SCIENTIST_TABLE = "scientists";
    private static final AssistantDao ASSISTANT_DAO = new AssistantDao();
    private static final ScientistDao SCIENTIST_DAO = new ScientistDao();

    public void insertScientist(Scientist toInsert)
    {
        SCIENTIST_DAO.insert(toInsert, SCIENTIST_TABLE);
    }

    public Scientist getScientistById(int id)
    {
        Scientist criteria = new Scientist(id, null, null, null);
        return SCIENTIST_DAO.select(new ArrayList<String>(), criteria, "= ").get(0);
    }

    public void updateScientist(Scientist newVals)
    {
        Scientist criteria = new Scientist(newVals.getId(), null, null, null);
        SCIENTIST_DAO.update(newVals, criteria, SCIENTIST_TABLE, " = ");
    }

    public List<Assistant> getAssistantsByScientistId(int scientistId)
    {
        Assistant allFields = new Assistant();
        Assistant criteria = new Assistant(null, null, null, new Scientist(scientistId, null, null, null));

        return ASSISTANT_DAO.select(allFields.getFields(), criteria, " = ");
    }

    public List<Scientist> getScientistsByDegree(String degreeName)
    {
        Scientist allFields = new Scientist();
        Scientist criteria = new Scientist(null, null, null, new Degree(null, degreeName, null));
        
        return SCIENTIST_DAO.select(allFields.getFields(), criteria, " = ");
    }
}
