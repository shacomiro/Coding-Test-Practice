import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem1018 {
    public static int solution(int n, int m, String[][] chessboard) {
        int rowLimit = n - 7;
        int colLimit = m - 7;
        int minRepaintCount = 64;

        for(int i = 0; i < rowLimit; i++) {
            for(int j = 0; j < colLimit; j++) {
                minRepaintCount = Math.min(minRepaintCount, getRepaintCount(i, j, chessboard));
            }
        }
        
        return minRepaintCount;
    }

    public static int getRepaintCount(int x, int y, String[][] chessboard) {
        String currentColor = "W";
        int repaintCount = 0;

        for(int i = x; i < x + 8; i++) {
            for(int j = y; j < y + 8; j++) {
                if(!chessboard[i][j].equals(currentColor)) {
                    repaintCount++;
                }
                currentColor = changeColor(currentColor);
            }
            currentColor = changeColor(currentColor);
        }

        return Math.min(repaintCount, 64 - repaintCount);
    }

    public static String changeColor(String currentColor) {
        if(currentColor.equals("W")) {
            return "B";
        } else {
            return "W";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        String[][] arr = new String[n][m];
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                arr[i][j] = String.valueOf(line.charAt(j));
            }
        }

        bw.write(String.valueOf(solution(n, m, arr)));
        bw.flush();
        bw.close();
    }    
}