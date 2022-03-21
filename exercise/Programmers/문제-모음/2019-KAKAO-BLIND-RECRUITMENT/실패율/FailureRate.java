import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		int[] currentStageNumber = new int[N];

		Map<Integer, Double> failureRate = new HashMap<Integer, Double>();
		int remainPlayer = stages.length;

		for (int stage : stages) {
			if (stage <= N)
				currentStageNumber[stage - 1]++;
		}

		for (int i = 0; i < N; i++) {
			if (remainPlayer == 0) {
				failureRate.put(i + 1, (double) 0);
			} else {
				failureRate.put(i + 1, (double) currentStageNumber[i] / (double) (remainPlayer));
			}

			remainPlayer -= currentStageNumber[i];
		}

		List<Map.Entry<Integer, Double>> failureRateEntryList = new ArrayList<Map.Entry<Integer, Double>>(
				failureRate.entrySet());
		failureRateEntryList.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

		for (int i = 0; i < N; i++) {
			answer[i] = failureRateEntryList.get(i).getKey();
		}

		return answer;
    }
}