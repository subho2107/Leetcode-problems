import java.io.*;
import java.util.*;

public class BeautifulArrangement {
    int cnt;
    public void cntUtil(ArrayList<Integer>list, int n){
        if(list.size() == 0)
        {
            cnt++;
            return;
        }
        int pos = n - list.size() + 1;
        for(int i = 0; i < list.size(); i++){
            int num = list.get(i);
            if(num % pos == 0 || pos % num == 0){
                list.remove(i);
                cntUtil(list, n);
                list.add(i, num);
            }
        }
    }
    public int countArrangement(int n) {
        cnt = 0;
        ArrayList<Integer>list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            list.add(i);
        cntUtil(list, n);
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new BeautifulArrangement().countArrangement(15));
    }
}
