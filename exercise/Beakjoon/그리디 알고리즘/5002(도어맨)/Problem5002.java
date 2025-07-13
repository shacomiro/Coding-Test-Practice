import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

class Solution5002 {
    private int x;
    private Queue<Character> queue;

    public Solution5002(int x, String order) {
        this.x = x;
        this.queue = new ArrayDeque<>(order.length());

        for (int i = 0; i < order.length(); i++) {
            queue.offer(order.charAt(i));
        }
    }

    public String solve() {
        int count = 0;
        int gap = 0;
        int p1 = 0;
        int p2 = 0;
        boolean couldEnterP1 = true;
        boolean couldEnterP2 = true;

        while (true) {
            p1 = (!queue.isEmpty() && p1 == 0) ? ((queue.poll() == 'M') ? 1 : -1) : p1;
            p2 = (!queue.isEmpty() && p2 == 0) ? ((queue.poll() == 'M') ? 1 : -1) : p2;
            couldEnterP1 = (p1 != 0) && (Math.abs(gap + p1) <= x);
            couldEnterP2 = (p2 != 0) && (Math.abs(gap + p2) <= x);

            int choice = 0;
            if (couldEnterP1 && couldEnterP2) {
                choice = (Math.abs(gap + p1) <= Math.abs(gap + p2)) ? 1 : 2;
            } else if (couldEnterP1) {
                choice = 1;
            } else if (couldEnterP2) {
                choice = 2;
            }

            if (choice == 1) {
                gap += p1;
                p1 = 0;
                count++;
            } else if (choice == 2) {
                gap += p2;
                p2 = 0;
                count++;
            } else {
                break;
            }
        }

        return String.valueOf(count);
    }
}

public class Problem5002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution5002(Integer.parseInt(br.readLine()), br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
