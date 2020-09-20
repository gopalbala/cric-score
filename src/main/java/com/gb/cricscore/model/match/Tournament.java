package com.gb.cricscore.model.match;

import com.gb.cricscore.model.people.Person;
import com.gb.cricscore.model.people.Team;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
public class Tournament {
    private final String name;
    private Set<Team> teams;
    private Set<String> sponsors;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private Set<Match> matches;
    private Team winner;
    private Team runner;
    private Map<AwardType, Person> awards;

    public Tournament(String name, LocalDateTime startDate, LocalDateTime endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        teams = new HashSet<>();
        sponsors = new HashSet<>();
        matches = new HashSet<>();
    }
}
