package com.gb.cricscore.model.people;

import com.gb.cricscore.model.match.Ball;

public class Scorer extends Person {
    public Scorer(String name) {
        super(name);
    }

    public void setScore(Ball ball) {
        ball.getRunsScored();
    }
}
