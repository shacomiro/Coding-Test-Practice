package kakao_blind_recruitment_2022;

import java.util.ArrayList;
import java.util.HashMap;

public class get_the_report_results {

	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		
//		String[] id_list = {"con", "ryan"};
//		String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
//		int k = 3;
	
		
		for(int element : solution(id_list, report, k)) {
			System.out.print(element + " ");
		}
	}

	//신고 결과 받기
	public static int[] solution(String[] id_list, String[] report, int k) {
		int[] result = new int[id_list.length];
		HashMap<String, ArrayList<String>> reportResult = new HashMap<String, ArrayList<String>>();
		HashMap<String, Integer> repondent = new HashMap<String, Integer>();
		
		for(String id : id_list) {
			reportResult.put(id, new ArrayList<String>());
		}
				
		for(String reportInfo : report) {
			String[] reporterNrepondent = reportInfo.split(" ");
			ArrayList<String> tempRepondents = new ArrayList<String>();
			
			if(repondent.get(reporterNrepondent[1]) == null) {
				repondent.put(reporterNrepondent[1], 1);
			} else {
				if(reportResult.get(reporterNrepondent[0]).contains(reporterNrepondent[1])) {
				} else {
					repondent.put(reporterNrepondent[1], repondent.get(reporterNrepondent[1]) + 1);
				}
			}
			
			if(reportResult.get(reporterNrepondent[0]) == null) {
				tempRepondents.add(reporterNrepondent[1]);
				reportResult.put(reporterNrepondent[0], tempRepondents);
			} else {
				tempRepondents = reportResult.get(reporterNrepondent[0]);
				
				if(!tempRepondents.contains(reporterNrepondent[1])) {
					tempRepondents.add(reporterNrepondent[1]);
					reportResult.put(reporterNrepondent[0], tempRepondents);
				}			
			}
		}
		
		repondent.forEach((id, count) -> {
 			if(count < k) {
				reportResult.forEach((reporter, targets) -> {
					if(targets.contains(id)) {
						targets.remove(id);
					}
				});
			}
		});
		
		for(int i = 0; i < id_list.length; i++) {
			result[i] = reportResult.get(id_list[i]).size();
		}
		
		return result;
	}
}
