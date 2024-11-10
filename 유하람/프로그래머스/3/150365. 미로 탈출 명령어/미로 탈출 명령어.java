import java.util.*;
import java.io.*;

class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "impossible";
            
            // 최소 이동거리가 k보다 크거나 최소이동거리와 k의 차이가 짝수가 아닌경우 불가능
            int dist = Math.abs(r-x) + Math.abs(c-y);
            if(dist>k || (k-dist)%2!=0) {
            	return answer;
            }
            
            // 이동 방향 (d: 아래, l: 왼쪽, r: 오른쪽, u: 위)
            char[] dir = {'u', 'r', 'l', 'd'};
            int[] dr = {-1, 0, 0, 1}; // 행 변화
            int[] dc = {0, 1, -1, 0}; // 열 변화
            
            Stack<int[]> stack = new Stack<>();
            
            // 스택에 초기값 (x, y, 방향, 길이)
            stack.push(new int[]{x, y, 0, 0});
            
            char[] tmp = new char[k + 1]; // k까지의 경로 저장
            
            while (!stack.isEmpty()) {
                int[] curr = stack.pop();
                
                tmp[curr[3]] = dir[curr[2]];
                
                
                // 만약 경로 길이가 k라면
                if (curr[3] == k) {
                    // 도착지점에 도달했으면
                    if (curr[0] == r && curr[1] == c) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 1; i <= k; i++) {
                            sb.append(tmp[i]);
                        }
                        answer = sb.toString();
                        break;
                    }
                    continue;
                }

                // 이동 가능한 방향 탐색
                for (int d = 0; d < 4; d++) {
                    int nr = curr[0] + dr[d];
                    int nc = curr[1] + dc[d];
                    
                    if (nr > 0 && nr <= n && nc > 0 && nc <= m) {
                    	// 가능한 경우만 넣기
                    	int remainDist = Math.abs(nr-r)+Math.abs(nc-c);
                    	if(remainDist < k - curr[3]) {
                    		stack.push(new int[]{nr, nc, d, curr[3] + 1});
                    	}
                    }
                }
            }

            return answer;
    }
}