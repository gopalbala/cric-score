package com.gb.cricscore.model.people;

import com.gb.cricscore.exception.InvalidMatch;
import com.gb.cricscore.exception.InvalidTeamException;
import com.gb.cricscore.exception.InvalidTournamentException;
import com.gb.cricscore.model.match.Fixture;
import com.gb.cricscore.model.match.Match;
import com.gb.cricscore.model.match.Stadium;
import com.gb.cricscore.model.match.Tournament;
import com.gb.cricscore.repository.DataSink;

import java.util.ArrayList;

public class Admin extends Person {
    public Admin(String name) {
        super(name);
    }

    public void addTournament(Tournament tournament) {
        DataSink.tournamentMap.putIfAbsent(tournament.getName(), tournament);
    }

    public void addMatch(Match match) throws InvalidTournamentException {
        if (DataSink.tournamentMap.get(match.getTournament()) == null) {
            throw new InvalidTournamentException("Invalid tournament");
        }
        DataSink.tournamentMap.get(match.getTournament())
                .getMatches().add(match);
        DataSink.matchMap.putIfAbsent(match.getMatchId(), match);
    }

    public void addTeam(Team team) throws InvalidTournamentException {
        if (DataSink.tournamentMap.get(team.getTourName()) == null) {
            throw new InvalidTournamentException("Invalid tournament");
        }
        DataSink.tournamentMap.get(team.getTourName()).getTeams().add(team);
        DataSink.teamMap.putIfAbsent(team.getName(), team);
    }

    public void addPlayer(Player player, String team, String tour) throws InvalidTeamException, InvalidTournamentException {
        if (DataSink.tournamentMap.get(tour) == null)
            throw new InvalidTournamentException("Invalid tournament");
        if (DataSink.teamMap.get(team) == null)
            throw new InvalidTeamException("Invalid team");
        DataSink.teamMap.get(team)
                .getPlayers().add(player);

    }

    public void addUmpire(Umpire umpire, String match) throws InvalidMatch {
        if (DataSink.matchMap.get(match) == null)
            throw new InvalidMatch("Invalid match");
        DataSink.matchMap.get(match).getUmpires().add(umpire);
    }

    public void addCommentator(Commentator commentator, String match) throws InvalidMatch {
        if (DataSink.matchMap.get(match) == null)
            throw new InvalidMatch("Invalid match");
        DataSink.matchMap.get(match).getCommentators().add(commentator);
        DataSink.commentators.putIfAbsent(commentator.getName(), commentator);
    }

    public void addScorer(Scorer scorer, String match) throws InvalidMatch {
        if (DataSink.matchMap.get(match) == null)
            throw new InvalidMatch("Invalid match");
        DataSink.matchMap.get(match).getScorers().add(scorer);
        DataSink.scorerMap.putIfAbsent(scorer.getName(), scorer);
    }

    public void addStadium(Stadium stadium) {
        DataSink.stadiumMap.putIfAbsent(stadium.getName(), stadium);
    }

    public void addFixture(Fixture fixture, String tournament) throws InvalidTournamentException {
        if (DataSink.tournamentMap.get(tournament) == null)
            throw new InvalidTournamentException("Invalid tournament");
        if (DataSink.fixtureMap.get(tournament) == null)
            DataSink.fixtureMap.put(tournament, new ArrayList<>());
        DataSink.fixtureMap.get(tournament).add(fixture);
    }
}
