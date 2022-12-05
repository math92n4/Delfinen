package Delfinen;

import Delfinen.comparatorer.FlexibleComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Database {


    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<Trainer> trainers = new ArrayList<>();


    public Team getTeamById(int id) {
        for (Team team : teams) {
            if(team.getId() == id) {
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
            if(trainer.getId() == id) {
                return trainer;
            }
        }
        throw new NoSuchElementException("No trainer with id " + id);
    }


    public void addNormalMember(String firstName, String lastName, boolean gender, int age, boolean isActive, boolean isCompetetive, boolean hasPaid, boolean isStudent) {
        int id = members.size() + 1;
        NormalSwimmer member = new NormalSwimmer(id,firstName,lastName,gender,age,isActive,hasPaid,isStudent);
        members.add(member);
    }

    public void addCompetitiveSwimmer(String firstName,String lastName,boolean gender, int age, boolean isActive, boolean isCompetitive, boolean hasPaid, boolean isStudent,
                                      boolean canButterfly,boolean canCrawl, boolean canBackCrawl, boolean canBreastStroke) {
        int id = members.size() + 1;
        CompetitiveSwimmer member = new CompetitiveSwimmer(id, firstName,lastName,gender,age,isActive,hasPaid,isStudent,canButterfly,canCrawl,canBackCrawl,canBreastStroke);
        members.add(member);
    }

    public void addTrainer(String firstName, String lastName) {

        int id = trainers.size() + 1;
        Trainer trainer = new Trainer(id, firstName,lastName);
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

    public void editTrainer(int trainerId, String firstName, String lastName, int teamId) {

        Team team = getTeamById(teamId);

        for (Trainer trainer : trainers) {
            if (trainer.getId() == trainerId) {
                if(!firstName.isEmpty()) {
                    trainer.setName(firstName);
                }
                if (!lastName.isEmpty()) {
                    trainer.setLastName(lastName);
                }
                if (teamId != -1) {
                    trainer.setTeam(team);
                }
            }
        }
    }

    public void editTeam(int teamId, String name, int swimmerId) {

        Member member = getMemberById(swimmerId);

        for (Team team : teams) {
            if (team.getId() == teamId) {
                if (!name.isEmpty()) {
                    team.setName(name);
                }
                if (swimmerId != -1) {
                    team.setMember(member);
                }
            }
        }
    }


    public ArrayList<Member> getAllSwimmers() {
        return members;
    }

    public ArrayList<CompetitiveSwimmer> getJuniorMenButterfly() {
        ArrayList<CompetitiveSwimmer> juniorMenButterfly = new ArrayList<>();
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canButterfly() && member.getAge() < 18 && member.getGender()) {
                juniorMenButterfly.add((CompetitiveSwimmer) member);
            }
        }
        return juniorMenButterfly;
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
        ArrayList<CompetitiveSwimmer> seniorMenButterfly = new ArrayList<>();
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canButterfly() && member.getAge() >= 18 && member.getGender()) {
                seniorMenButterfly.add((CompetitiveSwimmer) member);
            }
        }
        return seniorMenButterfly;
    }

    public ArrayList<CompetitiveSwimmer> getSeniorMenCrawl() {
        ArrayList<CompetitiveSwimmer> seniorMenCrawl = new ArrayList<>();
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canCrawl() && member.getAge() >= 18 && member.getGender()) {
                seniorMenCrawl.add((CompetitiveSwimmer) member);
            }
        }
        return seniorMenCrawl;
    }

    public ArrayList<CompetitiveSwimmer> getSeniorMenBackCrawl() {
        ArrayList<CompetitiveSwimmer> seniorMenBackCrawl = new ArrayList<>();
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canBackcrawl() && member.getAge() >= 18 && member.getGender()) {
                seniorMenBackCrawl.add((CompetitiveSwimmer) member);
            }
        }
        return seniorMenBackCrawl;
    }

    public ArrayList<CompetitiveSwimmer> getSeniorMenBreastStroke() {
        ArrayList<CompetitiveSwimmer> seniorMenBreastStroke = new ArrayList<>();
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canBreastswimming() && member.getAge() >= 18 && member.getGender()) {
                seniorMenBreastStroke.add((CompetitiveSwimmer) member);
            }
        }
        return seniorMenBreastStroke;
    }
    public ArrayList<CompetitiveSwimmer> getSeniorWomenButterfly() {
        ArrayList<CompetitiveSwimmer> seniorWomenButterfly = new ArrayList<>();
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canButterfly() && member.getAge() >= 18 && !member.getGender()) {
                seniorWomenButterfly.add((CompetitiveSwimmer) member);
            }
        }
        return seniorWomenButterfly;
    }

    public ArrayList<CompetitiveSwimmer> getSeniorWomenCrawl() {
        ArrayList<CompetitiveSwimmer> seniorWomenCrawl = new ArrayList<>();
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canCrawl() && member.getAge() >= 18 && !member.getGender()) {
                seniorWomenCrawl.add((CompetitiveSwimmer) member);
            }
        }
        return seniorWomenCrawl;
    }

    public ArrayList<CompetitiveSwimmer> getSeniorWomenBackCrawl() {
        ArrayList<CompetitiveSwimmer> seniorWomenBackCrawl = new ArrayList<>();
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canBackcrawl() && member.getAge() >= 18 && !member.getGender()) {
                seniorWomenBackCrawl.add((CompetitiveSwimmer) member);
            }
        }
        return seniorWomenBackCrawl;
    }

    public ArrayList<CompetitiveSwimmer> getSeniorWomenBreastStroke() {
        ArrayList<CompetitiveSwimmer> seniorWomenBreastStroke = new ArrayList<>();
        for (Member member : members) {
            if (member instanceof CompetitiveSwimmer && ((CompetitiveSwimmer) member).canBreastswimming() && member.getAge() >= 18 && !member.getGender()) {
                seniorWomenBreastStroke.add((CompetitiveSwimmer) member);
            }
        }
        return seniorWomenBreastStroke;
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
}



