package com.versus.versus.vo.statistics;

import com.versus.versus.entity.User;
import com.versus.versus.vo.enums.Gender;

import java.util.List;

public class GenderStatistics {
    private final Integer totalVoters;
    private final DataPoint maleVoters;
    private final DataPoint femaleVoters;
    private final String dominantGender;


    public GenderStatistics(List<User> maleVoters, List<User> femaleVoters) {
        this.totalVoters = maleVoters.size() + femaleVoters.size();
        this.maleVoters = new DataPoint(Gender.MALE.getName(), maleVoters.size(), this.totalVoters);
        this.femaleVoters = new DataPoint(Gender.FEMALE.getName(), femaleVoters.size(), this.totalVoters);
        this.dominantGender = maleVoters.size() > femaleVoters.size() ? Gender.MALE.getName(): Gender.FEMALE.getName();
    }
}
