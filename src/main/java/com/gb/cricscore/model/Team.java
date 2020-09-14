package com.gb.cricscore.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Team {
    private final String name;
    private List<Player> players;
    private List<Coach> coaches;
    private List<Physicio> physicios;
    private Manager manager;

    public Team(String name) {
        this.name = name;
    }
}
