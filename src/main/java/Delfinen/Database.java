package Delfinen;

import Delfinen.comparatorer.FlexibleComparator;

import java.util.ArrayList;
import java.util.Comparator;

public class Database {


    private ArrayList<Member> members = new ArrayList<>();

    public void addNormalMember(String firstName, String lastName, String gender, int age, boolean isActive, boolean isCompetetive, boolean hasPaid, boolean isStudent) {
        NormalSwimmer member = new NormalSwimmer(firstName,lastName,gender,age,isActive,hasPaid,isStudent);
        members.add(member);
    }

    public void addCompetitiveSwimmer(String firstName, String lastName, String gender, int age, boolean isActive,boolean isCompetitive,boolean hasPaid, boolean isStudent,
                                      boolean canButterfly, boolean canCrawl, boolean canBackcrawl,
                                      boolean canBreastswimming) {
        CompetitiveSwimmer member = new CompetitiveSwimmer(firstName,lastName,gender,age,isActive,hasPaid,isStudent,canButterfly,canCrawl,canBackcrawl,canBreastswimming);
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


    public void editSwimmer(int index, String firstName, String lastName, String gender,
                            int age, boolean isActive, boolean isCompetitive,
                            boolean hasPaid, boolean isStudent) {

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



