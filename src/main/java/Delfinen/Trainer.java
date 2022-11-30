package Delfinen;

public class Trainer {

    private String trainerFirstName;
    private String trainerLastName;

    public Trainer(String trainerFirstName, String trainerLastName) {
        this.trainerFirstName = trainerFirstName;
        this.trainerLastName = trainerLastName;
    }

    public Trainer() {

    }

    public String getTrainerFirstName() {
        return trainerFirstName;
    }

    public String getTrainerLastName() {
        return trainerLastName;
    }

    public void setTrainerFirstName(String trainerFirstName) {
        this.trainerFirstName = trainerFirstName;
    }

    public void setTrainerLastName(String trainerLastName) {
        this.trainerLastName = trainerLastName;
    }
}
