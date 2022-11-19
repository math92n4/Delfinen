import java.util.Scanner;

public class UserInterface {


    Controller controller = new Controller();
    Scanner scanner = new Scanner(System.in);

    public void start() {

        System.out.println("\nTHE DOPLHIN SWIMCLUB\n" + "-------------------\n" +
                "Please enter your password: ");

        String chairmanPassword = "chairman";
        String cashierPassword = "cashier";
        String password = scanner.nextLine();

        if (password.toLowerCase().equals(chairmanPassword)) {
            chairmanUI();
        } else if (password.toLowerCase().equals(cashierPassword)) {
            cashierUI();
        }

    }

    private void chairmanUI() {
        System.out.println("Chairman password identified!");
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
