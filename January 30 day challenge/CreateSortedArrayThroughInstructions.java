class CreateSortedArrayThroughInstructions {
    public int createSortedArray(int[] instructions) {
        int n = instructions.length;
        int max = 0;
        for(int num : instructions)
            max = Math.max(num, max);
        FenwickTree fw = new FenwickTree(max+1);
        long cost = 0, MOD = (int) 1e9 + 7;
        for(int i = 0; i < n; i++){
            int left = fw.query(instructions[i]-1);
            int right = i - fw.query(instructions[i]);
            cost += Math.min(left, right);
            cost %= MOD;
            fw.add(instructions[i], 1);
        }
        return (int)cost;
    }
}
class FenwickTree{
    int [] bit;
    int n;
    FenwickTree(int n){
        this.n = n;
        bit = new int[n];
    }
    void add(int i, int val){
        while(i < n){
            bit[i] += val;
            i += i & -i;
        }
    }
    int query(int i){
        int val = 0;
        while(i > 0){
            val += bit[i];
            i -= i & -i;
        }
        return val;
    }
}