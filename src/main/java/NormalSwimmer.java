public class NormalSwimmer extends Member{

    public NormalSwimmer(String firstName,String lastName, String gender, int age,
                         boolean isActive,boolean hasPaid) {
        super(firstName,lastName,gender,age,isActive,hasPaid);
        setCompetitive(false);
        setSubscription();
    }


}
