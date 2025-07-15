import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution7513 {
    private int t;
    private String[] words;
    private List<List<Integer>> indexes;

    public Solution7513(int t, String[] words, List<List<Integer>> indexes) {
        this.t = t;
        this.words = words;
        this.indexes = indexes;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();
        sb.append("Scenario #").append(t).append(":\n");

        for (List<Integer> index : indexes) {
            for (int idx : index) {
                sb.append(words[idx]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

public class Problem7513 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            int m = Integer.parseInt(br.readLine());
            String[] arr = new String[m];
            for (int j = 0; j < m; j++) {
                arr[j] = br.readLine();
            }
            int n = Integer.parseInt(br.readLine());
            List<List<Integer>> list1 = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                List<Integer> list2 = new ArrayList<>(Integer.parseInt(st.nextToken()));
                while (st.hasMoreTokens()) {
                    list2.add(Integer.parseInt(st.nextToken()));
                }
                list1.add(list2);
            }
            bw.write(new Solution7513(i, arr, list1).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
