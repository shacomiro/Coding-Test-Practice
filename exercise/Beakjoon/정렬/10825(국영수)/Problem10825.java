import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Solution10825 {
    private List<Grade> grades;

    public Solution10825(List<Grade> grades) {
        this.grades = grades;
    }

    public String solve() {
        Collections.sort(grades);

        StringBuilder sb = new StringBuilder();
        for(Grade grade : grades) {
            sb.append(grade.name).append("\n");
        }

        return sb.toString();
    }

    static class Grade implements Comparable<Grade> {
        private String name;
        private int korean;
        private int english;
        private int math;

        public Grade(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Solution10825.Grade o) {
            return (korean != o.korean) ? o.korean - korean :
                    (english != o.english) ? english - o.english :
                    (math != o.math) ? o.math - math : name.compareTo(o.name);
        }
    }
}

public class Problem10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Solution10825.Grade> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Solution10825.Grade(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        bw.write(new Solution10825(list).solve());
        bw.flush();
        bw.close();
    }
}
