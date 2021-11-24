import java.io.*;
import java.util.*;

public class IteratorForCombination {
    class CombinationIterator {
        private List<String>combinations;
        private int pos;
        private int size;
        public CombinationIterator(String characters, int combinationLength) {
            combinations = new ArrayList<>();
            pos = 0;
            char [] arr = characters.toCharArray();
            int n = characters.length();
            for(int i = (1<<n)-1; i >= 0; i--){
                int bitCnt = 0, dup = i;
                StringBuilder sb = new StringBuilder();
                for(int j = n-1; j >= 0; j--){
                    if((i&(1<<j)) > 0){
                        bitCnt++;
                        sb.append(arr[n-j-1]);
                    }
                }
                if(bitCnt == combinationLength)
                    combinations.add(sb.toString());
            }
            size = combinations.size();
        }

        public String next() {
            return combinations.get(pos++);
        }

        public boolean hasNext() {
            return pos < size;
        }
    }
}
