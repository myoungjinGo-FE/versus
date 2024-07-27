package com.versus.versus.domain.valueObject;

import com.versus.versus.domain.entity.User;
import com.versus.versus.domain.valueObject.enums.BloodType;
import com.versus.versus.domain.valueObject.enums.Gender;

import java.util.List;

public class UserList {
    private List<User> voters;

    public UserList(List<User> voters) {
        this.voters = voters;
    }

    public List<User> getVotersByGender(Gender gender){
        return voters.stream().filter(voter -> voter.getGender().equals(gender)).toList();
    }

    public List<User> getVotersByBloodType(BloodType bloodType){
        return voters.stream().filter(voter -> voter.getBloodType().equals(bloodType)).toList();
    }

    public List<User> getVotersByAge(int age){
        return voters.stream().filter(voter -> voter.getAge() == age).toList();
    }

    public Integer getVotersCount() {
        return voters.size();
    }
}
