package Delfinen;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    Controller controller = new Controller();

    Scanner scanner = new Scanner(System.in);

    private int readChoice() {
        int choice;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("You have the wrong value");
            scanner = new Scanner(System.in);
            choice = readChoice();
        }
        return choice;
    }

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

        int chairmanChoice = 0;
        System.out.println("Chairman password identified!");

        do {
            controller.loadData();
            controller.loadTrainerData();
            controller.loadTeamData();

            System.out.println("1) Register swimmer\n" +
                    "2) Search for swimmer\n" +
                    "3) Edit swimmer\n" +
                    "4) Delete swimmer\n" +
                    "----------------------\n" +
                    "5) Register Trainer\n" +
                    "6) List of all Trainers\n" +
                    "7) Edit trainer\n" +
                    "8) Delete trainer\n" +
                    "----------------------\n" +
                    "9) Register team\n" +
                    "10) Edit team\n" +
                    "11) Delete team\n" +
                    "----------------------\n" +
                    "12) Lists \n" +
                    "----------------------\n" +
                    "13) log out");

            chairmanChoice = readChoice();

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
                    registerTrainer();
                    break;
                case 6:
                    listOfAllTrainers();
                    break;
                case 7:
                    editTrainer();
                    break;
                case 8:
                    deleteTrainer();
                    break;
                case 9:
                    registerTeam();
                    break;
                case 10:
                    editTeam();
                    break;
                case 11:
                    deleteTeam();
                    break;
                case 12:
                    System.out.println("1) List of all swimmers\n" +
                            "2) Sorted lists of all swimmers\n" +
                            "3) List of competitive swimmers\n" +
                            "4) List of student swimmers\n" +
                            "5) List of normal swimmers\n" +
                            "6) List of active swimmers\n" +
                            "7) List of inactive swimmers\n" +
                            "8) List of junior swimmers\n" +
                            "9) List of senior swimmers\n" +
                            "10) return");
                    int listChoice;
                    listChoice = readChoice();
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
                            listOfStudentSwimmers();
                            break;
                        case 5:
                            listOfNormalSwimmers();
                            break;
                        case 6:
                            listOfActiveSwimmers();
                            break;
                        case 7:
                            listOfInactiveSwimmers();
                            break;
                        case 8:
                            listOfJuniorSwimmers();
                            break;
                        case 9:
                            listOfSeniorSwimmers();
                            break;
                        case 10:
                            scanner = new Scanner(System.in);
                            chairmanUI();
                    }
                    break;
                case 13:
                    scanner = new Scanner(System.in);
                    start();
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
            crawl = scanner.next().charAt(0);
            if (crawl == 'n') {
                canCrawl = false;
            } else if (crawl == 'y') {
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

    private void registerTrainer() throws FileNotFoundException {

        scanner.nextLine(); //scanner bug

        System.out.println("Enter trainer's first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter trainer's last name: ");
        String lastName = scanner.nextLine();

        controller.createTrainer(firstName, lastName);
        controller.saveTrainerData();

    }

    private void registerTeam() throws FileNotFoundException {
        System.out.println("Enter the name of the team: ");
        scanner.nextLine(); // scanner bug
        String teamName = scanner.nextLine();

        controller.createTeam(teamName);
        controller.saveTeamData();
    }

    private void listOfAllTrainers() {

        System.out.println("-------------------");
        for (Trainer trainer : controller.getAllTrainers()) {
            System.out.println("Trainers first name: " + trainer.getName() +
                    "\nTrainers last name: " + trainer.getLastName());
            System.out.println("-------------------");
        }
    }

    private void editTrainer() throws FileNotFoundException {


        for (Trainer trainer : controller.getTrainers()) {
            System.out.println("ID: " + trainer.getId() +
                    "\n First name: " + trainer.getName() +
                    "\n Last name: " + trainer.getLastName());
        }

        System.out.println("Which trainer should be edited?");

        int trainerId = readChoice();

        System.out.println("Choose the field you wish to edit by number\n" +
                "1) First name\n" +
                "2) Last name\n" +
                "3) Team");

        int choice = readChoice();


        String firstName = "";
        String lastName = "";
        int teamId = -1;


        switch (choice) {
            case 1:
                System.out.println("Enter first name");
                scanner.nextLine();                             //scanner bug
                firstName = scanner.nextLine();
                break;
            case 2:
                System.out.println("Enter last name");
                scanner.nextLine();                             // scanner bug
                lastName = scanner.nextLine();
                break;
            case 3:
                System.out.println("Set team to trainer by id");
                for (Team team : controller.getTeams()) {
                    System.out.println("ID: " + team.getId() +
                            "\n Team: " + team.getName());
                }

                System.out.println("What team should the trainer coach? Enter ID");
                teamId = readChoice();

                break;
        }


        controller.editTrainer(trainerId, firstName, lastName);

        if (teamId > 0) {
            controller.setTrainerToTeam(trainerId, teamId);
        }

        controller.saveTrainerData();

        for (Trainer trainer : controller.getTrainers()) {
            if (trainer.getTeam() != null) {
                System.out.println(trainer.getName() + " " + trainer.getLastName() + " is training " + trainer.getTeamName());
            }
        }

        //controller.saveTeamData();


    }

    private void editTeam() throws FileNotFoundException {

        String name = "";
        int swimmerId = -1;


        for (Team team : controller.getTeams()) {
            System.out.println("ID: " + team.getId() +
                    "\nName: " + team.getName());
        }

        System.out.println("Choose the team you wish to edit by ID number");

        int teamId = scanner.nextInt();

        System.out.println("Choose the field you wish to edit by number\n" +
                "1) Name\n" +
                "2) Member");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter new name: ");
                scanner.nextLine();                                     //Scanner bug
                name = scanner.nextLine();
                break;
            case 2:
                for (Member member : controller.getAllSwimmers()) {
                    System.out.println("ID: " + member.getId() +
                            "\nName: " + member.getFirstName() +
                            "\nLast name: " + member.getLastName());
                }

                System.out.println("Choose the member you wish to set to the team");

                swimmerId = scanner.nextInt();
                break;
        }

        if (!name.isEmpty()) {
            controller.editTeam(teamId, name);
        }

        if (swimmerId > 0) {
            controller.setMemberToTeam(teamId, swimmerId);
        }

        controller.saveTeamData();

        for (Member member : controller.getAllSwimmers()) {
            if (member.getTeam() != null) {
                System.out.println(member.getFirstName() + " is on " + member.getTeamName());
            }
        }
    }

    private void searchForSwimmer() {
        ArrayList<Member> swimmerFound;
        System.out.println("Search for a member: ");
        String firstName = scanner.next();
        swimmerFound = controller.SearchForSwimmer(firstName);

        for (Member member : swimmerFound) {
            System.out.println("--------------------" + "\n" + "Delfinens medlemmer" + "\n" + "--------------------");
            System.out.println("ID: " + member.getId());
            System.out.println("First name: " + member.getFirstName() + "\nLast name: " + member.getLastName());
            if (member.getGender()) {
                System.out.println("Gender: Male");
            } else {
                System.out.println("Gender: Female");
            }
            System.out.println("Age: " + member.getAge() + ("Is active? " + member.isActive() + "\n"
                    + ("Is competitive?: " + member.isCompetitive() + "\n" + ("Has paid? "
                    + member.hasPaid() + "\n" + ("Subscription to pay in DDK: "
                    + member.getSubscription() + ",-" + "\n--------------------")))));
        }
    }

    private void sort() {
        System.out.println("--------------------" + "\n");
        System.out.println("Sort the list by:\n" +
                "1) first name" + "\n" +
                "2) last name " + "\n" +
                "3) Gender " + "\n" +
                "4) Age " + "\n" +
                "5) Active status " + "\n" +
                "6) Competitive status " + "\n" +
                "7) payment status " + "\n" +
                "8) Student status " + "\n" +
                "9) Subscription - soon!!...");

        int choice = readChoice();


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
            System.out.println("ID: " + member.getId());
            System.out.println("First name: " + member.getFirstName() +
                    "\nLast name: " + member.getLastName());
            if (member.getGender()) {
                System.out.println("Gender: Male");
            } else {
                System.out.println("Gender: Female");
            }
            System.out.println("Age: " + member.getAge());

            if (member.isStudent()) {
                System.out.println("Is the swimmer a student: Yes");
            } else {
                System.out.println("Is the swimmer a student: No");
            }
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
                System.out.println("ID: " + member.getId());
                System.out.println("First name: " + member.getFirstName() +
                        "\nLast name: " + member.getLastName());
                if (member.getGender()) {
                    System.out.println("Gender: Male");
                } else {
                    System.out.println("Gender: Female");
                }
                System.out.println("Age: " + member.getAge());

                if (member.isStudent()) {
                    System.out.println("Is the swimmer a student: Yes");
                } else {
                    System.out.println("Is the swimmer a student: No");
                }
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

    private void listOfStudentSwimmers() {
        System.out.println("-------------------");
        for (Member member : controller.getAllSwimmers()) {
            if (member.isStudent()) {
                System.out.println("ID: " + member.getId());
                System.out.println("First name: " + member.getFirstName() +
                        "\nLast name: " + member.getLastName());
                if (member.getGender()) {
                    System.out.println("Gender: Male");
                } else {
                    System.out.println("Gender: Female");
                }
                System.out.println("Age: " + member.getAge());

                if (member.isStudent()) {
                    System.out.println("Is the swimmer a student: Yes");
                } else {
                    System.out.println("Is the swimmer a student: No");
                }
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
                System.out.println("ID: " + member.getId());
                System.out.println("First name: " + member.getFirstName() +
                        "\nLast name: " + member.getLastName());
                if (member.getGender()) {
                    System.out.println("Gender: Male");
                } else {
                    System.out.println("Gender: Female");
                }
                System.out.println("Age: " + member.getAge());
                if (member.isStudent()) {
                    System.out.println("Is the swimmer a student: Yes");
                } else {
                    System.out.println("Is the swimmer a student: No");
                }
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
                System.out.println("ID: " + member.getId());
                System.out.println("First name: " + member.getFirstName() +
                        "\nLast name: " + member.getLastName());
                if (member.getGender()) {
                    System.out.println("Gender: Male");
                } else {
                    System.out.println("Gender: Female");
                }
                System.out.println("Age: " + member.getAge());

                if (member.isStudent()) {
                    System.out.println("Is the swimmer a student: Yes");
                } else {
                    System.out.println("Is the swimmer a student: No");
                }
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
                System.out.println("ID: " + member.getId());
                System.out.println("First name: " + member.getFirstName() +
                        "\nLast name: " + member.getLastName());
                if (member.getGender()) {
                    System.out.println("Gender: Male");
                } else {
                    System.out.println("Gender: Female");
                }
                System.out.println("Age: " + member.getAge());

                if (member.isStudent()) {
                    System.out.println("Is the swimmer a student: Yes");
                } else {
                    System.out.println("Is the swimmer a student: No");
                }
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
                System.out.println("ID: " + member.getId());
                System.out.println("First name: " + member.getFirstName() +
                        "\nLast name: " + member.getLastName());
                if (member.getGender()) {
                    System.out.println("Gender: Male");
                } else {
                    System.out.println("Gender: Female");
                }
                System.out.println("Age: " + member.getAge());

                if (member.isStudent()) {
                    System.out.println("Is the swimmer a student: Yes");
                } else {
                    System.out.println("Is the swimmer a student: No");
                }
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
                System.out.println("ID: " + member.getId() +
                        "First name: " + member.getFirstName() +
                        "\nLast name: " + member.getLastName());
                if (member.getGender()) {
                    System.out.println("Gender: Male");
                } else {
                    System.out.println("Gender: Female");
                }
                System.out.println("Age: " + member.getAge());


                if (member.isStudent()) {
                    System.out.println("Is the swimmer a student: Yes");
                } else {
                    System.out.println("Is the swimmer a student: No");
                }
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

    private void listOfButterfly() {
        System.out.println("-------------------");
        for (Member member : controller.getAllSwimmers())
            if (member instanceof CompetitiveSwimmer swimmer) {
                System.out.println("ID " + swimmer.getId() +
                        "\nFirst Name: " + swimmer.getFirstName() +
                        "\nLast name: " + swimmer.getLastName() +
                        "\nAge: " + swimmer.getAge() +
                        "\nButterfly time: " + ((CompetitiveSwimmer) swimmer).getButterflyScore());
                System.out.println("-------------------");
            }
    }

    private void listOfCrawl() {
        System.out.println("-------------------");
        for (Member member : controller.getAllSwimmers())
            if (member instanceof CompetitiveSwimmer swimmer) {
                System.out.println("ID: " + swimmer.getId() +
                        "\nFirst Name: " + swimmer.getFirstName() +
                        "\nLast name: " + swimmer.getLastName() +
                        "\nAge: " + swimmer.getAge() +
                        "\nCrawl time: " + ((CompetitiveSwimmer) swimmer).getCrawlScore());
                System.out.println("-------------------");
            }
    }

    private void listOfBackCrawl() {
        for (Member member : controller.getAllSwimmers()) {
            if (member instanceof CompetitiveSwimmer swimmer) {
                System.out.println("ID: " + swimmer.getId() +
                        "\n Name: " + swimmer.getFirstName() +
                        "\n Last name" + swimmer.getLastName() +
                        "\n Age: " + swimmer.getAge() +
                        "\n Back crawl time: " + swimmer.getBackCrawlScore());
            }
            System.out.println("------------------");
        }
    }

    private void listOfBreastStroke() {
        for (Member member : controller.getAllSwimmers()) {
            if (member instanceof CompetitiveSwimmer swimmer) {
                System.out.println("ID: " + swimmer.getId() +
                        "\n Name: " + swimmer.getFirstName() +
                        "\n Last name" + swimmer.getLastName() +
                        "\n Age: " + member.getAge() +
                        "\n Breast stroke time: " + swimmer.getBreastStrokeScore());
            }
            System.out.println("------------------");
        }
    }

    private void deleteSwimmer() throws FileNotFoundException {
        int index = 1;
        for (Member member : controller.getAllSwimmers()) {
            System.out.println(index++ + ". Name: " + member.getFirstName() + " " + member.getLastName());
        }

        int choice = readChoice();
        controller.deleteSwimmer(choice);
        controller.saveData();
    }

    private void editSwimmer() throws FileNotFoundException {

        System.out.println("-------------------");
        for (Member member : controller.getAllSwimmers()) {
            System.out.println("ID: " + member.getId() +
                    "First name: " + member.getFirstName() +
                    "\nLast name: " + member.getLastName());
            if (member.getGender()) {
                System.out.println("Gender: Male");
            } else {
                System.out.println("Gender: Female");
            }
            System.out.println("Age: " + member.getAge());

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
        char gender = 0;
        int age = 0;
        char isActive = 0;
        char isCompetitive = 0;
        char hasPaid = 0;
        char isStudent = 0;
        char canButterfly = 0;
        char canCrawl = 0;
        char canBackcrawl = 0;
        char canBreastStroke = 0;


        System.out.println("Choose the field you wish to edit\n" +
                "1) First name\n" +
                "2) Last name\n" +
                "3) Gender\n" +
                "4) Age\n" +
                "5) Is active\n" +
                "6) Is competitive\n" +
                "7) Has paid\n" +
                "8) Is student\n" +
                "9) Butterfly\n" +
                "10) Crawl\n" +
                "11) Back crawl\n" +
                "12) Breast stroke");

        int attributeChoice = readChoice();
        scanner.nextLine();                         // Scanner bug


        if (attributeChoice == 1) {
            System.out.println("Enter first name: ");
            firstName = scanner.nextLine();

        } else if (attributeChoice == 2) {
            System.out.println("Enter last name: ");
            lastName = scanner.nextLine();

        } else if (attributeChoice == 3) {
            System.out.println("Enter gender male/female: ");
            gender = scanner.next().charAt(0);

        } else if (attributeChoice == 4) {
            System.out.println("Enter age: ");
            age = scanner.nextInt();

        } else if (attributeChoice == 5) {
            System.out.println("Is the member active? (y/n)");
            isActive = scanner.next().charAt(0);


        } else if (attributeChoice == 6) {
            System.out.println("Is the member competitive? (y/n)");
            isCompetitive = scanner.next().charAt(0);

        } else if (attributeChoice == 7) {
            System.out.println("Has the member paid? (y/n)");
            hasPaid = scanner.next().charAt(0);

        } else if (attributeChoice == 8) {
            System.out.println("Is the member a student? (y/n)");
            isStudent = scanner.next().charAt(0);

        } else if (attributeChoice == 9) {
            System.out.println("Can the member butterfly?");
            canButterfly = scanner.next().charAt(0);

        } else if (attributeChoice == 10) {
            System.out.println("Can the member crawl?");
            canCrawl = scanner.next().charAt(0);

        } else if (attributeChoice == 11) {
            System.out.println("Can the member back crawl?");
            canBackcrawl = scanner.next().charAt(0);

        } else if (attributeChoice == 12) {
            System.out.println("Can the member breast stroke?");
            canBreastStroke = scanner.next().charAt(0);
        }


        //TODO: USE EDITCOMPETITIVESWIMMER SOMEHOW


        controller.editSwimmer(swimmerChoice, firstName, lastName, gender, age, isActive, isCompetitive, hasPaid, isStudent,
                canButterfly, canCrawl, canBackcrawl, canBreastStroke);

        controller.saveData();

    }

    private void deleteTrainer() throws FileNotFoundException {

        System.out.println("Choose the trainer you wish to delete by number");
        for (Trainer trainer : controller.getTrainers()) {
            System.out.println("ID: " + trainer.getId());
            System.out.println(trainer.getName() + " " + trainer.getLastName());
            System.out.println("-------------------");
        }

        int index = readChoice();

        controller.deleteTrainer(index);
        controller.saveTrainerData();

    }

    private void deleteTeam() throws FileNotFoundException {

        System.out.println("Choose the team you wish to delete by number");
        for (Team team : controller.getTeams()) {
            System.out.println("ID:" + team.getId());
            System.out.println("Name: " + team.getName());
            System.out.println("-------------------");
        }

        int index = readChoice();

        controller.deleteTeam(index);
        controller.saveTeamData();
    }

    private void cashierUI() throws FileNotFoundException {

        controller.loadData();
        controller.loadTeamData();
        controller.loadTrainerData();

        int cashierChoice;
        System.out.println("Cashier password identified!");

        do {

            System.out.println("1) Expected income\n" +
                    "2) List of people who hasn't paid\n" +
                    "3) log out");

            cashierChoice = readChoice();

            switch (cashierChoice) {
                case 1:
                    subscriptionSum();
                    break;
                case 2:
                    listOfUnpaidSwimmers();
                    break;
                case 3:
                    scanner = new Scanner(System.in);
                    start();
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
        int index = 1;

        double butterfly = 0;
        double crawl = 0;
        double backCrawl = 0;
        double breastStroke = 0;


        do {
            controller.loadData();
            controller.loadTrainerData();
            controller.loadTeamData();

            // trainer menu
            System.out.println("1) Overview over teams \n" +
                    "2) Register new score\n" +
                    "3) See best scores\n" +
                    "4) See top 5 swimmers for discipline" +
                    "5) Save data\n" +
                    "---------------------\n" +
                    "6) Log out");
            System.out.println("---------------------");

            choice = readChoice();

            // second menu UI for overview over teams junior/senior men & junior/senior women
            if (choice == 1) {
                System.out.println("""
                        1) Junior men
                        2) Junior women
                        3) Senior men
                        4) Senior women
                        ---------------------""");

                secondChoice = readChoice();
                System.out.println("""
                        1) Butterfly
                        2) Crawl
                        3) BackCrawl
                        4) BreastStroke
                        ---------------------""");

                thirdChoice = readChoice();

                boolean men = false;
                boolean junior = false;
                Discipline discipline = null;

                //juniorMen
                if (secondChoice == 1 && thirdChoice == 1) {
                    men = true;
                    junior = true;
                    discipline = Discipline.BUTTERFLY;

                } else if (secondChoice == 1 && thirdChoice == 2) {
                    men = true;
                    junior = true;
                    discipline = Discipline.CRAWL;

                } else if (secondChoice == 1 && thirdChoice == 3) {
                    men = true;
                    junior = true;
                    discipline = Discipline.BACKCRAWL;

                } else if (secondChoice == 1 && thirdChoice == 4) {
                    men = true;
                    junior = true;
                    discipline = Discipline.BREASTSTROKE;
                }

                //juniorWomen
                else if (secondChoice == 2 && thirdChoice == 1) {
                    men = false;
                    junior = true;
                    discipline = Discipline.BUTTERFLY;

                } else if (secondChoice == 2 && thirdChoice == 2) {
                    men = false;
                    junior = true;
                    discipline = Discipline.CRAWL;

                } else if (secondChoice == 2 && thirdChoice == 3) {
                    men = false;
                    junior = true;
                    discipline = Discipline.BACKCRAWL;

                } else if (secondChoice == 2 && thirdChoice == 4) {
                    men = false;
                    junior = true;
                    discipline = Discipline.BREASTSTROKE;
                }

                //seniorMen
                else if (secondChoice == 3 && thirdChoice == 1) {
                    men = true;
                    junior = false;
                    discipline = Discipline.BUTTERFLY;

                } else if (secondChoice == 3 && thirdChoice == 2) {
                    men = true;
                    junior = false;
                    discipline = Discipline.CRAWL;

                } else if (secondChoice == 3 && thirdChoice == 3) {
                    men = true;
                    junior = false;
                    discipline = Discipline.BACKCRAWL;

                } else if (secondChoice == 3 && thirdChoice == 4) {
                    men = true;
                    junior = false;
                    discipline = Discipline.BREASTSTROKE;
                }

                //seniorWomen

                else if (secondChoice == 4 && thirdChoice == 1) {
                    men = false;
                    junior = false;
                    discipline = Discipline.BUTTERFLY;

                } else if (secondChoice == 4 && thirdChoice == 2) {
                    men = false;
                    junior = false;
                    discipline = Discipline.CRAWL;

                } else if (secondChoice == 4 && thirdChoice == 3) {
                    men = false;
                    junior = false;
                    discipline = Discipline.BACKCRAWL;

                } else if (secondChoice == 4 && thirdChoice == 4) {
                    men = false;
                    junior = false;
                    discipline = Discipline.BREASTSTROKE;
                }

                for (CompetitiveSwimmer competitiveSwimmer : controller.getCompetitiveSwimmersWithDiscipline(junior, men, discipline)) {
                    System.out.println("First name: " + competitiveSwimmer.getFirstName() +
                            "\nLast name: " + competitiveSwimmer.getLastName() +
                            "\nGender: " + competitiveSwimmer.getGender() +
                            "\nAge: " + competitiveSwimmer.getAge());
                    if (competitiveSwimmer.canButterfly()) {
                        System.out.println("Can butterfly: Yes");
                    } else if (competitiveSwimmer.canCrawl()) {
                        System.out.println("Can crawl: Yes");
                    } else if (competitiveSwimmer.canBackcrawl()) {
                        System.out.println("Can backcrawl: Yes");
                    } else if (competitiveSwimmer.canBreastswimming()) {
                        System.out.println("Can breaststroke: Yes");
                    }
                    System.out.println("-------------------");
                }
            }


            if (choice == 2) {
                System.out.println("""
                        Who do you wish to register a score for: 
                        1) Junior men
                        2) Junior women
                        3) Senior men
                        4) Senior women
                        ---------------------""");

                secondChoice = readChoice();


                boolean junior = false;
                if (secondChoice == 1 || secondChoice == 2) {
                    junior = true;
                }
                boolean men = false;
                if (secondChoice == 1 || secondChoice == 3) {
                    men = true;
                }

                for (Member member : controller.getCompetitiveSwimmers(junior, men)) {
                    System.out.println("-------------------");
                    System.out.println("# " + member.getId() + "\nFirst name: " + member.getFirstName() +
                            "\nLast name: " + member.getLastName() +
                            "\nAge: " + member.getAge());
                    System.out.println("-------------------");
                }
                System.out.println("Choose the swimmer you wish to set a score for: ");
                scanner.nextLine();                         // Scanner bug

                int swimmerChoice = 0;
                swimmerChoice = readChoice();

                System.out.println("Choose the field you wish to edit\n" +
                        "1) Butterfly\n" +
                        "2) Crawl\n" +
                        "3) Back crawl\n" +
                        "4) Breast stroke");

                int attributeChoice = readChoice();

                if (attributeChoice == 1) {
                    System.out.println("Type in butterfly time: ");
                    butterfly = scanner.nextDouble();

                } else if (attributeChoice == 2) {
                    System.out.println("Type in crawl time: ");
                    crawl = scanner.nextDouble();

                } else if (attributeChoice == 3) {
                    System.out.println("Type in backCrawl time: ");
                    backCrawl = scanner.nextDouble();

                } else if (attributeChoice == 4) {
                    System.out.println("Type in breastStroke time: ");
                    breastStroke = scanner.nextDouble();
                }

                controller.setCompSwimmerScore(swimmerChoice, butterfly, crawl, backCrawl, breastStroke);
                controller.saveTrainerData();
                controller.saveData();
            }

            if (choice == 3) {
                // scoreComparator - used to sort fastest times for different 4 disciplines
                sortScore();
            }

            if (choice == 4) {
                // TODO: Som tr??ner vil jeg se de bedste 5 sv??mmere indenfor given disciplin

            }

            if (choice == 6) {
                scanner = new Scanner(System.in);
                start();

            }

        } while (choice != 0);


        if (choice == 6) {
            controller.saveData();
            controller.saveTrainerData();
            controller.saveTeamData();
        }

    }

    private void sortScore() {
        System.out.println("Sort the list by:\n" +
                "1) Butterfly" + "\n" +
                "2) Crawl " + "\n" +
                "3) BackCrawl " + "\n" +
                "4) BreastStroke ");

        int choice = readChoice();

        if (choice == 1) {
            controller.sortByScore("butterfly");
            listOfButterfly();
        } else if (choice == 2) {
            controller.sortByScore("crawl");
            listOfCrawl();
        } else if (choice == 3) {
            controller.sortByScore("backcrawl");
            listOfBackCrawl();
        } else if (choice == 4) {
            controller.sortByScore("breaststroke");
            listOfBreastStroke();
        }


    }
}

