import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution18310 {
    private int n;
    private int[] houses;

    public Solution18310(int n, int[] houses) {
        this.n = n;
        this.houses = houses;
    }

    public String solve() {
        Arrays.sort(houses);

        return String.valueOf(houses[(n - 1) / 2]);
    }
}

public class Problem18310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution18310(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
