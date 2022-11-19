import java.util.Scanner;

public class UserInterface {


    Controller controller = new Controller();
    Scanner scanner = new Scanner(System.in);

    public void start() {

        System.out.println("\nTHE DOPLHIN SWIMCLUB\n" + "-------------------\n" +
                "Please enter your password: ");

        String chairmanPassword = "chairman";
        String cashierPassword = "cashier";
        String password;

        do {

            password = scanner.nextLine();

            if (password.equals(chairmanPassword)) {
                chairmanUI();
            } else if (password.equals(cashierPassword)) {
                cashierUI();
            } else
                System.out.println("Password doesn't match. Please try again!");

        } while (!password.equals(chairmanPassword) && !password.equals(cashierPassword));

    }

    private void chairmanUI() {

        System.out.println("Chairman password identified!\n" +
                "1) Register swimmer\n" +
                "2) List of all swimmer\n" +
                "3) List of competetive swimmer\n" +
                "4) List of normalswimmer");

        int chairmanChoice = scanner.nextInt();

        switch (chairmanChoice) {
            case 1:
                registerMember();
            case 2:
                // List of all swimmers
            case 3:
                // List of competitive member
            case 4:
                // List of normal simmers
        }


    }

    private void registerMember() {

        System.out.println("You have selected register member\n" +
                "Enter first name: ");

        String firstName = scanner.nextLine();

        System.out.println("Enter last name");

        String lastName = scanner.nextLine();

        System.out.println("Enter the member's age");
        //TODO: TRY CATCH
        int age = scanner.nextInt();

        // isActive

        // isCompetitive

        // hasPaid



    }




    private void cashierUI() {
        System.out.println("Cashier password identified!\nWork still in progress!");
    }





        /*System.out.println("ALL SWIMMERS IN DA CLUB:");
        for (Member member : controller.getAllSwimmers()) {
            System.out.println(member.getFirstName() + " " + member.getLastName());
        }

        System.out.println("\nALL COMPETITIVE MEMBERS:");
        for (Member member : controller.getCompetitiveSwimmers()) {
            System.out.println(member.getFirstName() + " " + member.getLastName());
        }

        System.out.println("\nALL NORMAL SWIMMERS:");
        for (Member member : controller.getNormalSwimmers()) {
            System.out.println(member.getFirstName() + " " + member.getLastName());
        }*/



}
