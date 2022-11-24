package delfinen;

public class CompetitiveSwimmer extends Member{


    public CompetitiveSwimmer(String firstName,String lastName, String gender, int age,
                              boolean isActive, boolean hasPaid, boolean isStudent) {
        super(firstName, lastName, gender, age, isActive, hasPaid, isStudent);
        setCompetitive(true);
    }


}
