package Delfinen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    public void saveData(ArrayList<Member> members) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("Data/SwimmerData.csv"));

        for (Member member : members) {
            output.print("");

            output.print(member.getFirstName() + ";");
            output.print(member.getLastName() + ";");
            output.print(member.getGender() + ";");
            output.print(member.getAge() + ";");
            output.print(member.isActive() + ";");
            output.print(member.isCompetitive() + ";");
            output.print(member.hasPaid() + ";");
            output.print(member.isStudent() + ";");
            output.print(member.getSubscription() + ";");

            if(member.isCompetitive()) {
                output.print(((CompetitiveSwimmer) member).canCrawl() + ";");
                output.print(((CompetitiveSwimmer) member).canBackcrawl()+ ";");
                output.print(((CompetitiveSwimmer) member).canButterfly()+ ";");
                output.print(((CompetitiveSwimmer) member).canBreastswimming()+ ";");
            }

            output.println("");
        }
        output.close();

    }

    public void loadData(ArrayList<Member> members) throws FileNotFoundException {
        Scanner scanList = new Scanner(new File("Data/SwimmerData.csv"));

        members.clear();

        while (scanList.hasNextLine()) {
            String scan = scanList.nextLine();

            Member member = splitLines(scan);

            members.add(member);
        }
    }

    private Member splitLines(String scan) {
        String[] split = scan.split(";");
        boolean isCompetitive = Boolean.parseBoolean(split[5]);

        if(isCompetitive) {
            CompetitiveSwimmer competitiveSwimmer = new CompetitiveSwimmer();
            competitiveSwimmer.setFirstName(split[0]);
            competitiveSwimmer.setLastName(split[1]);
            competitiveSwimmer.setGender(split[2]);
            competitiveSwimmer.setAge(Integer.parseInt(split[3]));
            competitiveSwimmer.setActive(Boolean.parseBoolean(split[4]));
            competitiveSwimmer.setCompetitive(Boolean.parseBoolean(split[5]));
            competitiveSwimmer.setHasPaid(Boolean.parseBoolean(split[6]));
            competitiveSwimmer.setStudent(Boolean.parseBoolean(split[7]));
            competitiveSwimmer.setSubscription(Integer.parseInt(split[8]));
            competitiveSwimmer.setCanButterfly(Boolean.parseBoolean(split[9]));
            competitiveSwimmer.setCanCrawl(Boolean.parseBoolean(split[10]));
            competitiveSwimmer.setCanBackcrawl(Boolean.parseBoolean(split[11]));
            competitiveSwimmer.setCanBreastStroke(Boolean.parseBoolean(split[12]));
            return competitiveSwimmer;
        } else {
            NormalSwimmer normalSwimmer = new NormalSwimmer();
            normalSwimmer.setFirstName(split[0]);
            normalSwimmer.setLastName(split[1]);
            normalSwimmer.setGender(split[2]);
            normalSwimmer.setAge(Integer.parseInt(split[3]));
            normalSwimmer.setActive(Boolean.parseBoolean(split[4]));
            normalSwimmer.setCompetitive(Boolean.parseBoolean(split[5]));
            normalSwimmer.setHasPaid(Boolean.parseBoolean(split[6]));
            normalSwimmer.setStudent(Boolean.parseBoolean(split[7]));
            normalSwimmer.setSubscription(Integer.parseInt(split[8]));
            return normalSwimmer;
        }
    }

}


