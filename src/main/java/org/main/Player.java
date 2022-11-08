package org.main;

import com.github.javafaker.Faker;

public class Player {
    private boolean isStar;
    private String name;
    private int height;
    private String position;
    private int offensiveRating;
    private int defensiveRating;
    Faker faker = new Faker();


    public Player(String position) {
        generateName();
        generateHeight();
        this.position = position;
        this.offensiveRating = generateOffensiveRating();
    }

    private void generateHeight() {
        height = faker.number().numberBetween(69, 89);
    }

    private void generateName() {
        name = faker.funnyName().name();
    }

    public int getDefensiveRating() {
        return defensiveRating;
    }

    public int getOffensiveRating() {
        return offensiveRating;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "name: " + name + ", height: " + height + ", position: " + position + ", offensiveRating: "
        + offensiveRating + ", isStar: " + isStar + "\n";
    }

    // Generate a random offensive rating number based on position and star probability
    private int generateOffensiveRating() {
        if (faker.number().numberBetween(0, 100) < 10) {
            isStar = true;
        }
        offensiveRating = faker.number().numberBetween(90, 115);
        if(isStar) {
            offensiveRating += 10 + faker.number().numberBetween(10,20);
        }
        return offensiveRating;
    }

    // Generate a random defensive rating number based on position and height
    private int generateDefensiveRating() {
        defensiveRating = faker.number().numberBetween(90, 130);
        return defensiveRating;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }
}
