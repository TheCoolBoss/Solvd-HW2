package com.solvd.hw2.services.abstracts;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public abstract class ServiceMB 
{
    protected static final String SETUP_PATH = "mybatis.xml";
    protected InputStream stream; 
    protected SqlSessionFactoryBuilder builder;
    protected SqlSessionFactory factory;

    public void setUpService() throws IOException
    {
        stream = Resources.getResourceAsStream(SETUP_PATH);  
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(stream);
    }
}
