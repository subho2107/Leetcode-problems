import java.util.*;

public class LargestRectangleInHistogramJan22 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer>stack = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i < n;){
            if(stack.isEmpty() || heights[stack.peek()] <= heights[i])
                stack.push(i++);
            else{
                int poppedPos = stack.pop();
                maxArea = Math.max(maxArea, heights[poppedPos]*(stack.isEmpty()?i:i-stack.peek()-1));
            }
        }
        while(!stack.isEmpty()){
            int poppedPos = stack.pop();
            maxArea = Math.max(maxArea, heights[poppedPos]*(stack.isEmpty()?n:n-stack.peek()-1));
        }
        return maxArea;
    }
}
