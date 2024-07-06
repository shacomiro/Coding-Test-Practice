import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2839 {
    public int solution(int n) {
        int answer = 0;
        int cnt3 = 0;
        int cnt5 = 0;

        while(0 < n) {
            if(n % 5 == 0) {
                cnt5++;
                n -= 5;
            } else {
                cnt3++;
                n -= 3;
            }

            if(n == 0) answer = cnt3 + cnt5;
        }

        if(answer == 0) answer = -1;

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Problem2839 T = new Problem2839();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(T.solution(n));
    }
}
