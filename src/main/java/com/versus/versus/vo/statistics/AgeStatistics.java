package com.versus.versus.vo.statistics;

import com.versus.versus.vo.enums.Ages;
import java.util.EnumMap;
import java.util.Map;
import java.util.Comparator;

public class AgeStatistics {
    private final Integer totalVoters;
    private final Map<Ages, DataPoint> ageData;
    private final Ages dominantAgeGroup;

    public AgeStatistics(Map<Ages, Integer> ageVotes) {
        this.totalVoters = getTotalVoters(ageVotes);
        this.ageData = createAgeData(ageVotes);
        this.dominantAgeGroup = getDominantAgeGroup(ageVotes);
    }

    private static int getTotalVoters(Map<Ages, Integer> ageVotes) {
        return ageVotes.values().stream().mapToInt(Integer::intValue).sum();
    }

    private Map<Ages, DataPoint> createAgeData(Map<Ages, Integer> ageVotes) {
        Map<Ages, DataPoint> data = new EnumMap<>(Ages.class);
        ageVotes.forEach((age, votes) ->
                data.put(age, new DataPoint(age.getName(), votes, this.totalVoters))
        );
        return data;
    }

    private Ages getDominantAgeGroup(Map<Ages, Integer> ageVotes) {
        return ageVotes.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new IllegalStateException("No dominant age group found"));
    }
}