import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution5597 {
    private boolean[] isAssignmentssubmitted;

    public Solution5597(boolean[] isAssignmentssubmitted) {
        this.isAssignmentssubmitted = isAssignmentssubmitted;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= 30; i++) {
            if(!isAssignmentssubmitted[i]) {
                sb.append(i).append("\n");
            }
        }

        return sb.toString();
    }
}


public class Problem5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] arr = new boolean[31];
        for(int i = 1; i <= 28; i++) {
            arr[Integer.parseInt(br.readLine())] = true;
        }

        bw.write(new Solution5597(arr).solve());
        bw.flush();
        bw.close();
    }
}
