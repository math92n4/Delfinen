import java.util.ArrayList;

public class Database {


    private ArrayList<Member> members = new ArrayList<>();


    public void addMember(String firstName,String lastName,int age,
                            boolean isActive, boolean isCompetetive,
                            boolean hasPaid) {
        Member member;
        if (isCompetetive) {
            member = new CompetitiveSwimmer(firstName, lastName, age, isActive, hasPaid);
        } else
            member = new NormalSwimmer(firstName, lastName, age, isActive, hasPaid);
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
}
