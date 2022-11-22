import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInterface {


    Controller controller = new Controller();
    Scanner scanner = new Scanner(System.in);

    public void start() throws FileNotFoundException {

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

    private void chairmanUI() throws FileNotFoundException {

        int chairmanChoice;
        System.out.println("Chairman password identified!");

        do {
            controller.loadData();

            System.out.println("1) Register swimmer\n" +
                    "2) List of all swimmers\n" +
                    "3) List of competitive swimmers\n" +
                    "4) List of casual swimmers\n" +
                    "5) List of active swimmers\n" +
                    "6) List of inactive swimmers\n" +
                    "7) List of junior swimmers\n" +
                    "8) List of senior swimmers");

            chairmanChoice = scanner.nextInt();

            switch (chairmanChoice) {
                case 1:
                    registerMember();
                    break;
                case 2:
                    listOfAllSwimmers();
                    break;
                case 3:
                    listOfCompetitiveSwimmers();
                    break;
                case 4:
                    listOfNormalSwimmers();
                    break;
                case 5:
                    listOfActiveSwimmers();
                    break;
                case 6:
                    listOfInactiveSwimmers();
                    break;
                case 7:
                    listOfJuniorSwimmers();
                    break;
                case 8:
                    listOfSeniorSwimmers();
            }
        } while (chairmanChoice <= 8 && chairmanChoice > 0);


    }

    private void registerMember() throws FileNotFoundException {

        System.out.println("You have selected register member\n" +
                "Enter first name: ");

        scanner.nextLine();                                     //Scanner bug

        String firstName = scanner.nextLine();

        System.out.println("Enter last name");

        String lastName = scanner.nextLine();

        System.out.println("Enter gender: male / female: ");

        String gender = scanner.nextLine();

        System.out.println("Enter the member's age");
        //TODO: HANDLE WRONG INPUT
        int age = scanner.nextInt();

        // isActive
        System.out.println("Is the member active? (yes/no)");
        //TODO: HANDLE WRONG INPUT

        boolean isActive = true;
        char active;

        active = scanner.next().charAt(0);
        if (active == 'n') {
            isActive = false;
        } else if (active == 'y') {
            isActive = true;
        }

        // isCompetitive
        System.out.println("Is the member a competitive swimmer?");
        //TODO: HANDLE WRONG INPUT

        boolean isCompetitive = true;
        char competitive;

        competitive = scanner.next().charAt(0);
        if (competitive == 'n') {
            isCompetitive = false;
        } else if (competitive == 'y') {
            isCompetitive = true;
        }

        // hasPaid
        System.out.println("Has the member paid?");
        //TODO: HANDLE WRONG INPUT

        boolean hasPaid = true;
        char paid;

        paid = scanner.next().charAt(0);
        if (paid == 'n') {
            hasPaid = false;
        } else if (paid == 'y') {
            hasPaid = true;
        }

        controller.createMember(firstName, lastName, gender, age, isActive, isCompetitive, hasPaid);
        controller.saveData();
    }

    private void listOfAllSwimmers() {
        System.out.println("-------------------");
        for (Member member : controller.getAllSwimmers()) {
            System.out.println("First name: " + member.getFirstName() +
                    "\nLast name: " + member.getLastName() +
                    "\nGender: " + member.getGender() +
                    "\nAge: " + member.getAge());
            if (member.isActive()) {
                System.out.println("Is the swimmer active: Yes");
            } else {
                System.out.println("Is the swimmer active: No");
            }
            if (member.isCompetitive()) {
                System.out.println("Is the swimmer competitive: Yes");
            } else {
                System.out.println("Is the swimmer competitive: No");
            }
            if (member.hasPaid()) {
                System.out.println("Has the member paid: Yes");
            } else {
                System.out.println("Has the member paid: No");
            }
            controller.setSubscription();
            if (member.getSubscription() > 0) {
                System.out.println("Subscription to pay in DKK: " + member.getSubscription() + ",-");
            }
            System.out.println("-------------------");
        }
    }

    private void listOfCompetitiveSwimmers() {
        System.out.println("-------------------");
        for (Member member : controller.getCompetitiveSwimmers()) {
            System.out.println("First name: " + member.getFirstName() +
                    "\nLast name: " + member.getLastName() +
                    "\nGender: " + member.getGender() +
                    "\nAge: " + member.getAge());
            if (member.isActive()) {
                System.out.println("Is the swimmer active: Yes");
            } else {
                System.out.println("Is the swimmer active: No");
            }
            if (member.isCompetitive()) {
                System.out.println("Is the swimmer competitive: Yes");
            } else {
                System.out.println("Is the swimmer competitive: No");
            }
            if (member.hasPaid()) {
                System.out.println("Has the member paid: Yes");
            } else {
                System.out.println("Has the member paid: No");
            }
            controller.setSubscription();
            if (member.getSubscription() > 0) {
                System.out.println("Subscription to pay in DKK: " + member.getSubscription() + ",-");
            }
            System.out.println("-------------------");
        }
    }

    private void listOfNormalSwimmers() {
        System.out.println("-------------------");
        for (Member member : controller.getNormalSwimmers()) {
            System.out.println("First name: " + member.getFirstName() +
                    "\nLast name: " + member.getLastName() +
                    "\nGender: " + member.getGender() +
                    "\nAge: " + member.getAge());
            if (member.isActive()) {
                System.out.println("Is the swimmer active: Yes");
            } else {
                System.out.println("Is the swimmer active: No");
            }
            if (member.isCompetitive()) {
                System.out.println("Is the swimmer competitive: Yes");
            } else {
                System.out.println("Is the swimmer competitive: No");
            }
            if (member.hasPaid()) {
                System.out.println("Has the member paid: Yes");
            } else {
                System.out.println("Has the member paid: No");
            }
            controller.setSubscription();
            if (member.getSubscription() > 0) {
                System.out.println("Subscription to pay in DKK: " + member.getSubscription() + ",-");
            }
            System.out.println("-------------------");
        }
    }

    private void listOfActiveSwimmers() {
        System.out.println("-------------------");
        for (Member member : controller.getActiveSwimmers()) {
            System.out.println("First name: " + member.getFirstName() +
                    "\nLast name: " + member.getLastName() +
                    "\nGender: " + member.getGender() +
                    "\nAge: " + member.getAge());
            if (member.isActive()) {
                System.out.println("Is the swimmer active: Yes");
            }
            if (member.isCompetitive()) {
                System.out.println("Is the swimmer competitive: Yes");
            } else {
                System.out.println("Is the swimmer competitive: No");
            }
            if (member.hasPaid()) {
                System.out.println("Has the member paid: Yes");
            } else {
                System.out.println("Has the member paid: No");
            }
            controller.setSubscription();
            if (member.getSubscription() > 0) {
                System.out.println("Subscription to pay in DKK: " + member.getSubscription() + ",-");
            }
            System.out.println("-------------------");
        }
    }

    private void listOfInactiveSwimmers() {
        System.out.println("-------------------");
        for (Member member : controller.getInactiveSwimmers()) {
            System.out.println("First name: " + member.getFirstName() +
                    "\nLast name: " + member.getLastName() +
                    "\nGender: " + member.getGender() +
                    "\nAge: " + member.getAge());
            if (member.isActive()) {
                System.out.println("Is the swimmer active: Yes");
            } else {
                System.out.println("Is the swimmer active: No");
            }
            if (member.isCompetitive()) {
                System.out.println("Is the swimmer competitive: Yes");
            } else {
                System.out.println("Is the swimmer competitive: No");
            }
            if (member.hasPaid()) {
                System.out.println("Has the member paid: Yes");
            } else {
                System.out.println("Has the member paid: No");
            }
            controller.setSubscription();
            if (member.getSubscription() > 0) {
                System.out.println("Subscription to pay in DKK: " + member.getSubscription() + ",-");
            }
            System.out.println("-------------------");
        }
    }

    private void listOfJuniorSwimmers() {
        System.out.println("-------------------");
        for (Member member : controller.getJuniorSwimmers()) {
            System.out.println("First name: " + member.getFirstName() +
                    "\nLast name: " + member.getLastName() +
                    "\nGender: " + member.getGender() +
                    "\nAge: " + member.getAge());
            if (member.isActive()) {
                System.out.println("Is the swimmer active: Yes");
            } else {
                System.out.println("Is the swimmer active: No");
            }
            if (member.isCompetitive()) {
                System.out.println("Is the swimmer competitive: Yes");
            } else {
                System.out.println("Is the swimmer competitive: No");
            }
            if (member.hasPaid()) {
                System.out.println("Has the member paid: Yes");
            } else {
                System.out.println("Has the member paid: No");
            }
            controller.setSubscription();
            if (member.getSubscription() > 0) {
                System.out.println("Subscription to pay in DKK: " + member.getSubscription() + ",-");
            }
            System.out.println("-------------------");
        }
    }

    private void listOfSeniorSwimmers() {
        System.out.println("-------------------");
        for (Member member : controller.getSeniorSwimmers()) {
            System.out.println("First name: " + member.getFirstName() +
                    "\nLast name: " + member.getLastName() +
                    "\nGender: " + member.getGender() +
                    "\nAge: " + member.getAge());
            if (member.isActive()) {
                System.out.println("Is the swimmer active: Yes");
            } else {
                System.out.println("Is the swimmer active: No");
            }
            if (member.isCompetitive()) {
                System.out.println("Is the swimmer competitive: Yes");
            } else {
                System.out.println("Is the swimmer competitive: No");
            }
            if (member.hasPaid()) {
                System.out.println("Has the member paid: Yes");
            } else {
                System.out.println("Has the member paid: No");
            }
            controller.setSubscription();
            if (member.getSubscription() > 0) {
                System.out.println("Subscription to pay in DKK: " + member.getSubscription() + ",-");
            }
            System.out.println("-------------------");
        }
    }


    private void cashierUI() {
        System.out.println("Cashier password identified!\nWork still in progress!");
    }


}
