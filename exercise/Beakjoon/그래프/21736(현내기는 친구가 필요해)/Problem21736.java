import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution21736 {
    private final int[] DX = {0, 1, 0, -1};
    private final int[] DY = {1, 0, -1, 0};
    private int height;
    private int width;
    private char[][] campus;
    private boolean[][] visited;
    private int[] start;

    public Solution21736(int height, int width, char[][] campus, int[] start) {
        this.height = height;
        this.width = width;
        this.campus = campus;
        this.visited = new boolean[height][width];
        this.start = start;
    }

    public String solve() {
        int count = bfs(start);

        return String.valueOf(count > 0 ? count : "TT");
    }

    private int bfs(int[] start) {
        int count = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            if(campus[cx][cy] == 'P') {
                count++;
            }

            for(int i = 0; i < 4; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];

                if(!(0 <= nx && nx < height && 0 <= ny && ny < width)) {
                    continue;
                }
                if(visited[nx][ny]) {
                    continue;
                }
                if(campus[nx][ny] == 'X') {
                    continue;
                }

                queue.offer(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }

        return count;
    }
}

public class Problem21736 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][m];
        int[] s = new int[2];
        for(int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                arr[i][j] = chars[j];
                if(chars[j] == 'I') {
                    s[0] = i;
                    s[1] = j;
                }
            }
        }

        bw.write(new Solution21736(n, m, arr, s).solve());
        bw.flush();
        bw.close();
    }
}
