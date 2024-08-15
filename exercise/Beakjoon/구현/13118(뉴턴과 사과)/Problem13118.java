import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution13118 {
    private int[] person;
    private int[] apple;

    public Solution13118(int[] person, int[] apple) {
        this.person = person;
        this.apple = apple;
    }

    public String solve() {
        int impact = apple[0];

        for(int i = 0; i < 4; i++) {
            if(person[i] == impact) {
                return String.valueOf(i + 1);
            }
        }

        return String.valueOf(0);
    }
}

public class Problem13118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        
        int[] arr1 = new int[4];
        for(int i = 0; i < 4; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] arr2 = new int[3];
        for(int i = 0; i < 3; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        

        bw.write(new Solution13118(arr1, arr2).solve());
        bw.flush();
        bw.close();
    }
}
