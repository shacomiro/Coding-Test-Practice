import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PalindromeNumber {
    public static String solution(String numStr) {
        char[] charArr = numStr.toCharArray();
        int lt = 0;
        int rt = charArr.length - 1;

        while(lt <= rt) {
            if(charArr[lt] != charArr[rt]) {
                return "no";
            }
            lt++;
            rt--;
        }

        return "yes";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String numStr;
        while(!(numStr = br.readLine()).equals("0")) {
            bw.write(solution(numStr));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
