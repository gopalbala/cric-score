package com.gb.cricscore.model.match;

import com.gb.cricscore.model.people.Commentator;
import com.gb.cricscore.model.people.Scorer;
import com.gb.cricscore.model.people.Umpire;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class Match {
    private String matchId;
    private Tournament tournament;
    private final PlayedTeams playedTeams;
    private String venue;
    private Toss toss;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Set<Umpire> umpires;
    private String winner;
    private String lost;
    private MatchResult matchResult;
    private List<Innings> innings;
    private Set<Commentator> commentators;
    private Set<Scorer> scorers;

    public Match(PlayedTeams playedTeams) {
        this.playedTeams = playedTeams;
        umpires = new HashSet<>();
        innings = new ArrayList<>();
        commentators = new HashSet<>();
        scorers = new HashSet<>();
    }
}
