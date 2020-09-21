package com.gb.cricscore.model.match;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class Over {
    private List<Ball> balls;
    private List<Run> runs;

    private boolean isMaidenOver() {
        for (Ball ball : balls) {
            if (ball.getRunsScored() > 0) {
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

    private int getRunsScoredInOver() {
        int runsScored = 0;
        for (Ball ball : balls) {
            runsScored += ball.getRunsScored();
        }
        return runsScored;
    }

}
