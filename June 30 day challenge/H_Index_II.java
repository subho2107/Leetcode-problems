import java.io.*;
import java.util.*;

public class H_Index_II {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if(len==0)return 0;
        if(citations[0]>len)return len;
        int pos = len-1;
        int left = 0, right = pos, hIndex =0;
        while (left<=right)
        {
            int mid = (left+right)/2;
            if(len-mid<=citations[mid])
                hIndex = Math.max(hIndex, len-mid);
            if(mid+1<len && len-mid-1<=hIndex)
                right=mid-1;
            else
                left = mid+1;
        }
        return hIndex;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int []arr = {7,8,9};
        System.out.println(new H_Index_II().hIndex(arr));
    }
}
