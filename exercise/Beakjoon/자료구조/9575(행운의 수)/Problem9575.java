import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Solution9575 {
    private int n;
    private int[] sequenceA;
    private int m;
    private int[] sequenceB;
    private int k;
    private int[] sequenceC;
    private Set<Integer> luckyNumbers;

    public Solution9575(int n, int[] sequenceA, int m, int[] sequenceB, int k, int[] sequenceC) {
        this.n = n;
        this.sequenceA = sequenceA;
        this.m = m;
        this.sequenceB = sequenceB;
        this.k = k;
        this.sequenceC = sequenceC;
        this.luckyNumbers = new HashSet<>();
    }

    public String solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < k; l++) {
                    int sum = sequenceA[i] + sequenceB[j] + sequenceC[l];

                    if (isLuckyNumber(sum)) {
                        luckyNumbers.add(sum);
                    }
                }
            }
        }

        return String.valueOf(luckyNumbers.size());
    }

    private boolean isLuckyNumber(int number) {
        String s = String.valueOf(number);

        for (char c : s.toCharArray()) {
            if (c != '5' && c != '8') {
                return false;
            }
        }

        return true;
    }
}

public class Problem9575 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr1 = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr1[j] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            int[] arr2 = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr2[j] = Integer.parseInt(st.nextToken());
            }
            int k = Integer.parseInt(br.readLine());
            int[] arr3 = new int[k];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                arr3[j] = Integer.parseInt(st.nextToken());
            }
            bw.write(new Solution9575(n, arr1, m, arr2, k, arr3).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
