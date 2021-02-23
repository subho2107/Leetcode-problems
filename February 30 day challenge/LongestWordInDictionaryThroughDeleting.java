import java.io.*;
import java.util.*;

public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        d.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length())
                    return o2.length()-o1.length();
                else
                    return o1.compareTo(o2);
            }
        });
        for (String substring : d) {
            int i = 0;
            for (char ch : s.toCharArray()) {
                if (substring.charAt(i) == ch)
                    i++;
                if (i == substring.length())
                    return substring;
            }
        }
        return "";
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {

        }
        System.out.println(sb);
    }
}
