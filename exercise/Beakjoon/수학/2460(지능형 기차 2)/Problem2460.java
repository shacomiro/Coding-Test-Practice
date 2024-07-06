import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2460 {
    public int solution(int[][] arr) {
        int max = Integer.MIN_VALUE;
        int cnt = 0;

        for(int[] station : arr) {
            cnt -= station[0];
            cnt += station[1];

            max = Math.max(max, cnt);
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        Problem2460 main = new Problem2460();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[10][2];
        for(int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        br.close();

        System.out.println(main.solution(arr));
    }
}