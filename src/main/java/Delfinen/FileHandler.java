package Delfinen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileHandler {

    public void saveData(ArrayList<Member> members) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("Data/SwimmerData.csv"));

        for (Member member : members) {
            output.print("");

            output.print(member.getId() + ";");
            output.print(member.getFirstName() + ";");
            output.print(member.getLastName() + ";");
            output.print(member.getGender() + ";");
            output.print(member.getAge() + ";");
            output.print(member.isActive() + ";");
            output.print(member.isCompetitive() + ";");
            output.print(member.hasPaid() + ";");
            output.print(member.isStudent() + ";");
            output.print(member.getSubscription() + ";");

            if (member.isCompetitive() && member instanceof CompetitiveSwimmer) {
                output.print(((CompetitiveSwimmer) member).canButterfly() + ";");
                output.print(((CompetitiveSwimmer) member).canCrawl() + ";");
                output.print(((CompetitiveSwimmer) member).canBackcrawl() + ";");
                output.print(((CompetitiveSwimmer) member).canBreastswimming() + ";");
                output.print(((CompetitiveSwimmer) member).getButterflyScore() + ";");
                output.print(((CompetitiveSwimmer) member).getCrawlScore() + ";");
                output.print(((CompetitiveSwimmer) member).getBackCrawlScore() + ";");
                output.print(((CompetitiveSwimmer) member).getBreastStrokeScore() + ";");
            }

            output.println("");
        }
        output.close();

    }

    public void saveTrainerData(ArrayList<Trainer> trainers) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("Data/TrainerData.csv"));

        for (Trainer trainer : trainers) {
            output.print("");

            output.print(trainer.getId() + ";");
            output.print(trainer.getName() + ";");
            output.print(trainer.getLastName() + ";");

            output.println("");
        }
        output.close();

    }

    public void loadData(ArrayList<Member> members) throws FileNotFoundException {
        Scanner scanList = new Scanner(new File("Data/SwimmerData.csv"));

        members.clear();

        while (scanList.hasNextLine()) {
            String scan = scanList.nextLine();

           // Member member = splitLines(scan);

            members.add(splitLines(scan));
        }
    }

    public void loadTrainerData(ArrayList<Trainer> trainers) throws FileNotFoundException {
        Scanner scanList = new Scanner(new File("Data/trainerData.csv"));

        trainers.clear();

        while (scanList.hasNextLine()) {
            String scan = scanList.nextLine();

            Trainer trainer = splitLinesTrainer(scan);

            trainers.add(trainer);
        }
    }

    private Member splitLines(String scan) {
        String[] split = scan.split(";");
        boolean isCompetitive = Boolean.parseBoolean(split[6]);

        if(isCompetitive) {
            CompetitiveSwimmer competitiveSwimmer = new CompetitiveSwimmer();
            competitiveSwimmer.setId(Integer.parseInt(split[0]));
            competitiveSwimmer.setFirstName(split[1]);
            competitiveSwimmer.setLastName(split[2]);
            competitiveSwimmer.setGender(Boolean.parseBoolean(split[3]));
            competitiveSwimmer.setAge(Integer.parseInt(split[4]));
            competitiveSwimmer.setActive(Boolean.parseBoolean(split[5]));
            competitiveSwimmer.setCompetitive(Boolean.parseBoolean(split[6]));
            competitiveSwimmer.setHasPaid(Boolean.parseBoolean(split[7]));
            competitiveSwimmer.setStudent(Boolean.parseBoolean(split[8]));
            competitiveSwimmer.setSubscription(Integer.parseInt(split[9]));
            competitiveSwimmer.setCanButterfly(Boolean.parseBoolean(split[10]));
            competitiveSwimmer.setCanCrawl(Boolean.parseBoolean(split[11]));
            competitiveSwimmer.setCanBackcrawl(Boolean.parseBoolean(split[12]));
            competitiveSwimmer.setCanBreastStroke(Boolean.parseBoolean(split[13]));
            competitiveSwimmer.setButterflyScore(Double.parseDouble(split[14]));
            competitiveSwimmer.setCrawlScore(Double.parseDouble(split[15]));
            competitiveSwimmer.setBackCrawlScore(Double.parseDouble(split[16]));
            competitiveSwimmer.setBackCrawlScore(Double.parseDouble(split[17]));
            return competitiveSwimmer;
        } else {
            NormalSwimmer normalSwimmer = new NormalSwimmer();
            normalSwimmer.setId(Integer.parseInt(split[0]));
            normalSwimmer.setFirstName(split[1]);
            normalSwimmer.setLastName(split[2]);
            normalSwimmer.setGender(Boolean.parseBoolean(split[3]));
            normalSwimmer.setAge(Integer.parseInt(split[4]));
            normalSwimmer.setActive(Boolean.parseBoolean(split[5]));
            normalSwimmer.setCompetitive(Boolean.parseBoolean(split[6]));
            normalSwimmer.setHasPaid(Boolean.parseBoolean(split[7]));
            normalSwimmer.setStudent(Boolean.parseBoolean(split[8]));
            normalSwimmer.setSubscription(Integer.parseInt(split[9]));
            return normalSwimmer;
        }
    }

    private Trainer splitLinesTrainer(String scan) {
        String[] splitTrainer = scan.split(";");

        Trainer trainer = new Trainer();

        trainer.setId(Integer.parseInt(splitTrainer[0]));
        trainer.setName(splitTrainer[1]);
        trainer.setLastName(splitTrainer[2]);

        return trainer;
    }

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

            Team team = splitLinesTeam(scan);

            teams.add(team);
        }
    }

    private Team splitLinesTeam(String scan) {
        String[] split = scan.split(";");

        Team team = new Team();

        team.setId(Integer.parseInt(split[0]));
        team.setName(split[1]);

        return team;
    }


}




