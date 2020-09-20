package com.gb.cricscore.model.match;

import com.gb.cricscore.model.people.Person;
import com.gb.cricscore.model.people.Team;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Tournament {
    private final String name;
    private List<Team> teams;
    private List<String> sponsors;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private List<Match> matches;
    private Team winner;
    private Team runner;
    private Map<AwardType, Person> awards;

    public Tournament(String name, LocalDateTime startDate, LocalDateTime endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        teams = new ArrayList<>();
        sponsors = new ArrayList<>();
        matches = new ArrayList<>();
    }
}
