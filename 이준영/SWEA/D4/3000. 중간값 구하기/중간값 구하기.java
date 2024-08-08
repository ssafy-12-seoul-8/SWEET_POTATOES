
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for (int tc=1;tc<=T;tc++) {
			PriorityQueue<Integer> minheap = new PriorityQueue<>();
			PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> b - a);;
			int sum=0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			minheap.add(A);
			for (int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = minheap.peek();
				int e=0;
				int count=0;
				if (a<d) {
					count+=1;
					maxheap.add(a);
				} else {
					minheap.add(a);
				}
				if (b<d) {
					count+=1;
					maxheap.add(b);
				} else {
					minheap.add(b);
				}
				switch(count) {
					case 0:
						e = minheap.poll();
						maxheap.add(e);
						break;
					case 1:
						break;
					case 2:
						e = maxheap.poll();
						minheap.add(e);
						break;
				}
				sum=(sum+minheap.peek())%20171109;
			}
			System.out.printf("#%d %d\n",tc,sum);
		}
	}
	
	
	
}
