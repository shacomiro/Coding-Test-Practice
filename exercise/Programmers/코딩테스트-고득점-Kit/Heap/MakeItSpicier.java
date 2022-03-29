import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        
        for(int num : scoville)
            pQueue.add(num);
        
        while(pQueue.peek() < K) {
            answer++;
            
            if(pQueue.size() == 1)
                return -1;
            
            pQueue.add(pQueue.poll() + (pQueue.poll() * 2));
        }
        
        return answer;
    }
}
//+5