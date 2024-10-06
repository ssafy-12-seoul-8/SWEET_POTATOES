import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 사람 수
		int N = friends.length;
		
		// 사람 이름과 인덱스 연결
		int no = 0;
		Map<String,Integer> person = new HashMap<>();
		for(String name : friends) {
			person.put(name, no++);
		}
		
		// 두 친구가 주고받은 선물 수
		int[][] arr = new int[N][N];
		
		// 각 사람의 선물 지수
		int[][] score = new int[N][3];
		
		for(String gift : gifts) {
			StringTokenizer st = new StringTokenizer(gift);
			// 준사람
			int p1 = person.get(st.nextToken());
			// 받은 사람
			int p2 = person.get(st.nextToken());
			arr[p1][p2]++;
			score[p1][0]++;
			score[p1][2]++;
			score[p2][1]++;
			score[p2][2]--;
			
		}
		
		int max = 0;
		
		for(int i=0 ; i<N ; i++) {
			int tmp =0;
			for(int j=0 ; j<N ; j++) {
				if(arr[i][j] > arr[j][i]) {
					tmp++;
				} else if(arr[i][j]==arr[j][i]) {
					if(score[i][2] > score[j][2]) {
						tmp++;
					}
				}
			}
			max = Math.max(max, tmp);
		}
        
        return max;
    }
}