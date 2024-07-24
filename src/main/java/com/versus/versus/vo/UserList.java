package com.versus.versus.vo;

import com.versus.versus.entity.User;
import com.versus.versus.vo.enums.BloodType;
import com.versus.versus.vo.enums.Gender;

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
}
