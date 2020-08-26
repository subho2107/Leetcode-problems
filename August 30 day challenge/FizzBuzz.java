import java.io.*;
import java.util.*;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> result = new ArrayList<>();
        for (int currNum = 1; currNum < n + 1; currNum++) {
            if (currNum % 15 == 0)
                result.add("FizzBuzz");
            else if (currNum % 3 == 0)
                result.add("Fizz");
            else if (currNum % 5 == 0)
                result.add("Buzz");
            else
                result.add(Integer.toString(currNum));
        }
        return result;
    }
}
