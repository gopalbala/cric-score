package com.gb.cricscore.model.people;

import com.gb.cricscore.model.match.MatchType;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class PlayerStats {
    private Map<MatchType, Stats> playerStatistics;

    @Getter
    @Setter
    private static class Stats {
        private int matchesPlayed;
        private float oversBowled;
        private float runsScored;
        private int wicketsTaken;
        private int catchesTaken;
        private int stumping;
        private float econ;
        private float avg;
    }
}
