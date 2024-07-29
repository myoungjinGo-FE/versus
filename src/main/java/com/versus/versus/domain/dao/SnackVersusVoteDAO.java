package com.versus.versus.domain.dao;


import com.versus.versus.domain.entity.SnackStatistics;

import java.sql.SQLException;

public interface SnackVersusVoteDAO {
    public SnackStatistics select(Integer SnackId, Integer VersusId) throws SQLException;
}
