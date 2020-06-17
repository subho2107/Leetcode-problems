import java.util.ArrayList;
class Surrounded_Region
{
    boolean valid;
    boolean[][]visited;
    public void dfs(int rowPos, int colPos, ArrayList<int[]> posToBeChang, char[][]board)
    {
        int rowLen = board.length-1, colLength = board[0].length-1;
        if (!(rowPos > rowLen || rowPos < 0 || colPos < 0 || colPos > colLength) && board[rowPos][colPos] != 'X' && !visited[rowPos][colPos]) {
            visited[rowPos][colPos] = true;
            if (rowPos==0||rowPos==rowLen||colPos==0||colPos==colLength) {
                this.valid = false;
            }
            int[] a = {rowPos, colPos};
            posToBeChang.add(a);
            dfs(rowPos + 1, colPos, posToBeChang, board);
            dfs(rowPos - 1, colPos, posToBeChang, board);
            dfs(rowPos, colPos - 1, posToBeChang, board);
            dfs(rowPos, colPos + 1, posToBeChang, board);
        }

    }
    public void solve(char[][] board)
    {
        if(board.length==0)return;
        this.valid=true;
        this.visited = new boolean[board.length][board[0].length];
        int rowLen = board.length, colLen = board[0].length;
        ArrayList <int []> posToBeChang = new ArrayList<int[]>();
        for (int rowPos = 0; rowPos < rowLen; rowPos++)
        {
            for (int colPos = 0; colPos < colLen; colPos++)
            {
                if(board[rowPos][colPos]=='O')
                {
                    this.valid=true;
                    ArrayList <int []> temp = new ArrayList<int[]>();
                    this.dfs(rowPos, colPos, temp, board);
                    if(!this.valid)temp.clear();
                    else posToBeChang.addAll(temp);

                }
            }

        }
        for (int[]arr:posToBeChang) {
            board[arr[0]][arr[1]]= 'X';

        }
    }

}