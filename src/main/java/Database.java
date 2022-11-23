import java.util.ArrayList;
import java.util.Scanner;

public class Database {


    private ArrayList<Member> members = new ArrayList<>();


    public void addMember(String firstName, String lastName, String gender, int age,
                          boolean isActive, boolean isCompetetive,
                          boolean hasPaid) {
        Member member;
        if (isCompetetive) {
            member = new CompetitiveSwimmer(firstName, lastName, gender, age, isActive, hasPaid);
        } else
            member = new NormalSwimmer(firstName, lastName, gender, age, isActive, hasPaid);
        members.add(member);
    }

    public ArrayList<Member> getAllSwimmers() {
        return members;
    }

    public ArrayList<Member> getCompetitiveSwimmers() {
        ArrayList<Member> competetiveSwimmers = new ArrayList<>();
        for (Member member : members) {
            if (member.isCompetitive()) {
                competetiveSwimmers.add(member);
            }
        }
        return competetiveSwimmers;
    }

    public ArrayList<Member> getNormalSwimmers() {
        ArrayList<Member> normalSwimmers = new ArrayList<>();
        for (Member member : members) {
            if (!member.isCompetitive()) {
                normalSwimmers.add(member);
            }
        }
        return normalSwimmers;
    }

    public void editSwimmer(String name) {
        boolean found = false;
        Scanner sc = new Scanner(System.in);
        for (Member member : members) {
            do {
                if (member.getFirstName().toLowerCase().contains(name.toLowerCase()) || member.getLastName().toLowerCase().contains(name.toLowerCase())) {
                    found = true;

                    System.out.println("You are about to edit " + member.getFirstName() + " " + member.getLastName() + "\n Which information on the member would you like to edit?");
                    System.out.println("1: Firstname: " + member.getFirstName()); // evt erstat det her med GETTERS, skal lige finde ud af hvordan vi tager fat i den som der er søgt på
                    System.out.println("2: Lastname: " + member.getLastName());
                    System.out.println("3: Age: " + member.getAge());
                    System.out.println("4: Gender" + member.getGender());
                    System.out.println("5: Status of membership: active/passive " + member.isActive());
                    System.out.println("6: Competitive status: " + member.isCompetitive());
                    System.out.println("7: Payment confirmed: " + member.hasPaid());
                    System.out.println("8: Go back to the general menu");
                    // TO-DO: Tjek op på om vi skal bruge en anden scanner
                    int choice = sc.nextInt();
                    if (choice == 1) {
                        System.out.println("Enter new firstname");
                        String firstname = sc.next();
                        member.setFirstName(firstname);
                        System.out.println("The firstname has been changed to: " + member.getFirstName());
                        System.out.println(" ");
                        System.out.println("Would you like to continue editing info on the selected member? yes/no");
                        String svar = sc.next();

                        if (svar.equals("no")) {
                            found = false;
                        }

                    } else if (choice == 2) {
                        System.out.println("Enter new lastname");
                        String lastname = sc.nextLine();
                        member.setLastName(lastname);
                        System.out.println("The lastname has been changed to: " + member.getLastName());
                        System.out.println(" ");
                        System.out.println("Would you like to continue editing info on the selected member? yes/no");
                        String svar = sc.next();

                        if (svar.equals("no")) {
                            found = false;
                        }
                    } else if (choice == 3) {
                        System.out.println("Enter age");
                        int age = sc.nextInt();
                        member.setAge(age);
                        System.out.println("The age has been changed to: " + member.getAge());
                        System.out.println("Would you like to continue editing info on the selected member? yes/no");
                        String svar = sc.next();

                        if (svar.equals("no")) {
                            found = false;
                        }


                    } else if (choice == 4) {
                        System.out.println("What gender do you wish to set the member to? The member currently identifies as: ");
                        String gender = sc.nextLine();
                        member.setGender(gender);
                        System.out.println("The gender has been changed to: " + member.getGender());
                        System.out.println("Would you like to continue editing info on the selected member? yes/no");
                        String svar = sc.next();

                        if (svar.equals("no")) {
                            found = false;
                        }

                    } else if (choice == 5) {
                        System.out.println("The membership status is currently set to: ");
                        System.out.println("Do you wish to switch it to (opposite of current status)");
                        Boolean status = sc.nextBoolean();
                        member.setActive(status);
                        System.out.println("The membership status has been changed to: " + member.isActive());
                        System.out.println("Would you like to continue editing info on the selected member? yes/no");
                        String svar = sc.next();

                        if (svar.equals("no")) {
                            found = false;
                        }

                    } else if (choice == 6) {
                        System.out.println("The swimmers competitive status is currently set to: ");
                        System.out.println("Do you wish to switch it to (opposite of current status)");
                        Boolean competitiveStatus = sc.nextBoolean();
                        member.setCompetitive(competitiveStatus);
                        System.out.println("The competitivestatus has been changed to: " + member.isCompetitive());
                        System.out.println("Would you like to continue editing info on the selected member? yes/no");
                        String svar = sc.next();

                        if (svar.equals("no")) {
                            found = false;
                        }

                    } else if (choice == 7) {
                        System.out.println("The swimmers payment status is set to: ");
                        System.out.println("The current status of the payment status is: " + member.hasPaid());
                        System.out.println("Enter true/false if you  wish to switch it");
                        Boolean hasPaid = sc.nextBoolean();
                        member.setHasPaid(hasPaid);
                        System.out.println("The payment status of member " + member.getFirstName() + " " + member.getLastName() + " has been switched to " + member.hasPaid());
                        System.out.println("Would you like to continue editing info on the selected member? yes/no");
                        String svar = sc.next();


                        if (svar.equals("no")) {
                            found = false;
                        }
                    } else if (choice == 8) {
                        found = false;
                    }

                }

            } while (found == true);


        }
    }
}



