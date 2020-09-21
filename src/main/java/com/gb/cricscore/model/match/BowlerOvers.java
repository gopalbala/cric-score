package com.gb.cricscore.model.match;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class BowlerOvers {
    private String name;
    private Map<Integer, Over> overMap;
}
