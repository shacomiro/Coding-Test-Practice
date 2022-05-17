import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public int[] solution(int n, int[] scores) {
        int[] answer = new int[n];

        for(int i = 0; i < n; i++) {
            int cnt = 1;

            for(int j = 0; j < i; j++) {
                if(scores[j] > scores[i])
                    cnt++;
                else if(scores[j] < scores[i])
                    answer[j]++;
            }

            answer[i] = cnt;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        for(int num : T.solution(n, scores)) System.out.print(num + " ");
    }
}
