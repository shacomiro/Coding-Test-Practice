import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution13900 {
    private int n;
    private int[] numbers;

    public Solution13900(int n, int[] numbers) {
        this.n = n;
        this.numbers = numbers;
    }

    public String solve() {
        long base = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            base += numbers[i];
        }

        for (int i = 0; i < n; i++) {
            base -= numbers[i];
            sum += base * numbers[i];
        }

        return String.valueOf(sum);
    }
}

public class Problem13900 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution13900(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
