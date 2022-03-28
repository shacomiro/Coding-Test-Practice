import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] numbersStr = new String[numbers.length];
        
        for(int i = 0; i < numbersStr.length; i++)
            numbersStr[i] = String.valueOf(numbers[i]);
        
        Arrays.sort(numbersStr, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
		});
        
        if(numbersStr[0].equals("0"))
            return "0";
        else {
            for(String str : numbersStr)
                answer = answer.concat(str);
            
            return answer;
        }
    }
}
//+5