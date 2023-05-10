package abcde.comparing;

import java.util.Arrays;
import java.util.Comparator;

public class TestComparator  implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.toLowerCase().compareTo(o2.toLowerCase());
    }

    public static void main(String[] args) {
        String[] values = {"890","234", "Abb", "aab"};
        Arrays.sort(values, new TestComparator());
        for (String s: values) { System.out.print(s + " "); } // 234 890 aab Abb
    }
}
