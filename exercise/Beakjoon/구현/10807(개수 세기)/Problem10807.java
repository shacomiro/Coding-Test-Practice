import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution10807 {
    private int[] numbers;
    private int target;

    public Solution10807(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
    }

    public String solve() {
        int count = 0;

        for(int n : numbers) {
            if(n == target) {
                count++;
            }
        }

        return String.valueOf(count);
    }
}

public class Problem10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int v = Integer.parseInt(br.readLine());

        bw.write(new Solution10807(arr, v).solve());
        bw.flush();
        bw.close();
    }
}
