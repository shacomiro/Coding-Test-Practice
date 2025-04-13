import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Solution2587 {
    private int[] numbers;

    public Solution2587(int[] numbers) {
        this.numbers = numbers;
    }

    public String solve() {
        Arrays.sort(numbers);
        int mid = numbers[2];

        int sum = 0;
        for(int n : numbers) {
            sum += n;
        }
        int avrage = sum / 5;

        return String.valueOf(avrage + "\n" + mid);
    }
}

public class Problem2587 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[5];
        for(int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solution2587(arr).solve());
        bw.flush();
        bw.close();
    }
}