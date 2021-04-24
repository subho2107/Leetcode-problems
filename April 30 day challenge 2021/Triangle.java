import java.io.*;
import java.util.*;
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        for(int i = 1; i < rows; i++){
            int cols = triangle.get(i).size(), colsPrev = triangle.get(i-1).size();
            for(int j = 0; j < cols; j++){
                int min = Integer.MAX_VALUE;
                if (j < colsPrev)
                    min = Math.min(min, triangle.get(i-1).get(j));
                if(j >= 1)
                    min = Math.min(triangle.get(i-1).get(j-1), min);
                triangle.get(i).set(j, min+triangle.get(i).get(j));
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < triangle.get(rows-1).size(); i++){
            ans = Math.min(ans, triangle.get(rows-1).get(i));
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {
        List<List<Integer>>list = new ArrayList<>();
        int [][] arr = {{2},{3,4}, {6,5,7}, {4,1,8,3}};
        for (int [] nums : arr) {
            ArrayList<Integer>temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            list.add(temp);
        }
        new Triangle().minimumTotal(list);
  }
}
