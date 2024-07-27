package com.versus.versus.domain.entity;

import java.util.List;

public class SnackVersus {
    private Integer versusId;
    private List<Snack> snacks;

    public SnackVersus(Integer versusId, List<Snack> snacks) {
        this.versusId = versusId;
        this.snacks = snacks;
    }

    public SnackVersus() {

    }

    public Integer getVersusId() {
        return versusId;
    }

    public void setVersusId(Integer versusId) {
        this.versusId = versusId;
    }

    public void setSnacks(List<Snack> snacks) {
        this.snacks = snacks;
    }

    public void addSnack(Snack snacks) {
        this.snacks.add(snacks);
    }

    public List<Snack> getSnacks() {
        return snacks;
    }
}
