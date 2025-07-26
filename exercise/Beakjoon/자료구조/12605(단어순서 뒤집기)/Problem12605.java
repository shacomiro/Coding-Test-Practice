import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

class Solution12605 {
    private int n;
    private List<List<String>> words;
    private Deque<String> stack;

    public Solution12605(int n, List<List<String>> words) {
        this.n = n;
        this.words = words;
        this.stack = new ArrayDeque<>();
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append("Case #").append(i + 1).append(": ");

            for (String word : words.get(i)) {
                stack.push(word);
            }
            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

public class Problem12605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<List<String>> list1 = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            List<String> list2 = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                list2.add(st.nextToken());
            }
            list1.add(list2);
        }

        bw.write(new Solution12605(n, list1).solve());
        bw.flush();
        bw.close();
    }
}
