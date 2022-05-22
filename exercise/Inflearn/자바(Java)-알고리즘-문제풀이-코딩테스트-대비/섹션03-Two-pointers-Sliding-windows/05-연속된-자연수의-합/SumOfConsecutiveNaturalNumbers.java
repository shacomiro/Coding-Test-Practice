import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public int twoPointersSolution(int n) {
        int answer = 0;
        int sum = 0;
        int lt = 1;
        
        for(int rt = 1; rt <= n / 2 + 1; rt++) {
            sum += rt;

            if(sum == n) answer++;

            while(sum >= n) {
                sum -= lt++;
                if(sum == n) answer++;
            }
        }

        return answer;
    }

    public int alternativeTwoPointersSolution(int n) {
        int answer = 0;
        int sum = 0;
        int lt = 0;
        int m = n / 2 + 1;
        int[] arr = new int[m];

        for(int i = 0; i < m; i++) arr[i] = i + 1;

        for(int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if(sum == n) answer++;

            while(sum >= n) {
                sum -= arr[lt++];
                if(sum == n) answer++;
            }
        }

        return answer;
    }

    public int mathSolution(int n) {
        int answer = 0;
        int cnt = 1;
        int sum = 1;

        while(true) {
            sum += ++cnt;

            if(n - sum < 0) break;
            if((n - sum) % cnt == 0) answer++;
        }

        return answer;
    }

    public int alternativeMathSolution(int n) {
        int answer = 0;
        int cnt = 1;
        
        n--;
        while(n > 0) {
            cnt++;
            n = n - cnt;
            
            if(n % cnt == 0) answer++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(T.mathSolution(n));
    }
}
