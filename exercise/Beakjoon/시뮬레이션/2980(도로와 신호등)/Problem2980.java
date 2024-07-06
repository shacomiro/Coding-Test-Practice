import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2980 {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] TLs = new int[N][5];
        int time = 0;
        int distance = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for(int j = 0; j < 3; j++) {
                TLs[i][j] = Integer.parseInt(st2.nextToken());
            }
            TLs[i][3] = 0;
            TLs[i][4] = TLs[i][1];
        }

        int nextTLIdx = 0;

        while(distance < L) {
            if(nextTLIdx < N && distance == TLs[nextTLIdx][0]) {
                if(TLs[nextTLIdx][3] == 1) {
                    distance++;
                    nextTLIdx++;
                }
            } else {
                distance++;
            }

            time++;

            for(int i = 0; i < TLs.length; i++) {
                if(TLs[i][3] == 0) {
                    if(time == TLs[i][4]) {
                        TLs[i][3] = 1;
                        TLs[i][4] = time + TLs[i][2];
                    }
                } else {
                    if(time == TLs[i][4]) {
                        TLs[i][3] = 0;
                        TLs[i][4] = time + TLs[i][1];
                    }
                }
            }
        }

        System.out.println(time);
    }

    public static void main(String[] args) throws IOException {
        Problem2980.solution();
    }
}
