class Solution {
    public String solution(String s) {
        String[] splitArr = s.split(" ");
		int min = Integer.valueOf(splitArr[0]);
		int max = Integer.valueOf(splitArr[0]);
		
		for(String num : splitArr) {
			int targetNum = Integer.valueOf(num);
			
			max = Math.max(targetNum, max);
			min = Math.min(targetNum, min);
		}
		
		return min+ " " + max;
    }
}