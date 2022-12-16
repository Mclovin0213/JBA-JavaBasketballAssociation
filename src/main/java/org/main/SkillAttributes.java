package org.main;

public class SkillAttributes{
    Position position;

    private double threePercent;
    double midPercent;
    double finishingPercentage;
    double freePercent;
    double threeFrequency;
    double midFrequency;
    double drivePercentage;
    double passingFrequency;
    double passingScore;
    double pickAndRollFrequency;


    int basketballIQ;

    public SkillAttributes(Position position, String playerType) {
        this.position = position;

        generateShootingPercentages();

    }

    private void generateShootingPercentages() {
    }

}
