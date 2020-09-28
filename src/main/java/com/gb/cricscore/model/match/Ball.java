package com.gb.cricscore.model.match;

import lombok.Data;

@Data
public class Ball {
    private int overNumber;
    private BallType ballType;
    private String bowledBy;
    private String facedBy;
    private RunType runType;
    private Wicket wicket;
    private Commentary commentary;

    public Ball(int overNumber, String bowledBy, String facedBy) {
        this.overNumber = overNumber;
        this.bowledBy = bowledBy;
        this.facedBy = facedBy;
    }
}
