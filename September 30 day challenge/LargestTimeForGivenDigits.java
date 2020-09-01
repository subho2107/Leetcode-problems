import java.io.*;
import java.util.*;

public class LargestTimeForGivenDigits {
    public String largestTimeFromDigits(int[] A) {
        boolean found = false;
        int a = 0, b = 0, c = 0, d = 0;
        for (int hour = 23; hour >= 0; hour--) {
            a = hour / 10;
            b = hour % 10;
            for (int min = 59; min >= 0; min--) {
                c = min / 10;
                d = min % 10;
                boolean check1 = false, check2 = false, check3 = false, check4 = false;
                for (int num : A) {
                    if (!check1 && num == a)
                        check1 = true;
                    else if (!check2 && num == b)
                        check2 = true;
                    else if (!check3 && num == c)
                        check3 = true;
                    else if (!check4 && num == d)
                        check4 = true;
                }
                found = check1 && check2 && check3 && check4;
                if (found)
                    break;
            }
            if (found)
                break;
        }
        if (!found) return "";
        return a + Integer.toString(b) + ":" + c + d;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        System.out.println(new LargestTimeForGivenDigits().largestTimeFromDigits(new int[]{2,2,3,4}));
        System.out.println(sb);
    }
}
