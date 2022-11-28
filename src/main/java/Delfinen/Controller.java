package Delfinen;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Controller {

    Delfinen.Database database = new Database();
    FileHandler fileHandler = new FileHandler();

    public void createMember(String firstName, String lastName, String gender, int age,
                             boolean isActive, boolean isCompetitive, boolean hasPaid, boolean isStudent) {
        database.addMember(firstName, lastName, gender, age, isActive, isCompetitive, hasPaid, isStudent);
    }

    public ArrayList<Member> getAllSwimmers() {
        return database.getAllSwimmers();
    }

    public ArrayList<Member> SearchForSwimmer(String firstName) {
        return database.getSearchForSwimmer(firstName);
    }


    public int getSubscriptionSum() {
        return database.getSubscriptionSum();
    }

    public void deleteSwimmer(int index) {
        database.deleteSwimmer(index);
    }

    public void saveData() throws FileNotFoundException {
        fileHandler.saveData(database.getAllSwimmers());
    }

    public void loadData() throws FileNotFoundException {
        fileHandler.loadData(database.getAllSwimmers());
    }

    public void editSwimmer(int index, String firstName, String lastName, String gender, int age,
                            boolean isActive, boolean isCompetitive, boolean hasPaid, boolean isStudent) {
        database.editSwimmer(index, firstName, lastName, gender, age, isActive, isCompetitive, hasPaid, isStudent);
    }

    public void sortBy(String sortBy) {
        database.sortBy(sortBy);
    }

}