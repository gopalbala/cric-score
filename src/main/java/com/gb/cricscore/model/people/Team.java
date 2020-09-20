package com.gb.cricscore.model.people;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Team {
    private final String name;
    private final String tourName;
    private Set<Player> players;
    private Set<Coach> coaches;
    private Set<Physicio> physicios;
    private Manager manager;

    public Team(String name, String tourName) {
        this.name = name;
        this.tourName = tourName;
        players = new HashSet<>();
        coaches = new HashSet<>();
        physicios = new HashSet<>();
    }
}
