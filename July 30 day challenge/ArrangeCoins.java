class ArrangeCoins {
    public int arrangeCoins(int n) {
        if(n==0)return 0;
        long row = 0;
        int cnt = 0;
        while(row < n)
        {
            row += cnt+1;
            cnt++;
        }
        if(row>n)
            cnt--;
        return cnt;
    }
}