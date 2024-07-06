import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2609 {
    public int[] solution(int n, int m) {
        int big, small;
        int gcd, lcm;

        if(n > m) {
            big = n;
            small = m;
        } else {
            big = m;
            small = n;
        }

        gcd = getGCF(big, small);
        lcm = (big * small) / gcd;

        return new int[] {gcd, lcm};
    }

    public int getGCF(int b, int s) {
        if(b % s == 0) return s;
        else return getGCF(s, (b % s));
    }

    public static void main(String[] args) throws IOException {
        Problem2609 main = new Problem2609();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        br.close();

        for(int x : main.solution(n, m)) System.out.println(x);
    }
}