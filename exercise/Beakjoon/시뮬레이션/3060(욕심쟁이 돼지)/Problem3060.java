import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution3060 {
    private int n;
    private int[] meals;

    public Solution3060(int n, int[] meals) {
        this.n = n;
        this.meals = meals;
    }

    public String solve() {
        int day = 1;

        while (Arrays.stream(meals).sum() <= n) {
            int[] nextMeals = new int[6];

            for (int i = 0; i < 6; i++) {
                nextMeals[i] = meals[i] + meals[(6 + i - 1) % 6] + meals[(i + 1) % 6] + meals[(i + 3) % 6];
            }
            meals = nextMeals;
            day++;
        }

        return String.valueOf(day);
    }
}

public class Problem3060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[6];
            for (int j = 0; j < 6; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            bw.write(new Solution3060(n, arr).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
