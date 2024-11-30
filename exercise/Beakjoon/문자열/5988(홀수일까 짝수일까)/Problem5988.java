import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution5988 {
    private String[] numbers;

    public Solution5988(String[] numbers) {
        this.numbers = numbers;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(String number : numbers) {
            if(Character.digit(number.charAt(number.length() - 1), 10) % 2 == 1) {
                sb.append("odd");
            } else {
                sb.append("even");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

public class Problem5988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solution5988(arr).solve());
        bw.flush();
        bw.close();
    }
}
