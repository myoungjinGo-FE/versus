package com.versus.versus.domain.valueObject;

public class Age {
    private final int age;
    private final String ageName;

    public Age (int age) {
        this.age = setAgeBound(age);
        this.ageName = setAgeName(this.age);
    }

    private Integer setAgeBound(Integer age) {
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

    private String setAgeName(Integer age) {
        if (age < 20) {
            return "10대 이하";
        } else if (age < 30) {
            return "20대";
        } else if (age < 40) {
            return "30대";
        } else {
            return "40대 이상";
        }
    }

    public int getAge() {
        return age;
    }

    public String getAgeName() {
        return ageName;
    }
}
