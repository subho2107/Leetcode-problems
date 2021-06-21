import java.io.*;
import java.util.*;

public class NumberOfSubarraysWithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        int [] nextGreater = new int[n], prevGreater = new int[n];
        Stack<Integer>stack = new Stack<>();
        stack.add(0);
        for(int i = 1; i < n; i++){
            int next = nums[i];
            if(!stack.isEmpty()){
                int element = stack.pop();
                while(nums[element] < next){
                    nextGreater[element] = i;
                    if(stack.isEmpty())
                        break;
                    element = stack.pop();
                }
                if(nums[element] >= next)
                    stack.push(element);
            }
            stack.push(i);
        }
        while(!stack.isEmpty())
        {
            nextGreater[stack.pop()] = n;
        }
        stack.push(n-1);
        for(int i = n-2; i >= 0; i--){
            int next = nums[i];
            if(!stack.isEmpty()){
                int element = stack.pop();
                while(nums[element] < next){
                    prevGreater[element] = i;
                    if(stack.isEmpty())
                        break;
                    element = stack.pop();
                }
                if(nums[element] > next)
                    stack.push(element);
            }
            stack.push(i);
        }
        while(!stack.isEmpty())
        {
            prevGreater[stack.pop()] = -1;
        }
        long ans = 0;
        HashMap<Integer, Integer>prevPos = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(nums[i] >= left && nums[i] <= right){
                long leftLength = i-prevGreater[i]-1;
                if(leftLength > 0 && prevPos.containsKey(nums[i])){
                    leftLength = Math.min(leftLength, i - prevPos.get(nums[i])-1);
                }
                long rightLength = nextGreater[i]-i-1;
                ans += rightLength+leftLength+rightLength*leftLength+1;
                prevPos.put(nums[i], i);
            }
        }
        return (int)ans;

    }
}
