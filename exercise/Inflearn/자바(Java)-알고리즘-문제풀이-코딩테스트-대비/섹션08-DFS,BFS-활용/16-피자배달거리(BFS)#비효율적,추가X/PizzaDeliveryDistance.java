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

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public void getStoreCombi(int l, int s) {
        if(l == m) {
            for(int i = 0; i < m; i++) System.out.print("{"+selectedStores[i][0] + ", " +selectedStores[i][1]+"} ");
            System.out.println();

            cityDeliveryDist = 0;
            for(int i = 0; i < houses.size(); i++) {
                houseDist = Integer.MAX_VALUE;
                int sx = houses.get(i)[0];
                int sy = houses.get(i)[1];
                findShortestDistBFS(sx, sy);
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

    public void findShortestDistBFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        check[x][y] = 1;
        queue.offer(new int[] {x, y});

        while(!queue.isEmpty()) {
            int len = queue.size();

            for(int i = 0; i < len; i++) {
                int[] tmp = queue.poll();
                int tx = tmp[0];
                int ty = tmp[1];

                if(map[tx][ty] == 2) {
                    for(int k = 0; k < m; k++) {
                        if(selectedStores[k][0] == tx && selectedStores[k][1] == ty) {
                            houseDist = Math.abs(tx - x) + Math.abs(ty - y);
                            check = new int[n][n];
                            return;
                        }
                    }
                }

                for(int j = 0; j < 4; j++) {
                    int nx = tx + dx[j];
                    int ny = ty + dy[j];

                    if(0 <= nx && nx < n && 0 <= ny && ny < n) {
                        if(check[nx][ny] == 0) {
                            check[nx][ny] = 1;
                            queue.offer(new int[] {nx, ny});
                        }
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
