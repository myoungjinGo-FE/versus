package com.versus.versus.domain.valueObject.enums;

public enum Ages {
    AGE_10("10대 이하"),
    AGE_20("20대"),
    AGE_30("30대"),
    AGE_40("40대 이상");

    private final String name;

    Ages(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
