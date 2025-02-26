import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution1475 {
    private String roomNumber;
    private int[] numberSet;

    public Solution1475(String roomNumber) {
        this.roomNumber = roomNumber;
        this.numberSet = new int[9];
    }

    public String solve() {
        for(char c : roomNumber.toCharArray()) {
            int num = Character.getNumericValue(c);
            numberSet[(num == 9) ? 6 : num]++;
        }
        numberSet[6] = (numberSet[6] / 2) + ((numberSet[6] % 2 == 1) ? 1 : 0);

        int max = 0;
        for(int num : numberSet) {
            max = Math.max(max, num);
        }

        return String.valueOf(max);
    }
}

public class Problem1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution1475(br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
