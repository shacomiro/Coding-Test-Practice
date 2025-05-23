import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution2840 {
    private int n;
    private int k;
    private int[] rotates;
    private char[] characters;
    private char[] wheel;
    private boolean[] isUsed;

    public Solution2840(int n, int k, int[] rotates, char[] characters) {
        this.n = n;
        this.k = k;
        this.rotates = rotates;
        this.characters = characters;
        this.wheel = new char[n];
        this.isUsed = new boolean[26];
    }

    public String solve() {
        for (int i = 0; i < n; i++) {
            wheel[i] = '?';
        }

        int cursor = 0;
        for (int i = 0; i < k; i++) {
            cursor = (cursor - (rotates[i] % n) + n) % n;

            if (wheel[cursor] == '?') {
                if (isUsed[characters[i] - 'A']) {
                    return "!";
                }

                wheel[cursor] = characters[i];
                isUsed[characters[i] - 'A'] = true;
            } else if (wheel[cursor] != characters[i]) {
                return "!";
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(wheel[cursor]);

            cursor = (cursor + 1) % n;
        }

        return sb.toString();
    }
}

public class Problem2840 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[k];
        char[] arr2 = new char[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            arr1[i] = Integer.parseInt(st.nextToken());
            arr2[i] = st.nextToken().charAt(0);
        }

        bw.write(new Solution2840(n, k, arr1, arr2).solve());
        bw.flush();
        bw.close();
    }
}
