package com.gb.cricscore.model.people;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Team {
    private final String name;
    private final String tourName;
    private List<Player> players;
    private List<SupportStaff> supportStaffs;

    public Team(String name, String tourName) {
        this.name = name;
        this.tourName = tourName;
        players = new ArrayList<>();
        supportStaffs = new ArrayList<>();
    }
}
