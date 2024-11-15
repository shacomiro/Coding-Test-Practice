import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

class Solution2161 {
    private Queue<Integer> queue;

    public Solution2161(int n) {
        this.queue = getNQueue(n);
    }

    private Queue<Integer> getNQueue(int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        return queue;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()) {
            sb.append(queue.poll()).append(" ");

            if(!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }

        return sb.toString();
    }
}

public class Problem2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution2161(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }
}
