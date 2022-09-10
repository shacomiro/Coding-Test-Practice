import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] country;
    static int[][] check;
    static ArrayList<int[]> lands;

    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public void dfs(int x, int y) {
        if(country[x][y] == 0) return;
        else {
            for(int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if(check[nx][ny] == 0) {
                        check[nx][ny] = 1;
                        dfs(nx, ny);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        country = new int[n][n];
        lands = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int land = Integer.parseInt(st.nextToken());
                country[i][j] = land;
                if(land == 1) lands.add(new int[] {i, j});
            }
        }
        check = new int[n][n];
        int cnt = 0;

        for(int i = 0; i < lands.size(); i++) {
            int[] coor = {lands.get(i)[0], lands.get(i)[1]};
            if(check[coor[0]][coor[1]] == 0) {
                T.dfs(coor[0], coor[1]);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
