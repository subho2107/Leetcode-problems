import java.io.*;
import java.util.*;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length, pos = -1;
        int left = -1, right = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == x){
                left = i;right = i+1;
                break;
            }
            else if((i == n- 1 && x > arr[i]) || (x > arr[i] && x < arr[i+1])){
                left = i;right = i+1;
                break;
            }
        }
        List<Integer>list = new ArrayList<>();
        while((left >= 0 || right < n) && list.size() < k){
            if(left >= 0 && right < n){
                int leftDiff = x - arr[left], rightDiff = arr[right] - x;
                if(leftDiff <= rightDiff){
                    list.add(arr[left]);
                    left--;
                }
                else{
                    list.add(arr[right]);
                    right++;
                }
            }
            else if(left >= 0)
            {
                list.add(arr[left]);
                left--;
            }
            else{
                list.add(arr[right]);
                right++;
            }
        }
        Collections.sort(list);
        return list;
    }
}
