import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> neverHeardSet = new HashSet<>();
        List<String> unkonwnList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            neverHeardSet.add(br.readLine());
        }

        for(int i = 0; i < m; i++) {
            String neverSawName = br.readLine();

            if(neverHeardSet.contains(neverSawName)) {
                unkonwnList.add(neverSawName);
            }
        }

        Collections.sort(unkonwnList);

        bw.write(String.valueOf(unkonwnList.size()));
        bw.newLine();
        for(String name : unkonwnList) {
            bw.write(name);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
