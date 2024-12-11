import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution14235 {
    private List<String> infos;
    private PriorityQueue<Integer> pq;

    public Solution14235(List<String> infos) {
        this.infos = infos;
        this.pq = new PriorityQueue<>(Collections.reverseOrder());
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(String info : infos) {
            st = new StringTokenizer(info);
            int a = Integer.parseInt(st.nextToken());

            if(a == 0) {
                sb.append(pq.isEmpty() ? -1 : pq.poll()).append("\n");
            } else {
                for(int i = 0; i < a; i++) {
                    pq.offer(Integer.parseInt(st.nextToken()));
                }
            }
        }

        return sb.toString();
    }
}

public class Problem14235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        bw.write(new Solution14235(list).solve());
        bw.flush();
        bw.close();
    }
}
