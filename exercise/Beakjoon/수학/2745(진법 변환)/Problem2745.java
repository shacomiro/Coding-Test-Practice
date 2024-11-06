import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution2745 {
    private String number;
    private int radix;

    public Solution2745(String number, int radix) {
        this.number = number;
        this.radix = radix;
    }

    public String solve() {
        long sum = 0;
        long rank = (long) Math.pow(radix, number.length() - 1);

        for(int i = 0; i < number.length(); i++) {
            sum += Character.digit(number.charAt(i), radix) * rank;
            rank /= radix;
        }

        return String.valueOf(sum);
    }
}

public class Problem2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        bw.write(new Solution2745(st.nextToken(), Integer.parseInt(st.nextToken())).solve());
        bw.flush();
        bw.close();
    }
}
