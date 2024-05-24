import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Problem3184 {
    private static int r;
    private static int c;
    private static char[][] yard;
    private static boolean[][] visited;
    private static int survivedSheeps;
    private static int survivedWolfs;

    public static String solution() {
        survivedSheeps = 0;
        survivedWolfs = 0;

        for(int x = 0; x < r; x++) {
            for(int y = 0 ; y < c; y++) {
                if(visited[x][y] || yard[x][y] == '#') {
                    continue;
                }

                bfs(new int[] {x, y});
            }
        }

        return new StringBuilder()
                .append(survivedSheeps)
                .append(" ")
                .append(survivedWolfs)
                .toString();
    }

    private static void bfs(int[] start) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int sheepsCnt = 0;
        int wolfsCnt = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            if(yard[cx][cy] == 'o') {
                sheepsCnt++;
            }

            if(yard[cx][cy] == 'v') {
                wolfsCnt++;
            }

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(!(0 <= nx && nx < r && 0 <= ny && ny < c)) {
                    continue;
                }

                if(visited[nx][ny]) {
                    continue;
                }

                if(yard[nx][ny] == '#') {
                    continue;
                }

                queue.add(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }

        if(sheepsCnt > wolfsCnt) {
            survivedSheeps += sheepsCnt;
        } else {
            survivedWolfs += wolfsCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st1.nextToken());
        c = Integer.parseInt(st1.nextToken());

        yard = new char[r][c];
        visited = new boolean[r][c];
        for(int i = 0; i < r; i++) {
            String line = br.readLine();
            
            for(int j = 0; j < c; j++) {
                yard[i][j] = line.charAt(j);
            }
        }

        bw.write(solution());
        bw.flush();
        bw.close();
    }
}