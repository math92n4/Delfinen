public class Member {

    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private boolean isActive;
    private boolean isCompetitive;
    private boolean hasPaid;

    public Member(String firstName, String lastName, String gender, int age,
                  boolean isActive, boolean hasPaid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.isActive = isActive;
        this.hasPaid = hasPaid;
    }

    public Member() {

    }

    //GETTERS

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }


    public boolean isActive() {
        return isActive;
    }

    public boolean isCompetitive() {
        return isCompetitive;
    }

    public boolean hasPaid() {
        return hasPaid;
    }

    //SETTERS

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setCompetitive(boolean competitive) {
        isCompetitive = competitive;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }
}
