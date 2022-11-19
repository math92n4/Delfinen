public class NormalSwimmer extends Member{

    public NormalSwimmer(String firstName,String lastName,int age,
                         boolean isActive,boolean hasPaid) {
        super(firstName,lastName,age,isActive,hasPaid);
        setCompetitive(false);
    }


}
