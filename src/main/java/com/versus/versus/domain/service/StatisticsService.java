package com.versus.versus.domain.service;

import com.versus.versus.domain.valueObject.statistics.DataPoint;

public interface StatisticsService {
    // 인기있는 제품 조회
    public DataPoint getPopularProduct();

    //선택한 과자별 사용자 통계정보 조회
    // 나이별 통계
    public DataPoint getAgeStatistics(String SnackId);
    // 성별 통계
    public DataPoint getGenderStatistics(String SnackId);
    // 혈액형별 통계
    public DataPoint getBloodTypeStatistics(String SnackId);
}
