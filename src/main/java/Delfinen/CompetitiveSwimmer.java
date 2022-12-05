package Delfinen;

public class CompetitiveSwimmer extends Member {

    private boolean canButterfly;
    private boolean canCrawl;
    private boolean canBackcrawl;
    private boolean canBreastStroke;
    private double butterflyScore;
    private double crawlScore;
    private double backCrawlScore;
    private double breastStrokeScore;
    private String TrainerName;

    public CompetitiveSwimmer() {

    }
    public CompetitiveSwimmer(int id, String firstName,String lastName, boolean gender, int age,
                              boolean isActive, boolean hasPaid, boolean isStudent,
                              boolean canButterfly, boolean canCrawl, boolean canBackcrawl,
                              boolean canBreastStroke) {
        super(id, firstName, lastName, gender, age, isActive, hasPaid, isStudent);
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

    public double getButterflyScore() {
        return butterflyScore;
    }

    public void setButterflyScore(double butterflyScore) {
        this.butterflyScore = butterflyScore;
    }

    public boolean canCrawl() {
        return canCrawl;
    }

    public void setCanCrawl(boolean canCrawl) {
        this.canCrawl = canCrawl;
    }

    public double getCrawlScore() {
        return crawlScore;
    }

    public void setCrawlScore(double butterflyScore) {
        this.crawlScore = crawlScore;
    }

    public boolean canBackcrawl() {
        return canBackcrawl;
    }

    public void setCanBackcrawl(boolean canBackcrawl) {
        this.canBackcrawl = canBackcrawl;
    }

    public double getBackCrawlScore() {
        return backCrawlScore;
    }

    public void setBackCrawlScore(double backCrawlScore) {
        this.backCrawlScore = backCrawlScore;
    }

    public boolean canBreastswimming() {
        return canBreastStroke;
    }

    public void setCanBreastStroke(boolean canBreastStroke) {
        this.canBreastStroke = canBreastStroke;
    }

    public double getBreastStrokeScore() {
        return breastStrokeScore;
    }

    public void setBreastStrokeScore(double breastStrokeScore) {
        this.breastStrokeScore = breastStrokeScore;
    }
}
