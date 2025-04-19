import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution33756 {
    private static final long[] eightNumbers = initEightNumbers();
    private long n;

    public Solution33756(long n) {
        this.n = n;
    }

    public String solve() {
        int count = 0;

        for(long eightNumber : eightNumbers) {
            while(n >= eightNumber) {
                n -= eightNumber;
                count++;

                if(n == 0 && count <= 8) {
                    return "Yes";
                }
            }
        }

        return "No";
    }

    private static long[] initEightNumbers() {
        long[] eightNumbers = new long[18];
        long en = 888888888888888888L;

        for(int i = 0; i < 18; i++) {
            eightNumbers[i] = en;
            en /= 10;
        }

        return eightNumbers;
    }
}

public class Problem33756 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            bw.write(new Solution33756(Long.parseLong(br.readLine())).solve());
            bw.newLine();   
        }
        bw.flush();
        bw.close();
    }
}
