import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
		Map<String, Boolean> map = new HashMap<>();
		int len = begin.length();
		for (String str : words) {
			map.put(str, false);
		}
		map.put(begin, false);
		if (!map.containsKey(target)) {
			return 0;
		}
		Queue<String> queue = new LinkedList<>();
		queue.add(begin);
		while (!queue.isEmpty()) {
			answer += 1;
			int count = queue.size();
			for (int i = 0; i < count; i++) {
				String str = queue.poll();
				if (!map.get(str)) {
                    map.put(str, true);
					for (int j = 0; j < len; j++) {
						for (int k = 0; k < 26; k++) {
							StringBuilder sb = new StringBuilder(str);
							sb.setCharAt(j, (char) ('a' + k));
							String tmp = sb.toString();
							if (map.containsKey(tmp) && !map.get(tmp)) {
								queue.offer(tmp);
								if (tmp.equals(target)) {
									return answer;
								}
							}
						}
					}
				}
			}
		}
		return 0;
    }
}