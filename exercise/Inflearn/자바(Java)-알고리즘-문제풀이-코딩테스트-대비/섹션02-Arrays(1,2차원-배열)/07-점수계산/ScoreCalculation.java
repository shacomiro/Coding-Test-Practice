import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int[] score) {
        int answer = 0;
        int stack = 0;

        for(int i = 0; i < n; i++) {
            if(score[i] == 1) {
                stack++;
                answer += stack;
            } else {
                stack = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(T.solution(n, score));
    }
}
