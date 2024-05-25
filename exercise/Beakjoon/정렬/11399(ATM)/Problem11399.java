import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11399 {
    private static int n;
    private static int[] times;

    public static String solution() {
        int totalTime = 0;
        int accumulationTime = 0;

        Arrays.sort(times);

        for(int time : times) {
            accumulationTime += time;
            totalTime += accumulationTime;
        }

        return String.valueOf(totalTime);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        times = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(solution());
        bw.flush();
        bw.close();
    }
}