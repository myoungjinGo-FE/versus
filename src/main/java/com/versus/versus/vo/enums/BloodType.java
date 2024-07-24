package com.versus.versus.vo.enums;

public enum BloodType {
    A("A형"), // A형
    B("B형"), // B형
    O("C형"), // O형
    AB("AB형"); // AB형

    private final String name;

    BloodType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
