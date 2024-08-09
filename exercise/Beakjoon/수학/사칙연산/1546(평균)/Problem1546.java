import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution1546 {
    List<Double> scores;

    public Solution1546(List<Double> scores) {
        this.scores = scores;
    }

    public String solve() {
        double max = 0;
        double sum = 0;

        for(double score : scores) {
            max = Math.max(max, score);    
        }
        for(double score : scores) {
            sum += score / max * 100;
        }

        return String.valueOf(sum / scores.size());
    }
}

public class Problem1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Double> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(Double.parseDouble(st.nextToken()));
        }

        bw.write(new Solution1546(list).solve());
        bw.flush();
        bw.close();
    }
}
