package org.main;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class PhysicalAttributes{

    private static final double[] PG_HEIGHT_PROB = {6.0, 2.0, 1.2, 0.6, 0.2};
    private static final double[] SG_HEIGHT_PROB = {1.5, 6.0, 1.5, 0.8, 0.2};
    private static final double[] SF_HEIGHT_PROB = {0.2, 0.8, 6.5, 2.0, 0.5};
    private static final double[] PF_HEIGHT_PROB = {0, 0, 2.0, 6.0, 2.0};
    private static final double[] C_HEIGHT_PROB = {0, 0, 0, 2.0, 8.0};

    Faker faker = new Faker();
    Random rand = new Random();
    int height;
    Position position;
    int weight;
    int wingspan;
    int maxVert;
    int agilityScore;
    int speedScore;

    public PhysicalAttributes(Position position, String playerType) {
        this.position = position;
        generateHeight();
        generateWeight();
        generateWingspan();
        generateMaxVert();
        generateScores();
    }


    private void generateHeight() {
        if (Objects.equals(position, "PG")) {
            setHeight(PG_HEIGHT_PROB);
        } else if (Objects.equals(position, "SG")) {
            setHeight(SG_HEIGHT_PROB);
        } else if (Objects.equals(position, "SF")) {
            setHeight(SF_HEIGHT_PROB);
        } else if (Objects.equals(position, "PF")) {
            setHeight(PF_HEIGHT_PROB);
        } else {
            setHeight(C_HEIGHT_PROB);
        }
    }

    private void setHeight(double[] probabilities) {
        double p = rand.nextDouble() * 10.0;
        if (p < probabilities[0]) {
            height = faker.number().numberBetween(71,77); // PG 5'11 - 6'4
        } else if (probabilities[0] <= p && p < probabilities[0] + probabilities[1]) {
            height = faker.number().numberBetween(76, 79);// SG 6'4 - 6'6
        } else if (probabilities[0] + probabilities[1] <= p && p < probabilities[0] + probabilities[1] + probabilities[2]) {
            height = faker.number().numberBetween(78, 81);// SF 6'6 - 6'8
        } else if (probabilities[0] + probabilities[1] + probabilities[2] <= p && p < probabilities[0] + probabilities[1] + probabilities[2] + probabilities[3]) {
            height = faker.number().numberBetween(80, 83);// PF 6'8 - 6'10
        } else {
            height = faker.number().numberBetween(82, 89);// C 6'10 - 7'4
        }
    }

    private void generateWeight() {
        if (height >= 71 && height < 77) {
            weight = faker.number().numberBetween(165, 201);
        } else if (height >= 76 && height < 79) {
            weight = faker.number().numberBetween(195, 215);
        } else if (height >= 78 && height < 81) {
            weight = faker.number().numberBetween(210, 230);
        } else if (height >= 80 && height < 82) {
            weight = faker.number().numberBetween(220, 245);
        } else {
            weight = faker.number().numberBetween(235, 300);
        }
    }

    private void generateWingspan() {
        wingspan = (int) (height * (1 + (1.15 - 1) * rand.nextDouble()));
    }

    private void generateMaxVert() {
        maxVert = faker.number().numberBetween(28, 48);
    }

    private void generateScores() {
        agilityScore = rand.nextInt(10) + 1;
        speedScore = rand.nextInt(10) + 1;
    }

}
