package com.versus.versus.domain.service;

import com.versus.versus.domain.entity.SnackVersus;

import java.sql.SQLException;


public interface SnackVersusService {
    // 스낵 대결 정보 불러오기
    public SnackVersus getSnackVersus(Integer VersusId) throws SQLException;

    // 스낵 투표하기
    public void voteForSnack(Integer VersusId, Integer SnackId, Integer userId) throws SQLException;
}
