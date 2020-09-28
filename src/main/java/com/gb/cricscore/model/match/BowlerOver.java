package com.gb.cricscore.model.match;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class BowlerOver {
    private String bowlerName;
    private Map<Integer, Over> overMap;
    private Map<BallType, Integer> extrasBowled;
    private int wicketsTaken;

    public BowlerOver(String bowlerName) {
        this.bowlerName = bowlerName;
        overMap = new HashMap<>();
        extrasBowled = new HashMap<>();
    }
}
