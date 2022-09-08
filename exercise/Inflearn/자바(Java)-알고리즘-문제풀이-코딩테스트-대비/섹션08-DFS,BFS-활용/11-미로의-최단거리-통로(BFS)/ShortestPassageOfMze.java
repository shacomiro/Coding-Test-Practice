import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] maze = new int[7][7];
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    static int answer = -1;

    public void bfs(int L) {
        Queue<int[]> queue = new LinkedList<>();
        maze[0][0] = 1;
        queue.offer(new int[] {0, 0});

        while(!queue.isEmpty()) {
            int len = queue.size();

            for(int i = 0; i < len; i++) {
                int[] coor = queue.poll();
                int x = coor[0];
                int y = coor[1];

                if(x == 6 && y == 6) {
                    answer = L;
                    return;
                }
                for(int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if(0 <= nx && nx < 7 && 0 <= ny && ny < 7 && maze[nx][ny] == 0) {
                        maze[nx][ny] = 1;
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }

            L++;
        }
    }

    class Point{
        public int x, y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    static int[][] board = new int[8][8];
    static int[][] dis = new int[8][8];

    public void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        board[x][y] = 1;

        while(!Q.isEmpty()) {
            Point tmp = Q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(1 <= nx && nx <= 7 && 1 <= ny && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    Q.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 1; i <= 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 7; j++) {
                int num = Integer.parseInt(st.nextToken());
                maze[i - 1][j - 1] = num;
                board[i][j] = num;
            }
        }

//        T.bfs(0);
//        System.out.println(answer);

        T.BFS(1, 1);
        if(dis[7][7] == 0) System.out.println(-1);
        else System.out.println(dis[7][7]);
    }
}
