import java.io.*;
import java.util.*;

public class SudokuSolver {
    List<int[]>emptyCells;
    int [] rows, cols, boxes;
    public void solveSudoku(char[][] board) {
        emptyCells = new ArrayList<>();
        rows = new int[9];
        cols = new int[9];
        boxes = new int[9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.')
                    emptyCells.add(new int[]{i, j});
                else{
                    int num = board[i][j]-'0';
                    rows[i] |= 1<<num;
                    cols[j] |= 1<<num;
                    boxes[(i/3)*3+(j/3)] |= 1<<num;
                }
            }
        }
        backtrack(board, 0);
    }
    public boolean backtrack(char [][] board, int i){
        if(i == emptyCells.size())
            return true;
        int r = emptyCells.get(i)[0], c = emptyCells.get(i)[1], boxPos = (r/3)*3+(c/3);
        for(int num = 1; num <= 9; num++){
            if(containsBit(num, rows[r]) || containsBit(num, cols[c]) || containsBit(num, boxes[boxPos]))
                continue;
            int oldRow  = rows[r], oldCol = cols[c], oldBox = boxes[boxPos];
            rows[r] |= 1<<num;
            cols[c] |= 1<<num;
            boxes[boxPos] |= 1<<num;
            board[r][c] = (char)('0'+num);
            if(backtrack(board, i+1))
                return true;
            rows[r] = oldRow;
            cols[c] = oldCol;
            boxes[boxPos] = oldBox;
        }
        return false;
    }
    public boolean containsBit(int bit, int num){
        return ((num>>bit) & 1) == 1;
    }
}
