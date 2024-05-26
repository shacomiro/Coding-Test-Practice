import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem4963 {

    public static String solution(int w, int h, boolean[][] map) {
        boolean[][] visited = new boolean[h][w];
        int IslandsCnt = 0;

        for(int x = 0; x < h; x++) {
            for(int y = 0; y < w; y++) {
                if(visited[x][y]) {
                    continue;
                }

                if(!map[x][y]) {
                    continue;
                }

                bfs(new int[] {x, y}, map, visited, w, h);
                IslandsCnt++;
            }
        }

        return String.valueOf(IslandsCnt);
    }

    private static void bfs(int[] start, boolean[][] map, boolean[][] visited, int width, int height) {
        int[] dx = {1, 0, -1 ,0, 1, 1, -1, -1};
        int[] dy = {0, 1, 0 ,-1, 1, -1, 1, -1};
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            for(int i = 0; i < 8; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(!(0 <= nx && nx < height && 0 <= ny && ny < width)) {
                    continue;
                }

                if(visited[nx][ny]) {
                    continue;
                }

                if(!map[nx][ny]) {
                    continue;
                }

                queue.offer(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        while(!(input = br.readLine()).equals("0 0")) {
            StringTokenizer st1 = new StringTokenizer(input);
            int w = Integer.parseInt(st1.nextToken());
            int h = Integer.parseInt(st1.nextToken());
            boolean[][] arr = new boolean[h][w];

            for(int i = 0; i < h; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());

                for(int j = 0; j < w; j++) {
                    if(st2.nextToken().equals("1")) {
                        arr[i][j] = true;
                    } else {
                        arr[i][j] = false;
                    }
                }
            }
            bw.write(solution(w, h, arr));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}