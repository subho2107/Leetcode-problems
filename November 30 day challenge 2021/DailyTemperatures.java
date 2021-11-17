import java.io.*;
import java.util.*;

public class DailyTemperatures {
    //time complexity:O(n)
    //space complexity:O(n)
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer>stack = new Stack<>();
        int n = temperatures.length;
        int [] ans = new int[n];
        for(int i = 0; i < n; i++){
            if(stack.isEmpty() || temperatures[i] <= temperatures[stack.peek()])
                stack.push(i);
            else{
                while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                    ans[stack.peek()] = i-stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return ans;
    }
    //time complexity:O(n)
    //space complexity:O(1)
    public int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        int [] ans = new int[n];
        int maxTempTillNow = 0;
        for(int i = n-1; i >= 0; i--){
            int pos = i+1;
            if(maxTempTillNow <= temperatures[i]){
                maxTempTillNow = temperatures[i];
                continue;
            }
            while(pos < n && temperatures[pos] <= temperatures[i]){
                pos += ans[pos];
            }
            ans[i] = pos-i;
            maxTempTillNow = Math.max(maxTempTillNow, temperatures[i]);
        }
        return ans;
    }
}
