package com.versus.versus.domain.valueObject.statistics;

import com.versus.versus.domain.valueObject.enums.BloodType;

import java.util.Map;
import java.util.stream.Collectors;

public class BloodTypeStatistics {
    private final Integer totalVoters;
    private final Map<BloodType, DataPoint> bloodTypeDataPoints;
    private final BloodType dominantBloodType;

    public BloodTypeStatistics(Map<BloodType, Integer> bloodTypeCounts) {
        this.totalVoters = getTotalVoters(bloodTypeCounts);
        this.bloodTypeDataPoints = getBloodTypeDataPoints(bloodTypeCounts);
        this.dominantBloodType = getDominantBloodType(bloodTypeCounts);
    }

    private static BloodType getDominantBloodType(Map<BloodType, Integer> bloodTypeCounts) {
        return bloodTypeCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    private Map<BloodType, DataPoint> getBloodTypeDataPoints(Map<BloodType, Integer> bloodTypeCounts) {
        return bloodTypeCounts.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> new DataPoint(entry.getKey().getName(), entry.getValue(), getTotalVoters(bloodTypeCounts))));
    }

    private static Integer getTotalVoters(Map<BloodType, Integer> bloodTypeCounts) {
        return bloodTypeCounts.values().stream().reduce(0, Integer::sum);
    }
}
