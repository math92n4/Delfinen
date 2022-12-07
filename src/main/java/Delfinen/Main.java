package Delfinen;
public class Main {

    public static void main(String[] args) {
        try {
            UserInterface ui = new UserInterface();
            ui.start();
        }
        catch (Exception e) {
            System.out.println("Random mistake");
        }
    }
}

