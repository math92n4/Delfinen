package Delfinen;

import Delfinen.comparatorer.FlexibleComparator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Database {


    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<Trainer> trainers = new ArrayList<>();
    private ArrayList<CompetitiveSwimmer> compSwimmers = new ArrayList<>();


    public Team getTeamById(int id) {
        for (Team team : teams) {
            if (team.getId() == id) {
                return team;
            }
        }
        throw new NoSuchElementException("No team with id " + id);
    }

    public Member getMemberById(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        throw new NoSuchElementException("No member with id " + id);
    }


    public Trainer getTrainerById(int id) {
        for (Trainer trainer : trainers) {
            if (trainer.getId() == id) {
                return trainer;
            }
        }
        throw new NoSuchElementException("No trainer with id " + id);
    }

    public void addNormalMember(String firstName, String lastName, boolean gender, int age, boolean isActive, boolean isCompetetive, boolean hasPaid, boolean isStudent) {
        int id = members.size() + 1;
        NormalSwimmer member = new NormalSwimmer(id, firstName, lastName, gender, age, isActive, hasPaid, isStudent);
        members.add(member);
    }

    public void addCompetitiveSwimmer(String firstName, String lastName, boolean gender, int age, boolean isActive, boolean isCompetitive, boolean hasPaid, boolean isStudent,
                                      boolean canButterfly, boolean canCrawl, boolean canBackCrawl, boolean canBreastStroke) {
        int id = members.size() + 1;
        CompetitiveSwimmer member = new CompetitiveSwimmer(id, firstName, lastName, gender, age, isActive, hasPaid, isStudent, canButterfly, canCrawl, canBackCrawl, canBreastStroke);
        members.add(member);
    }

    public void addTrainer(String firstName, String lastName) {

        int id = trainers.size() + 1;
        Trainer trainer = new Trainer(id, firstName, lastName);
        trainers.add(trainer);
    }

    public void addTeam(String name) {

        int id = teams.size() + 1;
        Team team = new Team(id, name);
        teams.add(team);
    }

    public ArrayList<Trainer> getTrainers() {
        return trainers;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void editTrainer(int trainerId, String firstName, String lastName) {

        Trainer trainer = getTrainerById(trainerId);


        if (!firstName.isEmpty()) {
            trainer.setName(firstName);
        }
        if (!lastName.isEmpty()) {
            trainer.setLastName(lastName);
        }

    }

    public void setTrainerToTeam(int trainerId, int teamId) {
        Trainer trainer = getTrainerById(trainerId);
        Team team = getTeamById(teamId);

        trainer.setTeam(team);
        team.setTrainer(trainer);
    }

    public void editTeam(int teamId, String name) {

        Team team = getTeamById(teamId);

        if (!team.getName().isEmpty()) {
            team.setName(name);
        }
    }

    public void setMemberToTeam(int teamId, int memberId) {

        Team team = getTeamById(teamId);
        Member member = getMemberById(memberId);

        team.setMember(member);
        member.setTeam(team);
    }


    public ArrayList<Member> getAllSwimmers() {
        return members;
    }

    public ArrayList<Trainer> getAllTrainers() {
        return trainers;
    }

    public ArrayList<CompetitiveSwimmer> getJuniorMenButterfly() {
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canButterfly() && member.getAge() < 18 && member.getGender()) {
                compSwimmers.add((CompetitiveSwimmer) member);
            }
        }
        return compSwimmers;
    }

    public ArrayList<CompetitiveSwimmer> getJuniorMenCrawl() {
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canCrawl() && member.getAge() < 18 && member.getGender()) {
                compSwimmers.add((CompetitiveSwimmer) member);
            }
        }
        return compSwimmers;
    }

    public ArrayList<CompetitiveSwimmer> getJuniorMenBackCrawl() {
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canBackcrawl() && member.getAge() < 18 && member.getGender()) {
                compSwimmers.add((CompetitiveSwimmer) member);
            }
        }
        return compSwimmers;
    }

    public ArrayList<CompetitiveSwimmer> getJuniorMenBreastStroke() {
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canBreastswimming() && member.getAge() < 18 && member.getGender()) {
                compSwimmers.add((CompetitiveSwimmer) member);
            }
        }
        return compSwimmers;
    }

    public ArrayList<CompetitiveSwimmer> getJuniorWomenButterfly() {

        ArrayList<CompetitiveSwimmer> juniorWomenButterfly = new ArrayList<>();

        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canButterfly() && member.getAge() < 18 && !member.getGender()) {
                compSwimmers.add((CompetitiveSwimmer) member);
            }
        }
        return compSwimmers;
    }

    public ArrayList<CompetitiveSwimmer> getJuniorWomenCrawl() {
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canCrawl() && member.getAge() < 18 && !member.getGender()) {
                compSwimmers.add((CompetitiveSwimmer) member);
            }
        }
        return compSwimmers;
    }

    public ArrayList<CompetitiveSwimmer> getJuniorWomenBackCrawl() {
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canBackcrawl() && member.getAge() < 18 && !member.getGender()) {
                compSwimmers.add((CompetitiveSwimmer) member);
            }
        }
        return compSwimmers;
    }

    public ArrayList<CompetitiveSwimmer> getJuniorWomenBreastStroke() {
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canBreastswimming() && member.getAge() < 18 && !member.getGender()) {
                compSwimmers.add((CompetitiveSwimmer) member);
            }
        }
        return compSwimmers;
    }

    public ArrayList<CompetitiveSwimmer> getSeniorMenButterfly() {
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canButterfly() && member.getAge() >= 18 && member.getGender()) {
                compSwimmers.add((CompetitiveSwimmer) member);
            }
        }
        return compSwimmers;
    }

    public ArrayList<CompetitiveSwimmer> getSeniorMenCrawl() {
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canCrawl() && member.getAge() >= 18 && member.getGender()) {
                compSwimmers.add((CompetitiveSwimmer) member);
            }
        }
        return compSwimmers;
    }

    public ArrayList<CompetitiveSwimmer> getSeniorMenBackCrawl() {
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canBackcrawl() && member.getAge() >= 18 && member.getGender()) {
                compSwimmers.add((CompetitiveSwimmer) member);
            }
        }
        return compSwimmers;
    }

    public ArrayList<CompetitiveSwimmer> getSeniorMenBreastStroke() {
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canBreastswimming() && member.getAge() >= 18 && member.getGender()) {
                compSwimmers.add((CompetitiveSwimmer) member);
            }
        }
        return compSwimmers;
    }

    public ArrayList<CompetitiveSwimmer> getSeniorWomenButterfly() {
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canButterfly() && member.getAge() >= 18 && !member.getGender()) {
                compSwimmers.add((CompetitiveSwimmer) member);
            }
        }
        return compSwimmers;
    }

    public ArrayList<CompetitiveSwimmer> getSeniorWomenCrawl() {
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canCrawl() && member.getAge() >= 18 && !member.getGender()) {
                compSwimmers.add((CompetitiveSwimmer) member);
            }
        }
        return compSwimmers;
    }

    public ArrayList<CompetitiveSwimmer> getSeniorWomenBackCrawl() {
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canBackcrawl() && member.getAge() >= 18 && !member.getGender()) {
                compSwimmers.add((CompetitiveSwimmer) member);
            }
        }
        return compSwimmers;
    }

    public ArrayList<CompetitiveSwimmer> getSeniorWomenBreastStroke() {
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canBreastswimming() && member.getAge() >= 18 && !member.getGender()) {
                compSwimmers.add((CompetitiveSwimmer) member);
            }
        }
        return compSwimmers;
    }

    public ArrayList<Member> getSearchForSwimmer(String firstName) {
        ArrayList<Member> swimmerFound = new ArrayList<>();

        for (Member søgning : members) {
            if (søgning.getFirstName().toLowerCase().contains(firstName.toLowerCase())) {

                swimmerFound.add(søgning);
            }

        }
        return swimmerFound;
    }

    public void editSwimmer(int index, String firstName, String lastName, boolean gender,
                            int age, boolean isActive, boolean isCompetitive,
                            boolean hasPaid, boolean isStudent) {

        Member member = members.get(index - 1);

        if (!firstName.isEmpty()) {
            member.setFirstName(firstName);
        }
        if (!lastName.isEmpty()) {
            member.setLastName(lastName);
        }

        member.setGender(gender);

        if (age != 0) {
            member.setAge(age);
        }

        member.setCompetitive(isCompetitive);
        member.setActive(isActive);
        member.setHasPaid(hasPaid);
        member.setStudent(isStudent);
    }

    public void editCompetitiveSwimmer(int index, String firstName, String lastName, boolean gender,
                                       int age, boolean isActive, boolean isCompetitive,
                                       boolean hasPaid, boolean isStudent, boolean canButterfly,
                                       boolean canCrawl, boolean canBackcrawl, boolean canBreastStroke) {

        Member member = members.get(index - 1);

        if (member instanceof CompetitiveSwimmer) {

            editSwimmer(index, firstName, lastName, gender, age, isActive, isCompetitive, hasPaid, isStudent);

            ((CompetitiveSwimmer) member).setCanButterfly(canButterfly);
            ((CompetitiveSwimmer) member).setCanCrawl(canCrawl);
            ((CompetitiveSwimmer) member).setCanBackcrawl(canBackcrawl);
            ((CompetitiveSwimmer) member).setCanBreastStroke(canBreastStroke);
        }

    }


    public void setCompSwimmerScore(int memberId, double butterflyScore, double crawlScore, double backCrawlScore, double breastStrokeScore) {

        CompetitiveSwimmer compSwimmer = (CompetitiveSwimmer) getMemberById(memberId);

        if (butterflyScore != 0) {
            compSwimmer.setButterflyScore(butterflyScore);
        }

        if (crawlScore != 0) {
            compSwimmer.setCrawlScore(crawlScore);
        }

        if (backCrawlScore != 0) {
            compSwimmer.setBackCrawlScore(backCrawlScore);
        }

        if (breastStrokeScore != 0) {
            compSwimmer.setBreastStrokeScore(breastStrokeScore);
        }
    }

    public int getSubscriptionSum() {
        int total = 0;
        for (Member member : members) {
            total += member.getSubscription();
        }
        return total;
    }

    public void deleteSwimmer(int index) {

        Member member = members.get(index - 1);
        members.remove(member);

    }

    public void deleteTeam(int index) {

        Team team = getTeamById(index);
        teams.remove(team);
    }

    public void deleteTrainer(int index) {
        Trainer trainer = getTrainerById(index);
        trainers.remove(trainer);
    }

    public void sortBy(String sortBy) {
        Comparator comparator = new FlexibleComparator(sortBy);
        members.sort(comparator);
    }

    public ArrayList<CompetitiveSwimmer> getCompetitiveSwimmers(boolean junior, boolean men) {
        ArrayList<CompetitiveSwimmer> csw = new ArrayList<>();
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer swimmer) {
                if ((junior && swimmer.getAge() < 18 && men && swimmer.getGender())
                  || (junior && swimmer.getAge() < 18 && !men && !swimmer.getGender())
                    || (!junior && swimmer.getAge() >= 18 && men && swimmer.getGender())
                || (!junior && swimmer.getAge() >= 18 && !men & !swimmer.getGender())) {
                    csw.add(swimmer);
                }
            }


        }
        return csw;
    }
}



