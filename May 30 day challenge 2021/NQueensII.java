import java.util.ArrayList;

class NQueensII {
    int N, cnt;
    public void getAllValidStates(int row, ArrayList<int[]> occupiedPositions){
        if(row >= N)
        {
            cnt++;
            return;
        }
        for(int col = 0; col < N; col++){
            boolean canBePlaced = true;
            for(int [] pos : occupiedPositions){
                int rowDiff = Math.abs(pos[0] - row), colDiff = Math.abs(pos[1] - col);
                if((rowDiff == colDiff) || (rowDiff == 0 || colDiff == 0))
                {
                    canBePlaced = false;
                    break;
                }
            }
            if(canBePlaced)
            {
                occupiedPositions.add(new int[]{row, col});
                getAllValidStates(row+1, occupiedPositions);
                occupiedPositions.remove(occupiedPositions.size()-1);

            }
        }
    }
    public int totalNQueens(int n) {
        N = n;
        cnt = 0;
        ArrayList<int[]>occupiedPositions = new ArrayList<>();
        getAllValidStates(0, occupiedPositions);
        return cnt;
    }
}