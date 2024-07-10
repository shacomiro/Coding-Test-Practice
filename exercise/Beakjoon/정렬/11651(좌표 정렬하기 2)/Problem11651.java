import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Solution11651 {
    private List<Coordinate> coordinates;

    public Solution11651(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public String solve() {
        Collections.sort(coordinates);
        
        StringBuilder sb = new StringBuilder();
        for(Coordinate coor : coordinates) {
            sb.append(coor.toString()).append("\n");
        }

        return sb.toString();
    }

    static class Coordinate implements Comparable<Coordinate> {
        private int x;
        private int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate o) {
            if(this.y == o.y) {
                return this.x - o.x;
            }

            return this.y - o.y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}

public class Problem11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Solution11651.Coordinate> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Solution11651.Coordinate(x, y));
        }

        bw.write(new Solution11651(list).solve());
        bw.flush();
        bw.close();
    }
}
