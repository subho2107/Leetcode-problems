import java.io.*;
import java.util.*;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>ans = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer>currRow = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(i - 1 >= 0 && j - 1 >= 0 && j < ans.get(i-1).size()){
                    currRow.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
                }
                else
                    currRow.add(1);
            }
            ans.add(currRow);
        }
        return ans;
    }
}
