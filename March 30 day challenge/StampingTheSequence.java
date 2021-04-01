import java.io.*;
import java.util.*;

public class StampingTheSequence {
    public boolean startWithSpecial(char [] arr, int pos, String start){
        boolean check = false;
        for (int i = 0; i < start.length(); i++) {
            boolean isStar = arr[pos+i] == '*', isSame = arr[pos+i] == start.charAt(i);
            if (!isStar && !isSame)
                return false;
            if (!isStar && isSame)
                check = true;
        }
        return check;
    }
    public int[] movesToStamp(String stamp, String target) {
        char [] targetArray = target.toCharArray();
        int starred = 0, n = target.length(), m = stamp.length();
        ArrayList<Integer>ops = new ArrayList<>();
        while (starred < target.length()){
            boolean check = false;
            for (int i = 0; i <= n-m; i++) {
                if (startWithSpecial(targetArray, i, stamp)){
                    check = true;
                    for (int j = 0; j < stamp.length(); j++) {
                        if (targetArray[i+j] != '*')
                            starred++;
                        targetArray[i+j] = '*';
                    }
                    ops.add(i);
                    break;
                }
            }
            if (!check)
                break;
        }
        int [] ans = new int[ops.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[ans.length-i-1] = ops.get(i);
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString(new StampingTheSequence().movesToStamp("aye", "eyeye")));
    }
}
