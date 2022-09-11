import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] check;
    static ArrayList<int[]> stores;
    static ArrayList<int[]> houses;
    static int[][] selectedStores;
    static int distance = Integer.MAX_VALUE;
    static int answer = Integer.MAX_VALUE;
    int cityDeliveryDist;
    int houseDist;
    boolean flag;

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public void getStoreCombi(int l, int s) {
        if(l == m) {
            for(int i = 0; i < m; i++) System.out.print("{"+selectedStores[i][0] + ", " +selectedStores[i][1]+"} ");
            System.out.println();

            cityDeliveryDist = 0;
            for(int i = 0; i < houses.size(); i++) {
                houseDist = Integer.MAX_VALUE;
                flag = false;
                int sx = houses.get(i)[0];
                int sy = houses.get(i)[1];
                findShortestDistDFS(sx, sy, sx, sy, 0);
                cityDeliveryDist += houseDist;
            }

            answer = Math.min(answer, cityDeliveryDist);
        } else {
            for(int i = s; i < stores.size(); i++) {
                selectedStores[l] = stores.get(i);
                getStoreCombi(l + 1, i + 1);
            }
        }
    }

    public void findShortestDistDFS(int x, int y, int ox, int oy, int findCnt) {
        if(flag) return;
        if(map[x][y] == 2) {
            houseDist = Math.min(houseDist, Math.abs(ox - x) + Math.abs(oy - y));
            findCnt++;
            if(findCnt == m) flag= true;
        } else {
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = x + dy[i];

                if(0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if(check[nx][ny] == 0) {
                        check[nx][ny] = 1;
                        findShortestDistDFS(nx, ny, x, y, findCnt);
                        check[nx][ny] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());
        map = new int[n][n];
        check = new int[n][n];
        stores = new ArrayList<>();
        houses = new ArrayList<>();
        selectedStores = new int[m][2];
        for(int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
                if(map[i][j] == 2) stores.add(new int[] {i, j});
                if(map[i][j] == 1) houses.add(new int[] {i, j});
            }
        }

        T.getStoreCombi(0, 0);
        System.out.println(answer);
    }
}
