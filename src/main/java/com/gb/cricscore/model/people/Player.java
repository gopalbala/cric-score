package com.gb.cricscore.model.people;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Player extends Person {
    public Player(String name) {
        super(name);
    }

    private PlayerResponsibility playerResponsibility;
    private PlayerType playerType;

}
