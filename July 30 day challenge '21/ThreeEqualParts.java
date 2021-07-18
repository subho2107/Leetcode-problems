import java.io.*;
import java.util.*;

public class ThreeEqualParts {
    public int[] threeEqualParts(int[] arr) {
        int cntOfOnes = 0, n = arr.length;
        int[]notPossible = {-1, -1};
        for(int num : arr)
            cntOfOnes += num;
        if(cntOfOnes == 0)
            return new int[]{0, n-1};
        if(cntOfOnes % 3 != 0)
            return notPossible;
        int i1 = -1, i2 = -1, i3 = -1, j1 = -1, j2 = -1; //effective starting and ending indices for partition
        int onesInAPartition = cntOfOnes/3, lastZeroes = 0;
        for(int i = n-1; i >= 0 && arr[i] == 0; i--)
            lastZeroes++;
        cntOfOnes = 0;
        for(int i = 0; i < n; i++){
            cntOfOnes += arr[i];
            if(cntOfOnes == 1 && i1 == -1)
                i1 = i;
            if(cntOfOnes == onesInAPartition && j1 == -1)
                j1 = i;
            if(cntOfOnes == onesInAPartition+1 && i2 == -1)
                i2 = i;
            if(cntOfOnes == 2*onesInAPartition && j2 == -1)
                j2 = i;
            if(cntOfOnes == 2*onesInAPartition+1 && i3 == -1)
                i3 = i;
        }
        int [] part1 = Arrays.copyOfRange(arr, i1, j1+lastZeroes+1), part2 = Arrays.copyOfRange(arr, i2, j2+lastZeroes+1), part3 = Arrays.copyOfRange(arr, i3, n);
        if(!Arrays.equals(part1, part2))
            return notPossible;
        if(!Arrays.equals(part1, part3))
            return notPossible;
        return new int[]{j1+lastZeroes, j2+lastZeroes+1};
    }
}
