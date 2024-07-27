package com.versus.versus.domain.entity;


import com.versus.versus.domain.valueObject.enums.Ages;
import com.versus.versus.domain.valueObject.enums.BloodType;
import com.versus.versus.domain.valueObject.statistics.AgeStatistics;
import com.versus.versus.domain.valueObject.enums.Gender;
import com.versus.versus.domain.valueObject.UserList;
import com.versus.versus.domain.valueObject.statistics.BloodTypeStatistics;
import com.versus.versus.domain.valueObject.statistics.DataPoint;
import com.versus.versus.domain.valueObject.statistics.GenderStatistics;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;


public class Statistics {
    private final Map<Snack, List<User>> snackAVotes;

    public Statistics(Map<Snack, List<User>> snackAVotes) {
        this.snackAVotes = snackAVotes;
    }

    public DataPoint getPopularSnack() {
        Snack popularSnack = null;
        int maxVotes = 0;
        int totalVotes = 0;

        for (Map.Entry<Snack, List<User>> entry : snackAVotes.entrySet()) {
            int votes = entry.getValue().size();
            totalVotes += votes;
            if (votes > maxVotes) {
                maxVotes = votes;
                popularSnack = entry.getKey();
            }
        }
        return new DataPoint(popularSnack.getName(), maxVotes, totalVotes);
    }

//    public GenderStatistics getGenderStatistics() {
//
//    }

    public AgeStatistics getAgeStatistics() {
        Map<Ages, Integer> ageVotes = new EnumMap<>(Ages.class);
        ageVotes.put(Ages.AGE_10, 100);
        ageVotes.put(Ages.AGE_20, 200);
        ageVotes.put(Ages.AGE_30, 150);
        ageVotes.put(Ages.AGE_40, 50);

        return new AgeStatistics(ageVotes);
    }

    public BloodTypeStatistics getBloodTypeStatistics() {
        Map<BloodType, Integer> ageVotes = new EnumMap<>(BloodType.class);
        ageVotes.put(BloodType.A, 100);
        ageVotes.put(BloodType.B, 200);
        ageVotes.put(BloodType.O, 150);
        ageVotes.put(BloodType.AB, 50);

        return new BloodTypeStatistics(ageVotes);
    }
}