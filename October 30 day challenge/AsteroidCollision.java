import java.io.*;
import java.util.*;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        asteroids:
        for (int num : asteroids) {
            while (!stack.isEmpty() && num < 0 && stack.peek() > 0) {
                if (-num > stack.peek())
                    stack.pop();
                else if (-num < stack.peek())
                    continue asteroids;
                else
                {
                    stack.pop();
                    continue asteroids;
                }
            }
            stack.push(num);
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = stack.get(i);
        return res;
    }

}
