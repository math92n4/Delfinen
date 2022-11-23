/*package Comparatorer;

import java.lang.reflect.Member;
import java.util.Comparator;

public class FlexibleComparator implements Comparator<Member> {

    private String sortBy;

    public FlexibleComparator(String sortBy) {
        this.sortBy = sortBy;
    }

    @Override
    public int compare(Member o1, Member o2) {
        switch (sortBy) {
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
        }
        return 0;
    }
}
*/