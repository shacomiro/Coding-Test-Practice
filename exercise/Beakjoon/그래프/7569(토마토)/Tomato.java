import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {
    public static int solution(int h, int n, int m, int[][][] tomatoBoxes, boolean[][][] visited, LinkedList<int[]> ripenedTomatos, int rawTomatosCnt) {
        if(rawTomatosCnt == 0) {
            return 0;
        }

        return bfs(ripenedTomatos, rawTomatosCnt, visited, tomatoBoxes, h, n, m);
    }

    public static int bfs(LinkedList<int[]> ripenedTomatos, int rawTomatosCnt, boolean[][][] visited, int[][][] tomatoBoxes, int h, int n, int m) {
        int[] dx = {1, 0, 0, -1, 0, 0};
        int[] dy = {0, 1, 0, 0, -1, 0};
        int[] dz = {0, 0, 1, 0, 0, -1};
        Queue<int[]> queue = ripenedTomatos;
        int days = -1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int[] coor = queue.poll();
                int cx = coor[1];
                int cy = coor[2];
                int cz = coor[0];

                if(tomatoBoxes[cz][cx][cy] == 0) {
                    tomatoBoxes[cz][cx][cy] = 1;
                    rawTomatosCnt--;
                }
    
                for(int j = 0; j < 6; j++) {
                    int nx = cx + dx[j];
                    int ny = cy + dy[j];
                    int nz = cz + dz[j];
    
                    if(!(0 <= nz && nz < h && 0 <= nx && nx < n && 0 <= ny && ny < m)) {
                        continue;
                    }
    
                    if(tomatoBoxes[nz][nx][ny] == -1) {
                        continue;
                    }
    
                    if(visited[nz][nx][ny]) {
                        continue;
                    }
    
                    queue.add(new int[] {nz, nx, ny});
                    visited[nz][nx][ny] = true;
                }
            }
            
            days++;
        }

        return rawTomatosCnt > 0 ? -1 : days;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st1.nextToken());
        int n = Integer.parseInt(st1.nextToken());
        int h = Integer.parseInt(st1.nextToken());
        int[][][] tomatoBoxes = new int[h][n][m];
        boolean[][][] visited = new boolean[h][n][m];
        LinkedList<int[]> ripenedTomatos = new LinkedList<>();
        int rawTomatosCnt = 0;

        for(int z = 0; z < h; z++) {
            for(int x = 0; x < n; x++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());

                for(int y = 0; y < m; y++) {                    
                    int num = Integer.parseInt(st2.nextToken());
                    tomatoBoxes[z][x][y] = num;
                    int[] tomatoCoor = new int[] {z, x, y};

                    if(num == 0) {
                        rawTomatosCnt++;
                    }

                    if(num == 1) {
                        ripenedTomatos.add(tomatoCoor);
                        visited[z][x][y] = true;
                    }
                }
            }
        }

        bw.write(String.valueOf(solution(h, n, m, tomatoBoxes, visited, ripenedTomatos, rawTomatosCnt)));
        bw.flush();
        bw.close();
    }
}