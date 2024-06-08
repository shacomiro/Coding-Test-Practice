import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution20802 {
    private int participantsCount;
    private int[] tshirtsReq;
    private int tshirtBundleSize;
    private int pencilBundleSize;
    
    public Solution20802(int participantsCount, int[] tshirtsReq, int tshirtBundleSize, int pencilBundleSize) {
        this.participantsCount = participantsCount;
        this.tshirtsReq = tshirtsReq;
        this.tshirtBundleSize = tshirtBundleSize;
        this.pencilBundleSize = pencilBundleSize;
    }
    
    public String solve() {
        int ReqT = calcReqTshirtBundles();
        int[] ReqP = calcReqPencilBundlesAndSingle();
        
        return String.valueOf(ReqT + "\n" + ReqP[0] + " " + ReqP[1]);
    }
    
    private int calcReqTshirtBundles() {
        int bundleCnt = 0;
        
        for(int tReq : tshirtsReq) {
            bundleCnt += tReq / tshirtBundleSize;
            
            if(tReq % tshirtBundleSize > 0) {
                bundleCnt++;
            }
        }
        
        return bundleCnt;
    }
    
    private int[] calcReqPencilBundlesAndSingle() {
        int bundleCnt = participantsCount / pencilBundleSize;
        int singleCnt = participantsCount % pencilBundleSize;
        
        return new int[] {bundleCnt, singleCnt};
    }
}

public class Problem30802 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr = new int[6];
        for(int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }
        int t = Integer.parseInt(st2.nextToken());
        int p = Integer.parseInt(st2.nextToken());
        
        bw.write(new Solution20802(n, arr, t, p).solve());
        bw.flush();
        bw.close();
    }
}
