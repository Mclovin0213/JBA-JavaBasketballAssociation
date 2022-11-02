package org.main;

import com.github.javafaker.Faker;

import java.util.Arrays;

public class Team {
    private String name;
    private String city;
    private Player[] players = new Player[10];
    Faker faker = new Faker();


    public Team() {
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
        String[] position = {"PG", "SG", "SF", "PF", "C"};
        int posIndex = 0;
        for (int i = 0; i < 10; i++) {
            players[i] = new Player(position[i % 5]);
        }
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + city + " " + name + '\n' +
                ", players=" + Arrays.toString(players) +
                '}';
    }
}
