import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Controller {

    Database database = new Database();
    FileHandler fileHandler = new FileHandler();

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

    public void saveData() throws FileNotFoundException {
        fileHandler.saveData(database.getAllSwimmers());
    }

    public void loadData() throws FileNotFoundException {
        fileHandler.loadData(database.getAllSwimmers());
    }


}
