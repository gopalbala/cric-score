package com.gb.cricscore.model.match;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Over {
    private List<Ball> balls;
    private List<Run> runs;
}
