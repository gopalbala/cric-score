package com.gb.cricscore.repository;

import com.gb.cricscore.model.match.Match;
import com.gb.cricscore.model.match.Stadium;
import com.gb.cricscore.model.match.Tournament;
import com.gb.cricscore.model.people.Commentator;
import com.gb.cricscore.model.people.Scorer;
import com.gb.cricscore.model.people.Team;

import java.util.HashMap;
import java.util.Map;

public class DataSink {
    public static Map<String, Tournament> tournamentMap = new HashMap<>();
    public static Map<String, Match> matchMap = new HashMap<>();
    public static Map<String, Team> teamMap = new HashMap<>();
    public static Map<String, Commentator> commentators = new HashMap<>();
    public static Map<String, Scorer> scorerMap = new HashMap<>();
    public static Map<String, Stadium> stadiumMap = new HashMap<>();
}
