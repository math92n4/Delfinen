import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Controller {

    Database database = new Database();
    FileHandler fileHandler = new FileHandler();

    public void createMember(String firstName, String lastName, String gender, int age,
                             boolean isActive,boolean isCompetitive, boolean hasPaid) {
        database.addMember(firstName,lastName, gender, age,isActive,isCompetitive,hasPaid);
    }

    public ArrayList<Member> getAllSwimmers() {
        return database.getAllSwimmers();
    }

    public ArrayList<Member> SearchForSwimmer(String firstName) {
        return database.getSearchForSwimmer(firstName);
    }

    public ArrayList<Member> getCompetitiveSwimmers() {
        return database.getCompetitiveSwimmers();
    }

    public ArrayList<Member> getNormalSwimmers() {
        return database.getNormalSwimmers();
    }

    public ArrayList<Member> getActiveSwimmers() {
        return database.getActiveSwimmers();
    }

    public ArrayList<Member> getInactiveSwimmers() {
        return database.getInactiveSwimmers();
    }

    public ArrayList<Member> getJuniorSwimmers() {
        return database.getJuniorSwimmers();
    }

    public ArrayList<Member> getSeniorSwimmers() {
        return database.getSeniorSwimmers();
    }

    public void saveData() throws FileNotFoundException {
        fileHandler.saveData(database.getAllSwimmers());
    }

    public void loadData() throws FileNotFoundException {
        fileHandler.loadData(database.getAllSwimmers());
    }


}
