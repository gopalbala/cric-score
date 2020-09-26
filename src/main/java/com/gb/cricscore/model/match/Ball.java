package com.gb.cricscore.model.match;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ball {
    private int overNumber;
    private BallType ballType;
    private String bowledBy;
    private String facedBy;
    private int runsScored;
    private Wicket wicket;
    private Commentary commentary;

    public Ball(int overNumber, String bowledBy, String facedBy) {
        this.overNumber = overNumber;
        this.bowledBy = bowledBy;
        this.facedBy = facedBy;
    }
}
