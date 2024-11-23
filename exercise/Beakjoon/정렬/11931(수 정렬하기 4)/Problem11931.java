import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Solution11931 {
    private int[] numbers;

    public Solution11931(int[] numbers) {
        this.numbers = numbers;
    }

    public String solve() {
        Arrays.sort(numbers);

        StringBuilder sb = new StringBuilder();
        for(int i = numbers.length - 1; i >= 0; i--) {
            sb.append(numbers[i]).append("\n");
        }

        return sb.toString();
    }
}

public class Problem11931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solution11931(arr).solve());
        bw.flush();
        bw.close();
    }
}
