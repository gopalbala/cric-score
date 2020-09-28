package com.gb.cricscore.model.match;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Innings {
    private int inningsNumber;
    private Map<Integer, Over> overs;

    public Innings(int inningsNumber) {
        this.inningsNumber = inningsNumber;
        overs = new HashMap<>();
    }
}
