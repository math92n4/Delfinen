public class Main {

    public static void main(String[] args) {

        //TESTING SOMETHING FUN, MOVE THIS TO UI PLS

        Controller controller = new Controller();

        controller.createMember("Mathias","Wulff",24,true,true,true);
        controller.createMember("Søren","Sørensen",54,true,true,true);
        controller.createMember("Michael","Nielsen",54,true,false,true);
        controller.createMember("Morten","Mortensen",54,true,false,true);

        System.out.println("ALL SWIMMERS IN DA CLUB:");
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
        }

    }


}
