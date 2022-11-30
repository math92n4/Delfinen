package Delfinen;

import Delfinen.comparatorer.FlexibleComparator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Database {


    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Trainer> trainers = new ArrayList<>();
    private ArrayList<CompetitiveSwimmer> compSwimmers = new ArrayList<>();

    public void addNormalMember(String firstName, String lastName, boolean gender, int age, boolean isActive, boolean isCompetetive, boolean hasPaid, boolean isStudent) {
        NormalSwimmer member = new NormalSwimmer(firstName,lastName,gender,age,isActive,hasPaid,isStudent);
        members.add(member);
    }

    public void addCompetitiveSwimmer(String firstName, String lastName, boolean gender, int age, boolean isActive,boolean isCompetitive,boolean hasPaid, boolean isStudent,
                                      boolean canButterfly, boolean canCrawl, boolean canBackcrawl,
                                      boolean canBreastStroke) {
        CompetitiveSwimmer member = new CompetitiveSwimmer(firstName,lastName,gender,age,isActive,hasPaid,isStudent,canButterfly,canCrawl,canBackcrawl,canBreastStroke);
        members.add(member);
    }

    public void addTrainer(String trainerFirstName, String trainerLastName) {
        Trainer trainer = new Trainer(trainerFirstName, trainerLastName);
        trainers.add(trainer);
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

        ArrayList<CompetitiveSwimmer> juniorMenCrawl = new ArrayList<>();

        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canCrawl() && member.getAge() < 18 && member.getGender()) {
                juniorMenCrawl.add((CompetitiveSwimmer) member);
            }
        }
        return juniorMenCrawl;
    }

    public ArrayList<CompetitiveSwimmer> getJuniorMenBackCrawl() {

        ArrayList<CompetitiveSwimmer> juniorMenBackCrawl = new ArrayList<>();

        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canBackcrawl() && member.getAge() < 18 && member.getGender()) {
                juniorMenBackCrawl.add((CompetitiveSwimmer) member);
            }
        }
        return juniorMenBackCrawl;
    }

    public ArrayList<CompetitiveSwimmer> getJuniorMenBreastStroke() {

        ArrayList<CompetitiveSwimmer> juniorMenBreastStroke = new ArrayList<>();

        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canBreastswimming() && member.getAge() < 18 && member.getGender()) {
                juniorMenBreastStroke.add((CompetitiveSwimmer) member);
            }
        }
        return juniorMenBreastStroke;
    }

    public ArrayList<CompetitiveSwimmer> getJuniorWomenButterfly() {

        ArrayList<CompetitiveSwimmer> juniorWomenButterfly = new ArrayList<>();

        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canButterfly() && member.getAge() < 18 && !member.getGender()) {
                juniorWomenButterfly.add((CompetitiveSwimmer) member);
            }
        }
        return juniorWomenButterfly;
    }

    public ArrayList<CompetitiveSwimmer> getJuniorWomenCrawl() {

        ArrayList<CompetitiveSwimmer> juniorWomenCrawl = new ArrayList<>();

        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canCrawl() && member.getAge() < 18 && !member.getGender()) {
                juniorWomenCrawl.add((CompetitiveSwimmer) member);
            }
        }
        return juniorWomenCrawl;
    }

    public ArrayList<CompetitiveSwimmer> getJuniorWomenBackCrawl() {

        ArrayList<CompetitiveSwimmer> juniorWomenBackCrawl = new ArrayList<>();

        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canBackcrawl() && member.getAge() < 18 && !member.getGender()) {
                juniorWomenBackCrawl.add((CompetitiveSwimmer) member);
            }
        }
        return juniorWomenBackCrawl;
    }

    public ArrayList<CompetitiveSwimmer> getJuniorWomenBreastStroke() {

        ArrayList<CompetitiveSwimmer> juniorWomenBreastStroke = new ArrayList<>();

        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canBreastswimming() && member.getAge() < 18 && !member.getGender()) {
                juniorWomenBreastStroke.add((CompetitiveSwimmer) member);
            }
        }
        return juniorWomenBreastStroke;
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

    public void editTrainer(int index, String trainerFirstName, String trainerLastName) {
        Trainer trainer = trainers.get(index - 1);

        if (!trainerFirstName.isEmpty()) {
            trainer.setTrainerFirstName(trainerFirstName);
        }
        if (!trainers.isEmpty()) {
            trainer.setTrainerLastName(trainerLastName);
        }
        }

    public void deleteTrainer(int index, String trainerFirstName,String trainerLastName) {
        Trainer trainer = trainers.get(index - 1);
        trainers.remove(trainer);
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

    public void sortBy(String sortBy) {
        Comparator comparator = new FlexibleComparator(sortBy);
        members.sort(comparator);
    }
}



