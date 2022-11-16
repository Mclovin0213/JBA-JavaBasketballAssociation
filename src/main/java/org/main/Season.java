package org.main;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Season {
    public Team[] teams = new Team[16];

    public Season(){
        createTeams();
        generateSchedules();
    }

    private void createTeams() {
        for (int i = 0; i < 16; i++) {
            teams[i] = new Team();
        }
    }

    private void generateSchedules() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 16; k++) {
                    if (i != k) {
                        teams[i].regularSeasonSchedule.add(new Point(i, k));
                    }
                }
            }
        }

    }
}
