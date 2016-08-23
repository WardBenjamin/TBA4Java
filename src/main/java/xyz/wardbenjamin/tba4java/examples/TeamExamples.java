package xyz.wardbenjamin.tba4java.examples;

import xyz.wardbenjamin.tba4java.Teams;

/**
 * Created by AdiSai on 7/19/16.
 */
public class TeamExamples {
    public String getTeamName(int number) {
        return Teams.getTeam("frc" + number).nickname;
    }
    public String getTeamWebsite(int number) {
        return Teams.getTeam("frc" + number).website;
    }
}
