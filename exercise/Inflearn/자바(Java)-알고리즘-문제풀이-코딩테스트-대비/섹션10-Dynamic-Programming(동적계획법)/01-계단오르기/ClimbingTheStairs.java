import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] dy;

    public int solution(int[][] arr) {
         for(int i = 0; i < n; i++) {
             int ps = arr[i][0];
             int pt = arr[i][1];

             for(int j = m; pt <= j; j--) {
                 dy[j] = Math.max(dy[j], dy[j - pt] + ps);
             }
         }

        return dy[m];
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());
        dy = new int[m + 1];
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st2.nextToken());
            arr[i][1] = Integer.parseInt(st2.nextToken());
        }

        System.out.println(T.solution(arr));
    }
}