import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Problem2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int verifyNum = 0;
        
        while(st.hasMoreTokens()) {
            int uniqueNum = Integer.parseInt(st.nextToken());
            verifyNum += uniqueNum * uniqueNum;
        }
        verifyNum %= 10;
        
        bw.write(String.valueOf(verifyNum));
        bw.flush();
        bw.close();
    }
}