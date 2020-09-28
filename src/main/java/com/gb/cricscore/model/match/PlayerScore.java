package com.gb.cricscore.model.match;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlayerScore {
    private String name;
    private List<Integer> runsScored;
    private WicketType wicketType;
    private String bowler;
    private boolean isOut;
    private int totalBoundaries;
    private int totalSixes;

    public PlayerScore(String name) {
        this.name = name;
        runsScored = new ArrayList<>();
    }

}
