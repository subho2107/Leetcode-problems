import java.util.*;

public class SequentialDigitsJan22 {
    private int currLen, toAdd;
    private int getLen(int num){
        int cnt = 0;
        while(num != 0){
            num /= 10;
            cnt++;
        }
        return cnt;
    }
    private int makeNumSeq(int num){
        int dup = num, lenOfNum = getLen(num), firstDig = num/((int)Math.pow(10, lenOfNum-1));
        currLen = lenOfNum;
        toAdd = 0;
        if(firstDig+lenOfNum-1 > 9){
            firstDig = 1;
            currLen++;
            lenOfNum++;
        }
        int ans = 0;
        for(int i = 0, dig = firstDig; i < lenOfNum; i++, dig++){
            ans = ans*10 + dig;
            toAdd = toAdd*10+1;
        }
        return ans;
    }
    private int getNextSeqDigNum(int num){
        int ans = num+toAdd;
        if(num % 10 == 9){
            ans = 0;
            currLen++;
            toAdd = toAdd*10+1;
            for(int i = 1; i <= currLen; i++)
                ans = ans*10 + i;
        }
        return ans;
    }
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer>list = new ArrayList<>();
        int num = makeNumSeq(low);
        while(num < low)
            num = getNextSeqDigNum(num);
        while(num <= high){
            list.add(num);
            num = getNextSeqDigNum(num);
        }
        return list;
    }
}
