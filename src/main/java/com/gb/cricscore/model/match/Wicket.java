package com.gb.cricscore.model.match;

import com.gb.cricscore.model.people.Player;
import lombok.Data;

@Data
public class Wicket {
    private WicketType wicketType;
    private Player playerOut;
    private Player bowledBy;
    private Player caughtBy;
    private Player stumpedBy;
    private Player runOutBy;

    public Wicket(WicketType wicketType, Player playerOut,
                  Player bowledBy, Player caughtBy, Player stumpedBy,
                  Player runOutBy) {
        this.wicketType = wicketType;
        this.playerOut = playerOut;
        this.bowledBy = bowledBy;
        this.caughtBy = caughtBy;
        this.stumpedBy = stumpedBy;
        this.runOutBy = runOutBy;
    }
}
