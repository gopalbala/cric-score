package com.gb.cricscore.model.match;

import com.gb.cricscore.model.people.Person;
import com.gb.cricscore.model.people.Team;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Tournament {
    private final String name;
    private final List<Team> teams;
    private final List<String> sponsors;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private Team winner;
    private Team runner;
    private Map<AwardType, Person> awards;

    public Tournament(String name, List<Team> teams,
                      List<String> sponsors,
                      LocalDateTime startDate, LocalDateTime endDate) {
        this.name = name;
        this.teams = teams;
        this.sponsors = sponsors;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
