package com.gb.cricscore.model.match;

import com.gb.cricscore.model.people.Player;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Wicket {
    private WicketType wicketType;
    private Player playerOut;
    private Player bowledBy;
    private Player caughtBy;
    private Player stumpedBy;
    private Player runOutBy;
}
