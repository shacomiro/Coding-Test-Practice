import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution20044 {
    private int[] skills;

    public Solution20044(int[] skills) {
        this.skills = skills;
    }

    public String solve() {
        Arrays.sort(skills);

        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < skills.length / 2; i++) {
            sum = skills[i] + skills[(skills.length - 1) - i];

            if(sum < min) {
                min = sum;
            }
        }

        return String.valueOf(min);
    }
}


public class Problem20044 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n * 2];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n * 2; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution20044(arr).solve());
        bw.flush();
        bw.close();
    }
}
