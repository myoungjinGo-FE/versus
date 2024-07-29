package com.versus.versus.domain.service;

import com.versus.versus.domain.entity.SnackStatistics;
import com.versus.versus.domain.valueObject.statistics.DataPoint;

import java.sql.SQLException;
import java.util.List;

public interface StatisticsService {
    // 모든 통계 조회
    public SnackStatistics getVoteStatistics(Integer snackId, Integer versusId) throws SQLException;

    //선택한 과자별 사용자 통계정보 조회
    // 나이별 통계
//    public DataPoint getAgeStatistics(String SnackId);
    // 성별 통계
//    public DataPoint getGenderStatistics(String SnackId);
    // 혈액형별 통계
//    public DataPoint getBloodTypeStatistics(String SnackId);
}
