package com.gb.cricscore.model.match;

import com.gb.cricscore.common.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stadium {
    private String name;
    private Address address;

    public Stadium(String name) {
        this.name = name;
    }
}
