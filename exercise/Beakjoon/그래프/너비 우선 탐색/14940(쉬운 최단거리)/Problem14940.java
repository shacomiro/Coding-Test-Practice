import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem14940 {
    public static int[][] solution(int n, int m, int[] start, int[][] map, boolean[][] visited) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> coorQueue = new LinkedList<>();
        Queue<int[]> unreachableCoorQueue = new LinkedList<>();

        coorQueue.add(new int[] {start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while(!coorQueue.isEmpty()) {
            int[] info = coorQueue.poll();
            int cx = info[0];
            int cy = info[1];
            int cd = info[2];

            if(map[cx][cy] == 1) {
                map[cx][cy] = cd;
            }

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nd = cd + 1;

                if(!isValidCoor(nx, ny, n, m)) {
                    continue;
                }

                if(visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                if(map[nx][ny] != 0) {
                    coorQueue.add(new int[] {nx, ny, nd});
                } else {
                    unreachableCoorQueue.add(new int[] {nx, ny});
                }
                
            }
        }

        while(!unreachableCoorQueue.isEmpty()) {
            int[] info = unreachableCoorQueue.poll();
            int cx = info[0];
            int cy = info[1];

            if(map[cx][cy] == 1) {
                map[cx][cy] = -1;
            }

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(!isValidCoor(nx, ny, n, m)) {
                    continue;
                }
                
                if(visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                unreachableCoorQueue.add(new int[] {nx, ny});
            }
        }

        return map;
    }

    public static int[][] solution2(int n, int m, int[] start, int[][] map, boolean[][] visited) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> coorQueue = new LinkedList<>();

        coorQueue.add(new int[] {start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while(!coorQueue.isEmpty()) {
            int[] info = coorQueue.poll();
            int cx = info[0];
            int cy = info[1];
            int cd = info[2];

            if(map[cx][cy] == 1) {
                map[cx][cy] = cd;
            }

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nd = cd + 1;

                if(!isValidCoor(nx, ny, n, m)) {
                    continue;
                }

                if(visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                coorQueue.add(new int[] {nx, ny, nd});
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j]) {
                    continue;
                }

                if(map[i][j] == 1) {
                    map[i][j] = -1;
                }
            }
        }

        return map;
    }

    public static boolean isValidCoor(int x, int y, int width, int height) {
        if(0 <= x && x < width && 0 <= y && y < height) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        
        int[] start = new int[2];

        for(int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int num = Integer.parseInt(st2.nextToken());

                if(num == 2) {
                    start[0] = i;
                    start[1] = j;
                    num = 1;
                }

                map[i][j] = num;
            }
        }

        for(int[] line : solution(n, m, start, map, visited)) {
            for(int dis : line) {
                bw.write(dis + " ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}