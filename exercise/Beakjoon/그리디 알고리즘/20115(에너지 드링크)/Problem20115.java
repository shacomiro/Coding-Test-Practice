import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution20115 {
    private int n;
    private long[] energyDrinks;

    public Solution20115(int n, long[] energyDrinks) {
        this.n = n;
        this.energyDrinks = energyDrinks;
    }

    public String solve() {
        Arrays.sort(energyDrinks);

        long max = energyDrinks[n - 1];
        double sum = Arrays.stream(energyDrinks).limit(n - 1).sum();

        return String.valueOf(max + (sum / 2));
    }
}

public class Problem20115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        bw.write(new Solution20115(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
