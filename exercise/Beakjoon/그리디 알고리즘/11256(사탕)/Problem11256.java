import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution11256 {
    private Queue<Integer> queue;
    private int candyCount;

    public Solution11256(int candyCount, List<int[]> boxes) {
        this.queue = new PriorityQueue<>(Comparator.reverseOrder());
        this.candyCount = candyCount;

        for(int[] box : boxes) {
            queue.add(box[0] * box[1]);
        }
    }

    public String solve() {
        int boxCount = 0;
        while(!queue.isEmpty() && candyCount > 0) {
            candyCount -= queue.poll();
            boxCount++;
        }

        return String.valueOf(boxCount);
    }
}

public class Problem11256 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            List<int[]> list = new ArrayList<>(n);
            for(int k = 0; k < n; k++) {
                st = new StringTokenizer(br.readLine());
                list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }

            bw.write(new Solution11256(j, list).solve());
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
