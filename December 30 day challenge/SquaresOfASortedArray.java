import java.io.*;
import java.util.*;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        ArrayList<Integer>squares = new ArrayList<>();
        for(int num : nums)
            squares.add(num*num);
        Collections.sort(squares);
        return squares.stream().mapToInt(o->o).toArray();

    }
}
