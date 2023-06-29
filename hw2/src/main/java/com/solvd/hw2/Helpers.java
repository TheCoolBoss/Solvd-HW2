package com.solvd.hw2;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw2.dao.jdbc.*;
import com.solvd.hw2.models.*;
import com.solvd.hw2.services.interfaces.IClientService;
import com.solvd.hw2.services.interfaces.IEmployeeService;
import com.solvd.hw2.services.jdbc.ClientTypeService;

public class Helpers 
{
    private static final Logger LOGGER = LogManager.getLogger("Helpers");
    private static final String INSTITUTION_TABLE = "institutions";
    private static final InstitutionsDao INSTITUTIONS_DAO = new InstitutionsDao();
    private static final LabDao LAB_DAO = new LabDao();
    private static final String LAB_TABLE = "labs";
    private static final LocationDao LOC_DAO = new LocationDao();
    private static final String LOC_TABLE = "locations";

    public static Client getBoss(IClientService clientService, ClientTypeService clientTypeService)
    {
        Client bigBoss = clientService.getClientByName("Big Boss");
        if (bigBoss == null)
        {
            LOGGER.info("Adding Boss");
            int individualType = clientTypeService.getTypeIdByName("Individual");
            Client addedBoss = new Client(null, "Big Boss", new ClientType(individualType, null));
            clientService.insertClient(addedBoss);
        }

        return clientService.getClientByName("Big Boss");
    }

    public static Institution getMotherBase() throws SQLException, InterruptedException
    {
        Institution criteria = new Institution(null, "Mother Base");
        List<Institution> criteriaSize = INSTITUTIONS_DAO.select(new ArrayList<String>(), criteria, " = ");
        
        if (criteriaSize.size() == 0)
        {
            LOGGER.info("Mother Base does not exist. Adding it now.");
            INSTITUTIONS_DAO.insert(criteria, INSTITUTION_TABLE);
        }

        return INSTITUTIONS_DAO.select(new ArrayList<String>(), criteria, " = ").get(0);
    }

    public static Lab getRAndDLab() throws SQLException, InterruptedException
    {
        Lab criteria = new Lab(null, "R&D Lab", getCaribbean(), getMotherBase());
        List<Lab> criteriaSize = LAB_DAO.select(new ArrayList<String>(), criteria, " = ");

        if (criteriaSize.size() == 0)
        {
            LOGGER.info("R&D Lab does not exist. Adding it now.");
            LAB_DAO.insert(criteria, LAB_TABLE);
        }

        Lab ret = LAB_DAO.select(new ArrayList<String>(), criteria, " = ").get(0);
        ret.setInstitution(getMotherBase());
        ret.setLocation(getCaribbean());

        return ret;
    }

    public static Location getCaribbean() throws SQLException, InterruptedException
    {
        Location criteria = new Location(null, "Mother Base", "Caribbean");
        List<Location> criteriaSize = LOC_DAO.select(new ArrayList<String>(), criteria, " = ");

        if (criteriaSize.size() == 0)
        {
            LOGGER.info("Caribbean location does not exist. Adding it now.");
            LOC_DAO.insert(criteria, LOC_TABLE);
        }

        return LOC_DAO.select(new ArrayList<String>(), criteria, " = ").get(0);
    }
}
