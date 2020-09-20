package com.gb.cricscore.repository;

import com.gb.cricscore.model.match.Match;
import com.gb.cricscore.model.match.Tournament;
import com.gb.cricscore.model.people.Team;

import java.util.HashMap;
import java.util.Map;

public class DataSink {
    public static Map<String, Tournament> tournamentMap = new HashMap<>();
    public static Map<String, Match> matchMap = new HashMap<>();
    public static Map<String, Team> teamMap = new HashMap<>();
}
