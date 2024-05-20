import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class GetDivisor {
    public int solution(int n, int k) {
        int answer = 0;
        int cnt = 0;

        for(int i = 1; i <= n; i++) {
            if(n % i == 0) cnt++;
            if(cnt == k) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        GetDivisor main = new GetDivisor();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(main.solution(n, k));
    }
}