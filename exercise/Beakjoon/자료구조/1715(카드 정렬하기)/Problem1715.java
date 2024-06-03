import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution1715 {
    private PriorityQueue<Integer> cardBundlesQueue;
    private int compareCount;

    public Solution1715(ArrayList<Integer> cards) {
        this.cardBundlesQueue = new PriorityQueue<>(cards);
        this.compareCount = 0;
    }

    public String solve() {
        while(cardBundlesQueue.size() > 1) {
            int firstCardBundle = cardBundlesQueue.poll();
            int secondCardBundle = cardBundlesQueue.poll();
            int newCardBundle = firstCardBundle + secondCardBundle;

            compareCount += newCardBundle;
            cardBundlesQueue.offer(newCardBundle);
        }

        return String.valueOf(compareCount);
    }
}

public class Problem1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        bw.write(new Solution1715(list).solve());
        bw.flush();
        bw.close();
    }
}