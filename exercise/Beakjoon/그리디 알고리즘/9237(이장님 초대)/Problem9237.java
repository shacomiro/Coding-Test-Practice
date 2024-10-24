import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Solution9237 {
    private Integer[] saplings;

    public Solution9237(Integer[] saplings) {
        this.saplings = saplings;
    }

    public String solve() {
        Arrays.sort(saplings, Collections.reverseOrder());

        int max = 0;
        for(int day = 0; day < saplings.length; day++) {
            max = Math.max(max, day + 1 + saplings[day] + 1);
        }

        return String.valueOf(max);
    }
}

public class Problem9237 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution9237(arr).solve());
        bw.flush();
        bw.close();
    }
}
