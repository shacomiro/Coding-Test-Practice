import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution1356 {
    private int[] number;

    public Solution1356(String str) {
        this.number = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            number[i] = Character.getNumericValue(str.charAt(i));
        }
    }

    public String solve() {
        if (number.length == 1) {
            return "NO";
        }

        for (int i = 1; i < number.length; i++) {
            int left = 1;
            int right = 1;

            for (int l = 0; l < i; l++) {
                left *= number[l];
            }
            for (int r = i; r < number.length; r++) {
                right *= number[r];
            }

            if (left == right) {
                return "YES";
            }
        }

        return "NO";
    }
}

public class Problem1356 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution1356(br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
