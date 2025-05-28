import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Solution27964 {
    private int n;
    private String[] cheeses;
    private Set<String> set;

    public Solution27964(int n, String[] cheeses) {
        this.n = n;
        this.cheeses = cheeses;
        this.set = new HashSet<>();
    }

    public String solve() {
        for (int i = 0; i < n; i++) {
            if (cheeses[i].endsWith("Cheese")) {
                set.add(cheeses[i]);
            }
        }

        return set.size() >= 4 ? "yummy" : "sad";
    }
}

public class Problem27964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = st.nextToken();
        }

        bw.write(new Solution27964(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
