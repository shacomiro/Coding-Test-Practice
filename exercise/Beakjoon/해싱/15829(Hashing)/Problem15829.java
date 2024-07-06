import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem15829 {
    public static long solution(int l, String str) {
        int r = 31;
        int m = 1234567891;
        char[] charArr = str.toCharArray();
        long hash = 0;
        long factor = 1;

        for(int i = 0; i < l; i++) {
            int charNum = charArr[i] - 96;
            
            hash = (hash + charNum * factor) % m;
            factor = (factor * r) % m;
        }

        return hash;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int l = Integer.parseInt(br.readLine());
        String str = br.readLine();

        bw.write(String.valueOf(solution(l, str)));
        bw.flush();
        bw.close();
    }
}
