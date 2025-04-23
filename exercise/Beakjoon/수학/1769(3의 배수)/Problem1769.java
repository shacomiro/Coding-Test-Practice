import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution1769 {
    private String number;

    public Solution1769(String number) {
        this.number = number;
    }

    public String solve() {
        int cnt = 0;

        while (number.length() > 1) {
            number = getShortenNumber(number);
            cnt++;
        }

        return cnt + "\n" + ((Integer.parseInt(number) % 3 == 0) ? "YES" : "NO");
    }

    private String getShortenNumber(String number) {
        int sum = 0;

        for (int i = 0; i < number.length(); i++) {
            sum += Character.getNumericValue(number.charAt(i));
        }

        return Long.toString(sum);
    }
}

public class Problem1769 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution1769(br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
