import java.io.*;
import java.util.*;

public class ShuffleAnArray {
    class Solution {
        int [] original, toBeModified;
        int n;
        Random rand;
        ArrayList<Integer>list;
        public Solution(int[] nums) {
            n = nums.length;
            rand = new Random();
            original = new int[n];
            toBeModified = new int[n];
            for(int i = 0; i < n; i++)
                original[i] = nums[i];
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            for(int i = 0; i < n; i++)
                toBeModified[i] = original[i];
            return toBeModified;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            list = new ArrayList<>();
            for(int num : original){
                list.add(num);
            }
            for(int i = 0; i< n; i++){
                int pos = rand.nextInt(list.size());
                toBeModified[i] = list.get(pos);
                list.remove(pos);
            }
            return toBeModified;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
}
