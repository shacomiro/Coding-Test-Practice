import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr) {
		ArrayList<Integer> arrList = new ArrayList<Integer>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
		
		if(arrList.size() != 1) {
			arrList.remove(arrList.indexOf(arrList.stream().mapToInt(x -> x).min().getAsInt()));
		} else {
			return new int[] {-1};
		}
		
		return arrList.stream().mapToInt(x -> x).toArray();
    }
}