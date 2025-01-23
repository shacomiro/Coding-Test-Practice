import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution32979 {
    private int n;
    private int t;
    private Queue<Integer> apart;
    private int[] floors;

    public Solution32979(int n, int t, List<Integer> apart, int[] floors) {
        this.n = n;
        this.t = t;
        this.apart = new ArrayDeque<>(apart);
        this.floors = floors;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(int f : floors) {
            for(int b = 1; b < f; b++) {
                apart.offer(apart.poll());
            }

            sb.append(apart.peek()).append(" ");
        }

        return sb.toString();
    }
}

public class Problem32979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(2 * n);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2 * n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int[] arr = new int[t];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        bw.write(new Solution32979(n, t, list, arr).solve());
        bw.flush();
        bw.close();
    }
}
