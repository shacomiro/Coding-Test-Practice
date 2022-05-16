import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int[][] arr) {
        int answer = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if((i - 1 >= 0 && arr[i][j] <= arr[i - 1][j])
                        || (i + 1 < n && arr[i][j] <= arr[i + 1][j])
                        || (j - 1 >= 0 && arr[i][j] <= arr[i][j - 1])
                        || (j + 1 < n && arr[i][j] <= arr[i][j + 1])
                ) continue;

                answer++;
            }
        }

        return answer;
    }

    public int alternativeSolution(int n, int[][] arr) {
        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                boolean isPeak = true;

                for(int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]) {
                        isPeak = false;
                        break;
                    }
                }

                if(isPeak) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(T.alternativeSolution(n, arr));
    }
}
