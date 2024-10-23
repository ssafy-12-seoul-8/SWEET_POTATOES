import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		// 사람의 수
		int N = Integer.parseInt(st.nextToken());
		

		// 파티의 수
		int M = Integer.parseInt(st.nextToken());
		

		// 진실을 아는 사람
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());

		List<Integer> person = new ArrayList<>();

		for (int i = 0; i < K; i++) {
			person.add(Integer.parseInt(st.nextToken()));
		}
		

		Map<Integer, List<Integer>> party = new HashMap<>();
		Map<Integer, List<Integer>> people = new HashMap<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			for (int j = 0; j < n; j++) {
				int p = Integer.parseInt(st.nextToken());
				// 파티에 가는 사람 저장
				if (!party.containsKey(i)) {
					party.put(i, new ArrayList<>());
				}
				party.get(i).add(p);

				// 사람이 가는 파티 저장
				if (!people.containsKey(p)) {
					people.put(p, new ArrayList<>());
				}
				people.get(p).add(i);

			}
		}

		// 진실을 말한 파티
		boolean[] trueParty = new boolean[M];

		// 방문 사람 체크
		boolean[] checkedP = new boolean[N + 1];
		
		while(!person.isEmpty()) {
			int p = person.remove(0);
			
			if(checkedP[p]) continue;
			
			checkedP[p] = true;
			
			if(!people.containsKey(p)) continue;
			
			for(int par : people.get(p)) {
				
				trueParty[par] = true;
				
				for(int per : party.get(par)) {
					person.add(per);
				}
			}
		}
		
		int answer = 0;
		
		for(boolean b : trueParty) {
			if(!b) answer++;
		}
		
		System.out.println(answer);

	} // main

} // Main class