package com.gb.cricscore.model.people;

import com.gb.cricscore.model.match.MatchType;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class PlayerStats {
    private Map<MatchType, Integer> matchesPlayed;
    private Map<MatchType, Integer> runsScored;
    private Map<MatchType, Integer> oversBowled;
    private Map<MatchType, Integer> wicketsTaken;
    private Map<MatchType, Integer> catchesTaken;
    private Map<MatchType, Integer> stumping;
}
