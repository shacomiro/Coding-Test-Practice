import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int cnt;

    public ArrayList<Integer> solution(int[][] arr, ArrayList<int[]> houses) {
        ArrayList<Integer> answer = new ArrayList<>();

        for(int[] hus : houses) {
            int x = hus[0];
            int y = hus[1];

            if(arr[x][y] == 1) {
                cnt = 1;
                arr[x][y] = 0;
                dfs(x, y, arr);

                answer.add(cnt);
            }
        }

        Collections.sort(answer);

        return answer;
    }

    public void dfs(int x, int y, int[][] arr) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && nx < arr.length && 0 <= ny && ny < arr[nx].length && arr[nx][ny] == 1) {
                cnt++;
                arr[nx][ny] = 0;
                dfs(nx, ny, arr);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        ArrayList<int[]> houses = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for(int j = 0; j < n; j++) {
                int value = Character.getNumericValue(tmp.charAt(j));

                arr[i][j] = value;
                if(value == 1) houses.add(new int[] {i, j});
            }
        }

        ArrayList<Integer> answer = T.solution(arr, houses);

        System.out.println(answer.size());
        for(int x : answer) System.out.println(x);
    }
}