package com.versus.versus.domain.valueObject.enums;

public enum Gender {
    MALE("남성"),
    FEMALE("여성");

    private final String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
