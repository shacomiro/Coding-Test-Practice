import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class OrganicCabbage {
    public static int solution(int n, int m, int[][] cabbageCoors, boolean[][] cabbageMaps) {
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for(int i = 0; i < cabbageCoors.length; i++) {
            int sx = cabbageCoors[i][0];
            int sy = cabbageCoors[i][1];

            if(visited[sx][sy]) {
                continue;
            }

            bfs(cabbageCoors[i], visited, n, m, cabbageMaps);
            count++;
        }

        return count;
    }

    public static void bfs(int[] start, boolean[][] visited, int width, int height, boolean[][] isCabbagePlanted) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();

        queue.add(start);
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] coor = queue.poll();
            int cx = coor[0];
            int cy = coor[1];

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(!(0 <= nx && nx < width && 0 <= ny && ny < height)) {
                    continue;
                }

                if(!isCabbagePlanted[nx][ny]) {
                    continue;
                }

                if(visited[nx][ny]) {
                    continue;
                }

                queue.add(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st1.nextToken());
            int n = Integer.parseInt(st1.nextToken());
            int k = Integer.parseInt(st1.nextToken());
    
            int[][] cabbageCoors = new int[k][2];
            boolean[][] cabbageMap = new boolean[n][m];
            for(int j = 0; j < k; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st2.nextToken());
                int x = Integer.parseInt(st2.nextToken());

                cabbageCoors[j] = new int[] {x, y};
                cabbageMap[x][y] = true;
            }            
            bw.write(String.valueOf(solution(n, m, cabbageCoors, cabbageMap)));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
