package com.gb.cricscore.model.people;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PlayingMembers {
    private String team;
    private Set<Player> players;
    private Set<Player> substitute;
}
