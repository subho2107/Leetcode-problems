import java.io.*;
import java.util.*;

public class FindTheMostCompetitiveSubsequence {
        public int[] mostCompetitive(int[] nums, int k) {
            Stack<Integer>stack = new Stack<>();
            int n = nums.length, cnt = n-k;
            for(int num : nums){
                while(!stack.isEmpty() && stack.peek() > num && cnt > 0)
                {stack.pop();cnt--;}
                stack.push(num);
            }
            ArrayList<Integer>list = new ArrayList<>();
            while(!stack.isEmpty()){
                list.add(stack.pop());
            }
            int [] arr = new int[k];
            for(int i = list.size()-1, j = 0; j < k; i--,j++)
            {
                arr[j] = list.get(i);
            }
            return arr;
        }
}
