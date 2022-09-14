import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class AttendLog implements Comparable<AttendLog> {
    public int time;
    public char status;

    AttendLog(int time, char status) {
        this.time = time;
        this.status = status;
    }

    @Override
    public int compareTo(AttendLog o) {
        if(this.time == o.time) return this.status - o.status;
        else return this.time - o.time;
    }
}

public class Main {
    public int solution(int n, int[][] arr) {
        int answer = 0;
        int cnt = 0;
        ArrayList<AttendLog> logs = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            logs.add(new AttendLog(arr[i][0], 's'));
            logs.add(new AttendLog(arr[i][1], 'e'));
        }
        Collections.sort(logs);

        for(AttendLog al : logs) {
            if(al.status == 's') cnt++;
            else cnt--;

            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][2];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(T.solution(n, arr));
    }
}
