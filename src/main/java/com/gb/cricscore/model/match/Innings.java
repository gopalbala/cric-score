package com.gb.cricscore.model.match;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Innings {
    Map<Integer, Over> overs;

    public Innings() {
        overs = new HashMap<>();
    }
}
