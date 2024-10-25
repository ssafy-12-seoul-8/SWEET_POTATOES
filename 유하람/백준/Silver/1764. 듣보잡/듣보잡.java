import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 듣도 못한 사람 수
		int N = Integer.parseInt(st.nextToken());
		
		// 보도 못한 사람 수
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> list = new TreeSet<>();
		
		for(int i=0 ; i<N ; i++) {
			list.add(br.readLine());
		}
		
		List<String> ans = new ArrayList<>();
		
		for(int i=0 ; i<M ; i++) {
			String word = br.readLine();
			if(list.contains(word)) {
				ans.add(word);
			}
		}
		
		Collections.sort(ans);
		
		sb.append(String.valueOf(ans.size())+"\n");
		for(String s : ans) {
			sb.append(s+"\n");
		}
		
		System.out.println(sb);
	} // main

}
// Main class
