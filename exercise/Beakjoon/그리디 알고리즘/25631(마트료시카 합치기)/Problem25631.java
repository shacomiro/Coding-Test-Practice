import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution25631 {
    private int n;
    private int[] matryoshka;
    private Map<Integer, Integer> map;

    public Solution25631(int n, int[] matryoshka) {
        this.n = n;
        this.matryoshka = matryoshka;
        this.map = new HashMap<>();
    }

    public String solve() {
        for (int m : matryoshka) {
            map.put(m, map.getOrDefault(m, 0) + 1);
        }

        int max = 0;
        for (int count : map.values()) {
            max = Math.max(max, count);
        }

        return String.valueOf(max);
    }
}

public class Problem25631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution25631(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
