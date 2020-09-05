import java.io.*;
import java.util.*;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] lastPosition = new int[26];
        Arrays.fill(lastPosition, -1);
        for (int pos = S.length() - 1; pos >= 0; pos--) {
            int charPos = lastPosition[S.charAt(pos) - 'a'];
            if (charPos == -1) {
                lastPosition[S.charAt(pos) - 'a'] = pos;
            }
        }
        List<Integer>arrayList = new ArrayList<>();
        for (int pos = 0; pos < S.length(); pos++) {
            int maxPos = lastPosition[S.charAt(pos)-'a'];
            int cnt = 0;
            for (; pos < S.length(); pos++) {
                cnt++;
                maxPos = Math.max(maxPos, lastPosition[S.charAt(pos) - 'a']);
                if (maxPos == pos)
                    break;
            }
            arrayList.add(cnt);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij").toString());
    }
}
