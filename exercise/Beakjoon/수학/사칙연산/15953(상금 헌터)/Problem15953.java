import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution15953 {
    private int rank2017;
    private int rank2018;

    public Solution15953(int rank2017, int rank2018) {
        this.rank2017 = rank2017;
        this.rank2018 = rank2018;
    }

    public String solve() {
        return String.valueOf(getPrize2017(rank2017) + getPrize2018(rank2018));
    }

    private int getPrize2017(int rank) {
        int prize = 0;

        if(rank == 0) {
            prize = 0;
        } else if(rank == 1) {
            prize = 5000000;
        } else if(rank <= 3) {
            prize = 3000000;
        } else if(rank <= 6) {
            prize = 2000000;
        } else if(rank <= 10) {
            prize = 500000;
        } else if(rank <= 15) {
            prize = 300000;
        } else if(rank <= 21) {
            prize = 100000;
        }

        return prize;
    }

    private int getPrize2018(int rank) {
        int prize = 0;

        if(rank == 0) {
            prize = 0;
        } else if(rank == 1) {
            prize = 5120000;
        } else if(rank <= 3) {
            prize = 2560000;
        } else if(rank <= 7) {
            prize = 1280000;
        } else if(rank <= 15) {
            prize = 640000;
        } else if(rank <= 31) {
            prize = 320000;
        }

        return prize;
    }
}

public class Problem15953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            bw.write(new Solution15953(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
