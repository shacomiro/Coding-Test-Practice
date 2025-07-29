import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Problem11580 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int l = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        bw.write(new Solver(l, arr).solve());
        bw.flush();
        bw.close();
    }

    private static class Solver {
        private int l;
        private char[] orders;
        private Set<Point> footprints;

        public Solver(int l, char[] orders) {
            this.l = l;
            this.orders = orders;
            this.footprints = new HashSet<>();
        }

        public String solve() {
            int x = 0;
            int y = 0;
            footprints.add(new Point(x, y));

            for (int i = 0; i < l; i++) {
                switch (orders[i]) {
                    case 'S':
                        y--;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                    case 'N':
                        y++;
                        break;
                }

                footprints.add(new Point(x, y));
            }

            return String.valueOf(footprints.size());
        }

        private static class Point {
            private final int x;
            private final int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o)
                    return true;
                if (o == null || getClass() != o.getClass())
                    return false;
                Point point = (Point) o;
                return x == point.x && y == point.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }
    }
}
