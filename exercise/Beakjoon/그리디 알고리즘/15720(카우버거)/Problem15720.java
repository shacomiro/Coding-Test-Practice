import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Solution15720 {
    private int b, c, d;
    private Integer[] burger, side, drink;

    public Solution15720(int b, int c, int d, Integer[] burger, Integer[] side, Integer[] drink) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.burger = burger;
        this.side = side;
        this.drink = drink;
    }

    public String solve() {
        Arrays.sort(burger, Collections.reverseOrder());
        Arrays.sort(side, Collections.reverseOrder());
        Arrays.sort(drink, Collections.reverseOrder());

        int min = Math.min(b, Math.min(c, d));
        int origin = 0;
        int discount = 0;

        for (int i = 0; i < min; i++) {
            origin += burger[i] + side[i] + drink[i];
            discount += (burger[i] + side[i] + drink[i]) * 0.9;
        }

        for (int i = min; i < b; i++) {
            origin += burger[i];
            discount += burger[i];
        }
        for (int i = min; i < c; i++) {
            origin += side[i];
            discount += side[i];
        }
        for (int i = min; i < d; i++) {
            origin += drink[i];
            discount += drink[i];
        }

        return String.valueOf(origin + "\n" + discount);
    }
}

public class Problem15720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        Integer[] arr1 = new Integer[b];
        Integer[] arr2 = new Integer[c];
        Integer[] arr3 = new Integer[d];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < d; i++) {
            arr3[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution15720(b, c, d, arr1, arr2, arr3).solve());
        bw.flush();
        bw.close();
    }
}
