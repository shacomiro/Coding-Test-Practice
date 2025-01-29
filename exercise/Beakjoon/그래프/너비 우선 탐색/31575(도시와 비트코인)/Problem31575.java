import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution31575 {
    private int[] DX = {0, 1};
    private int[] DY = {1, 0};
    private int n;
    private int m;
    private int[][] city;

    public Solution31575(int n, int m, int[][] city) {
        this.n = n;
        this.m = m;
        this.city = city;
    }

    public String solve() {
        return bfs(new int[] {0, 0});
    }

    private String bfs(int[] start) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            if(cx == m - 1 && cy == n - 1) {
                return "Yes";
            }

            for(int i = 0; i < 2; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];

                if(!(0 <= nx && nx < m && 0 <= ny && ny < n)) {
                    continue;
                }
                if(visited[nx][ny]) {
                    continue;
                }
                if(city[nx][ny] == 0) {
                    continue;
                }
                
                queue.offer(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }

        return "No";
    }
}

public class Problem31575 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(new Solution31575(n, m, arr).solve());
        bw.flush();
        bw.close();
    }
}
