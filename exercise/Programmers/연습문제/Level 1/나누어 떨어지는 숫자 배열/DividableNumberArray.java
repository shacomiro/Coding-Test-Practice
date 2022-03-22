import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> arrList = new ArrayList<Integer>();
        
        for(int num : arr) {
            if(num % divisor == 0) arrList.add(num);
        }
        if(arrList.size() == 0) arrList.add(-1);
        
        arrList.sort(Comparator.naturalOrder());
        
        int[] answer = arrList.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}