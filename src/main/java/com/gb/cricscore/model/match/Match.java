package com.gb.cricscore.model.match;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Match {
    private final PlayedTeams playedTeams;
    private String venue;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private MatchType matchType;

    public Match(PlayedTeams playedTeams) {
        this.playedTeams = playedTeams;
    }
}
