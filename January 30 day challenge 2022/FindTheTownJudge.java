import java.io.*;
import java.util.*;

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        int judge = -1;
        int [] inDegree = new int[n], outDegree = new int[n];
        for(int [] t : trust){
            outDegree[t[0]-1]++;
            inDegree[t[1]-1]++;
        }
        for(int i = 0; i < n; i++){
            if(inDegree[i] == n-1 && outDegree[i] == 0){
                if(judge == -1)
                    judge = i+1;
                else
                    return -1;
            }
        }
        return judge;
    }
}
