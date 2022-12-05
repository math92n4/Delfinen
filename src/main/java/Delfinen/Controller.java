package Delfinen;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Controller {

    Delfinen.Database database = new Database();
    MemberFileHandler memberFileHandler = new MemberFileHandler();
    TeamFileHandler teamFileHandler = new TeamFileHandler();
    TrainerFileHandler trainerFileHandler = new TrainerFileHandler();

    public void createNormalMember(String firstName, String lastName, boolean gender, int age,
                             boolean isActive, boolean isCompetitive, boolean hasPaid, boolean isStudent) {
        database.addNormalMember(firstName, lastName, gender, age, isActive, isCompetitive, hasPaid, isStudent);
    }

    public void createCompetitiveMember(String firstName, String lastName, boolean gender, int age, boolean isActive, boolean isCompetitive,
                                        boolean hasPaid, boolean isStudent, boolean canButterfly, boolean canCrawl, boolean canBackcrawl,
                                        boolean canBreastswim) {

        database.addCompetitiveSwimmer(firstName,lastName,gender,age,isActive,isCompetitive,hasPaid,isStudent,canButterfly,canCrawl,canBackcrawl,canBreastswim);
    }

    public void createTeam(String name) {
        database.addTeam(name);
    }

    public void createTrainer(String firstName, String lastName) {
        database.addTrainer(firstName,lastName);
    }

    public void editTeam(int teamId, String name, int swimmerId) {
        database.editTeam(teamId,name,swimmerId);
    }

    public Team getTeamById(int id) {
        return database.getTeamById(id);
    }

    public Trainer getTrainerById(int id) {
        return database.getTrainerById(id);
    }

    public ArrayList<Trainer> getTrainers() {
        return database.getTrainers();
    }

    public ArrayList<Team> getTeams() {
        return database.getTeams();
    }

    public void editTrainer(int trainerId, String firstName, String lastName, int teamId) {
        database.editTrainer(trainerId,firstName,lastName,teamId);
    }

    public ArrayList<Member> getAllSwimmers() {
        return database.getAllSwimmers();
    }

    public ArrayList<CompetitiveSwimmer> getJuniorMenButterfly() {
        return database.getJuniorMenButterfly();
    }

    public ArrayList<CompetitiveSwimmer> getJuniorMenCrawl() {
        return database.getJuniorMenCrawl();
    }

    public ArrayList<CompetitiveSwimmer> getJuniorMenBackCrawl() {
        return database.getJuniorMenBackCrawl();
    }

    public ArrayList<CompetitiveSwimmer> getJuniorMenBreastStroke() {
        return database.getJuniorMenBreastStroke();
    }

    public ArrayList<CompetitiveSwimmer> getJuniorWomenButterfly() {
        return database.getJuniorWomenButterfly();
    }

    public ArrayList<CompetitiveSwimmer> getJuniorWomenCrawl() {
        return getJuniorWomenCrawl();
    }

    public ArrayList<CompetitiveSwimmer> getJuniorWomenBackCrawl() {
        return database.getJuniorWomenBackCrawl();
    }

    public ArrayList<CompetitiveSwimmer> getJuniorWomenBreastStroke() {
        return database.getJuniorWomenBreastStroke();
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

    public ArrayList<CompetitiveSwimmer> getSeniorWomenButterfly() {
        return database.getSeniorWomenButterfly();
    }

    public ArrayList<CompetitiveSwimmer> getSeniorWomenCrawl() {
        return database.getSeniorWomenCrawl();
    }

    public ArrayList<CompetitiveSwimmer> getSeniorWomenBackCrawl() {
        return database.getSeniorWomenBackCrawl();
    }

    public ArrayList<CompetitiveSwimmer> getSeniorWomenBreastStroke() {
        return database.getSeniorWomenBreastStroke();
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

    public void deleteTrainer(int index) {
        database.deleteTrainer(index);
    }

    public void deleteTeam(int index) {
        database.deleteTeam(index);
    }

    public void saveData() throws FileNotFoundException {
        memberFileHandler.saveData(database.getAllSwimmers());
    }

    public void loadData() throws FileNotFoundException {
        memberFileHandler.loadData(database.getAllSwimmers());
    }

    public void saveTrainerData() throws FileNotFoundException {
        trainerFileHandler.saveTrainerData(database.getTrainers());
    }

    public void loadTrainerData() throws FileNotFoundException {
        trainerFileHandler.loadTrainerData(database.getTrainers());
    }

    public void saveTeamData() throws FileNotFoundException {
        teamFileHandler.saveTeamData(database.getTeams());
    }

    public void loadTeamData() throws FileNotFoundException {
        teamFileHandler.loadTeamData(database.getTeams());
    }

    public void editSwimmer(int index, String firstName, String lastName, boolean gender, int age,
                            boolean isActive, boolean isCompetitive, boolean hasPaid, boolean isStudent) {
        database.editSwimmer(index, firstName, lastName, gender, age, isActive, isCompetitive, hasPaid, isStudent);
    }

    public void editCompetitiveSwimmer(int index, String firstName, String lastName, boolean gender,
                                       int age, boolean isActive, boolean isCompetitive,
                                       boolean hasPaid, boolean isStudent, boolean canButterfly,
                                       boolean canCrawl, boolean canBackcrawl, boolean canBreastStroke) {

        database.editCompetitiveSwimmer(index, firstName, lastName, gender, age, isActive, isCompetitive,
                hasPaid, isStudent, canButterfly, canCrawl, canBackcrawl, canBreastStroke);
    }

    public void sortBy(String sortBy) {
        database.sortBy(sortBy);
    }

}
