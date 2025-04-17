import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution1417 {
    private int n;
    private int[] votes;
    private Queue<Integer> queue;

    public Solution1417(int n, int[] votes) {
        this.n = n;
        this.votes = votes;
        this.queue = new PriorityQueue<>(Collections.reverseOrder());
    }

    public String solve() {
        if(n == 1) {
            return "0";
        }

        int dasoomVote = votes[0];
        for(int i = 1; i < n; i++) {
            queue.offer(votes[i]);
        }

        int cnt = 0;
        while(dasoomVote <= queue.peek()) {
            dasoomVote++;
            queue.offer(queue.poll() - 1);

            cnt++;
        }

        return String.valueOf(cnt);
    }
}

public class Problem1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solution1417(n, arr).solve());
        bw.flush();
        bw.close();
    }
}