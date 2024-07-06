import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2693 {
    public int[] solution(int n, int[][] arr) {
        int[] answer = new int[n];

        for(int i = 0; i < n; i++) {
            Arrays.sort(arr[i]);
            answer[i] = arr[i][7];
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {
        Problem2693 main = new Problem2693();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][10];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        br.close();

        for(int x : main.solution(n, arr)) System.out.println(x);
    }
}