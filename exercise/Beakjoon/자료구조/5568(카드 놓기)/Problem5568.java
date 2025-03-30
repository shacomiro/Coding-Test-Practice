import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

class Solution5568 {
    private int n;
    private int k;
    private int[] cards;
    private Set<Integer> numbers;
    private boolean[] picked;

    public Solution5568(int n, int k, int[] cards) {
        this.n = n;
        this.k = k;
        this.cards = cards;
        this.numbers = new HashSet<>();
        this.picked = new boolean[n];
    }

    public String solve() {
        pick(cards, n, 0, "");

        return String.valueOf(numbers.size());
    }

    private void pick(int[] elements, int n, int r, String ns) {
        if(r == k) {
            numbers.add(Integer.parseInt(ns));
            return;
        }

        for(int i = 0; i < n; i++) {
            if(picked[i] == false) {
                picked[i] = true;
                pick(elements, n, r + 1, ns + elements[i]);
                picked[i] = false;
            }
        }
    }
}

public class Problem5568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solution5568(n, k, arr).solve());
        bw.flush();
        bw.close();
    }
}
