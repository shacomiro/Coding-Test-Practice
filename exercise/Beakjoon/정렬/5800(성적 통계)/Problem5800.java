import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Solution5800 {
    private List<int[]> schoolScores;

    public Solution5800(List<int[]> schoolScores) {
        this.schoolScores = schoolScores;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();
        int classId = 0;

        for(int[] classScores : schoolScores) {
            classId++;
            Arrays.sort(classScores);

            int max = classScores[classScores.length - 1];
            int min = classScores[0];
            int lGap = 0;
            for(int i = classScores.length - 1; i > 0; i--) {
                int gap = classScores[i] - classScores[i - 1];
                lGap = Math.max(lGap, gap);
            }

            sb.append("Class ").append(classId).append("\n")
                .append("Max ").append(max)
                .append(", Min ").append(min)
                .append(", Largest gap ").append(lGap)
                .append("\n");
        }

        return sb.toString();
    }
}

public class Problem5800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>(k);
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for(int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            list.add(arr);
        }

        bw.write(new Solution5800(list).solve());
        bw.flush();
        bw.close();
    }
}
