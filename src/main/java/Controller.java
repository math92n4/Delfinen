import java.util.ArrayList;

public class Controller {

    Database database = new Database();

    public void createMember(String firstName, String lastName, int age,
                             boolean isActive,boolean isCompetitive, boolean hasPaid) {
        database.addMember(firstName,lastName,age,isActive,isCompetitive,hasPaid);
    }

    public ArrayList<Member> getAllSwimmers() {
        return database.getAllSwimmers();
    }

    public ArrayList<Member> getCompetitiveSwimmers() {
        return database.getCompetitiveSwimmers();
    }

    public ArrayList<Member> getNormalSwimmers() {
        return database.getNormalSwimmers();
    }


}
