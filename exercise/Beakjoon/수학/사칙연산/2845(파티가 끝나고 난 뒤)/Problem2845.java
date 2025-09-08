import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem2845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solver(l, p, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int l;
        private int p;
        private int[] news;

        public Solver(int l, int p, int[] news) {
            this.l = l;
            this.p = p;
            this.news = news;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();
            int count = l * p;

            for (int ns : news) {
                sb.append(ns - count).append(" ");
            }

            return sb.toString();
        }
    }
}
