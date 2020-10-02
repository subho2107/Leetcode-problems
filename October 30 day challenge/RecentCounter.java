import java.io.*;
import java.util.*;

class RecentCounter {
    int cnt;
    LinkedList<Integer>queryTimes;
    public RecentCounter() {
        cnt = 0;
        queryTimes = new LinkedList<>();
    }

    public int ping(int t) {
        queryTimes.add(t);
        int num = queryTimes.get(queryTimes.size()-1);
        while (queryTimes.get(0)<num-3000)
            queryTimes.removeFirst();
        cnt = queryTimes.size();
        return cnt;
    }
}