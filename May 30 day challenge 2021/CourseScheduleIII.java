import java.io.*;
import java.util.*;
public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b)-> a[1] - b[1]);
        int n = courses.length;
        int time = 0;
        PriorityQueue<Integer>queue = new PriorityQueue<>((a, b) -> b-a);
        for (int[] course : courses) {
            if (time + course[0] <= course[1]) {
                time += course[0];
                queue.add(course[0]);
            } else if (!queue.isEmpty() && queue.peek() > course[0]) {
                time -= queue.poll() - course[0];
                queue.add(course[0]);
            }
        }
        return queue.size();
    }
}
