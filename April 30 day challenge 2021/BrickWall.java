import java.io.*;
import java.util.*;

public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int maxWall = 0;
        for (List<Integer> row : wall) {
            int temp = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                int width = row.get(i);
                temp += width;
                freq.put(temp, freq.getOrDefault(temp, 0) + 1);
                maxWall = Math.max(maxWall, freq.get(temp));
            }
        }
        return wall.size() - maxWall;
    }

}
