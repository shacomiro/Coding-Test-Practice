import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution15702 {
    private int n;
    private int m;
    private int[] points;
    private Student[] students;

    public Solution15702(int n, int m, int[] points, Student[] students) {
        this.n = n;
        this.m = m;
        this.points = points;
        this.students = students;
    }

    public String solve() {
        int topPoint = -1;
        int topId = 0;

        for (int i = 0; i < m; i++) {
            int currPoint = students[i].getPoint(points);

            if (currPoint >= topPoint) {
                topId = (currPoint == topPoint) ? ((students[i].getId() < topId) ? students[i].getId() : topId)
                        : students[i].getId();
                topPoint = currPoint;
            }
        }

        return topId + " " + topPoint;
    }

    static class Student {
        private int id;
        private boolean[] isCorrect;

        public Student(int id, boolean[] isCorrect) {
            this.id = id;
            this.isCorrect = isCorrect;
        }

        public int getId() {
            return id;
        }

        public int getPoint(int[] points) {
            int sum = 0;

            for (int i = 0; i < isCorrect.length; i++) {
                if (isCorrect[i]) {
                    sum += points[i];
                }
            }

            return sum;
        }
    }
}

public class Problem15702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Solution15702.Student[] arr2 = new Solution15702.Student[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            boolean[] arr3 = new boolean[n];
            for (int j = 0; j < n; j++) {
                arr3[j] = (st.nextToken().equals("O")) ? true : false;
            }
            arr2[i] = new Solution15702.Student(id, arr3);
        }

        bw.write(new Solution15702(n, m, arr1, arr2).solve());
        bw.flush();
        bw.close();
    }
}
