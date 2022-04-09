import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int time = 0;
        int passed = 0;
        int nextTruck = 0;
        int currentWeight = 0;
        
        while(passed != truck_weights.length) {
            while(queue.size() < bridge_length) {
                if(nextTruck < truck_weights.length && weight >= currentWeight + truck_weights[nextTruck]) {
                    //다리 공간이 남았는데, 무게 여유가 있을 경우
                    queue.offer(truck_weights[nextTruck]);
                    currentWeight += truck_weights[nextTruck];
                    nextTruck++;    //다음트럭 지정
                } else {
                    //공간만 남고 더는 트럭이 못 타는 경우
                    queue.offer(0); //빈 공간(0)으로 채우기.
                }
                
                time++;
            }
            
            //다리 끝에 트럭이 다다른 경우
            if(queue.peek() != 0) {
                currentWeight -= queue.poll();   //트럭은 다리를 건넘(다리 위 무게에서 빠짐)
                passed++;
            } else {
                queue.poll();
            }
        }
        
        return time + 1;
    }
}
//+4