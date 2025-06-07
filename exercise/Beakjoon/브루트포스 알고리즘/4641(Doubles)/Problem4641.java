import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution4641 {
    private int[] numbers;

    public Solution4641(int[] numbers) {
        this.numbers = numbers;
    }

    public String solve() {
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j && numbers[i] * 2 == numbers[j]) {
                    count++;
                }
            }
        }

        return String.valueOf(count);
    }
}

public class Problem4641 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String input;

        while (!(input = br.readLine()).equals("-1")) {
            st = new StringTokenizer(input);
            int[] arr = new int[st.countTokens()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            bw.write(new Solution4641(arr).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
