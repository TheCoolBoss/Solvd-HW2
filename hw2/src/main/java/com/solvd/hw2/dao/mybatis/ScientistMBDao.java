package com.solvd.hw2.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.solvd.hw2.models.Scientist;

public class ScientistMBDao 
{
    private SqlSessionFactory factory;

    public ScientistMBDao(SqlSessionFactory factory) 
    {
        this.factory = factory;
    }

    public Scientist getScientistById(int id)
    {
        try(SqlSession session = factory.openSession())
        {
            return session.selectOne("ScientistMap.getScientistById", id);
        }
    }
}
