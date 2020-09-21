package com.gb.cricscore;

import com.gb.cricscore.model.match.Tournament;
import com.gb.cricscore.model.people.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CricScoreMain {
    public static void main(String[] args) {
        Tournament tournament = new Tournament("Gavaskar - Border Series",
                LocalDateTime.now().plusDays(7), LocalDateTime.now().plusDays(21));
        Team indianTeam = new Team("TEAM INDIA", "Gavaskar - Border Series");
        indianTeam.getPlayers().addAll(getIndianSquad());

        indianTeam.getSupportStaffs().add(new Coach("Gary kirsten"));
        indianTeam.getSupportStaffs().add(new Coach("Anil Kumble"));
        indianTeam.getSupportStaffs().add(new Manager("Girish Dongre"));
        indianTeam.getSupportStaffs().add(new Physio("Nitin Patel"));

        tournament.getTeams().add(indianTeam);

        Team ausTeam = new Team("TEAM AUSTRALIA", "Gavaskar - Border Series");
        ausTeam.getPlayers().addAll(getAustralianSquad());

        ausTeam.getSupportStaffs().add(new Coach("Justin Langer"));
        ausTeam.getSupportStaffs().add(new Coach("Sridharan Sriram"));
        ausTeam.getSupportStaffs().add(new Coach("Mike Young"));
        ausTeam.getSupportStaffs().add(new Physio("David Beakley"));

        tournament.getTeams().add(ausTeam);

        tournament.getSponsors().add("HERO MOTORS");
        tournament.getSponsors().add("ANZ");


    }

    private static List<Player> getIndianSquad() {
        List<Player> players = new ArrayList<>();
        Player captain = new Player("MS Dhoni");
        captain.setPlayerResponsibility(PlayerResponsibility.CAPTAIN);
        captain.setPlayerType(PlayerType.WICKET_KEEPER);
        players.add(captain);

        Player vc = new Player("VIRAT KHOLI");
        vc.setPlayerResponsibility(PlayerResponsibility.VICE_CAPTAIN);
        vc.setPlayerType(PlayerType.BATSMAN);
        players.add(vc);

        Player player1 = new Player("ROHIT SHARMA");
        player1.setPlayerResponsibility(PlayerResponsibility.PLAYER);
        player1.setPlayerType(PlayerType.BATSMAN);
        players.add(player1);

        Player player2 = new Player("SHIKAR DHAWAN");
        player2.setPlayerResponsibility(PlayerResponsibility.PLAYER);
        player2.setPlayerType(PlayerType.BATSMAN);
        players.add(player2);

        Player player3 = new Player("AMBATI RAYUDU");
        player3.setPlayerResponsibility(PlayerResponsibility.PLAYER);
        player3.setPlayerType(PlayerType.BATSMAN);
        players.add(player3);

        Player player4 = new Player("HARDIK PANDYA");
        player4.setPlayerResponsibility(PlayerResponsibility.PLAYER);
        player4.setPlayerType(PlayerType.ALL_ROUNDER);
        players.add(player4);

        Player player5 = new Player("DINESH KARTHIK");
        player5.setPlayerResponsibility(PlayerResponsibility.PLAYER);
        player5.setPlayerType(PlayerType.WICKET_KEEPER);
        players.add(player5);

        Player player6 = new Player("BUMRAH");
        player6.setPlayerResponsibility(PlayerResponsibility.PLAYER);
        player6.setPlayerType(PlayerType.BOWLER);
        players.add(player6);

        Player player7 = new Player("SHAMI");
        player7.setPlayerResponsibility(PlayerResponsibility.PLAYER);
        player7.setPlayerType(PlayerType.BOWLER);
        players.add(player7);

        Player player8 = new Player("BHUVENESHWAR");
        player8.setPlayerResponsibility(PlayerResponsibility.PLAYER);
        player8.setPlayerType(PlayerType.BOWLER);
        players.add(player8);

        Player player9 = new Player("SIR RAVI JADEJA");
        player9.setPlayerResponsibility(PlayerResponsibility.PLAYER);
        player9.setPlayerType(PlayerType.BOWLER);
        players.add(player9);

        Player player10 = new Player("CHAHAL");
        player10.setPlayerResponsibility(PlayerResponsibility.PLAYER);
        player10.setPlayerType(PlayerType.BOWLER);
        players.add(player10);

        Player player11 = new Player("KULDEEP");
        player11.setPlayerResponsibility(PlayerResponsibility.PLAYER);
        player11.setPlayerType(PlayerType.BOWLER);
        players.add(player11);

        Player player12 = new Player("KEDHAR");
        player12.setPlayerResponsibility(PlayerResponsibility.PLAYER);
        player12.setPlayerType(PlayerType.ALL_ROUNDER);
        players.add(player12);

        return players;
    }

    private static List<Player> getAustralianSquad() {
        List<Player> players = new ArrayList<>();
        Player captain = new Player("Aaron Finch");
        captain.setPlayerResponsibility(PlayerResponsibility.CAPTAIN);
        captain.setPlayerType(PlayerType.BATSMAN);
        players.add(captain);

        Player vc = new Player("Usman Khawaja");
        vc.setPlayerResponsibility(PlayerResponsibility.VICE_CAPTAIN);
        vc.setPlayerType(PlayerType.WICKET_KEEPER);
        players.add(vc);

        Player player1 = new Player("David Warner");
        player1.setPlayerResponsibility(PlayerResponsibility.PLAYER);
        player1.setPlayerType(PlayerType.BATSMAN);
        players.add(player1);

        Player player2 = new Player("Steve Smith");
        player2.setPlayerResponsibility(PlayerResponsibility.PLAYER);
        player2.setPlayerType(PlayerType.BATSMAN);
        players.add(player2);

        Player player3 = new Player("Shaun Marsh");
        player3.setPlayerResponsibility(PlayerResponsibility.PLAYER);
        player3.setPlayerType(PlayerType.BATSMAN);
        players.add(player3);

        Player player4 = new Player("Glenn Maxwell");
        player4.setPlayerResponsibility(PlayerResponsibility.PLAYER);
        player4.setPlayerType(PlayerType.ALL_ROUNDER);
        players.add(player4);

        Player player5 = new Player("Marcus Stoinis");
        player5.setPlayerResponsibility(PlayerResponsibility.PLAYER);
        player5.setPlayerType(PlayerType.WICKET_KEEPER);
        players.add(player5);

        Player player6 = new Player("Alex Carey");
        player6.setPlayerResponsibility(PlayerResponsibility.PLAYER);
        player6.setPlayerType(PlayerType.BOWLER);
        players.add(player6);

        Player player7 = new Player("Pat Cummins");
        player7.setPlayerResponsibility(PlayerResponsibility.PLAYER);
        player7.setPlayerType(PlayerType.BOWLER);
        players.add(player7);

        Player player8 = new Player("Mitchell Starc");
        player8.setPlayerResponsibility(PlayerResponsibility.PLAYER);
        player8.setPlayerType(PlayerType.BOWLER);
        players.add(player8);

        Player player9 = new Player("Jhye Richardson");
        player9.setPlayerResponsibility(PlayerResponsibility.PLAYER);
        player9.setPlayerType(PlayerType.BOWLER);
        players.add(player9);

        Player player10 = new Player("Nathan Coulter-Nile");
        player10.setPlayerResponsibility(PlayerResponsibility.PLAYER);
        player10.setPlayerType(PlayerType.BOWLER);
        players.add(player10);

        Player player11 = new Player("Jason Behrendorff");
        player11.setPlayerResponsibility(PlayerResponsibility.PLAYER);
        player11.setPlayerType(PlayerType.BOWLER);
        players.add(player11);

        Player player12 = new Player("Nathan Lyon");
        player12.setPlayerResponsibility(PlayerResponsibility.PLAYER);
        player12.setPlayerType(PlayerType.BOWLER);
        players.add(player12);

        return players;
    }
}
