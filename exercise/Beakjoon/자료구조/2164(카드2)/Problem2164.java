import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

class Solution2164 {
    private int n;
    private Queue<Integer> queue;
    
    public Solution2164(int n) {
        this.n = n;
        this.queue = new ArrayDeque<>();
    }
    
    public String solve() {
        for(int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        
        while(queue.size() != 1) {
            queue.poll();
            queue.offer(queue.poll());
        }
        
        return String.valueOf(queue.peek());
    }
}

public class Problem2164 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        bw.write(new Solution2164(n).solve());
        bw.flush();
        bw.close();
    }
}
