import java.io.*;
import java.util.*;
class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int [][] distStamps = new int[2*trips.length][2];
        for(int pos = 0; pos < trips.length; pos++){
            distStamps[2*pos][0] = trips[pos][1];
            distStamps[2*pos][1] = trips[pos][0];
            distStamps[2*pos+1][0] = trips[pos][2];
            distStamps[2*pos+1][1] = -trips[pos][0];
        }
        Arrays.sort(distStamps, new Comparator<int[]>(){
            public int compare(int [] a1, int [] a2){
                return a1[0] - a2[0];
            }
        });
        int currPass = 0;
        for(int pos = 0; pos < distStamps.length; pos++){
            currPass += distStamps[pos][1];
            if(currPass > capacity && pos < distStamps.length-1 && distStamps[pos+1][0]!=distStamps[pos][0])
                return false;
        }
        return true;
    }
}