import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] dx = {0,0,0,-1,1};
		int[] dy = {0,-1,1,0,0};
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1;tc<=T;tc++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int sum = 0;
			Map<Integer, int[]> map = new HashMap<>();
			for(int i=0;i<K;i++) {
				
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				map.put(100*y+x, new int[] {num,d});
			}
			while(M>0) {
				Map<Integer, int[]> map2 = new HashMap<>();
				
				for(int tmp:map.keySet()) {
					int y = tmp/100;
					int x = tmp%100;
					int[] value = map.get(tmp);
					int num = value[0];
					int d = value[1];
					int ny = y + dy[d];
					int nx = x + dx[d];
					if(ny == 0 || ny == N-1 || nx == 0 || nx== N-1) {
						num = num/2;
						if(d<=2) {
							d=3-d;
						} else {
							d=7-d;
						}
					} 
					
					if(map2.containsKey(100*ny+nx)) {
						int[] tmp2 = map2.get(100*ny+nx);
						if(tmp2[0]<num) {
							tmp2[0] = num;
							tmp2[1] += num;
							tmp2[2] = d;
						} else {
							tmp2[1] +=num;
						}
						map2.put(100*ny+nx, tmp2);
					} else {
						map2.put(100*ny+nx, new int[] {num,num,d});
					}
				}
				map.clear();
				for(int tmp:map2.keySet()) {
					int[] value = map2.get(tmp);
					map.put(tmp, new int[] {value[1],value[2]});
				}
				M=M-1;
			}
			
			for(int tmp:map.keySet()) {
				sum += map.get(tmp)[0];
			}
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
