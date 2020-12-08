import java.io.*;
import java.util.*;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 1 && flowerbed.length == 1 && flowerbed[0] == 0)
            return true;
        for(int i = 0; i < flowerbed.length && n > 0; i++){
            if(flowerbed[i] == 0 && !(i + 1 < flowerbed.length && flowerbed[i + 1] == 1) && !(i - 1 >= 0 && flowerbed[i - 1] == 1)){
                flowerbed[i] = 1;
                n--;
            }
        }
        if(n > 0)
            return false;
        return true;
    }
}
