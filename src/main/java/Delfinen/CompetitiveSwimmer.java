package Delfinen;

public class CompetitiveSwimmer extends Member {

    private boolean canButterfly;


    private boolean canCrawl;
    private boolean canBackcrawl;
    private boolean canBreastStroke;

    public CompetitiveSwimmer() {
    }
    public CompetitiveSwimmer(String firstName,String lastName, boolean gender, int age,
                              boolean isActive, boolean hasPaid, boolean isStudent,
                              boolean canButterfly, boolean canCrawl, boolean canBackcrawl,
                              boolean canBreastStroke) {
        super(firstName, lastName, gender, age, isActive, hasPaid, isStudent);
        setCompetitive(true);
        this.canButterfly = canButterfly;
        this.canCrawl = canCrawl;
        this.canBackcrawl = canBackcrawl;
        this.canBreastStroke = canBreastStroke;
        setSubscription();
    }

    public boolean canButterfly() {
        return canButterfly;
    }

    public void setCanButterfly(boolean canButterfly) {
        this.canButterfly = canButterfly;
    }

    public boolean canCrawl() {
        return canCrawl;
    }

    public void setCanCrawl(boolean canCrawl) {
        this.canCrawl = canCrawl;
    }

    public boolean canBackcrawl() {
        return canBackcrawl;
    }

    public void setCanBackcrawl(boolean canBackcrawl) {
        this.canBackcrawl = canBackcrawl;
    }

    public boolean canBreastswimming() {
        return canBreastStroke;
    }

    public void setCanBreastStroke(boolean canBreastStroke) {
        this.canBreastStroke = canBreastStroke;
    }
}
