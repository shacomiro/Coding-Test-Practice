import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    private int required;
    private int[] resource;

    public Solution(int required, int[] resource) {
        this.required = required;
        this.resource = resource;
    }

    public String solve() {
        Arrays.sort(resource);

        int count = 0;
        int lt = 0;
        int rt = resource.length - 1;

        while(lt < rt) {
            int armor = resource[lt] + resource[rt];

            if(armor == required) {
                count++;

                lt++;
                rt--;
            } else if(armor < required) {
                lt++;
            } else if(armor > required) {
                rt--;
            }
        }

        return String.valueOf(count);
    }
}

public class Problem1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution(m, arr).solve());
        bw.flush();
        bw.close();
    }
}
