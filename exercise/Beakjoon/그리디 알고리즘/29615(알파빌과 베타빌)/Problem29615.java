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

class Solution29615 {
    private int[] waitlist;
    private Set<Integer> friends;

    public Solution29615(int[] waitlist, List<Integer> friends) {
        this.waitlist = waitlist;
        this.friends = new HashSet<>(friends);
    }

    public String solve() {
        int replaceCnt = 0;

        for (int i = 0; i < friends.size(); i++) {
            replaceCnt += (friends.contains(waitlist[i])) ? 0 : 1;
        }

        return String.valueOf(replaceCnt);
    }
}

public class Problem29615 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        bw.write(new Solution29615(arr1, list).solve());
        bw.flush();
        bw.close();
    }
}
