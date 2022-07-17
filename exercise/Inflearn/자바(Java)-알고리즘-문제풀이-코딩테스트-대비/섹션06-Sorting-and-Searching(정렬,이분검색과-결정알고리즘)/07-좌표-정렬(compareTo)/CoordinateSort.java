import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public int[][] solution(int n, int[][] arr) {
        Arrays.sort(arr, (o1, o2) -> {
            if(o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
            else return Integer.compare(o1[0], o2[0]);
        });

        return arr;
    }

    class Point implements Comparable<Point> {
        public int x;
        public int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if(this.x == o.x) return this.y - o.y;
            else return this.x - o.x;
        }
    }

    public ArrayList<Point> alternativeSolution(int n, int[][] arr) {
        ArrayList<Point> answer = new ArrayList<>();
        for(int i = 0; i < n; i++) answer.add(new Point(arr[i][0], arr[i][1]));
        Collections.sort(answer);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int[] coor : T.solution(n, arr)) System.out.println(coor[0] + " " + coor[1]);
        for(Point coor : T.alternativeSolution(n, arr)) System.out.println(coor.x + " " + coor.y);
    }
}
