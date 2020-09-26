package com.gb.cricscore.model.match;

import com.gb.cricscore.model.people.Commentator;
import com.gb.cricscore.model.people.Scorer;
import com.gb.cricscore.model.people.Umpire;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Match {
    private String matchId;
    private Tournament tournament;
    private final TeamsBetween teamsBetween;
    private String venue;
    private Toss toss;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Umpire> umpires;
    private String winner;
    private String lost;
    private MatchResult matchResult;
    private List<Innings> innings;
    private List<Commentator> commentators;
    private List<Scorer> scorers;

    public Match(TeamsBetween teamsBetween) {
        this.teamsBetween = teamsBetween;
        umpires = new ArrayList<>();
        innings = new ArrayList<>();
        commentators = new ArrayList<>();
        scorers = new ArrayList<>();
    }
}
