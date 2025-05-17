import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution1835 {
    private int n;
    private Deque<Integer> deque;

    public Solution1835(int n) {
        this.n = n;
        this.deque = new ArrayDeque<>(n);
    }

    public String solve() {
        while (n > 0) {
            deque.offerFirst(n);

            for (int i = 0; deque.size() > 1 && i < n; i++) {
                deque.offerFirst(deque.pollLast());
            }

            n--;
        }

        StringBuilder sb = new StringBuilder();
        for (int x : deque) {
            sb.append(x).append(" ");
        }

        return sb.toString();
    }
}

public class Problem1835 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution1835(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }
}
