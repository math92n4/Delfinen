public abstract class Member {

    private String firstName;
    private String lastName;
    private int age;
    private boolean isActive;
    private boolean isCompetitive;
    private boolean hasPaid;

    public Member(String firstName, String lastName, int age,
                  boolean isActive, boolean hasPaid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isActive = isActive;
        this.hasPaid = hasPaid;
    }

    //GETTERS (SOME OF THEM SHOULD BE DELETED AT SOME POINT)

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

    public boolean isHasPaid() {
        return hasPaid;
    }

    //SETTERS (SOME OF THEM SHOULD BE DELETED AT SOME POINT)

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
