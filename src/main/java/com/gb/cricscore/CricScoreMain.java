package com.gb.cricscore;

import com.gb.cricscore.exception.InvalidMatch;
import com.gb.cricscore.exception.InvalidTeamException;
import com.gb.cricscore.exception.InvalidTournamentException;
import com.gb.cricscore.model.match.*;
import com.gb.cricscore.model.people.*;
import com.gb.cricscore.repository.DataSink;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CricScoreMain {
    public static void main(String[] args) throws InvalidMatch, InvalidTournamentException, InvalidTeamException {
        Tournament tournament = new Tournament("Gavaskar - Border Series",
                LocalDateTime.now().plusDays(7), LocalDateTime.now().plusDays(21));

        Team indianTeam = new Team("TEAM INDIA", tournament.getName());
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

        Fixture fixture1 = new Fixture();
        fixture1.setTournament(tournament.getName());
        fixture1.setBetween(new TeamsBetween(indianTeam, ausTeam));
        fixture1.setToBePlayed(new Stadium("Bangalore Chinnaswamy stadium"));
        fixture1.setMatchStartTime(LocalDateTime.now().plusDays(8));

        Fixture fixture2 = new Fixture();
        fixture2.setTournament(tournament.getName());
        fixture2.setBetween(new TeamsBetween(indianTeam, ausTeam));
        fixture2.setToBePlayed(new Stadium("MA Chidambaram stadium"));
        fixture2.setMatchStartTime(LocalDateTime.now().plusDays(10));

        Fixture fixture3 = new Fixture();
        fixture3.setTournament(tournament.getName());
        fixture3.setBetween(new TeamsBetween(indianTeam, ausTeam));
        fixture3.setToBePlayed(new Stadium("Eden gardens"));
        fixture3.setMatchStartTime(LocalDateTime.now().plusDays(15));

        Admin admin = new Admin("cric-admin");

        admin.addStadium(new Stadium("Bangalore Chinnaswamy stadium"));
        admin.addStadium(new Stadium("MA Chidambaram stadium"));
        admin.addStadium(new Stadium("Eden gardens"));

        admin.addTournament(tournament);

        admin.addTeam(indianTeam);
        admin.addTeam(ausTeam);

        for (Player player : indianTeam.getPlayers()) {
            admin.addPlayer(player, indianTeam.getName(), tournament.getName());
        }

        for (Player player : ausTeam.getPlayers()) {
            admin.addPlayer(player, ausTeam.getName(), tournament.getName());
        }
        try {
            admin.addFixture(fixture1);
            admin.addFixture(fixture2);
            admin.addFixture(fixture3);
        } catch (InvalidTournamentException e) {
            e.printStackTrace();
        }

        Match match = new OdiMatch(new TeamsBetween(indianTeam, ausTeam));
        match.setMatchId("BGINDVSAUSM1");
        match.setTournament(tournament);
        match.setVenue("Bangalore Chinnaswamy stadium");

        admin.addMatch(match);

        List<Umpire> umpires = new ArrayList<>();

        Umpire umpire = new Umpire("Venkatragavan");
        admin.addUmpire(umpire, match.getMatchId());
        umpires.add(umpire);

        Umpire umpire1 = new Umpire("Nitin Menon");
        admin.addUmpire(umpire1, match.getMatchId());
        umpires.add(umpire1);

        Umpire umpire2 = new Umpire("Aleem Dar");
        admin.addUmpire(umpire2, match.getMatchId());
        umpires.add(umpire2);

        Umpire umpire3 = new Umpire("Kumar Dharmasena");
        admin.addUmpire(umpire3, match.getMatchId());
        umpires.add(umpire3);

        match.setUmpires(umpires);

        Referee referee = new Referee("Javagal Srinath");
        match.setReferees(List.of(referee));

        admin.addCommentator(new Commentator("Ian Botham"), match.getMatchId());
        admin.addCommentator(new Commentator("Sunil Gavaskar"), match.getMatchId());

        Toss toss = new Toss();
        toss.setTossedBy("Aaron Finch");
        toss.setAskedBy("MS Dhoni");

        toss.setWonByTeam(indianTeam.getName());
        toss.setTossAction(TossAction.BOWLING);
        match.setToss(toss);

        Scorer scorer1 = new Scorer("Scorer 1");
        Scorer scorer2 = new Scorer("Scorer 2");

        admin.addScorer(scorer1, match.getMatchId());
        admin.addScorer(scorer2, match.getMatchId());

        List<Scorer> scorers = List.of(scorer1, scorer2);
        match.setScorers(scorers);

        Innings innings1 = new Innings(1);
        setOver1(match, innings1, scorer1);
        System.out.println(ScoreCard.INSTANCE(match.getMatchId(), innings1.getInningsNumber()));
        setOver2(match, innings1, scorer1);
        System.out.println(ScoreCard.INSTANCE(match.getMatchId(), innings1.getInningsNumber()));
    }

    private static void setOver1(Match match, Innings innings, Scorer scorer1) throws InvalidMatch {
        Over over1 = new Over(1);

        Ball ball1 = new Ball(1, "BHUVENESHWAR", "Aaron Finch");
        ball1.setRunType(RunType.ZERO);
        ball1.setBallType(BallType.NORMAL);

        Commentary commentary = new Commentary("Ian botham",
                "well bowled, length ball, swings outside");
        ball1.setCommentary(commentary);

        over1.getBalls().add(ball1);
        scorer1.setScore(ball1, match.getMatchId(), innings.getInningsNumber());

        Ball ball2 = new Ball(1, "BHUVENESHWAR", "Aaron Finch");
        ball2.setRunType(RunType.ZERO);
        ball2.setBallType(BallType.NORMAL);

        commentary = new Commentary("Ian botham",
                "well bowled, length ball, swings inside");
        ball2.setCommentary(commentary);

        over1.getBalls().add(ball2);
        scorer1.setScore(ball2, match.getMatchId(), innings.getInningsNumber());
        Ball ball3 = new Ball(1, "BHUVENESHWAR", "Aaron Finch");
        ball3.setRunType(RunType.ONE);
        ball3.setBallType(BallType.NORMAL);

        commentary = new Commentary("Ian botham",
                "well bowled, lenght ball, swings outside, edged to thirdman");
        ball3.setCommentary(commentary);
        over1.getBalls().add(ball3);
        scorer1.setScore(ball3, match.getMatchId(), innings.getInningsNumber());
        Ball ball4 = new Ball(1, "BHUVENESHWAR", "David Warner");
        ball4.setRunType(RunType.ONE);
        ball4.setBallType(BallType.NORMAL);

        commentary = new Commentary("Ian botham",
                "well bowled, lenght ball, swings outside, edged to thirdman");
        ball4.setCommentary(commentary);
        over1.getBalls().add(ball4);
        scorer1.setScore(ball4, match.getMatchId(), innings.getInningsNumber());
        Ball ball5 = new Ball(1, "BHUVENESHWAR", "Aaron Finch");
        ball5.setRunType(RunType.ONE);
        ball5.setBallType(BallType.NORMAL);

        commentary = new Commentary("Ian botham",
                "well bowled, lenght ball, swings outside");
        ball5.setCommentary(commentary);
        over1.getBalls().add(ball5);
        scorer1.setScore(ball5, match.getMatchId(), innings.getInningsNumber());
        Ball ball6 = new Ball(1, "BHUVENESHWAR", "David Warner");
        ball6.setRunType(RunType.ZERO);

        ball6.setWicket(new Wicket(WicketType.BOWLED,
                DataSink.playerMap.get("David Warner"),
                DataSink.playerMap.get("BHUVENESHWAR"),
                null, null, null));
        ball6.setBallType(BallType.WICKET);
        commentary = new Commentary("Ian botham",
                "well bowled, lenght ball, swings outside");
        ball6.setCommentary(commentary);
        over1.getBalls().add(ball6);
        scorer1.setScore(ball6, match.getMatchId(), innings.getInningsNumber());
        innings.getOvers().putIfAbsent(over1.getNumber(), over1);

    }

    private static void setOver2(Match match, Innings innings, Scorer scorer1) throws InvalidMatch {
        Over over1 = new Over(2);

        Ball ball1 = new Ball(2, "BUMRAH", "Aaron Finch");
        ball1.setRunType(RunType.ONE_WIDE);
        ball1.setBallType(BallType.WIDE);
        Commentary commentary = new Commentary("Ian botham",
                "well bowled, length ball, swings outside, wide");
        ball1.setCommentary(commentary);
        over1.getBalls().add(ball1);
        scorer1.setScore(ball1, match.getMatchId(), innings.getInningsNumber());

        ball1 = new Ball(1, "BUMRAH", "Aaron Finch");
        ball1.setRunType(RunType.FIVE_WIDES);
        ball1.setBallType(BallType.WIDE);
        commentary = new Commentary("Ian botham",
                "swings outside, wide");
        ball1.setCommentary(commentary);
        over1.getBalls().add(ball1);
        scorer1.setScore(ball1, match.getMatchId(), innings.getInningsNumber());

        //1
        ball1 = new Ball(2, "BUMRAH", "Aaron Finch");
        ball1.setRunType(RunType.ONE);
        ball1.setBallType(BallType.NORMAL);
        commentary = new Commentary("Ian botham",
                "well bowled, length ball, one run taken");
        ball1.setCommentary(commentary);
        over1.getBalls().add(ball1);
        scorer1.setScore(ball1, match.getMatchId(), innings.getInningsNumber());

        //2
        ball1 = new Ball(2, "BUMRAH", "Usman Khawaja");
        ball1.setRunType(RunType.FOUR);
        ball1.setBallType(BallType.NORMAL);
        commentary = new Commentary("Ian botham",
                "well bowled, length ball, Boudary");
        ball1.setCommentary(commentary);
        over1.getBalls().add(ball1);
        scorer1.setScore(ball1, match.getMatchId(), innings.getInningsNumber());

        //3
        ball1 = new Ball(2, "BUMRAH", "Usman Khawaja");
        ball1.setRunType(RunType.SIX);
        ball1.setBallType(BallType.NORMAL);
        commentary = new Commentary("Ian botham",
                "well bowled, length ball, Six");
        ball1.setCommentary(commentary);
        over1.getBalls().add(ball1);
        scorer1.setScore(ball1, match.getMatchId(), innings.getInningsNumber());

        //4
        ball1 = new Ball(2, "BUMRAH", "Usman Khawaja");
        ball1.setRunType(RunType.ONE);
        ball1.setBallType(BallType.NORMAL);
        commentary = new Commentary("Ian botham",
                "well bowled, length ball, One");
        ball1.setCommentary(commentary);
        over1.getBalls().add(ball1);
        scorer1.setScore(ball1, match.getMatchId(), innings.getInningsNumber());

        //5
        ball1 = new Ball(2, "BUMRAH", "Aaron Finch");
        ball1.setRunType(RunType.FOUR);
        ball1.setBallType(BallType.NORMAL);
        commentary = new Commentary("Ian botham",
                "length ball, Boundary");
        ball1.setCommentary(commentary);
        over1.getBalls().add(ball1);
        scorer1.setScore(ball1, match.getMatchId(), innings.getInningsNumber());

        //6
        ball1 = new Ball(2, "BUMRAH", "Usman Khawaja");
        ball1.setBallType(BallType.WICKET);
        ball1.setRunType(RunType.ZERO);
        ball1.setWicket(new Wicket(WicketType.CAUGHT,
                DataSink.playerMap.get("Usman Khawaja"),
                DataSink.playerMap.get("BUMRAH"),
                DataSink.playerMap.get("MS Dhoni"), null, null));
        commentary = new Commentary("Ian botham",
                "length ball, Boundary");
        ball1.setCommentary(commentary);
        over1.getBalls().add(ball1);
        scorer1.setScore(ball1, match.getMatchId(), innings.getInningsNumber());
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
