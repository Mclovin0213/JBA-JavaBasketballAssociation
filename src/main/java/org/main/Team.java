package org.main;

import com.github.javafaker.Faker;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Team {
    private String name;
    private String city;
    private int totalRating;
    private int totalOffensiveRating;
    private int totalDefensiveRating;
    public List<Point> regularSeasonSchedule;
    public int[] regularSeasonRecord;
    private Player[] players;
    Faker faker = new Faker();

    public Team() {
        regularSeasonRecord = new int[2];
        regularSeasonSchedule = new ArrayList<>();
        generatePlayers();
        generateName();
        generateCity();
    }

    private void generateCity() {
        city = faker.address().cityName();
    }

    private void generateName() {
        name = faker.team().creature();
    }

    private void generatePlayers() {
        players = new Player[10];
        Position[] pos = {Position.PG, Position.SG, Position.SF, Position.PF, Position.C};
        String playerType = "";
        for (int i = 0; i < 10; i++) {
            int num = faker.number().numberBetween(0,19);
            if (num == 0) {
                playerType = "Two-Way Superstar";
            } else if (num >= 1 && num < 3) {
                playerType = "Offensive Superstar";
            } else if (num >= 3 && num < 5) {
                playerType = "Defensive Specialist";
            } else if (num >= 5 && num < 7) {
                playerType = "Star";
            }  else if (num >= 7 && num < 17) {
                playerType = "Role-Player";
            } else {
                playerType = "Scrub";
            }
            players[i] = new Player(pos[i % 5], playerType);
        }
    }

    public String getRegularSeasonSchedule() {
        return regularSeasonSchedule.toString();
    }

    public String getCity() {
        return city;
    }

    public Player[] getPlayers() {
        return players;
    }

    public String getName() {
        return name;
    }

    public String getRegularSeasonRecord() {
        return Arrays.toString(regularSeasonRecord);
    }

    public void addWin() {
        regularSeasonRecord[0]++;
    }

    public void addLoss() {
        regularSeasonRecord[1]++;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + city + " " + name + '\n' +
                ", players=" + Arrays.toString(players) +
                '}';
    }
}
