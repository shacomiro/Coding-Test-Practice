import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution1652 {
    private int n;
    private char[][] room;

    public Solution1652(int n, char[][] room) {
        this.n = n;
        this.room = room;
    }

    public String solve() {
        int hTotalCnt = 0;
        int vTotalCnt = 0;
        
        for(int i = 0; i < n; i++) {
            int hCnt = 0;
            int vCnt = 0;

            for(int j = 0; j < n; j++) {
                if(room[i][j] == '.') {
                    hCnt++;
                } else {
                    if(hCnt >= 2) {
                        hTotalCnt++;
                    }

                    hCnt = 0;
                }
                

                if(room[j][i] == '.') {
                    vCnt++;
                } else {
                    if(vCnt >= 2) {
                        vTotalCnt++;
                    }

                    vCnt = 0;
                }
            }

            if(hCnt >= 2) {
                hTotalCnt++;
            }
            if(vCnt >= 2) {
                vTotalCnt++;
            }
        }

        return String.valueOf(hTotalCnt + " " + vTotalCnt);
    }
}

public class Problem1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        bw.write(new Solution1652(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
