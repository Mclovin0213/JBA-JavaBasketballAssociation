package org.main;

import com.github.javafaker.Faker;

public class Player {
    private String playerType;
    private String name;
    private Position position;
    private PhysicalAttributes physicals;
    private SkillAttributes skills;
    Faker faker = new Faker();


    public Player(Position position, String playerType) {
        generateName();
        this.position = position;
        this.physicals = new PhysicalAttributes(position, playerType);
        this.skills = new SkillAttributes(position, playerType);
    }

    private void generateName() {
        name = faker.funnyName().name();
    }

    public String getPosition() {
        if (position == Position.PG) {
            return "PG";
        } else if (position == Position.SG) {
            return "SG";
        } else if (position == Position.SF) {
            return "SF";
        } else if (position == Position.PF) {
            return "PF";
        } else {
            return "C";
        }
    }

    @Override
    public String toString() {
        return "name: " + name + ", height: " + physicals.height + ", position: "
                + getPosition();
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return physicals.height;
    }
}
