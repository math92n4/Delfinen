public class CompetitiveSwimmer extends Member{


    public CompetitiveSwimmer(String firstName,String lastName, String gender, int age,
                              boolean isActive,boolean hasPaid) {
        super(firstName,lastName, gender, age,isActive,hasPaid);
        setCompetitive(true);
        setSubscription();
    }


}
