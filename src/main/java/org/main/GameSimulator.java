package org.main;

public class GameSimulator {
    public Team homeTeam;
    public Team awayTeam;

    public GameSimulator(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public void simulateMatch() {
        if (homeTeam.getTotalRating() * 1.05 > awayTeam.getTotalRating()) {
            homeTeam.addWin();
            awayTeam.addLoss();
        } else {
            awayTeam.addWin();
            homeTeam.addLoss();

        }
    }
}
