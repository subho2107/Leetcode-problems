import java.io.*;
import java.util.*;

public class Candy {
    public int candy(int[] ratings) {
        int ans = 0, n = ratings.length;
        ans = n;
        int [] candies = new int[n];
        Arrays.fill(candies, 1);
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1] && candies[i] <= candies[i-1])
            {
                ans += candies[i-1]+1-candies[i];
                candies[i] = candies[i-1]+1;
            }
        }
        for(int i = n-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1] && candies[i] <= candies[i+1])
            {
                ans += candies[i+1]+1-candies[i];
                candies[i] = candies[i+1]+1;
            }
        }
        return ans;
    }
}
