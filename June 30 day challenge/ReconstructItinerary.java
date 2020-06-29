import java.io.*;
import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(ArrayList<ArrayList<String>> tickets) {
        LinkedList<String>itinerary = new LinkedList<>();
        Collections.sort(tickets, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> s1, List<String> s2) {
                int val = s1.get(0).compareTo(s2.get(0));
                if (val > 0)return 1;
                else if (val ==0)
                {
                    if (s1.get(1).compareTo(s2.get(1))>0)return 1;
                    else return -1;
                }
                return -1;
            }
        });
        HashMap<String, LinkedList<String>> connections = new HashMap<>();
        for (List<String> tkt:
                tickets) {
            if (connections.containsKey(tkt.get(0)))
            {
                connections.get(tkt.get(0)).add(tkt.get(1));
            }
            else
            {
                LinkedList<String>temp=new LinkedList<>();
                temp.add(tkt.get(1));
                connections.put(tkt.get(0), temp);
            }
        }
        Stack<String>stack=new Stack<>();
        stack.push("JFK");
        while (!stack.isEmpty())
        {
            while (connections.containsKey(stack.peek()) && !connections.get(stack.peek()).isEmpty())
            {
                stack.push(connections.get(stack.peek()).poll());
            }
            itinerary.addFirst(stack.pop());
        }
        return itinerary;

    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<ArrayList<String>>tickets = new ArrayList<ArrayList<String>>();
        int n = Integer.parseInt(buffer.readLine());
        for (int pos = 0; pos < n; pos++) {
            String[]inp =buffer.readLine().split(" ");
            ArrayList<String>temp = new ArrayList<>(Arrays.asList(inp[0], inp[1]));
            tickets.add(temp);
        }
        ReconstructItinerary obj = new ReconstructItinerary();
        ArrayList<String>res = (ArrayList<String>) obj.findItinerary(tickets);
        System.out.println(res.toString());
        System.out.println(sb);
    }
}
