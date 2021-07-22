import java.io.*;
import java.util.*;
public class PushDominoes {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int [] leftPos = new int[n], rightPos = new int[n];
        int currNearestPos = -1;
        for(int i = 0; i < n; i++){
            char ch = dominoes.charAt(i);
            if(ch == 'R')
                currNearestPos = i;
            else if(ch == 'L')
                currNearestPos = -1;
            rightPos[i] = currNearestPos;
        }
        currNearestPos = -1;
        for(int i = n-1; i >= 0; i--){
            char ch = dominoes.charAt(i);
            if(ch == 'L')
                currNearestPos = i;
            else if(ch == 'R')
                currNearestPos = -1;
            leftPos[i] = currNearestPos;
        }
        char [] ans = new char[n];
        for(int i = 0; i < n; i++){
            int distFromLeft = leftPos[i] != -1?leftPos[i]-i:Integer.MAX_VALUE;
            int distFromRight = rightPos[i] != -1?i-rightPos[i]:Integer.MAX_VALUE;
            if(distFromRight < distFromLeft)
                ans[i] = 'R';
            else if(distFromRight > distFromLeft)
                ans[i] = 'L';
            else
                ans[i] = '.';
        }
        return String.valueOf(ans);
    }
}
