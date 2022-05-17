import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int[] talls) {
        int answer = 0;
        int currentMaxTall = 0;

        for(int tall : talls) {
            if(tall > currentMaxTall) {
                currentMaxTall = tall;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] talls = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            talls[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(T.solution(n, talls));
    }
}
