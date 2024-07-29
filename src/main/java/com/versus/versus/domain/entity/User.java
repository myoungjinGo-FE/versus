package com.versus.versus.domain.entity;

import com.versus.versus.domain.valueObject.Age;
import com.versus.versus.domain.valueObject.enums.BloodType;
import com.versus.versus.domain.valueObject.enums.Gender;

public class User {
    private Integer userId;
    private Gender gender;
    private BloodType bloodType;
    private Age age;

    public User(Gender gender, BloodType bloodType, Integer age) {
        this.gender = gender;
        this.bloodType = bloodType;
        this.age = new Age(age);
    }

    public User() {

    }

    public Integer getUserId() {
        return userId;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public Age getAge() {
        return age;
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

    public void setAge(int age) {
        this.age = new Age(age);
    }

}
