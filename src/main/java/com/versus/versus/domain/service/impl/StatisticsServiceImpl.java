package com.versus.versus.domain.service.impl;

import com.versus.versus.domain.dao.SnackVersusVoteDAO;
import com.versus.versus.domain.entity.SnackStatistics;
import com.versus.versus.domain.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    SnackVersusVoteDAO dao;


    @Override
    public SnackStatistics getVoteStatistics(Integer SnackId, Integer versusId) throws SQLException {
        return dao.select(SnackId, versusId);
    }
}
