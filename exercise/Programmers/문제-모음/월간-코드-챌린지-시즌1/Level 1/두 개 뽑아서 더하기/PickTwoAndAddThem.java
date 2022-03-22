import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> combinations = new HashSet<Integer>();
		
		for(int x = 0; x < numbers.length; x++) {
			for(int y = x + 1; y < numbers.length; y++) {
				combinations.add(numbers[x] +numbers[y]);
			}
		}
		
		return combinations.stream().sorted().mapToInt(x -> x).toArray();
    }
}