import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 포켓몬의 개수 N
		int N = Integer.parseInt(st.nextToken());
		
		// 문제의 개수 M
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, String> map = new HashMap<>();
		Map<String,String> map2 = new HashMap<>();
		
		for(int i=1 ; i<=N ; i++) {
			String name = br.readLine();
			map.put(String.valueOf(i), name);
			map2.put(name, String.valueOf(i));
		}
		
		for(int i=0 ; i<M ; i++) {
			String key = br.readLine();
			if(map.containsKey(key)) {
				sb.append(map.get(key)+"\n");
			}else {
				sb.append(map2.get(key)+"\n");
			}
		}
		
		System.out.println(sb);
		
		
	} // main

}
// Main class
