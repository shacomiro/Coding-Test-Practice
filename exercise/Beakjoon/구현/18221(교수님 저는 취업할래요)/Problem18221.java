import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution18221 {
    private int n;
    private int[][] classroom;
    private int[] professor;
    private int[] sunggyu;

    public Solution18221(int n, int[][] classroom, int[] professor, int[] sunggyu) {
        this.n = n;
        this.classroom = classroom;
        this.professor = professor;
        this.sunggyu = sunggyu;
    }

    public String solve() {
        if (Math.sqrt((Math.pow(professor[0] - sunggyu[0], 2) + Math.pow(professor[1] - sunggyu[1], 2))) < 5) {
            return "0";
        }

        int fromX = 0;
        int fromY = 0;
        int toX = 0;
        int toY = 0;
        if (professor[0] < sunggyu[0]) {
            fromX = professor[0];
            toX = sunggyu[0];
        } else {
            fromX = sunggyu[0];
            toX = professor[0];
        }
        if (professor[1] < sunggyu[1]) {
            fromY = professor[1];
            toY = sunggyu[1];
        } else {
            fromY = sunggyu[1];
            toY = professor[1];
        }

        int studentsCnt = 0;
        for (int x = fromX; x <= toX; x++) {
            for (int y = fromY; y <= toY; y++) {
                if (classroom[x][y] == 1) {
                    studentsCnt++;
                }
            }
        }

        return (studentsCnt >= 3) ? "1" : "0";
    }
}

public class Problem18221 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr1 = new int[n][n];
        int[] arr2 = new int[2];
        int[] arr3 = new int[2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int d = Integer.parseInt(st.nextToken());
                arr1[i][j] = d;

                if (d == 5) {
                    arr2[0] = i;
                    arr2[1] = j;
                } else if (d == 2) {
                    arr3[0] = i;
                    arr3[1] = j;
                }
            }
        }

        bw.write(new Solution18221(n, arr1, arr2, arr3).solve());
        bw.flush();
        bw.close();
    }
}
