package Delfinen.comparatorer;

import Delfinen.CompetitiveSwimmer;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScoreComparator implements Comparator<CompetitiveSwimmer> {

    private String discipline;

    public ScoreComparator(String discipline) {
        this.discipline = discipline;
    }

    @Override
    public int compare(CompetitiveSwimmer o1, CompetitiveSwimmer o2) {

        switch (discipline) {
            case "butterfly" -> {
                return Double.compare(o1.getButterflyScore(), o2.getButterflyScore());
            }
            case "crawl" -> {
                return Double.compare(o1.getCrawlScore(), o2.getCrawlScore());
            }
            case "backcrawl" -> {
                return Double.compare(o1.getBackCrawlScore(), o2.getBackCrawlScore());
            }
            case "breaststroke" -> {
                return Double.compare(o1.getBreastStrokeScore(), o2.getBreastStrokeScore());
            }



        }
        return 0;
    }

}