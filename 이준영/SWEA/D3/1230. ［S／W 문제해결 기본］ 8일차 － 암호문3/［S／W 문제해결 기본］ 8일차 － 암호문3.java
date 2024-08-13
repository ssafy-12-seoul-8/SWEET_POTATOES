import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int x=0,y=0;
		for (int tc=1;tc<=10;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			LinkedList ll = new LinkedList<>();
			for(int j=0;j<N;j++) {
				ll.add(Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				String str = st.nextToken();
				switch (str) {
					case "I":
						x = Integer.parseInt(st.nextToken());
						y = Integer.parseInt(st.nextToken());
						for (int j=0;j<y;j++) {
							ll.add(x+j,Integer.parseInt(st.nextToken()));
						}
						break;
					case "D":
						x = Integer.parseInt(st.nextToken());
						y = Integer.parseInt(st.nextToken());
						for (int j=0;j<y;j++) {
							ll.remove(x);
						}
						break;
					case "A":
						y = Integer.parseInt(st.nextToken());
						for (int j=0;j<y;j++) {
							ll.addLast(Integer.parseInt(st.nextToken()));
						}
						break;
				}
			}
			sb.append("#").append(tc).append(" ");
			for (int i=0;i<10;i++) {
				sb.append(ll.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
