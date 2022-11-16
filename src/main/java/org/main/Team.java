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
        generateTotalRatings();
        generateName();
        generateCity();
    }

    private void generateTotalRatings() {
        for (int i = 0; i < players.length; i++) {
            totalOffensiveRating += players[i].getOffensiveRating();
            totalDefensiveRating += players[i].getDefensiveRating();
        }
        totalRating = totalDefensiveRating + totalOffensiveRating;
    }

    private void generateCity() {
        city = faker.address().cityName();
    }

    private void generateName() {
        name = faker.team().creature();
    }


    private void generatePlayers() {
        players = new Player[10];
        String[] position = {"PG", "SG", "SF", "PF", "C"};
        int posIndex = 0;
        for (int i = 0; i < 10; i++) {
            players[i] = new Player(position[i % 5]);
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

    public int getTotalRating() {
        return totalRating;
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
