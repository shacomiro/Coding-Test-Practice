import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] numbers) {
        int answer = -1;
        List<Integer> numberList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
        
        for(int num : numbers)
            numberList.remove(numberList.indexOf(num));
        
        answer = numberList.stream().mapToInt(x -> x).sum();
        
        return answer;
    }
}