import java.io.*;
import java.util.*;

public class BoatsToSvaPeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, n = people.length, j = n-1, boats = 0;
        while(i <= j){
            if(people[i]+people[j] <= limit){
                i++;
            }
            j--;
            boats++;
        }
        return boats;
    }
}
