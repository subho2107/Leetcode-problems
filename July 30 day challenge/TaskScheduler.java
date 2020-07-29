import java.util.ArrayList;
import java.util.HashMap;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer>frequency = new HashMap<>();
        for(char ch:tasks){
            frequency.put(ch, frequency.getOrDefault(ch, 0)+1);
        }
        ArrayList<Character>characters = new ArrayList<>(frequency.keySet());
        characters.sort((o1, o2) -> frequency.get(o2) - frequency.get(o1));
        int maxFreq = frequency.get(characters.get(0));
        int noOfMaxs = 0;
        for (Character character : characters) {
            if (frequency.get(character) == maxFreq)
                noOfMaxs++;
        }
        return Math.max((maxFreq-1)*(n+1)+noOfMaxs, tasks.length);

    }
    public static void main(String[] args) {
        char [] arr = {'A','A','B','B','C','C','D','D','E','E','F','F','G','G','H','H','I','I','J','J','K','K','L','L','M','M','N','N','O','O','P','P','Q','Q','R','R','S','S','T','T','U','U','V','V','W','W','X','X','Y','Y','Z','Z'};
        System.out.println(new TaskScheduler().leastInterval(arr,2));
    }
}
