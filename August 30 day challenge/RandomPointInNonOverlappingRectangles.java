import java.io.*;
import java.util.*;

public class RandomPointInNonOverlappingRectangles {
    int[][] rectangles;
    Random random;
    int sum;
    TreeMap<Integer, Integer> possibleSums;

    public RandomPointInNonOverlappingRectangles(int[][] rects) {
        rectangles = rects;
        random = new Random();
        sum = 0;
        possibleSums = new TreeMap<>();
        for (int pos = 0; pos < rects.length; pos++) {
            int[] rectangle = rects[pos];
            int x1 = rectangle[0], y1 = rectangle[1], x2 = rectangle[2], y2 = rectangle[3];
            sum += (x2 - x1 + 1) * (y2 - y1 + 1);
            possibleSums.put(sum, pos);
        }
    }

    public int[] pick() {
        int key = possibleSums.ceilingKey(random.nextInt(sum) + 1);
        int[] chosenRect = rectangles[possibleSums.get(key)];
        int[] point = new int[2];
        point[0] = chosenRect[0] + random.nextInt(chosenRect[2] - chosenRect[0] + 1);
        point[1] = chosenRect[1] + random.nextInt(chosenRect[3] - chosenRect[1] + 1);
        return point;
    }
}
