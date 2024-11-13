import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Solution1021 {
    private Deque<Integer> deque;
    private int[] targets;
    private int[] index;

    public Solution1021(int size, int[] targets) {
        this.deque = initDeque(size);
        this.targets = targets;
        this.index = initIndex(size, targets);
    }
    
    private Deque<Integer> initDeque(int size) {
        Deque<Integer> deque = new ArrayDeque<>(size);

        for(int i = 1 ; i <= size; i++) {
            deque.offer(i);
        }

        return deque;
    }

    private int[] initIndex(int size, int[] targets) {
        int[] index = new int[targets.length];

        for(int i = 0; i < index.length; i++) {
            index[i] = targets[i] - 1;
        }

        return index;
    }

    public String solve() {
        int count = 0;
        int curr = 0;

        while(curr < targets.length) {
            int target = targets[curr];

            if(deque.peek() == target) {
                deque.pollFirst();

                for(int i = curr; i < index.length; i++) {
                    index[i]--;
                }

                curr++;
            } else {
                int dequeSize = deque.size();

                if(index[curr] <= dequeSize / 2) {
                    deque.addLast(deque.pollFirst());

                    for(int i = curr; i < index.length; i++) {
                        if(index[i] > 0) {
                            index[i]--;
                        } else {
                            index[i] = dequeSize - 1;
                        }
                    }
                } else {
                    deque.addFirst(deque.pollLast());

                    for(int i = curr; i < index.length; i++) {
                        if(index[i] < dequeSize - 1) {
                            index[i]++;
                        } else {
                            index[i] = 0;
                        }
                    }
                }

                count++;
            }
        }

        return String.valueOf(count);
    }

}

public class Problem1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution1021(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
