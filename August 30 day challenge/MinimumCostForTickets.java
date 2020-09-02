import java.io.*;
import java.util.*;

public class MinimumCostForTickets {
    int[] costs;
    Integer[] memoization;
    Set<Integer> setOfDays;

    public int mincostTickets(int[] days, int[] costs) {
        setOfDays = new HashSet<>();
        memoization = new Integer[366];
        for (int day : days)
            setOfDays.add(day);
        this.costs = costs;
        return dp(1);
    }

    public int dp(int day) {
        if (day > 365)
            return 0;
        if (memoization[day] == null) {
            if (setOfDays.contains(day)) {
                memoization[day] = Math.min(dp(day + 1) + costs[0], dp(day + 7) + costs[1]);
                memoization[day] = Math.min(memoization[day], dp(day + 30) + costs[2]);
            } else
                memoization[day] = dp(day + 1);
        }
        return memoization[day];
    }
}
