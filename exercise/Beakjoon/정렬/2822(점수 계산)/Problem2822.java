import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Solution2822 {
    Set<Quiz> set;
    Set<Integer> result;

    public Solution2822(List<Quiz> quizs) {
        this.set = new TreeSet<>(quizs);
        this.result = new TreeSet<>();
    }

    public String solve() {
        int idx = 0;
        int sum = 0;
        for(Quiz q : set) {
            if(idx++ >= 5) {
                break;
            }

            sum += q.getPoint();
            result.add(q.getId());
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sum).append("\n");
        for(int r : result) {
            sb.append(r).append(" ");
        }

        return String.valueOf(sb);
    }

    static class Quiz implements Comparable<Quiz> {
        private int id;
        private int point;

        public Quiz(int id, int point) {
            this.id = id;
            this.point = point;
        }

        public int getId() {
            return id;
        }

        public int getPoint() {
            return point;
        }

        @Override
        public int compareTo(Quiz o) {
            if(this.point == o.point) {
                return this.id - o.id;
            }

            return o.point - this.point;
        }
    }
}

public class Problem2822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Solution2822.Quiz> list = new ArrayList<>(8);
        for(int i = 1; i <= 8; i++) {
            list.add(new Solution2822.Quiz(i, Integer.parseInt(br.readLine())));
        }

        bw.write(new Solution2822(list).solve());
        bw.flush();
        bw.close();
    }
}
