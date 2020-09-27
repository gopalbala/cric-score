package com.gb.cricscore.model.match;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class BowlerOver {
    private String bowlerName;
    private Map<Integer, Over> overMap;
    private Map<BallType, Integer> extrasBowled;

    public BowlerOver(String bowlerName) {
        this.bowlerName = bowlerName;
        overMap = new HashMap<>();
        extrasBowled = new HashMap<>();
    }
}
