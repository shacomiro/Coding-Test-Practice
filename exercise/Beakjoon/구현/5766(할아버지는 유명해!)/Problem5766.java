import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

class Solution5766 {
    private int n;
    private int m;
    private int[][] ranking;
    private Map<Integer, Integer> counts;
    
    public Solution5766(int n, int m, int[][] ranking) {
        this.n = n;
        this.m = m;
        this.ranking = ranking;
        this.counts = new TreeMap<>();
    }

    public String solve() {
        for(int i = 0 ; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int cnt = counts.getOrDefault(ranking[i][j], 0) + 1;
                counts.put(ranking[i][j], cnt);
            }
        }

        TreeSet<Integer> scores = new TreeSet<>(counts.values());
        int secondScore = scores.lower(scores.last());

        StringBuilder sb = new StringBuilder();
        for(Entry<Integer, Integer> count : counts.entrySet()) {
            if(count.getValue() == secondScore) {
                sb.append(count.getKey()).append(" ");
            }
        }

        return sb.toString();
    }
}

public class Problem5766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String input;

        while(!(input = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][m];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bw.write(new Solution5766(n, m, arr).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
