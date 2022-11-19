public class CompetitiveSwimmer extends Member{


    public CompetitiveSwimmer(String firstName,String lastName,int age,
                              boolean isActive,boolean hasPaid) {
        super(firstName,lastName,age,isActive,hasPaid);
        setCompetitive(true);
    }


}
