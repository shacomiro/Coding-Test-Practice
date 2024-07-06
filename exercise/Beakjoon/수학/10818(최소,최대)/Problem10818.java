import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10818 {
    public int[] solution(int n, int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for(int i = 0; i < n; i += 2) {
            int fir = arr[i];

            if(i + 1 == n) {
                if(fir < min) min = fir;
                if(fir > max) max = fir;
                break;
            }

            int sec = arr[i + 1];

            if(fir < sec) {
                if(fir < min) min = fir;
                if(sec > max) max = sec;
            } else {
                if(sec < min) min = sec;
                if(fir > max) max = fir;
            }
        }

        return new int[] {min, max};
    }

    public static void main(String[] args) throws IOException {
        Problem10818 main = new Problem10818();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        br.close();

        for(int x : main.solution(n, arr)) System.out.print(x + " ");
    }
}