import java.util.*;
class Pair<T1, T2>{
    T1 first;
    T2 second;
    Pair(T1 obj, T2 obj2){
        this.first = obj;
        this.second = obj2;
    }
    T1 getKey(){
        return first;
    }
    T2 getValue(){
        return second;
    }
}
class UndergroundSystem {
    HashMap<Integer, Pair<String, Integer>> checkIns;
    HashMap<String, int[]>timeStamps;//at 0 cnt of trips at 1 total time
    public UndergroundSystem() {
        checkIns = new HashMap<>();
        timeStamps = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer>startingInfo = checkIns.get(id);
        String route = startingInfo.first+" "+stationName;
        int [] temp = timeStamps.getOrDefault(route, new int[2]);
        temp[0]++;
        temp[1] += t - startingInfo.second;
        timeStamps.put(route, temp);
    }

    public double getAverageTime(String startStation, String endStation) {
        int [] info = timeStamps.get(startStation+" "+endStation);
        return (double) info[1]/info[0];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */