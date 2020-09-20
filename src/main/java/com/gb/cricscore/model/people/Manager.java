package com.gb.cricscore.model.people;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Manager extends SupportStaff {
    public Manager(String name) {
        super(name);
    }
}
