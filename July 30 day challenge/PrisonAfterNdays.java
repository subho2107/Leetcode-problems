import java.io.*;
import java.util.*;

public class PrisonAfterNdays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Set<String>visited = new HashSet<>();
        boolean cycleFound = false;
        int lenOfCycle = 0;
        for (int day = 0; day < N; day++) {
            int [] nextDayForm = getNextDay(cells);
            String key = Arrays.toString(nextDayForm);
            if (visited.contains(key))
            {
                cycleFound = true;
                break;
            }
            visited.add(key);
            lenOfCycle++;
            cells = nextDayForm;
        }
        if (cycleFound)
            return prisonAfterNDays(cells, N%lenOfCycle);
        return cells;
    }

    private int[] getNextDay(int[] cells) {
        int [] nextState = new int[cells.length];
        for (int cell = 1; cell < 7; cell++)
            nextState[cell] = (cells[cell-1]==cells[cell+1])?1:0;
        return nextState;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {

        }
        System.out.println(sb);
    }
}
