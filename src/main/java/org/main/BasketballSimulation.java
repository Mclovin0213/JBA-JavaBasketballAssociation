package org.main;

public class BasketballSimulation {
    public static void main(String[] args) {
        Team team = new Team();
        Team team2 = new Team();
        GameSimulator match =  new GameSimulator(team, team2);
        match.simulateMatch();
        System.out.println(team.getRegularSeasonRecord());
        System.out.println(team2.getRegularSeasonRecord());
    }
}