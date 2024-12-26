import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1049 {
    private int n;
    private int m;
    private int[] packs;
    private int[] pieces;
    private int[] priceInfo;

    public Solution1049(int n, int m, int[] packs, int[] pieces) {
        this.n = n;
        this.m = m;
        this.packs = packs;
        this.pieces = pieces;
        this.priceInfo = getPriceInfo(packs, pieces);
    }

    private int[] getPriceInfo(int[] packs, int[] pieces) {
        int minPiece = 1000;
        int minPack = 6000;
        int pieceLimit = 0;

        for(int i = 0; i < m; i++) {
            minPiece = (pieces[i] < minPiece) ? pieces[i] : minPiece;
            minPack = (packs[i] < minPack) ? packs[i] : minPack;
        }

        minPack = (minPiece * 6 < minPack) ? minPiece * 6 : minPack;
        while(minPiece * pieceLimit < minPack) {
            pieceLimit++;
        }

        return new int[] {minPack, minPiece,  pieceLimit};
    }

    public String solve() {
        int minPackPrice = priceInfo[0];
        int minPiecePrice = priceInfo[1];
        int pieceLimit = priceInfo[2];

        if(minPackPrice == 0 || minPiecePrice == 0) {
            return String.valueOf(0);
        }

        int packCount = n / 6;
        int pieceCount = n % 6;

        return String.valueOf((packCount * minPackPrice) + ((pieceCount >= pieceLimit) ? minPackPrice : pieceCount * minPiecePrice));
    }
}
public class Problem1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[m];
        int[] arr2 = new int[m];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arr1[i] = Integer.parseInt(st.nextToken());
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution1049(n, m, arr1, arr2).solve());
        bw.flush();
        bw.close();
    }
}
