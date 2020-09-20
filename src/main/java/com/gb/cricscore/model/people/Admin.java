package com.gb.cricscore.model.people;

import com.gb.cricscore.exception.InvalidTeamException;
import com.gb.cricscore.exception.InvalidTournamentException;
import com.gb.cricscore.model.match.Fixture;
import com.gb.cricscore.model.match.Match;
import com.gb.cricscore.model.match.Stadium;
import com.gb.cricscore.model.match.Tournament;
import com.gb.cricscore.repository.DataSink;

public class Admin extends Person {
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

    public void addPlayer(Player player) throws InvalidTeamException, InvalidTournamentException {
        if (DataSink.tournamentMap.get(player.getTournament()) == null)
            throw new InvalidTournamentException("Invalid tournament");
        if (DataSink.teamMap.get(player.getTeam()) == null)
            throw new InvalidTeamException("Invalid team");
        DataSink.teamMap.get(player.getTeam())
                .getPlayers().add(player);

    }

    public void addUmpire(Umpire umpire) {

    }

    public void addCommentator(Commentator commentator) {

    }

    public void addScorer(Scorer scorer) {

    }

    public void addStadium(Stadium stadium) {

    }

    public void addFixture(Fixture fixture) {

    }
}
