package Delfinen;

import Delfinen.comparatorer.FlexibleComparator;
import Delfinen.comparatorer.ScoreComparator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

import static Delfinen.Discipline.*;

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



    public ArrayList<Member> getSearchForSwimmer(String firstName) {
        ArrayList<Member> swimmerFound = new ArrayList<>();

        for (Member s??gning : members) {
            if (s??gning.getFirstName().toLowerCase().contains(firstName.toLowerCase())) {

                swimmerFound.add(s??gning);
            }

        }
        return swimmerFound;
    }

    public void editSwimmer(int index, String firstName, String lastName, char gender,
                            int age, char isActive, char isCompetitive,
                            char hasPaid, char isStudent, char canButterfly, char canCrawl,
                            char canBackCrawl, char canBreastStroke) {

        Member member = getMemberById(index);

        if (!firstName.isEmpty()) {
            member.setFirstName(firstName);
        }
        if (!lastName.isEmpty()) {
            member.setLastName(lastName);
        }

        if (gender == 'm') {
            member.setGender(true);
        } else if (gender == 'f') {
            member.setGender(false);
        }

        if (age != 0) {
            member.setAge(age);
        }

        if (isActive == 'y') {
            member.setActive(true);
        } else if (isActive == 'n') {
            member.setActive(false);
        }

        if (isCompetitive == 'y') {
            member.setCompetitive(true);
        } else if (isCompetitive == 'n')

        if (hasPaid == 'y') {
            member.setHasPaid(true);
        } else if (hasPaid == 'n') {
            member.setHasPaid(false);
        }

        if (isStudent == 'y') {
            member.setStudent(true);
        } else if (isStudent == 'n') {
            member.setStudent(false);
        }

        if (member instanceof CompetitiveSwimmer swimmer) {

            if (canCrawl == 'y') {
                swimmer.setCanCrawl(true);
            } else if (canCrawl == 'n') {
                swimmer.setCanCrawl(false);
            }

            if (canBackCrawl == 'y') {
                swimmer.setCanBackcrawl(true);
            } else if (canBackCrawl == 'n') {
                swimmer.setCanBackcrawl(false);
            }

            if (canButterfly == 'y') {
                swimmer.setCanButterfly(true);
            } else if (canButterfly == 'n') {
                swimmer.setCanButterfly(false);
            }

            if (canBreastStroke == 'y') {
                swimmer.setCanBreastStroke(true);
            } else if (canBreastStroke == 'n') {
                swimmer.setCanBreastStroke(false);
            }
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

    public void sortByScore(String discipline) {
        Comparator scoreComparator = new ScoreComparator(discipline);
        members.sort(scoreComparator);
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

    public ArrayList<CompetitiveSwimmer> getCompSwimmersWithDiscipline(boolean junior, boolean men, Discipline discipline) {
        ArrayList<CompetitiveSwimmer> newList = new ArrayList<>();
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer swimmer) {
                    //juniorMenButterfly
                if ((junior && swimmer.getAge() < 18 && men && swimmer.getGender() && discipline == BUTTERFLY)
                    //juniorMenCrawl
                    || (junior && swimmer.getAge() < 18 && men && swimmer.getGender() && discipline == CRAWL)
                    //juniorMenBackCrawl
                    || (junior && swimmer.getAge() < 18 && men && swimmer.getGender() && discipline == BACKCRAWL)
                    //juniorMenBreastStroke
                    || (junior && swimmer.getAge() < 18 && men && swimmer.getGender() && discipline == BREASTSTROKE)

                    //juniorWomenButterfly
                    || (junior && swimmer.getAge() < 18 && !men && !swimmer.getGender() && discipline == BUTTERFLY)
                    //juniorWomenCrawl
                    || (junior && swimmer.getAge() < 18 && !men && !swimmer.getGender() && discipline == CRAWL)
                    //juniorWomenBackCrawl
                    || (junior && swimmer.getAge() < 18 && !men && !swimmer.getGender() && discipline == BACKCRAWL)
                    //juniorWomenBreastStroke
                    || (junior && swimmer.getAge() < 18 && !men && !swimmer.getGender() && discipline == BREASTSTROKE)

                    //seniorMenButterfly
                    || (!junior && swimmer.getAge() >= 18 && men && swimmer.getGender() && discipline == BUTTERFLY)
                    //seniorMenCrawl
                    || (!junior && swimmer.getAge() >= 18 && men && swimmer.getGender() && discipline == CRAWL)
                    //seniorMenBackCrawl
                    || (!junior && swimmer.getAge() >= 18 && men && swimmer.getGender() && discipline == BACKCRAWL)
                    //seniorMenBreastStroke
                    || (!junior && swimmer.getAge() >= 18 && men && swimmer.getGender() && discipline == BREASTSTROKE)

                    //seniorWomenButterfly
                    || (!junior && swimmer.getAge() >= 18 && !men && !swimmer.getGender() && discipline == BUTTERFLY)
                    //seniorWomenCrawl
                    || (!junior && swimmer.getAge() >= 18 && !men && !swimmer.getGender() && discipline == CRAWL)
                    //seniorWomenBackCrawl
                    || (!junior && swimmer.getAge() >= 18 && !men && !swimmer.getGender() && discipline == BACKCRAWL)
                    //seniorWomenBreastStroke
                    || (!junior && swimmer.getAge() >= 18 && !men && !swimmer.getGender() && discipline == BREASTSTROKE)) {

                    newList.add(swimmer);
                }
            }
        }
        return newList;
    }
}



