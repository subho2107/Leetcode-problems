import java.io.*;
import java.util.*;

public class _01Matrix {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]>queue = new LinkedList<>();
        int n = mat.length, m = mat[0].length;
        int [][] dist = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0)
                    queue.add(new int[]{i, j});
                else
                    dist[i][j] = Integer.MAX_VALUE;
            }
        }
        int [][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while(queue.size() != 0){
            int [] curr = queue.poll();
            for(int [] currDir : dir){
                int x = currDir[0]+curr[0], y = currDir[1]+curr[1];
                if(x >= 0 && y >= 0 && x < n && y < m){
                    if(dist[x][y] > dist[curr[0]][curr[1]] + 1){
                        dist[x][y] = dist[curr[0]][curr[1]] + 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
        return dist;
    }
    public int[][] updateMatrixDPSoln(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int [][] dist = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dist[i][j] = Integer.MAX_VALUE-100_00;
                if(mat[i][j] == 0)
                    dist[i][j] = 0;
                else{
                    if(i-1 >= 0)
                        dist[i][j] = Math.min(dist[i][j], dist[i-1][j]+1);
                    if(j-1 >= 0)
                        dist[i][j] = Math.min(dist[i][j], dist[i][j-1]+1);
                }
            }
        }
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                if(i+1 < n)
                    dist[i][j] = Math.min(dist[i][j], dist[i+1][j]+1);
                if(j+1 < m)
                    dist[i][j] = Math.min(dist[i][j], dist[i][j+1]+1);
            }
        }
        return dist;
    }
}
