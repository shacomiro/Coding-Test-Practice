import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CoordinateCompression {
    public static int[] solution(int[] coordinates) {
        int[] compressedCoors = new int[coordinates.length];
        int[] cloneCoor = coordinates.clone();        
        Map<Integer, Integer> coorMap = new HashMap<>();
        int compValue = 0;

        Arrays.sort(cloneCoor);
        for(int coor : cloneCoor) {
            if(coorMap.containsKey(coor)) {
                continue;
            }

            coorMap.put(coor, compValue++);
        }

        for(int i = 0; i < compressedCoors.length; i++) {
            compressedCoors[i] = coorMap.get(coordinates[i]);
        }

        return compressedCoors;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] coordinates = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {            
            coordinates[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int cmpCoor : solution(coordinates)) {
            bw.write(cmpCoor + " ");
        }
        bw.flush();
        bw.close();
    }    
}