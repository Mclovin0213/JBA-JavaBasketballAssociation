package org.main;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Season {
    private Team[] teams;
    private final List<Point> schedule;

    public Season(){
        teams = new Team[16];
        schedule = new ArrayList<>();
        generateSchedule();
    }

    private void generateSchedule() {

    }

    public List<Point> getSchedule() {
        return schedule;
    }
}
