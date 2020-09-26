package com.gb.cricscore.model.match;

import com.gb.cricscore.model.people.PlayingMembers;
import com.gb.cricscore.model.people.Team;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamsBetween {
    Team team1;
    Team team2;
    PlayingMembers t1PlayingMembers;
    PlayingMembers t2PlayingMembers;

    public TeamsBetween(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }
}
