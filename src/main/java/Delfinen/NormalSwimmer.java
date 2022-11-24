package Delfinen;

public class NormalSwimmer extends Member{

    public NormalSwimmer(String firstName,String lastName, String gender, int age,
                         boolean isActive,boolean hasPaid, boolean isStudent) {
        super(firstName,lastName,gender,age,isActive,hasPaid,isStudent);
        setCompetitive(false);
    }


}
