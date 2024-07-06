import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem8979 {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] list = new int[N][3];
        String target = "";
        int rank = 1;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            String gold = st.nextToken();
            String silver = st.nextToken();
            String bronze = st.nextToken();
            String medals = gold + silver + bronze;

            list[idx][0] = Integer.parseInt(gold);
            list[idx][1] = Integer.parseInt(silver);
            list[idx][2] = Integer.parseInt(bronze);

            if(idx + 1 == K)
                target = medals;
        }

        Arrays.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] < o2[0]) {
                    return 1;
                } else if(o1[0] == o2[0]) {
                    if(o1[1] < o2[1]) {
                        return 1;
                    } else if(o1[1] == o2[1]) {
                        if(o1[2] < o2[2]) {
                            return 1;
                        } else if(o1[2] == o2[2]) {
                            return 0;
                        }
                    }
                }

                return -1;
            }
        });


        for(int i = 0; i < N; i++) {
            if(target.equals(""+list[i][0]+list[i][1]+list[i][2])) {
                System.out.println(rank);
                break;
            } else {
                rank++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Problem8979.solution();
    }
}
