package com.gb.cricscore.model.match;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PlayerScore {
    private String name;
    private List<Integer> runsScored;
    private WicketType wicketType;
    private String bowler;

    public PlayerScore(String name) {
        this.name = name;
        runsScored = new ArrayList<>();
    }

}
