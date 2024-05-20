import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

class FindNumber {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st1.nextToken());
        }
        
        int m = Integer.parseInt(br.readLine());
        int[] x = new int[m];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            x[i] = Integer.parseInt(st2.nextToken());
        }
        
        Arrays.sort(a);
        
        for(int i = 0; i < m; i++) {
            int lt = 0;
            int rt = n - 1;
            boolean isExist = false;
            
            while(lt <= rt) {
                int mid = (lt + rt) / 2;
                
                if(x[i] == a[mid]) {
                    isExist = true;
                    bw.write(String.valueOf(1));
                    break;
                } else if(x[i] < a[mid]) {
                    rt = mid - 1;
                } else {
                    lt = mid + 1;
                }
            }
            
            if(!isExist) {
                bw.write(String.valueOf(0));
            }
            
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
    }
}
