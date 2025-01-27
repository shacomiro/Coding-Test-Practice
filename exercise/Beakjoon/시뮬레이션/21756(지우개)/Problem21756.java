import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution21756 {
    private int n;
    private int[] numbers;

    public Solution21756(int n) {
        this.n = n;
        this.numbers = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            numbers[i] = i;
        }
    }

    public String solve() {
        int start = 1;
        int next = 2;
        int left = n;

        while(left > 1) {
            for(int i = start; i <= n; i += next) {
                left--;
            }

            start *= 2;
            next *= 2;
        }

        return String.valueOf(numbers[start]);
    }
}

public class Problem21756 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution21756(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }
}
