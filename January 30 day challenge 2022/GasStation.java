import java.io.*;
import java.util.*;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for(int i = 0; i < n; i++){
            int fuel = 0;
            boolean check= true;
            for(int j = i; j < n; j++){
                fuel += gas[j];
                if(cost[j] <= fuel){
                    fuel -= cost[j];
                }
                else{
                    check = false;
                    break;
                }
            }
            if(!check)
                continue;
            for(int j =0; j < i; j++){
                fuel += gas[j];
                if(cost[j] <= fuel){
                    fuel -= cost[j];
                }
                else{
                    check = false;
                    break;
                }
            }
            if(check)
                return i;
        }
        return -1;
    }
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int totalSurplus = 0, currSurplus = 0, start = 0, n = gas.length;
        for(int i = 0; i < n; i++){
            int diff = gas[i]-cost[i];
            totalSurplus += diff;
            currSurplus += diff;
            if(currSurplus < 0){
                currSurplus = 0;
                start = i+1;
            }
        }
        return totalSurplus >= 0?start:-1;
    }
}
