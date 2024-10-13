import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		double sum = 0;
		int min = 4000;
		int max = -4000;
		int maxCnt = 1;
		Map<Integer,Integer> map = new TreeMap<>();

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
			if(map.containsKey(arr[i])) {
				int cnt = map.get(arr[i])+1;
				map.put(arr[i], cnt);
				maxCnt = Math.max(maxCnt, cnt);
			}else {
				map.put(arr[i], 1);
			}
		}

		Arrays.sort(arr);
		
		List<Integer> list = new ArrayList<>();
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue()==maxCnt) {
				list.add(entry.getKey());
			}
		}
		
		Collections.sort(list);
		int ans3 = 0;
		
		if(list.size()==1) {
			ans3 = list.remove(0);
		}else {
			ans3 = list.remove(1);
		}
		
		
		System.out.println(Math.round(sum/N));
		System.out.println(arr[N/2]);
		System.out.println(ans3);
		System.out.println(max-min);
		
		
	} // main

} // Main class