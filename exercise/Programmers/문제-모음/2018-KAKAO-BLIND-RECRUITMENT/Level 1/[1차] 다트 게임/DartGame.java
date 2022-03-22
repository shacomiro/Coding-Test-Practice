import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public int solution(String dartResult) {
		int answer = 0;
		Pattern resultPattern = Pattern.compile("([0-9])+([SDT])([*#])?");
		Matcher ressultMatcher = resultPattern.matcher(dartResult);
		int[] points = new int[] { 0, 0, 0 };
		int cnt = 0;

		while (ressultMatcher.find()) {
			String result = ressultMatcher.group();

			Matcher pointMatcher = Pattern.compile("([0-9])+").matcher(result);
			Matcher bonusMatcher = Pattern.compile("([SDT])").matcher(result);
			Matcher optionMatcher = Pattern.compile("([*#])").matcher(result);

			int point = 0;
			int bonus = 1;
			int option = 1;

			if (pointMatcher.find())
				point = Integer.parseInt(pointMatcher.group());

			if (bonusMatcher.find()) {
				String bonusType = bonusMatcher.group();

				if (bonusType.equals("S"))
					bonus = 1;
				else if (bonusType.equals("D"))
					bonus = 2;
				else if (bonusType.equals("T"))
					bonus = 3;
			}

			if (optionMatcher.find()) {
				String optionType = optionMatcher.group();

				if (optionType.equals("*")) {
					option = 2;
					if (cnt > 0)
						points[cnt - 1] *= 2;
				} else if (optionType.equals("#"))
					option = -1;
			}

			points[cnt] = (int) (Math.pow(point, bonus) * option);
			cnt++;
		}

		for (int point : points)
			answer += point;

		return answer;
    }
}