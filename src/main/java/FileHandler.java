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
            output.print(member.getAge() + ";");
            output.print(member.isActive() + ";");
            output.print(member.isCompetitive() + ";");
            output.print(member.hasPaid() + ";");

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
        Member member = new Member();

        member.setFirstName(split[0]);
        member.setLastName(split[1]);
        member.setAge(Integer.parseInt(split[2]));
        member.setActive(Boolean.parseBoolean(split[3]));
        member.setCompetitive(Boolean.parseBoolean(split[4]));
        member.setHasPaid(Boolean.parseBoolean(split[5]));

        return member;
    }



}
