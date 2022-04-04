import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int start = 0;
        int end = people.length - 1;
        Arrays.sort(people);
        
        while(start <= end) {
            if(start != end && people[start] + people[end] <= limit)
                start++;
            answer++;
            end--;
        }
        
        return answer;
    }
}
//+6
//TowPoint 알고리즘