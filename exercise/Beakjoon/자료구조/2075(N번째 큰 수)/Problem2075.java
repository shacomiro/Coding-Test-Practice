import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
    private int n;
    private int[][] table;

    public Solution(int n , int[][] table) {
        this.n = n;
        this.table = table;
    }

    public String solve() {
        PriorityQueue<Coordinate> pq = new PriorityQueue<>();
        int number = 0;
        int count = 0;

        for(int i = 0; i < n; i++) {
            pq.offer(new Coordinate(table[n - 1][i], n - 1, i));
        }

        while(count < n) {
            Coordinate coor = pq.poll();
            number = coor.getNumber();
            count++;

            if(coor.hasNextX()) {
                pq.offer(new Coordinate(table[coor.getX() - 1][coor.getY()], coor.getX() - 1, coor.getY()));
            }
        }

        return String.valueOf(number);
    }

    static class Coordinate implements Comparable<Coordinate> {
        private int number;
        private int x;
        private int y;

        public Coordinate(int number, int x, int y) {
            this.number = number;
            this.x = x;
            this.y = y;
        }

        public int getNumber() {
            return number;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean hasNextX() {
            return (x > 0) ? true : false;
        }

        @Override
        public int compareTo(Solution.Coordinate o) {
            return Integer.compare(o.number, this.number);
        }
    }
}

public class Problem2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(new Solution(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
