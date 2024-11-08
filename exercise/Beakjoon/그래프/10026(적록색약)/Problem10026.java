import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

class Solution10026 {
    private final int[] DX = {0, 1, 0, -1};
    private final int[] DY = {1, 0, -1, 0};
    private int size;
    private char[][] paint;
    private Map<Character, Integer> normal;
    private Map<Character, Integer> dyschromatopsia;
    

    public Solution10026(int size, char[][] paint) {
        this.size = size;
        this.paint = paint;
        this.normal = Map.of('R', 0, 'G', 1, 'B', 2);
        this.dyschromatopsia = Map.of('R', 0, 'G', 0, 'B', 2);
    }

    public String solve() {
        int normalCnt = 0;
        int dyschromatopsiaCnt = 0;
        boolean[][] visited = new boolean[size][size];

        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                if(!visited[x][y]) {
                    normalCnt++;
                    bfs(new int[] {x, y}, visited, false);
                }
            }
        }

        visited = new boolean[size][size];
        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                if(!visited[x][y]) {
                    dyschromatopsiaCnt++;
                    bfs(new int[] {x, y}, visited, true);
                }
            }
        }

        return normalCnt + " " + dyschromatopsiaCnt;
    }

    private void bfs(int[] start, boolean[][] visited, boolean isDyschromatopsia) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        Map<Character, Integer> colorCode = isDyschromatopsia ? dyschromatopsia : normal;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            for(int i = 0; i < 4; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];

                if(!(0 <= nx && nx < size && 0 <= ny && ny < size)) {
                    continue;
                }
                if(visited[nx][ny]) {
                    continue;
                }
                if(colorCode.get(paint[cx][cy]) != colorCode.get(paint[nx][ny])) {
                    continue;
                }

                queue.offer(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
}

public class Problem10026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        for(int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for(int j = 0; j < n; j++) {
                arr[i][j] = chars[j];
            }
        }

        bw.write(new Solution10026(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
