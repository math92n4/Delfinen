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
        String trainerPassword = "trainer";
        String password;

        do {

            password = scanner.nextLine();

            if (password.equals(chairmanPassword)) {
                chairmanUI();
            } else if (password.equals(cashierPassword)) {
                cashierUI();
            } else if (password.equals(trainerPassword)) {
                trainerUI();
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
                    "5) Lists \n");

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
                    System.out.println("1) List of all swimmers\n" +
                            "2) Sorted lists of all swimmers\n" +
                            "3) List of competetive swimmers\n" +
                            "4) List of normal swimmers\n" +
                            "5) List of active swimmers\n" +
                            "6) List of inactive swimmers\n" +
                            "7) List of junior swimmers\n" +
                            "8) List of senior swimmers");
                    int listChoice;
                    listChoice = scanner.nextInt();
                    switch (listChoice) {
                        case 1:
                            listOfAllSwimmers();
                            break;
                        case 2:
                            sort();
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
                            break;
                    }
            }
        } while (chairmanChoice != 0);

    }

    private void registerMember() throws FileNotFoundException {

        System.out.println("You have selected register member\n" +
                "Enter first name: ");

        scanner.nextLine();                                     //Scanner bug

        String firstName = scanner.nextLine();

        System.out.println("Enter last name");

        String lastName = scanner.nextLine();

        System.out.println("Enter gender: male / female: ");

        boolean gender = true;
        char genderAnswer = scanner.next().charAt(0);
        if (genderAnswer == 'm') {
            gender = true;
        } else if (genderAnswer == 'f') {
            gender = false;
        }

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

        if (!isCompetitive) {

            controller.createNormalMember(firstName, lastName, gender, age, isActive, isCompetitive, hasPaid, isStudent);

        } else if (isCompetitive) {

            boolean canButterfly = true;
            char butterfly;

            System.out.println("Can the swimmer butterfly?");
            butterfly = scanner.next().charAt(0);
            if (butterfly == 'n') {
                canButterfly = false;
            } else if (butterfly == 'y') {
                canButterfly = true;
            }

            boolean canCrawl = true;
            char crawl;

            System.out.println("Can the swimmer crawl?");
            butterfly = scanner.next().charAt(0);
            if (butterfly == 'n') {
                canCrawl = false;
            } else if (butterfly == 'y') {
                canCrawl = true;
            }

            boolean canBackCrawl = true;
            char backCrawl;

            System.out.println("Can the swimmer back crawl?");
            backCrawl = scanner.next().charAt(0);
            if (backCrawl == 'n') {
                canBackCrawl = false;
            } else if (backCrawl == 'y') {
                canBackCrawl = true;
            }

            boolean canBreastswim = true;
            char breastSwim;

            System.out.println("Can the swimmer breast swim?");
            breastSwim = scanner.next().charAt(0);
            if (breastSwim == 'n') {
                canBreastswim = false;
            } else if (breastSwim == 'y') {
                canBreastswim = true;
            }


            controller.createCompetitiveMember(firstName, lastName, gender, age, isActive, isCompetitive, hasPaid, isStudent,
                    canButterfly, canCrawl, canBackCrawl, canBreastswim);
        }
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
                            + ("Has paid? " + member.hasPaid() + "\n" + ("Subscription to pay in DDK: " + member.getSubscription() + ",-"
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
        for (Member member : controller.getAllSwimmers()) {
            if (member.isCompetitive()) {
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
    }

    private void listOfNormalSwimmers() {
        System.out.println("-------------------");
        for (Member member : controller.getAllSwimmers()) {
            if (!member.isCompetitive()) {
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
    }

    private void listOfActiveSwimmers() {
        System.out.println("-------------------");
        for (Member member : controller.getAllSwimmers()) {
            if (member.isActive()) {
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
    }

    private void listOfInactiveSwimmers() {
        System.out.println("-------------------");
        for (Member member : controller.getAllSwimmers()) {
            if (!member.isActive()) {
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
    }

    private void listOfJuniorSwimmers() {
        System.out.println("-------------------");
        for (Member member : controller.getAllSwimmers()) {
            if (member.getAge() < 18) {
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
    }

    private void listOfSeniorSwimmers() {

        System.out.println("-------------------");
        for (Member member : controller.getAllSwimmers()) {
            if (member.getAge() >= 18) {
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
    }

    // TODO: print list of student swimmers

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
        boolean gender = false;
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
            System.out.println("Enter gender male/female: ");
            char genderAnswer = scanner.next().charAt(0);
            if (genderAnswer == 'm') {
                gender = true;
            } else if (genderAnswer == 'f') {
                gender = false;
            }

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


        controller.editSwimmer(swimmerChoice, firstName, lastName, gender, age, isActive, isActive, hasPaid, isStudent);
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
        for (Member member : controller.getAllSwimmers()) {
            if (!member.hasPaid()) {
                System.out.println(member.getFirstName() + " " + member.getLastName() + " is in debt");
            }
            System.out.println("-------------------");
        }
    }

    private void subscriptionSum() {
        System.out.println("Expected income from subscriptions: " + controller.getSubscriptionSum());
    }

    private void trainerUI() throws FileNotFoundException {


        System.out.println("Trainer password identified! ");


        int choice;
        int secondChoice;
        int thirdChoice;

        do {
            controller.loadData();

            // trainer menu
            System.out.println("1) Overview over teams \n" +
                    "2) Register new score\n" +
                    "3) Se best scores\n" +
                    "4) Edit scores\n" +
                    "5) Delete scores");
            System.out.println("---------------------");

            choice = scanner.nextInt();

            // second menu UI for overview over teams junior/senior men & junior/senior women
            if (choice == 1) {
                System.out.println("""
                        1) Junior men
                        2) Junior women
                        3) Senior men
                        4) Senior women
                        ---------------------""");

                secondChoice = scanner.nextInt();
                System.out.println("""
                        1) Butterfly
                        2) Crawl
                        3) BackCrawl
                        4) BreastStroke
                        ---------------------""");

                thirdChoice = scanner.nextInt();

                // list for junior men
                if (secondChoice == 1 && thirdChoice == 1) {
                    for (CompetitiveSwimmer competitiveSwimmer : controller.getJuniorMenButterfly()) {
                        System.out.println("First name: " + competitiveSwimmer.getFirstName() +
                                "\nLast name: " + competitiveSwimmer.getLastName() +
                                "\nGender: " + competitiveSwimmer.getGender() +
                                "\nAge: " + competitiveSwimmer.getAge() +
                                "\nCan butterfly " + competitiveSwimmer.canButterfly());
                        System.out.println("-------------------");
                    }
                }


                // list SeniorMenButterfly
                if (secondChoice == 3 && thirdChoice == 1) {
                    for (CompetitiveSwimmer competitiveSwimmer : controller.getSeniorMenButterfly()) {
                        System.out.println("First name: " + competitiveSwimmer.getFirstName() +
                                "\nLast name: " + competitiveSwimmer.getLastName() +
                                "\nGender: " + competitiveSwimmer.getGender() +
                                "\nAge: " + competitiveSwimmer.getAge() +
                                "\nCan butterfly " + competitiveSwimmer.canButterfly());
                        System.out.println("-------------------");
                    }
                }

                // list SeniorMenCrawl
                if (secondChoice == 3 && thirdChoice == 2) {
                    for (CompetitiveSwimmer competitiveSwimmer : controller.getSeniorMenCrawl()) {
                        System.out.println("First name: " + competitiveSwimmer.getFirstName() +
                                "\nLast name: " + competitiveSwimmer.getLastName() +
                                "\nGender: " + competitiveSwimmer.getGender() +
                                "\nAge: " + competitiveSwimmer.getAge() +
                                "\nCan Crawl " + competitiveSwimmer.canCrawl());
                        System.out.println("-------------------");
                    }
                }

                // list SeniorMenBackCrawl
                if (secondChoice == 3 && thirdChoice == 3) {
                    for (CompetitiveSwimmer competitiveSwimmer : controller.getSeniorMenBackCrawl()) {
                        System.out.println("First name: " + competitiveSwimmer.getFirstName() +
                                "\nLast name: " + competitiveSwimmer.getLastName() +
                                "\nGender: " + competitiveSwimmer.getGender() +
                                "\nAge: " + competitiveSwimmer.getAge() +
                                "\nCan BackCrawl " + competitiveSwimmer.canBackcrawl());
                        System.out.println("-------------------");
                    }
                }

                // list SeniorMenBreastStroke
                if (secondChoice == 3 && thirdChoice == 4) {
                    for (CompetitiveSwimmer competitiveSwimmer : controller.getSeniorMenBreastStroke()) {
                        System.out.println("First name: " + competitiveSwimmer.getFirstName() +
                                "\nLast name: " + competitiveSwimmer.getLastName() +
                                "\nGender: " + competitiveSwimmer.getGender() +
                                "\nAge: " + competitiveSwimmer.getAge() +
                                "\nCan BreastStroke " + competitiveSwimmer.canBreastswimming());
                        System.out.println("-------------------");
                    }
                }


                // list SeniorWomenButterfly
                if (secondChoice == 4 && thirdChoice == 1) {
                    for (CompetitiveSwimmer competitiveSwimmer : controller.getSeniorWomenButterfly()) {
                        System.out.println("First name: " + competitiveSwimmer.getFirstName() +
                                "\nLast name: " + competitiveSwimmer.getLastName() +
                                "\nGender: " + competitiveSwimmer.getGender() +
                                "\nAge: " + competitiveSwimmer.getAge() +
                                "\nCan butterfly " + competitiveSwimmer.canButterfly());
                        System.out.println("-------------------");
                    }
                }

                // list SeniorWomenCrawl
                if (secondChoice == 4 && thirdChoice == 2) {
                    for (CompetitiveSwimmer competitiveSwimmer : controller.getSeniorWomenCrawl()) {
                        System.out.println("First name: " + competitiveSwimmer.getFirstName() +
                                "\nLast name: " + competitiveSwimmer.getLastName() +
                                "\nGender: " + competitiveSwimmer.getGender() +
                                "\nAge: " + competitiveSwimmer.getAge() +
                                "\nCan Crawl " + competitiveSwimmer.canButterfly());
                        System.out.println("-------------------");
                    }
                }

                // list SeniorWomenBackCrawl
                if (secondChoice == 4 && thirdChoice == 3) {
                    for (CompetitiveSwimmer competitiveSwimmer : controller.getSeniorWomenBackCrawl()) {
                        System.out.println("First name: " + competitiveSwimmer.getFirstName() +
                                "\nLast name: " + competitiveSwimmer.getLastName() +
                                "\nGender: " + competitiveSwimmer.getGender() +
                                "\nAge: " + competitiveSwimmer.getAge() +
                                "\nCan BackCrawl " + competitiveSwimmer.canButterfly());
                        System.out.println("-------------------");
                    }
                }

                // list SeniorWomenBreastStroke
                if (secondChoice == 4 && thirdChoice == 4) {
                    for (CompetitiveSwimmer competitiveSwimmer : controller.getSeniorWomenBreastStroke()) {
                        System.out.println("First name: " + competitiveSwimmer.getFirstName() +
                                "\nLast name: " + competitiveSwimmer.getLastName() +
                                "\nGender: " + competitiveSwimmer.getGender() +
                                "\nAge: " + competitiveSwimmer.getAge() +
                                "\nCan BreastStroke " + competitiveSwimmer.canButterfly());
                        System.out.println("-------------------");
                    }
                }
            }

        } while (choice != 0);
    }

}
