package com.gb.cricscore.model.people;

import com.gb.cricscore.exception.InvalidMatch;
import com.gb.cricscore.model.match.Ball;
import com.gb.cricscore.model.match.ScoreCard;

public class Scorer extends Person {
    public Scorer(String name) {
        super(name);
    }

    public void setScore(Ball ball, String match, int innings) throws InvalidMatch {
        ScoreCard scoreCard = ScoreCard.INSTANCE(match, innings);
        scoreCard.setScoreCardForBall(ball);
    }
}
