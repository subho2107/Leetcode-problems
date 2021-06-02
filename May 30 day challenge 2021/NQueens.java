import java.io.*;
import java.util.*;
class NQueens {
    int N;
    List<List<String>>ans;
    public void getAllValidStates(int row, ArrayList<int[]>occupiedPositions){
        if(row >= N)
        {
            char [][] matrix = new char[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = '.';
                }
            }
            for(int [] pos : occupiedPositions){
                matrix[pos[0]][pos[1]] = 'Q';
            }
            List<String>list = new ArrayList<>();
            for(char [] currRow : matrix)
                list.add(String.valueOf(currRow));
            ans.add(list);
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
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        N = n;
        ArrayList<int[]>occupiedPositions = new ArrayList<>();
        getAllValidStates(0, occupiedPositions);
        return ans;
    }
}