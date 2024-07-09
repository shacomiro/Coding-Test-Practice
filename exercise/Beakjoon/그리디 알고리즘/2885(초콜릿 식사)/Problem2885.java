import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution2885 {
    private int target;

    public Solution2885(int target) {
        this.target = target;
    }

    public String solve() {
        int chocolate = 1;
        int splitCnt = 0;

        while(chocolate < target) {
            chocolate *= 2;
        }

        if(chocolate == target) {
            return String.valueOf(chocolate + " " + splitCnt);
        }

        int sum = 0;
        int piece = chocolate;

        while(sum < target) {
            piece /= 2;
            splitCnt++;

            if(sum + piece <= target) {
                sum += piece;
            }
        }

        return String.valueOf(chocolate + " " + splitCnt);
    }
}

public class Problem2885 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());

        bw.write(new Solution2885(k).solve());
        bw.flush();
        bw.close();
    }
}
