import java.io.*;
import java.util.*;

public class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> -o1[1] + o2[1]);
        long maxUnits = 0;
        for(int i = 0; i < boxTypes.length && truckSize >= 0; i++){
            if(boxTypes[i][0] > truckSize){
                maxUnits += (long)truckSize*boxTypes[i][1];
                break;
            }
            else{
                maxUnits += (long)boxTypes[i][0]*boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            }
        }
        return (int)maxUnits;
    }
}
