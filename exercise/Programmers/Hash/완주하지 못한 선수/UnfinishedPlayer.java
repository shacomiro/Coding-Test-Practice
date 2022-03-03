package hash;

import java.util.HashMap;
import java.util.Map.Entry;

public class UnfinishedPlayer {

	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		System.out.println(solution(participant, completion));
	}

	//완주하지 못한 선수
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> players = new HashMap<String, Integer>();
		
		for(String player : participant) {
			players.put(player, players.getOrDefault(player, 0) + 1);
		}
		
		for(String player : completion) {
			players.put(player, players.get(player) - 1);
		}
		
		for(Entry<String, Integer> entry : players.entrySet()) {
			if(!entry.getValue().equals(0)) answer = entry.getKey();
		}
		
		return answer;
	}
}
