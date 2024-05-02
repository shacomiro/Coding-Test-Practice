import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AddOneTwoThree {
    public static int[] solution(int t, int[] input) {
        int[] answer = new int[t];
        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i <= 11; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        for(int i = 0; i < t; i++) {
            answer[i] = dp[input[i]];
        }

        return answer;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int[] input = new int[t];
        for(int i = 0; i < t; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        for(int a : solution(t, input)) {
            bw.write(String.valueOf(a));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}