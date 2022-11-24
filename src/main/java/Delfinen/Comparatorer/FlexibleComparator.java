package Delfinen.Comparatorer;

import Delfinen.Member;

import java.util.Comparator;

public class FlexibleComparator implements Comparator<Member> {

    private String type;

    public FlexibleComparator(String type) {
        this.type = type;
    }

    @Override
    public int compare(Member o1, Member o2) {

    switch (type) {
        case "firstName":
            break;
        case "lastName":
            break;
        case "gender":
            break;
        case "age":
            break;
        case "isActive":
            break;
        case "isCompetitive":
            break;
        case "hasPaid":
            break;
        case "isStudent":
            break;
        case "subscription":
            break;
    }


        /*switch (sortBy) {
            case "type" -> {
                // type
                return o1.getType().compareTo(o2.getType());
            }
            case "age" -> {
                // age
                return Integer.compare(o1.getAge(), o2.getAge());
            }
            case "name" -> {
                //name
                return o1.getName().compareTo(o2.getName());
            }
            case "weight" -> {
                // weight
                return Double.compare(o1.getWeight(), o2.getWeight());
            }
        } */
        return 0;
    }
}