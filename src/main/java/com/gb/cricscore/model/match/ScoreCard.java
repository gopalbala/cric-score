package com.gb.cricscore.model.match;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ScoreCard {
    private List<PlayerScore> playerScores = new ArrayList<>();
    private List<BowlerOvers> bowlerOvers = new ArrayList<>();
    private int totalExtras;
    private int totalScore;
    private int totalByes;
    private int totalLegByes;
}
