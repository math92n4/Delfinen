import com.sun.source.tree.BreakTree;

import java.util.ArrayList;
import java.util.Scanner;

public class Database {


    private ArrayList<Member> members = new ArrayList<>();

    public void addMember(String firstName, String lastName, String gender, int age,
                          boolean isActive, boolean isCompetetive,
                          boolean hasPaid, boolean isStudent) {
        Member member;
        if (isCompetetive) {
            member = new CompetitiveSwimmer(firstName, lastName, gender, age, isActive, hasPaid, isStudent);
        } else
            member = new NormalSwimmer(firstName, lastName, gender, age, isActive, hasPaid, isStudent);
        members.add(member);
    }

    public ArrayList<Member> getAllSwimmers() {
        return members;
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

    public ArrayList<Member> getCompetitiveSwimmers() {
        ArrayList<Member> competetiveSwimmers = new ArrayList<>();
        for (Member member : members) {
            if (member.isCompetitive()) {
                competetiveSwimmers.add(member);
            }
        }
        return competetiveSwimmers;
    }

    public ArrayList<Member> getNormalSwimmers() {
        ArrayList<Member> normalSwimmers = new ArrayList<>();
        for (Member member : members) {
            if (!member.isCompetitive()) {
                normalSwimmers.add(member);
            }
        }
        return normalSwimmers;
    }

    public void editSwimmer(int index,String firstName, String lastName, String gender, int age,
                            boolean isActive, boolean isCompetitive, boolean hasPaid, boolean isStudent) {

        Member member = members.get(index - 1);

        if (!firstName.isEmpty()) {
            member.setFirstName(firstName);
        }
        if (!lastName.isEmpty()) {
            member.setLastName(lastName);
        }
        if (!gender.isEmpty()) {
            member.setGender(gender);
        }
        if (age != 0) {
            member.setAge(age);
        }

        member.setCompetitive(isCompetitive);
        member.setActive(isActive);
        member.setHasPaid(hasPaid);
        member.setStudent(isStudent);
    }

    public ArrayList<Member> getActiveSwimmers () {
        ArrayList<Member> activeSwimmers = new ArrayList<>();
        for (Member member : members) {
            if (member.isActive()) {
                activeSwimmers.add(member);
            }
        }
        return activeSwimmers;
    }

    public ArrayList<Member> getInactiveSwimmers () {
        ArrayList<Member> inactiveSwimmers = new ArrayList<>();
        for (Member member : members) {
            if (!member.isActive()) {
                inactiveSwimmers.add(member);
            }
        }
        return inactiveSwimmers;
    }

    public ArrayList<Member> getJuniorSwimmers () {
        ArrayList<Member> juniorSwimmers = new ArrayList<>();
        for (Member member : members) {
            if (member.getAge() < 18) {
                juniorSwimmers.add(member);
            }
        }
        return juniorSwimmers;
    }

    public ArrayList<Member> getSeniorSwimmers () {
        ArrayList<Member> seniorSwimmers = new ArrayList<>();
        for (Member member : members) {
            if (member.getAge() >= 18) {
                seniorSwimmers.add(member);
            }
        }
        return seniorSwimmers;
    }

    public int getSubscriptionSum() {
        int total = 0;
        for (Member member : members) {
            member.setSubscription();
            total += member.getSubscription();
        }
        return total;
    }

    public ArrayList<Member> getUnpaidSwimmers() {
        ArrayList<Member> unPaidSwimmers = new ArrayList<>();
        for (Member member : members) {
            if (!member.hasPaid()) {
                unPaidSwimmers.add(member);
            }
        }
        return unPaidSwimmers;
    }

    public void deleteSwimmer ( int index){

        Member member = members.get(index - 1);
        members.remove(member);

    }

    public void setSubscription (ArrayList < Member > members) {
        for (Member member : members) {
            member.setSubscription();
        }
    }
}



