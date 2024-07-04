import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Solution1427 {
    private String numberStr;

    public Solution1427(String numberStr) {
        this.numberStr = numberStr;
    }

    public String solve() {
        char[] arr = numberStr.toCharArray();
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }
}

public class Problem1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n = br.readLine();

        bw.write(new Solution1427(n).solve());
        bw.flush();
        bw.close();
    }
}
