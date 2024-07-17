import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

class Solution2346 {
    private Deque<Balloon> deque;

    public Solution2346(List<Balloon> balloons) {
        this.deque = new ArrayDeque<>(balloons);
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        while(deque.size() > 0) {
            Balloon removedBalloon = deque.pollFirst();
            int number = removedBalloon.getNumber();
            sb.append(removedBalloon.getId()).append(" ");

            if(number > 0) {
                number--;
            }

            if(deque.size() == 0) {
                break;
            }

            while(number != 0) {
                if(number < 0) {
                    deque.offerFirst(deque.pollLast());
                    number++;
                } else {
                    deque.offerLast(deque.pollFirst());
                    number--;
                }
            }
        }

        return sb.toString();
    }

    static class Balloon {
        private int id;
        private int number;

        public Balloon(int id, int number) {
            this.id = id;
            this.number = number;
        }

        public int getId() {
            return id;
        }

        public int getNumber() {
            return number;
        }
    }
}

public class Problem2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Solution2346.Balloon> list = new ArrayList<>(n);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            list.add(new Solution2346.Balloon(i + 1, Integer.parseInt(st.nextToken())));
        }
        
        bw.write(new Solution2346(list).solve());
        bw.flush();
        bw.close();
    }
}
