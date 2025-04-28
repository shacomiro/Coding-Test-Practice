import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution28432 {
    private int n;
    private int m;
    private String[] records;
    private String[] candidates;
    private boolean[] isDuplicated;

    public Solution28432(int n, int m, String[] records, String[] candidates) {
        this.n = n;
        this.m = m;
        this.records = records;
        this.candidates = candidates;
        this.isDuplicated = new boolean[m];
    }

    public String solve() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (candidates[i].equals(records[j])) {
                    isDuplicated[i] = true;

                    break;
                }
            }
        }

        String start = "";
        String end = "";
        for (int i = 0; i < n; i++) {
            if (records[i].equals("?")) {
                start = (i - 1 >= 0) ? String.valueOf(records[i - 1].charAt(records[i - 1].length() - 1)) : "";
                end = (i + 1 <= n - 1) ? String.valueOf(records[i + 1].charAt(0)) : "";

                break;
            }
        }

        String answer = "";
        for (int i = 0; i < m; i++) {
            if ((start.length() == 0 || candidates[i].startsWith(start))
                    && (end.length() == 0 || candidates[i].endsWith(end)) && !isDuplicated[i]) {
                answer = candidates[i];

                break;
            }
        }

        return answer;
    }
}

public class Problem28432 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr1 = new String[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = br.readLine();
        }
        int m = Integer.parseInt(br.readLine());
        String[] arr2 = new String[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = br.readLine();
        }

        bw.write(new Solution28432(n, m, arr1, arr2).solve());
        bw.flush();
        bw.close();
    }
}