import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class Solution1268 {
    private int n;
    private int[][] studentsClasses;
    private List<Set<Integer>> count;

    public Solution1268(int n, int[][] studentsClasses) {
        this.n = n;
        this.studentsClasses = studentsClasses;
        this.count = new ArrayList<>(n);

        for(int i = 0; i < n; i++) {
            count.add(new HashSet<>());
        }
    }

    public String solve() {
        int maxCount = -1;
        int id = 0;

        for(int self = 0; self < n; self++) {
            for(int grade = 0; grade < 5; grade++) {
                for(int other = self + 1; other < n; other++) {
                    if(studentsClasses[self][grade] == studentsClasses[other][grade]) {
                        count.get(self).add(other);
                        count.get(other).add(self);
                    }
                }
            }

            int currentCount = count.get(self).size();

            if(currentCount > maxCount) {
                maxCount = currentCount;
                id = self;
            } else if(currentCount == maxCount && self < id) {
                id = self;
            }
        }

        return String.valueOf(id + 1);
    }
}

public class Problem1268 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][5];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(new Solution1268(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
