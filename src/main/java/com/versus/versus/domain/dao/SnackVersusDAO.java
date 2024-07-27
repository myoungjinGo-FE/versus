package com.versus.versus.domain.dao;

import com.versus.versus.domain.entity.SnackVersus;

import java.sql.SQLException;

public interface SnackVersusDAO {
    // 스낵 대결 정보 불러오기
    public SnackVersus findByVersusId(Integer versusId) throws SQLException;

    // 스낵 투표하기
    public void insert(Integer VersusId, Integer SnackId, Integer userId) throws SQLException;
}
