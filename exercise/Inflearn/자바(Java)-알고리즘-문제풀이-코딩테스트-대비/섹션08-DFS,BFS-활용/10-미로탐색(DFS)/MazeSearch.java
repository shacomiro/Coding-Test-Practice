import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    static int[][] maze = new int[7][7];
    static int[][] check = new int[7][7];
    int[][] path = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    public void dfs(int y, int x) {
        if(maze[y][x] == 1) return;
        if(x == 6 && y == 6) answer++;
        else {
            for(int i = 0; i < 4; i++) {
                int ny = path[i][0];
                int nx = path[i][1];
                if(0 <= y + ny && y + ny < 7 &&
                        0 <= x + nx && x + nx < 7) {
                    if(check[y + ny][x + nx] == 0) {
                        check[y + ny][x + nx] = 1;
                        dfs(y + path[i][0], x + path[i][1]);
                        check[y + ny][x + nx] = 0;
                    }

                }
            }
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board = new int[8][8];

    public void DFS(int x, int y) {
        if(x == 7 && y == 7) answer++;
        else {
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(1 <= nx && nx <= 7 && 1 <= ny && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    DFS(nx, ny);
                    board[nx][ny] = 0;
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

//        check[0][0] = 1;
//        T.dfs(0, 0);

        board[1][1] = 1;
        T.DFS(1, 1);

        System.out.println(answer);
    }
}
