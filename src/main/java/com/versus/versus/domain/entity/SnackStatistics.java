package com.versus.versus.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class SnackStatistics {
    private Snack snack;
    private List<Map<User, Integer>> snackAVotes;

    public SnackStatistics(List<Map<User, Integer>> snackAVotes) {
        this.snackAVotes = snackAVotes;
    }

    public SnackStatistics() {

    }

    public void setSnack(Snack snack) {
        this.snack = snack;
        this.snackAVotes = new ArrayList<Map<User, Integer>>();
    }

    public void setUser(User user, Integer vote) {
        Map<User, Integer> userVote = Map.of(user, vote);
        snackAVotes.add(userVote);
    }

    public Snack getSnack() {
        return snack;
    }

    public List<Map<User, Integer>> getSnackAVotes() {
        return snackAVotes;
    }
}