package Delfinen;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Controller {

    Delfinen.Database database = new Database();
    FileHandler fileHandler = new FileHandler();

    public void createNormalMember(String firstName, String lastName, boolean gender, int age,
                             boolean isActive, boolean isCompetitive, boolean hasPaid, boolean isStudent) {
        database.addNormalMember(firstName, lastName, gender, age, isActive, isCompetitive, hasPaid, isStudent);
    }

    public void createCompetitiveMember(String firstName, String lastName, boolean gender, int age, boolean isActive,
                                        boolean isCompetitive, boolean hasPaid, boolean isStudent, boolean canButterfly, boolean canCrawl, boolean canBackcrawl,
                                        boolean canBreastswimming) {
        database.addCompetitiveSwimmer(firstName,lastName,gender,age,isActive,isCompetitive,hasPaid,isStudent, canButterfly,canCrawl,canBackcrawl,canBreastswimming);
    }

    public ArrayList<Member> getAllSwimmers() {
        return database.getAllSwimmers();
    }

    public ArrayList<CompetitiveSwimmer> getJuniorMenButterfly() {
        return database.getJuniorMenButterfly();
    }

    public ArrayList<CompetitiveSwimmer> getSeniorMenButterfly() {
        return database.getSeniorMenButterfly();
    }

    public ArrayList<CompetitiveSwimmer> getSeniorMenCrawl() {
        return database.getSeniorMenCrawl();
    }

    public ArrayList<CompetitiveSwimmer> getSeniorMenBackCrawl() {
        return database.getSeniorMenBackCrawl();
    }

    public ArrayList<CompetitiveSwimmer> getSeniorMenBreastStroke() {
        return database.getSeniorMenBreastStroke();
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

    public void editSwimmer(int index, String firstName, String lastName, boolean gender, int age,
                            boolean isActive, boolean isCompetitive, boolean hasPaid, boolean isStudent) {
        database.editSwimmer(index, firstName, lastName, gender, age, isActive, isCompetitive, hasPaid, isStudent);
    }

    public void sortBy(String sortBy) {
        database.sortBy(sortBy);
    }

}
