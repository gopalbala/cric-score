package com.gb.cricscore.model.match;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Fixture {
    private String tournament;
    private PlayedTeams between;
    private Stadium toBePlayed;
    private LocalDateTime matchStartTime;
}
