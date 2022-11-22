import com.sun.source.tree.BreakTree;

import java.util.ArrayList;

public class Database {


    private ArrayList<Member> members = new ArrayList<>();


    public void addMember(String firstName,String lastName, String gender, int age,
                            boolean isActive, boolean isCompetetive,
                            boolean hasPaid) {
        Member member;
        if (isCompetetive) {
            member = new CompetitiveSwimmer(firstName, lastName, gender, age, isActive, hasPaid);
        } else
            member = new NormalSwimmer(firstName, lastName, gender, age, isActive, hasPaid);
        members.add(member);
    }

    public ArrayList<Member> getAllSwimmers() {
        return members;
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

    public ArrayList<Member> getActiveSwimmers() {
        ArrayList<Member> activeSwimmers = new ArrayList<>();
        for (Member member : members) {
            if (member.isActive()) {
                activeSwimmers.add(member);
            }
        }
        return activeSwimmers;
    }

    public ArrayList<Member> getInactiveSwimmers() {
       ArrayList<Member> inactiveSwimmers = new ArrayList<>();
       for (Member member : members) {
           if (!member.isActive()) {
               inactiveSwimmers.add(member);
           }
       }
       return inactiveSwimmers;
    }

    public ArrayList<Member> getJuniorSwimmers() {
        ArrayList<Member> juniorSwimmers = new ArrayList<>();
        for (Member member : members) {
            if (member.getAge() < 18) {
                juniorSwimmers.add(member);
            }
        }
        return juniorSwimmers;
    }

    public ArrayList<Member> getSeniorSwimmers() {
        ArrayList<Member> seniorSwimmers = new ArrayList<>();
        for (Member member : members) {
            if (member.getAge() >= 18) {
                seniorSwimmers.add(member);
            }
        }
        return seniorSwimmers;
    }

    public void setSubscription(ArrayList<Member> members) {
        for (Member member : members) {
            member.setSubscription();
        }
    }
}
