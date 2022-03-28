import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        Map<Integer, Integer> prioritiesMap = new HashMap<Integer, Integer>();
        int topProiority = 0;
        int locations = 0;
        int cnt = 0;
        
        for(int proiority : priorities) {
            int[] info = {locations++, proiority};
            queue.add(info);
                
            if(topProiority < proiority)
                topProiority = proiority;
            
            if(prioritiesMap.get(proiority) != null)
                prioritiesMap.replace(proiority, prioritiesMap.get(proiority) + 1);
            else
                prioritiesMap.put(proiority, 1);
            
        }
        
        while(!queue.isEmpty()) {
            int[] currentInfo = queue.poll();
            
            if(currentInfo[1] == topProiority) {
                cnt++;
                prioritiesMap.replace(currentInfo[1], prioritiesMap.get(currentInfo[1]) - 1);
                
                if(currentInfo[0] == location) {
                    answer = cnt;                    
                    break;
                }
                while(!prioritiesMap.containsKey(topProiority) || prioritiesMap.get(topProiority) == 0)
                    topProiority--;
            } else {
                queue.add(currentInfo);
            }
        }
        
        return answer;
    }
}
//+2