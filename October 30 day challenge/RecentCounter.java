import java.io.*;
import java.util.*;

class RecentCounter {
    int cnt;
    ArrayList<Integer>queryTimes;
    public RecentCounter() {
        cnt = 0;
        queryTimes = new ArrayList<>();
    }

    public int ping(int t) {
        queryTimes.add(t);
        int num = queryTimes.get(queryTimes.size()-1);
        while (queryTimes.get(0)<num-3000)
            queryTimes.remove(0);
        cnt = queryTimes.size();
        return cnt;
    }
}