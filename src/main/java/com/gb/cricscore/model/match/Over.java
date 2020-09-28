package com.gb.cricscore.model.match;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Over {
    private int number;
    private int runsScored = 0;
    private int extras = 0;
    private int totalRunsInOver = 0;

    private List<Ball> balls;
    private List<Run> runs;

    public Over(int number) {
        this.number = number;
        balls = new ArrayList<>();
        runs = new ArrayList<>();
    }

    private boolean isMaidenOver() {
        for (Ball ball : balls) {
            if (ball.getRunType() != RunType.ZERO) {
                return false;
            }
        }
        return true;
    }

    private int getWicketsInOver() {
        int wkCount = 0;
        for (Ball ball : balls) {
            if (ball.getWicket() != null) {
                wkCount += 1;
            }
        }
        return wkCount;
    }

}
