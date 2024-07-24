package com.versus.versus.entity;


import com.versus.versus.vo.enums.Ages;
import com.versus.versus.vo.enums.BloodType;
import com.versus.versus.vo.statistics.AgeStatistics;
import com.versus.versus.vo.enums.Gender;
import com.versus.versus.vo.UserList;
import com.versus.versus.vo.statistics.BloodTypeStatistics;
import com.versus.versus.vo.statistics.GenderStatistics;

import java.util.EnumMap;
import java.util.Map;


public class Statistics {
    private UserList snackAVoters;
    private UserList snackBVoters;

    public Statistics(UserList snackAVoters, UserList snackBVoters) {
        this.snackAVoters = snackAVoters;
        this.snackBVoters = snackBVoters;
    }

    public GenderStatistics getGenderStatistics() {
        return new GenderStatistics(
                snackAVoters.getVotersByGender(Gender.MALE),
                snackBVoters.getVotersByGender(Gender.FEMALE)
        );
    }

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