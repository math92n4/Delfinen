package Delfinen;

import java.util.ArrayList;

public class Team {

    private String name;
    private int id;
    private ArrayList<CompetitiveSwimmer> members;
    private Member member;
    private Trainer trainer;


    public Team(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Team() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<CompetitiveSwimmer> getMembers() {
        return members;
    }

    /*public void setMembers(ArrayList<CompetitiveSwimmer> members) {
        this.members = members;
    }*/

    public void setMember(Member member) {
        this.member = member;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public void addMember(CompetitiveSwimmer member) {
        members.add(member);
        member.addTeam(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
