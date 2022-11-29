package Delfinen;

public abstract class Member {

    private String firstName;
    private String lastName;
    private boolean gender;
    private int age;
    private boolean isActive;
    private boolean isCompetitive;
    private boolean hasPaid;
    private boolean isStudent;
    private int subscription;


    public Member(String firstName, String lastName, boolean gender, int age,
                  boolean isActive, boolean hasPaid, boolean isStudent) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.isActive = isActive;
        this.isStudent = isStudent;
        this.hasPaid = hasPaid;
        setSubscription();
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

    public boolean getGender() {
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

    public boolean isStudent() {
        return isStudent;
    }

    public int getSubscription() {
        return subscription;
    }

    //SETTERS

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(boolean gender) {
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

    public void setStudent(boolean isStudent) {
        this.isStudent = isStudent;
    }

    public void setSubscription(int subscription) {
        this.subscription = subscription;
    }

    //CALCULATE SUBSRCIPTION BASED ON MEMBER INFO

    public void setSubscription() {
        if (isActive && age < 18 && age < 60 && !isStudent) {
            subscription = 1000;
        } else if (isActive && age < 18 && isStudent) {
            subscription = 850;
        } else if (isActive && age > 18 && !isStudent) {
            subscription = 1600;
        } else if (isActive && age > 18 && age < 60 && isStudent) {
            subscription = 1360;
        } else if (isActive && age > 60 && !isStudent) {
            subscription = 1200;
        } else if (isActive && age > 60 && isStudent) {
            subscription = 1020;
        } else if(!isActive) {
            subscription = 500;
        }
    }

}


