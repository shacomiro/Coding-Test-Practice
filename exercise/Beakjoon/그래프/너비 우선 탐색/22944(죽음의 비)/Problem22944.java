import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution22944 {
    private final int[] DX = {1, 0, -1, 0};
    private final int[] DY = {0, 1, 0, -1};
    private int length;
    private char[][] map;
    private int[][] visited;
    private int health;
    private int umbrellaHealth;
    private int[] start;

    public Solution22944(int length, char[][] map, int health, int umbrellaHealth, int[] start) {
        this.length = length;
        this.map = map;
        this.visited = new int[length][length];
        this.health = health;
        this.umbrellaHealth = umbrellaHealth;
        this.start = start;
    }

    public String solve() {
        return String.valueOf(bfs(start));
    }

    private int bfs(int[] start) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {start[0], start[1], health, 0, 0});
        visited[start[0]][start[1]] = health;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];
            int ch = curr[2];
            int cu = curr[3];
            int cd = curr[4];

            for(int i = 0; i < 4; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];
                int nh = ch;
                int nu = cu;
                int nd = cd + 1;

                if(!(0 <= nx && nx < length && 0 <= ny && ny < length)) {
                    continue;
                }

                if(map[nx][ny] == 'E') {
                    return nd;
                }
                if(map[nx][ny] == 'U') {
                    nu = umbrellaHealth;
                }
                if(nu > 0) {
                    nu--;
                } else {
                    nh--;
                }
                if(nh == 0) {
                    continue;
                }

                if(visited[nx][ny] >= nh + nu) {
                    continue;
                }
                
                queue.offer(new int[] {nx, ny, nh, nu, nd});
                visited[nx][ny] = nh + nu;
            }
        }

        return -1;
    }
}

public class Problem22944 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][n];
        int[] start = new int[2];
        for(int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for(int j = 0; j < n; j++) {
                char c = chars[j];
                arr[i][j] = c;

                if(c == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        bw.write(new Solution22944(n, arr, h, d, start).solve());
        bw.flush();
        bw.close();
    }
}
