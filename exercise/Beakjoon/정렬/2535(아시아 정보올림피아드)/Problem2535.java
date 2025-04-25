import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Solution2535 {
    private List<Student> students;

    public Solution2535(List<Student> students) {
        this.students = students;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();
        int[] countries = new int[101];

        Collections.sort(students);

        int i = 0;
        int rank = 1;
        while (rank <= 3) {
            Student s = students.get(i++);

            if (countries[s.getCountry()] < 2) {
                sb.append(s.getCountry()).append(" ").append(s.getId()).append("\n");

                countries[s.getCountry()]++;
                rank++;
            }
        }

        return sb.toString();
    }

    static class Student implements Comparable<Student> {
        private int country;
        private int id;
        private int score;

        public Student(int country, int id, int score) {
            this.country = country;
            this.id = id;
            this.score = score;
        }

        public int getCountry() {
            return country;
        }

        public int getId() {
            return id;
        }

        @Override
        public int compareTo(Solution2535.Student o) {
            return Integer.compare(o.score, this.score);
        }
    }
}

public class Problem2535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Solution2535.Student> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Solution2535.Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        bw.write(new Solution2535(list).solve());
        bw.flush();
        bw.close();
    }
}
