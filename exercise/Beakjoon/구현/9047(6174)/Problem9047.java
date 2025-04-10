import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Solution9047 {
    private int number;

    public Solution9047(int number) {
        this.number = number;
    }

    public String solve() {
        int[] digits = new int[4];
        int count = 0;

        while(number != 6174) {
            setDigits(digits, number);
            number = getMax(digits) - getMin(digits);

            count++;
        }

        return String.valueOf(count);
    }

    private int getMax(int[] digits) {
        int max = 0;

        for(int i = 3; i >= 0; i--) {
            max = (max * 10) + digits[i];
        }

        return max;
    }

    private int getMin(int[] digits) {
        int min = 0;

        for(int i = 0; i < 4; i++) {
            min = (min * 10) + digits[i];
        }

        return min;
    }

    private void setDigits(int[] digits, int number) {
        for(int i = 0; i < 4; i++) {
            digits[i] = number % 10;
            number /= 10;
        }

        Arrays.sort(digits);
    }
}

public class Problem9047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            bw.write(new Solution9047(Integer.parseInt(br.readLine())).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
