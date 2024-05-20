import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AlarmClock {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int hour, min;
        hour = Integer.parseInt(st.nextToken());
        min = Integer.parseInt(st.nextToken());

        if(min >= 45) {
            min -= 45;
        } else {
            min = 60 - (45 - min);

            if(hour - 1 < 0)
                hour = 23;
            else
                hour -= 1;
        }

        System.out.println(hour + " " + min);
        br.close();
    }

    public static void main(String[] args) throws IOException {
        AlarmClock.solution();
    }
}
