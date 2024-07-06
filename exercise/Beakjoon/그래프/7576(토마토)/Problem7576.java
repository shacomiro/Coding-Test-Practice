import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem7576 {
    public static int solution(int n, int m, int[][] tomatoBox, boolean[][] visited, LinkedList<int[]> ripenedTomatos, int rawTomatosCnt) {
        if(rawTomatosCnt == 0) {
            return 0;
        }
        
        return bfs(ripenedTomatos, rawTomatosCnt, tomatoBox, visited, n, m);
    }

    public static int bfs(LinkedList<int[]> ripenedTomatos, int rawTomatosCnt, int[][] tomatoBox, boolean[][] visited, int n, int m) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> queue = ripenedTomatos;
        int days = -1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                int[] coor = queue.poll();
                int cx = coor[0];
                int cy = coor[1];

                if(tomatoBox[cx][cy] == 0) {
                    tomatoBox[cx][cy] = 1;
                    rawTomatosCnt--;
                }
    
                for(int j = 0; j < 4; j++) {
                    int nx = cx + dx[j];
                    int ny = cy + dy[j];
    
                    if(!(0 <= nx && nx < n && 0 <= ny && ny < m)) {
                        continue;
                    }
    
                    if(tomatoBox[nx][ny] == -1) {
                        continue;
                    }
    
                    if(visited[nx][ny]) {
                        continue;
                    }
    
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
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
        int[][] tomatoBox = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        LinkedList<int[]> ripenedTomatos = new LinkedList<>();
        int rawTomatosCnt = 0;

        for(int x = 0; x < n; x++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for(int y = 0; y < m; y++) {                    
                int num = Integer.parseInt(st2.nextToken());
                tomatoBox[x][y] = num;

                if(num == 0) {
                    rawTomatosCnt++;
                }

                if(num == 1) {
                    ripenedTomatos.add(new int[] {x, y});
                    visited[x][y] = true;
                }
            }
        }
        
        bw.write(String.valueOf(solution(n, m, tomatoBox, visited, ripenedTomatos, rawTomatosCnt)));
        bw.flush();
        bw.close();
    }
}
