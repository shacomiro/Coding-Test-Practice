import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int[][] arr) {
        int answer = 0;
        int sumVertical = 0;
        int sumHorizontal = 0;
        int SumDiagonalI = 0;
        int SumDiagonalJ = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sumHorizontal += arr[i][j];
                sumVertical += arr[j][i];

                if(i == j) SumDiagonalI += arr[i][j];
                if(i + j == n - 1) SumDiagonalJ += arr[i][j];
            }

            answer = Math.max(answer, Math.max(sumHorizontal, sumVertical));

            sumVertical = 0;
            sumHorizontal = 0;
        }

        answer = Math.max(answer, Math.max(SumDiagonalI, SumDiagonalJ));

        return answer;
    }

    public int alternativeSolution(int n, int[][] arr) {
        int answer = Integer.MIN_VALUE;
        int sum1 = 0;
        int sum2 = 0;

        for(int i = 0; i < n; i++) {
            sum1 = 0;
            sum2 = 0;

            for(int j = 0; j < n; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }

            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        sum1 = 0;
        sum2 = 0;

        for(int i = 0; i < n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][n - i - 1];
        }

        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        System.out.println(T.alternativeSolution(n, arr));
    }
}
