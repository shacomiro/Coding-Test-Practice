import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution19638 {
    private List<Integer> giants;
    private int henti;
    private int time;

    public Solution19638(List<Integer> giants, int henti, int time) {
        this.giants = giants;
        this.henti = henti;
        this.time = time;
    }

    public String solve() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(giants);
        int count = 0;
        int tallGiant = 0;

        while(count < time) {
            int giant = pq.poll();

            if(giant < henti || giant == 1) {
                pq.offer(giant);
                break;
            } else if(giant >= henti) {
                pq.offer(giant / 2);
                count++;
            }
        }
        tallGiant = pq.poll();

        return String.valueOf((tallGiant < henti) ? "YES\n" + count : "NO\n" + tallGiant);
    }
}


public class Problem19638 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        bw.write(new Solution19638(list, h, t).solve());
        bw.flush();
        bw.close();
    }
}
