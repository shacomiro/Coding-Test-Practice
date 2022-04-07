import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String oper : operations) {
            String[] info = oper.split(" ");
            
            if(pqMin.size() == 0 && info[0].equals("D"))
                continue;
            
            if(info[0].equals("I")) {
                pqMin.offer(Integer.parseInt(info[1]));
                pqMax.offer(Integer.parseInt(info[1]));
            } else {
                if(info[1].equals("1")) {
                    int num = pqMax.poll();
                    pqMin.remove(num);
                } else {
                    int num = pqMin.poll();
                    pqMax.remove(num);
                }
            }      
        }
        
        return pqMin.size() == 0 ? new int[] {0, 0} : new int[] {pqMax.poll(), pqMin.poll()};
    }
}
//+2