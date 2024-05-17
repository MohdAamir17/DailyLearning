package May_18;

import java.util.Arrays;
import java.util.List;

public class FindTheHighestNumber {
    public static void main(String[] args) {
        //1st test case
        //List<Integer> a = Arrays.asList(1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1);
        //2nd
        List<Integer> a = Arrays.asList(1 ,2 ,3 ,4 ,5);
        int peakElement = findPeakElement(a);
        System.out.printf("Peak Element : " +peakElement);
    }

    public static int findPeakElement(List<Integer> a) {
        int max = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            if (max < a.get(i)) {
                max = a.get(i);
            }
        }
        return max;
    }
}
