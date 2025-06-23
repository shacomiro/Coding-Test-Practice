import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

class Solution1235 {
    private int n;
    private String[] ids;
    private Set<String> set;

    public Solution1235(int n, String[] ids) {
        this.n = n;
        this.ids = ids;
        this.set = new HashSet<>(ids.length);
    }

    public String solve() {
        int length = ids[0].length();

        for (int k = 1; k <= length; k++) {
            for (int i = 0; i < n; i++) {
                String newId = ids[i].substring(length - k);

                if (set.contains(newId)) {
                    set.clear();
                    break;
                }

                set.add(newId);
            }

            if (set.size() == n) {
                return String.valueOf(k);
            }
        }

        return String.valueOf(length);
    }
}

public class Problem1235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solution1235(n, arr).solve());
        bw.flush();
        bw.close();
    }
}