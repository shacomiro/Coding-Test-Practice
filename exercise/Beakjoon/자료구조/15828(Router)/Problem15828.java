import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution15828 {
    private int n;
    private List<Integer> packets;
    private Queue<Integer> router;

    public Solution15828(int n, List<Integer> packets) {
        this.n = n;
        this.packets = packets;
        this.router = new ArrayDeque<>(n);
    }

    public String solve() {
        for(int p : packets) {
            if(p == 0) {
                router.poll();
            } else if(router.size() < n) {
                router.offer(p);
            }
        }

        StringBuilder sb = new StringBuilder();
        if(router.isEmpty()) {
            return "empty";
        } else {
            while(!router.isEmpty()) {
                sb.append(router.poll()).append(" ");
            }
        }

        return sb.toString();
    }
}

public class Problem15828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        String input;
        while(!(input = br.readLine()).equals("-1")) {
            list.add(Integer.parseInt(input));
        }

        bw.write(new Solution15828(n, list).solve());
        bw.flush();
        bw.close();
    }
}
