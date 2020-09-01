import java.io.*;
import java.util.*;

public class PanCakeSorting {
    public void flip(int[] arr, int pos) {
        for (int i = 0; i <= pos / 2; i++) {
            arr[i] = arr[i] ^ arr[pos - i] ^ (arr[pos - i] = arr[i]);
        }
    }

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> listOfK = new ArrayList<>();
        int[] dupA = new int[A.length];
        for (int pos = 0; pos < A.length; pos++) {
            dupA[pos] = A[pos];
        }
        Arrays.sort(dupA);
        while (true) {
            int largestNotInPos = -1, posMax = -1, lastNotSortedPos = -1;
            for (int pos = 0; pos < A.length; pos++) {
                if (A[pos] != dupA[pos]) {
                    lastNotSortedPos = pos;
                    if (A[pos] > largestNotInPos) {
                        largestNotInPos = A[pos];
                        posMax = pos;
                    }
                }
            }
            if (posMax == -1)
                break;
            listOfK.add(posMax + 1);
            listOfK.add(lastNotSortedPos + 1);
            this.flip(A, posMax);
            this.flip(A, lastNotSortedPos);
        }
        return listOfK;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        System.out.println(new PanCakeSorting().pancakeSort(new int[]{3, 2, 4, 1}).toString());
        System.out.println(sb);
    }
}
