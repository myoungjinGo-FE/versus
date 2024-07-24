package com.versus.versus.entity;

import com.versus.versus.vo.enums.BloodType;
import com.versus.versus.vo.enums.Gender;

public class User {
    private String userId;
    private Gender gender;
    private BloodType bloodType;
    private int age;

    public String getUserId() {
        return userId;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public int getAge() {
        if (age < 20) {
            return 10;
        } else if (age < 30) {
            return 20;
        } else if (age < 40) {
            return 30;
        } else {
            return 40;
        }
    }

    public Gender getGender() {
        return gender;
    }
}
