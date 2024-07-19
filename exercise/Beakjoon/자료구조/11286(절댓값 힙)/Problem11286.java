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

class Solution11286 {
    private Queue<Integer> absoluteValueQueue;
    private List<Integer> operations;

    public Solution11286(List<Integer> operations) {
        this.absoluteValueQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                int a1 = Math.abs(i1);
                int a2 = Math.abs(i2);

                if(a1 == a2) {
                    return i1 - i2;
                }

                return a1 - a2;
            }
        });
        this.operations = operations;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(int op : operations) {
            if(op == 0) {
                if(absoluteValueQueue.isEmpty()) {
                    sb.append(0);
                } else {
                    sb.append(absoluteValueQueue.poll());
                }
                sb.append("\n");
            } else {
                absoluteValueQueue.offer(op);
            }
        }

        return sb.toString();
    }
}

public class Problem11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        bw.write(new Solution11286(list).solve());
        bw.flush();
        bw.close();
    }
}
