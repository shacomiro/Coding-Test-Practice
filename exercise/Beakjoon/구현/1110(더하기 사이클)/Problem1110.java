import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution1110 {
    private int n;
    private int number;

    public Solution1110(int n) {
        this.n = n;
        this.number = n;
    }

    public String solve() {
        int cycle = 0;

        do {
            number = next(number);
            cycle++;
        } while(n != number);

        return String.valueOf(cycle);
    }

    private int next(int n) {
        int left = n / 10;
        int right = n % 10;
        int sum = (n < 10) ? right : left + right;

        return (right * 10) + (sum % 10);
    }
}

public class Problem1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution1110(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }
}
