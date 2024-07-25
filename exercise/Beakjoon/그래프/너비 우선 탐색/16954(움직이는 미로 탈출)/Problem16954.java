import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution16954 {
    private final int[] DX = {0, 1, 0, 1, 1, -1, -1, 0, -1};
    private final int[] DY = {0, 0, 1, 1, -1, 1, 0, -1, -1};
    private char[][] map;
    private boolean[][] visited;
    
    public Solution16954(char[][] map) {
        this.map = map;
        this.visited = new boolean[8][8];
    }

    public String solve() {
        return String.valueOf(bfs());
    }

    private int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {7, 0});

        while(!queue.isEmpty()) {
            int qSize = queue.size();

            for(int i = 0; i < qSize; i++) {
                int[] curr = queue.poll();
                int cx = curr[0];
                int cy = curr[1];
                
                if(map[cx][cy] == '#') {
                    continue;
                }
                if(cx == 0 && cy == 7) {
                    return 1;
                }
    
                for(int j = 0 ; j < 9; j++) {
                    int nx = cx + DX[j];
                    int ny = cy + DY[j];
    
                    if(!(0<= nx && nx < 8 && 0 <= ny && ny < 8)) {
                        continue;
                    }
                    if(visited[nx][ny]) {
                        continue;
                    }
                    if(map[nx][ny] == '#') {
                        continue;
                    }
    
                    queue.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }

            visited = new boolean[8][8];
            moveWalls();
        }

        return 0;
    }

    private void moveWalls() {
        for(int i = 6; i >= 0; i--) {
            for(int j = 0; j < 8; j++) {
                map[i + 1][j] = map[i][j];
            }
        }
        Arrays.fill(map[0], '.');
    }
}

public class Problem16954 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] arr = new char[8][8];
        for(int i = 0; i < 8; i++) {
            char[] chars = br.readLine().toCharArray();
            for(int j = 0; j < 8; j++) {
                char c = chars[j];
                arr[i][j] = c;
            }
        }
        
        bw.write(new Solution16954(arr).solve());
        bw.flush();
        bw.close();
    }
}
