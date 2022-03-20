import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums) set.add(i);
        
        if(set.size() >= nums.length / 2)
            return nums.length / 2;
        else
            return set.size();
    }
}