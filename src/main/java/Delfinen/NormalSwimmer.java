package Delfinen;

public class NormalSwimmer extends Member {

    public NormalSwimmer() {
    }
    public NormalSwimmer(int id, String firstName,String lastName, boolean gender, int age,
                         boolean isActive,boolean hasPaid, boolean isStudent) {
        super(id, firstName,lastName,gender,age,isActive,hasPaid,isStudent);
        setCompetitive(false);
        setSubscription();
    }

}