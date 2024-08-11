import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1074 {
    private int size;
    private int row;
    private int column;
    private int count;
    private boolean found;

    public Solution1074(int n, int row, int column) {
        this.size = (int) Math.pow(2, n);
        this.row = row;
        this.column = column;
        this.count = -1;
        this.found = false;
    }

    public String solve() {
        divideConquerSearch(0, 0, size - 1, size - 1, size / 2);

        return String.valueOf(count);
    }

    private void divideConquerSearch(int fromX, int fromY, int toX, int toY, int mid) {
        if(mid == 1) {
            for(int x = fromX; x <= toX; x++) {
                for(int y = fromY; y <= toY; y++) {
                    count++;

                    if(x == row && y == column) {
                        return;
                    }
                }
            }
        } else {
            int midX = toX - mid;
            int midY = toY - mid;
            int nextMid = mid / 2;

            if(fromX <= row && row <= midX && fromY <= column && column <= midY) {
                divideConquerSearch(fromX, fromY, midX, midY, nextMid);
            } else if(fromX <= row && row <= midX && midY + 1 <= column && column <= toY) {
                count += mid * mid;
                divideConquerSearch(fromX, midY + 1, midX, toY, nextMid);
            } else if(midX + 1 <= row && row <= toX && fromY <= column && column <= midY) {
                count += 2 * mid * mid;
                divideConquerSearch(midX + 1, fromY, toX, midY, nextMid);
            } else if(midX + 1 <= row && row <= toX && midY + 1 <= column && column <= toY) {
                count += 3 * mid * mid;
                divideConquerSearch(midX + 1, midY + 1, toX, toY, nextMid);
            }
        }
    }

    private void exhaustiveSearch(int fromX, int fromY, int toX, int toY, int mid) {
        if(found) {
            return;
        }

        if(toX - fromX == 1 && toY - fromY == 1) {
            for(int x = fromX; x <= toX; x++) {
                for(int y = fromY; y <= toY; y++) {
                    count++;

                    if(x == row && y == column) {
                        found = true;
                        return;
                    }
                }
            }
        } else {
            int midX = toX - mid;
            int midY = toY - mid;
            int nextMid = mid / 2;

            exhaustiveSearch(fromX, fromY, midX, midY, nextMid);
            exhaustiveSearch(fromX, midY + 1, midX, toY, nextMid);
            exhaustiveSearch(midX + 1, fromY, toX, midY, nextMid);
            exhaustiveSearch(midX + 1, midY + 1, toX, toY, nextMid);
        }
    }
}

public class Problem1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        bw.write(new Solution1074(n, r, c).solve());
        bw.flush();
        bw.close();
    }
}
