import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int n;
    static int[] ch; //체크. 사용 여부를 표시함.

    public void DFS(int L) {
        if(L == n + 1) {
            String tmp = "";
            
            for(int i = 1; i <= n; i++)
                if(ch[i] == 1) tmp += (i + " ");

            if(tmp.length() > 0) System.out.println(tmp);
        } else {
            ch[L] = 1;//L을 사용한다고 가정했을 때
            DFS(L + 1);//L+1의 사용/미사용 경우 확인.
            ch[L] = 0;//L을 미사용한다고 가정했을 때
            DFS(L + 1);//L+1의 사용/미사용 경우 확인.
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ch = new int[n + 1];
        T.DFS(1);
    }
}
