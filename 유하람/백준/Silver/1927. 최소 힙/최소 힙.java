import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0 ; i<N ; i++) {
			int cmd = Integer.parseInt(br.readLine());
			if(cmd==0) {
				if(pq.isEmpty()) {
					sb.append("0\n");
				}else {
					sb.append(pq.poll()+"\n");
				}
			}else {
				pq.add(cmd);
			}
		}
		
		System.out.println(sb);
		
		
		
		
	} // main

}
// Main class
