package com.versus.versus.domain.entity;

import com.versus.versus.domain.valueObject.enums.BloodType;
import com.versus.versus.domain.valueObject.enums.Gender;

public class User {
    private Integer userId;
    private Gender gender;
    private BloodType bloodType;
    private Integer age;

    public User(Gender gender, BloodType bloodType, Integer age) {
        this.gender = gender;
        this.bloodType = bloodType;
        this.age = age;
    }

    public User() {

    }

    public Integer getUserId() {
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

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
