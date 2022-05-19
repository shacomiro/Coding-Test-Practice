import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int k, int[] arr) {
        int answer = 0;
        int sum = 0;
        int lpt = 0;
        int rpt = k - 1;

        for(int i = lpt; i <= rpt; i++) sum += arr[i];
        answer = sum;

        while(rpt < n - 1) {
            sum = sum - arr[lpt++] + arr[++rpt];
            answer = Math.max(answer, sum);
        }

        return answer;
    }
    // 슬라이딩 윈도우 활용

    public int alternativeSolution(int n, int k, int[] arr) {
        int answer = 0;
        int sum = 0;

        for(int i = 0; i < k; i++) sum += arr[i];
        answer = sum;

        for(int i = k; i < n; i++) {
            sum += (arr[i] - arr[i - k]);
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());
        int[] arr = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st2.nextToken());

        System.out.println(T.solution(n, k, arr));
    }
}
