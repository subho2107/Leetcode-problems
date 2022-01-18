import java.io.*;

public class CanPlaceFlowersJan22 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0)
            return true;
        int len = flowerbed.length;
        for(int i = 0; i < len && n > 0; i++){
            if(flowerbed[i] == 1)
                continue;
            if((i-1 < 0 || flowerbed[i-1] == 0) && (i+1 >= len || flowerbed[i+1] == 0)){
                flowerbed[i] = 1;
                n--;
            }
        }
        return n == 0;
    }
}
