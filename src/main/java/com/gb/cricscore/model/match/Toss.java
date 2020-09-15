package com.gb.cricscore.model.match;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Toss {
    private String tossedBy;
    private String askedBy;
    private String wonByTeam;
    private TossAction tossAction;
}
