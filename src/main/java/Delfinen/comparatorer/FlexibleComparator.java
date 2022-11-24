package Delfinen.comparatorer;

import Delfinen.Member;

import java.util.Comparator;

public class FlexibleComparator implements Comparator<Member> {

    private String sortBy;

    public FlexibleComparator(String sortBy) {
        this.sortBy = sortBy;
    }

    @Override
    public int compare(Member o1, Member o2) {

        switch (sortBy) {
            case "firstName" -> {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
            case "lastName" -> {
                return o1.getFirstName().compareTo(o2.getLastName());
            }
            case "gender" -> {
                return o1.getGender().compareTo(o2.getGender());
            }
            case "age" -> {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
            case "isActive" -> {
                return Boolean.compare(o1.isActive(), o2.isActive());
            }
            case "isCompetitive" -> {
                return Boolean.compare(o1.isCompetitive(), o2.isCompetitive());
            }
            case "hasPaid" -> {
                return Boolean.compare(o1.hasPaid(), o2.hasPaid());
            }
            case "isStudent" -> {
                return Boolean.compare(o1.isStudent(), o2.isStudent());
            }
            case "subscription" -> {
                return Integer.compare(o1.getSubscription(), o2.getSubscription());
            }
        }
        return 0;
    }
}