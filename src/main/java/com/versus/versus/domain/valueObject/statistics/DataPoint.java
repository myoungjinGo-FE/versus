package com.versus.versus.domain.valueObject.statistics;


public class DataPoint {
    private final String label;
    private final Integer value;
    private final Float percentage;

    public DataPoint(String label, Integer value, Integer total) {
        this.label = label;
        this.value = value;
        this.percentage = (float) value / total * 100;
    }
}
