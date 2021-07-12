import java.io.*;
import java.util.*;

public class FindMedianFromDataStream {
    PriorityQueue<Integer>minHeap, maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if(minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        if(minHeap.size() == maxHeap.size())
            return ((double)minHeap.peek()+maxHeap.peek())/2;
        return maxHeap.peek();
    }
}
