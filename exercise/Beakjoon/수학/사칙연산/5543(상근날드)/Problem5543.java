import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution5543 {
    private int[] burgers;
    private int cola;
    private int cider;

    public Solution5543(int[] burgers, int cola, int cider) {
        this.burgers = burgers;
        this.cola = cola;
        this.cider = cider;
    }

    public String solve() {
        int cheapestSetPrice = Integer.MAX_VALUE;
        int cheapestDrinkPrice = Math.min(cola, cider);
        
        for(int burger : burgers) {
            cheapestSetPrice = Math.min(cheapestSetPrice, burger + cheapestDrinkPrice - 50);
        }

        return String.valueOf(cheapestSetPrice);
    }
}

public class Problem5543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] b = new int[3];
        for(int i = 0; i < 3; i++) {
            b[i] = Integer.parseInt(br.readLine());
        }
        int d1 = Integer.parseInt(br.readLine());
        int d2 = Integer.parseInt(br.readLine());

        bw.write(new Solution5543(b, d1, d2).solve());
        bw.flush();
        bw.close();
    }
}
