import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
    
public class Problem18110 {
    public static int solution(int n, int[] levelOpinions) {
        int cutThreshold = (int) Math.round(((double) n) * 0.15);

        Arrays.sort(levelOpinions);

        double sum = 0;
        for(int i = cutThreshold; i < n - cutThreshold; i++) {
            sum += levelOpinions[i];
        }

        return (int) Math.round(sum / (n - 2 * cutThreshold));
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] levelOpinions = new int[n];
        for(int i = 0; i < n; i++) {
            levelOpinions[i] = Integer.parseInt(br.readLine());
        }

        bw.write(String.valueOf(solution(n, levelOpinions)));
        bw.flush();
        bw.close();
    }

}
