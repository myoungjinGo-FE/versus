package com.versus.versus.entity;

import java.util.List;

public class PreferenceSurvey {
    private final Snack snackA;
    private final Snack snackB;
    private final List<User> snackAVoters;
    private final List<User> snackBVoters;

    public PreferenceSurvey(Snack snackA, Snack snackB, List<User> snackAVoters, List<User> snackBVoters) {
        this.snackA = snackA;
        this.snackB = snackB;
        this.snackAVoters = snackAVoters;
        this.snackBVoters = snackBVoters;
    }

    public void voteForSnackA(User user) {
        snackAVoters.add(user);
    }

    public void voteForSnackB(User user) {
        snackBVoters.add(user);
    }
}
