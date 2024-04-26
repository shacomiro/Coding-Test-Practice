import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int sum;

    public ArrayList<Integer> solution(int[][] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i < arr.length; i++)
            for(int j = 0; j < arr[i].length; j++)
                if(arr[i][j] == 0) {
                    arr[i][j] = 1;
                    sum = 1;
                    dfs(i, j, arr);
                    answer.add(sum);
                }

        Collections.sort(answer);

        return answer;
    }

    public void dfs(int x, int y, int[][] arr) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && nx < arr.length && 0 <= ny && ny < arr[nx].length && arr[nx][ny] == 0) {
                arr[nx][ny] = 1;
                sum++;
                dfs(nx, ny, arr);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for(int i = 0; i < k; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st2.nextToken());
            int sx = Integer.parseInt(st2.nextToken());
            int ey = Integer.parseInt(st2.nextToken());
            int ex = Integer.parseInt(st2.nextToken());

            for(int x = sx; x < ex; x++)
                for(int y = sy; y < ey; y++)
                    if(arr[x][y] == 0) arr[x][y] = 1;
        }

        ArrayList<Integer> answer = T.solution(arr);

        System.out.println(answer.size());
        for(int x : answer) System.out.print(x + " ");
    }
}