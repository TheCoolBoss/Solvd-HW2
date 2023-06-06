package com.solvd.hw2;

import com.solvd.hw2.dao.*;

public class Service 
{
    private final Assistants ASSISTANTS_DAO;
    private final Clients CLIENTS_DAO;
    private final ClientTypes CLIENT_TYPE_DAO;
    private final Degrees DEGREE_DAO;
    private final ExperimentGroups EXP_GROUP_DAO;
    private final Experiments EXP_DAO;
    private final Institutions INSTITUTION_DAO;
    private final Investments INVESTMENT_DAO;
    private final Labs LAB_DAO;
    private final Locations LOCATION_DAO;
    private final Reports REPORT_DAO;
    private final Scientists SCIENTIST_DAO;

    //Probably break this up
    public Service(Assistants astDao, Clients clientDao, ClientTypes clientTypeDao, Degrees degreeDao, ExperimentGroups groupDao, Experiments expDao,
                    Institutions instDao, Investments investDao, Labs labDao, Locations locDao, Reports repDao, Scientists scientistDao)
    {
        ASSISTANTS_DAO = astDao;
        CLIENTS_DAO = clientDao;
        CLIENT_TYPE_DAO = clientTypeDao;
        DEGREE_DAO = degreeDao;
        EXP_GROUP_DAO = groupDao;
        EXP_DAO = expDao;
        INSTITUTION_DAO = instDao;
        INVESTMENT_DAO = investDao;
        LAB_DAO = labDao;
        LOCATION_DAO = locDao;
        REPORT_DAO = repDao;
        SCIENTIST_DAO = scientistDao;
    }
}
