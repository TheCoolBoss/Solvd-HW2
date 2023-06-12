package com.solvd.hw2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExperimentGroupDao 
{
    private static final Logger LOGGER = LogManager.getLogger("Exp Group DAO");
    private final String EXP_GROUP_TABLE = "experimentGroups";
}
