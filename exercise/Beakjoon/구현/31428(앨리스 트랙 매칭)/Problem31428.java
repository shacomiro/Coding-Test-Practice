import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem31428 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = st.nextToken();
        }
        String str = br.readLine();

        bw.write(new Solver(n, arr, str).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private String[] friendTrack;
        private String hellobitTrack;

        public Solver(int n, String[] friendsTrack, String hellobitTrack) {
            this.n = n;
            this.friendTrack = friendsTrack;
            this.hellobitTrack = hellobitTrack;
        }

        public String solve() {
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (hellobitTrack.equals(friendTrack[i])) {
                    count++;
                }
            }

            return String.valueOf(count);
        }
    }
}
