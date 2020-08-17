public class DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        int [] candyDistrb = new int[num_people];
        int currCandy = 1;
        while(candies>0){
            for(int pos = 0; pos < num_people && candies>0; pos++){
                candyDistrb[pos] += Math.min(currCandy, candies);
                candies -= currCandy++;
            }
        }
        return candyDistrb;
    }
}
