package Delfinen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TeamFileHandler {


    public void saveTeamData(ArrayList<Team> teams) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("Data/TeamData.csv"));

        for (Team team : teams) {

            output.print("");

            output.print(team.getId() + ";");
            output.print(team.getName() + ";");

            output.println("");
        }
        output.close();
    }

    public void loadTeamData(ArrayList<Team> teams) throws FileNotFoundException {

        Scanner scanList = new Scanner(new File("Data/TeamData.csv"));

        teams.clear();

        while (scanList.hasNextLine()) {
            String scan = scanList.nextLine();

            Team team = splitLines(scan);

            teams.add(team);
        }
    }

    private Team splitLines(String scan) {
        String[] split = scan.split(";");

        Team team = new Team();

        team.setId(Integer.parseInt(split[0]));
        team.setName(split[1]);

        return team;
    }



}
