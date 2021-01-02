import java.io.*;
import java.util.*;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length;
        int [][] nextGeneration = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int alive = 0;
                nextGeneration[i][j] = board[i][j];
                if(i-1 >= 0 && j-1 >= 0 && board[i-1][j-1] == 1)
                    alive++;
                if(i+1 < n && j+1 < m && board[i+1][j+1] == 1)
                    alive++;
                if(j+1 < m && board[i][j+1] == 1)
                    alive++;
                if(j-1 >= 0 && board[i][j-1] == 1)
                    alive++;
                if(i+1 < n && board[i+1][j] == 1)
                    alive++;
                if(i-1 >= 0 && board[i-1][j] == 1)
                    alive++;
                if(i-1 >= 0 && j+1<m && board[i-1][j+1] == 1)
                    alive++;
                if (i+1 < n && j-1>=0 && board[i+1][j-1] == 1)
                    alive++;
                if(board[i][j] == 1){
                    if(alive < 2)
                        nextGeneration[i][j] = 0;
                    if(alive > 3)
                        nextGeneration[i][j] = 0;
                }
                else if(alive == 3){
                    nextGeneration[i][j] = 1;
                }
            }
        }
        for(int i = 0; i < n; i++)
            System.arraycopy(nextGeneration[i], 0, board[i], 0, m);
    }
}
