package com.gb.cricscore.model.people;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Team {
    private final String name;
    private final String tourName;
    private List<Player> players;
    private List<Coach> coaches;
    private List<Physicio> physicios;
    private Manager manager;

    public Team(String name, String tourName) {
        this.name = name;
        this.tourName = tourName;
        players = new ArrayList<>();
        coaches = new ArrayList<>();
        physicios = new ArrayList<>();
    }
}
