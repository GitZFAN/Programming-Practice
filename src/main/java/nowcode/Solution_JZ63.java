package nowcode;

import java.util.ArrayList;
import java.util.Comparator;

public class Solution_JZ63 {

    ArrayList<Integer> array = new ArrayList<>();

    public void Insert(Integer num) {
        array.add(num);
    }

    public Double GetMedian() {
        array.sort(Comparator.comparingInt(o -> o));

        double median = 0;
        if (array.size()%2 == 0) {
            Integer right = array.get(array.size() / 2);
            Integer left = array.get(array.size() / 2 - 1);
            median = (left + right)/ 2.0;
        } else {
            median = array.get(array.size() / 2);
        }
        return median;
    }


}
