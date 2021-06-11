import java.io.*;
import java.util.*;
class MyCalendar {
    PriorityQueue<int[]>bookings;
    public MyCalendar() {
        bookings = new PriorityQueue<>((o1, o2)->{
            return o1[0]-o2[0];
        });
    }

    public boolean book(int start, int end) {
        int [] arr = {start, end};
        for(int [] booking : bookings){
            if(arr[0] >= booking[0] && arr[0] < booking[1])
                return false;
            else if(arr[0] < booking[0] && arr[1]-1 >= booking[0])
                return false;
        }
        bookings.add(arr);
        return true;
    }
}
