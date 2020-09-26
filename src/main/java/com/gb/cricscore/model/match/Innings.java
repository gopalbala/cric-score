package com.gb.cricscore.model.match;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Innings {
    List<Over> overs;

    public Innings() {
        overs = new ArrayList<>();
    }
}
