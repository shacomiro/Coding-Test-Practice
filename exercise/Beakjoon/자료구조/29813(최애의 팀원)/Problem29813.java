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

class Solution29813 {
    private Queue<Student> queue;

    public Solution29813(List<Student> students) {
        this.queue = new ArrayDeque<>(students);
    }

    public String solve() {
        while (queue.size() > 1) {
            Student student1 = queue.poll();

            for (int i = 0; i < student1.getId() - 1; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }

        return queue.poll().getInitial();
    }

    static class Student {
        private String initial;
        private int id;

        public Student(String initial, int id) {
            this.initial = initial;
            this.id = id;
        }

        public String getInitial() {
            return initial;
        }

        public int getId() {
            return id;
        }
    }
}

public class Problem29813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Solution29813.Student> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Solution29813.Student(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        bw.write(new Solution29813(list).solve());
        bw.flush();
        bw.close();
    }
}
