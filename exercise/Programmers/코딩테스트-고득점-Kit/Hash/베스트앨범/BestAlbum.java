import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Comparator;
import java.util.Collections;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> genresCount = new HashMap<>();//Map<장르, 장르재생수>
        Map<String, Map<Integer, Integer>> playsPerGenres = new HashMap<>();//Map<장르, Map<id, 곡재생수>>
        
        for(int i = 0; i < genres.length; i++) {
            if(genresCount.containsKey(genres[i])) {
                genresCount.put(genres[i], genresCount.get(genres[i]) + plays[i]);
                (playsPerGenres.get(genres[i])).put(i, plays[i]);
            } else {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                
                genresCount.put(genres[i], plays[i]);
                playsPerGenres.put(genres[i], map);
            }
        }

		List<Entry<String, Integer>> genresCountList = new ArrayList<>(genresCount.entrySet());
        Map<String, List<Entry<Integer, Integer>>> playsPerGenresList = new HashMap<>();
        
        Collections.sort(genresCountList, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});
        
        for(Entry<String, Map<Integer, Integer>> entry : playsPerGenres.entrySet()) {
            List<Entry<Integer, Integer>> tempList = new ArrayList<>(entry.getValue().entrySet());
            
            Collections.sort(tempList, new Comparator<Entry<Integer, Integer>>() {
			    public int compare(Entry<Integer, Integer> obj1, Entry<Integer, Integer> obj2) {
				    return obj2.getValue().compareTo(obj1.getValue());
			    }
		    });
            playsPerGenresList.put(entry.getKey(), tempList);
        }
        
        for(Entry<String, Integer> genresCnt : genresCountList) {
            int limit = 2;
            
            for(Entry<Integer, Integer> song :playsPerGenresList.get(genresCnt.getKey())) {
                if(limit == 0)
                    break;
                
                answer.add(song.getKey());
                limit--;
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}
//+2