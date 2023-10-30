import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int[] sortByBits(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }

        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int countA = Integer.bitCount(a);
                int countB = Integer.bitCount(b);
                if (countA == countB) {
                    return a - b;
                } else {
                    return countA - countB;
                }
            }
        });

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}
