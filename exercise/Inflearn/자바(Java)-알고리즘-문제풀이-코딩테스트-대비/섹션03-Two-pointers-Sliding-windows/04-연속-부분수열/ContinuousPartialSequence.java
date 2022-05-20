import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public int TimeLimitExceededsolution(int n, int m, int[] arr) {
        int answer = 0;
        int sum = 0;

        for(int wSize = 1; wSize <= n; wSize++) {
            for(int i = 0; i < wSize; i++) sum += arr[i];
            if(sum == m) answer++;

            for(int i = wSize; i < n; i++) {
                sum += (arr[i] - arr[i - wSize]);
                if(sum == m) answer++;
            }

            sum = 0;
        }

        return answer;
    }
    // 풀이 시간 초과 => 풀이 참고 후 재풀이

    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int sum = arr[0];

        int lpt = 0;
        int rpt = 0;

        while(lpt < n && rpt < n) {
            if(sum < m) {
                rpt++;
                if(rpt == n) break;
                sum += arr[rpt];
            }
            else if(sum > m) sum -= arr[lpt++];
            else {
                answer++;
                sum -= arr[lpt++];
            }
        }

        return answer;
    }
    //슬라이딩 윈도우, 투 포인트 알고리즘을 활용한 O(n^2) -> O(n) 시간복잡도 단축.

    public int alternativeSolution(int n, int m, int[] arr) {
        int answer = 0;
        int sum = 0;
        int lt = 0;

        for(int rt = 0; rt < n; rt++) {
            sum += arr[rt];

            if(sum == m) answer++;

            while(sum >= m) {
                sum -= arr[lt++];
                if(sum == m) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int[] arr = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st2.nextToken());

        System.out.println(T.solution(n, m, arr));
    }
}
