class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        for (int i = 0; i < nums.length; i++) {
			for (int j = Math.min(i + 1, nums.length); j < nums.length; j++) {
				for (int k = Math.min(j + 1, nums.length); k < nums.length; k++) {
					int number = nums[i] + nums[j]  + nums[k];
					boolean isPrime = true;

					for (int divisor = 2; divisor < number; divisor++) {
						if (divisor > (int) Math.sqrt(number)) break;
						if (number % divisor == 0) isPrime = false;
					}

					if (isPrime) answer++;
				}
			}
		}

        return answer;
    }
    
}