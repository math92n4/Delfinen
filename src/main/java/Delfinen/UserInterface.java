package Delfinen;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    Controller controller = new Controller();

    Scanner scanner = new Scanner(System.in);

    public void start() throws FileNotFoundException {

        // TODO: SET SUBSCRIPTION

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
                    "2) Search for swimmer\n" +
                    "3) Edit swimmer\n" +
                    "4) Delete swimmer\n" +
                    "5) List of all swimmers\n" +
                    "6) Sorted lists of all swimmers\n" +
                    "7) List of competetive swimmers\n" +
                    "8) List of normal swimmers\n" +
                    "9) List of active swimmers\n" +
                    "10) List of inactive swimmers\n" +
                    "11) List of junior swimmers\n" +
                    "12) List of senior swimmers");

            chairmanChoice = scanner.nextInt();

            switch (chairmanChoice) {
                case 1:
                    registerMember();
                    break;
                case 2:
                    searchForSwimmer();
                    break;
                case 3:
                    editSwimmer();
                    break;
                case 4:
                    deleteSwimmer();
                    break;
                case 5:
                    listOfAllSwimmers();
                    break;
                case 6:
                    sort();
                    break;
                case 7:
                    listOfCompetitiveSwimmers();
                    break;
                case 8:
                    listOfNormalSwimmers();
                    break;
                case 9:
                    listOfActiveSwimmers();
                    break;
                case 10:
                    listOfInactiveSwimmers();
                    break;
                case 11:
                    listOfJuniorSwimmers();
                    break;
                case 12:
                    listOfSeniorSwimmers();
            }
        } while (chairmanChoice != 13);

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

        // isStudent
        System.out.println("Is the member a student?");
        //TODO: HANDLE WRONG INPUT

        boolean isStudent = true;
        char student;

        student = scanner.next().charAt(0);
        if (student == 'n') {
            isStudent = false;
        } else if (student == 'y') {
            isStudent = true;
        }

        controller.createMember(firstName, lastName, gender, age, isActive, isCompetitive, hasPaid, isStudent);
        controller.saveData();
    }

    private void searchForSwimmer() {
        ArrayList<Member> swimmerFound;
        System.out.println("Search for a member: ");
        String firstName = scanner.next();
        swimmerFound = controller.SearchForSwimmer(firstName);

        for (Member member : swimmerFound) {
            System.out.println("--------------------" + "\n" + "Delfinens medlemmer" + "\n" + "--------------------"
                    + "\n" + "First name: " + member.getFirstName() + "\n" + "Last name: "
                    + member.getLastName() + "\n" + "Age: " + member.getAge() + "\n"
                    + ("Gender: " + member.getGender() + "\n" +
                    ("Is active? " + member.isActive() + "\n" + ("Is competitive?: " + member.isCompetitive() + "\n"
                            + ("Has paid? " + member.hasPaid() + "\n" + ("Subscription to pay in DDK: " + member.getSubscription() +",-"
                    + "\n--------------------"))))));


        }
    }

    private void sort() {
        System.out.println("--------------------" + "\n");
        System.out.println("Sort the list by: " + "\n" +
                "1) first name" + "\n" +
                "2) last name " + "\n" +
                "3) Gender " + "\n" +
                "4) Age " + "\n" +
                "5) Active status " + "\n" +
                "6) Competitive status " + "\n" +
                "7) payment status " + "\n" +
                "8) Student status " + "\n" +
                "9) Subscription - soon!!...");

        int choice = scanner.nextInt();


        if (choice == 1) {
            controller.sortBy("firstName");
        } else if (choice == 2) {
            controller.sortBy("lastName");
        } else if (choice == 3) {
            controller.sortBy("gender");
        } else if (choice == 4) {
            controller.sortBy("age");
        } else if (choice == 5) {
            controller.sortBy("isActive");
        } else if (choice == 6) {
            controller.sortBy("isCompetitive");
        } else if (choice == 7) {
            controller.sortBy("hasPaid");
        } else if (choice == 8) {
            controller.sortBy("isStudent");
        }

        // when sorted, show the list again
        listOfAllSwimmers();

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
            if (member.getSubscription() > 0) {
                System.out.println("Subscription to pay in DKK: " + member.getSubscription() + ",-");
            }
            System.out.println("--------------------");
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
            if (member.getSubscription() > 0) {
                System.out.println("Subscription to pay in DKK: " + member.getSubscription() + ",-");
            }
            System.out.println("-------------------");
        }
    }

    private void deleteSwimmer() throws FileNotFoundException {
        int index = 1;
        for (Member member : controller.getAllSwimmers()) {
            System.out.println(index++ + ". Name: " + member.getFirstName() + " " + member.getLastName());
        }

        int choice = scanner.nextInt();
        controller.deleteSwimmer(choice);
        controller.saveData();
    }

    private void editSwimmer() throws FileNotFoundException {

        int index = 1;

        System.out.println("-------------------");
        for (Member member : controller.getAllSwimmers()) {
            System.out.println("# " + index++);
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
            if (member.isStudent()) {
                System.out.println("Is the member a student: Yes");
            } else {
                System.out.println("Is the member a student: No");
            }
            if (member.getSubscription() > 0) {
                System.out.println("Subscription to pay in DKK: " + member.getSubscription() + ",-");
            }
            System.out.println("-------------------");
        }


        System.out.println("Choose the swimmer you wish to edit by number");

        int swimmerChoice = scanner.nextInt();
        String firstName = "";
        String lastName = "";
        String gender = "";
        int age = 0;
        boolean isActive = false;
        boolean isCompetitive = false;
        boolean hasPaid = false;
        boolean isStudent = false;

        System.out.println("Choose the field you wish to edit\n" +
                "1) First name\n" +
                "2) Last name\n" +
                "3) Gender\n" +
                "4) Age\n" +
                "5) Is active\n" +
                "6) Is competitive\n" +
                "7) Has paid\n" +
                "8) Is student ");

        int attributeChoice = scanner.nextInt();
        scanner.nextLine();                         // Scanner bug


        if (attributeChoice == 1) {
            System.out.println("Enter first name: ");
            firstName = scanner.nextLine();

        } else if (attributeChoice == 2) {
            System.out.println("Enter last name: ");
            lastName = scanner.nextLine();

        } else if (attributeChoice == 3) {
            System.out.println("Enter gender: ");
            gender = scanner.nextLine();

        } else if (attributeChoice == 4) {
            System.out.println("Enter age: ");
            age = scanner.nextInt();

        } else if (attributeChoice == 5) {
            System.out.println("Is the member active? (y/n)");
            char active = scanner.next().charAt(0);
            if (active == 'y') {
                isActive = true;
            } else if (active == 'n') {
                isActive = false;
            }

        } else if (attributeChoice == 6) {
            System.out.println("Is the member competitive? (y/n)");
            char competitive = scanner.next().charAt(0);
            if (competitive == 'y') {
                isCompetitive = true;
            } else if (competitive == 'n') {
                isCompetitive = false;
            }

        } else if (attributeChoice == 7) {
            System.out.println("Has the member paid? (y/n)");
            char paid = scanner.next().charAt(0);
            if (paid == 'y') {
                hasPaid = true;
            } else if (paid == 'n') {
                hasPaid = false;
            }

        } else if (attributeChoice == 8) {
            System.out.println("Is the member a student? (y/n)");
            char student = scanner.next().charAt(0);
            if (student == 'y') {
                isStudent = true;
            } else if (student == 'n') {
                isStudent = false;
            }

        }


        controller.editSwimmer(swimmerChoice, firstName, lastName,gender, age, isActive, isActive,hasPaid,isStudent);
        controller.saveData();

    }

    private void cashierUI() throws FileNotFoundException {

        controller.loadData();

        int cashierChoice;
        System.out.println("Cashier password identified!");

        do {

            System.out.println("1) Expected income\n" +
                    "2) List of people who hasn't paid");

            cashierChoice = scanner.nextInt();

            switch (cashierChoice) {
                case 1:
                    subscriptionSum();
                    break;
                case 2:
                    listOfUnpaidSwimmers();
                    break;
            }

        } while (cashierChoice != 0);

    }

    private void listOfUnpaidSwimmers() {
        for (Member member : controller.getUnpaidSwimmers()) {
            System.out.println(member.getFirstName() + " " + member.getLastName() + " is in debt");
        }
        System.out.println("-------------------");
    }

    private void subscriptionSum() {
        System.out.println("Expected income from subscriptions: " + controller.getSubscriptionSum());
    }

    private void TrainerUI() {
        System.out.println("Trainer password identified!\nWork still in progress!");
    }

}
