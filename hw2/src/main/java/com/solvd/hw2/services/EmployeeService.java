package com.solvd.hw2.services;

import java.util.List;

import com.solvd.hw2.dao.AssistantDao;
import com.solvd.hw2.dao.ScientistDao;
import com.solvd.hw2.models.*;

public class EmployeeService 
{
    private static final AssistantDao ASSISTANT_DAO = new AssistantDao();
    private static final String ASSISTANT_TABLE = "assistants";
    private static final ScientistDao SCIENTIST_DAO = new ScientistDao();
    private static final String SCIENTIST_TABLE = "scientists";

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
