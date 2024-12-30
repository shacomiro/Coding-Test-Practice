import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution11328 {
    private int n;
    private String[][] strArr;

    public Solution11328(int n, String[][] strArr) {
        this.n = n;
        this.strArr = strArr;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();
        int[] charCnt = new int[26];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < strArr[i][0].length(); j++) {
                charCnt[strArr[i][0].charAt(j) - 97]++;
            }
            for(int j = 0; j < strArr[i][1].length(); j++) {
                charCnt[strArr[i][1].charAt(j) - 97]--;
            }

            boolean isPossible = true;
            for(int j = 0; j < 26; j++) {
                if(charCnt[j] != 0) {
                    isPossible = false;
                }
                charCnt[j] = 0;
            }

            sb.append((isPossible) ? "Possible" : "Impossible").append("\n");
        }        

        return sb.toString();
    }
}

public class Problem11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }

        bw.write(new Solution11328(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
