import java.io.*;
import java.util.*;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m-1, j = n-1, k = n+m-1;k >= 0 ; k--){
            int temp;
            if(i >= 0 && j >= 0){
                if(nums1[i] > nums2[j]){
                    temp = nums1[i];
                    i--;
                }
                else{
                    temp = nums2[j];
                    j--;
                }
            }
            else if(i >= 0)
            {
                temp = nums1[i];
                i--;
            }
            else{
                temp = nums2[j];
                j--;

            }
            nums1[k] = temp;
        }
    }
}
