import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution2684 {
    private String sequence;

    public Solution2684(String sequence) {
        this.sequence = sequence;
    }

    public String solve() {
        int[] counts = new int[8];

        for (int i = 0; i < sequence.length() - 2; i++) {
            switch (sequence.substring(i, i + 3)) {
                case "TTT":
                    counts[0]++;
                    break;
                case "TTH":
                    counts[1]++;
                    break;
                case "THT":
                    counts[2]++;
                    break;
                case "THH":
                    counts[3]++;
                    break;
                case "HTT":
                    counts[4]++;
                    break;
                case "HTH":
                    counts[5]++;
                    break;
                case "HHT":
                    counts[6]++;
                    break;
                case "HHH":
                    counts[7]++;
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int c : counts) {
            sb.append(c).append(" ");
        }

        return sb.toString();
    }
}

public class Problem2684 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int p = Integer.parseInt(br.readLine());
        for (int i = 0; i < p; i++) {
            bw.write(new Solution2684(br.readLine()).solve());
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
