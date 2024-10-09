import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Computer {
	int number;
	List<Computer> connectedComputers = new ArrayList<>();
	
	public Computer(int number) {
		this.number = number;
	}
}
public class Main {

	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// N <= 10000
		// M <= 100000
		
		// 컴퓨터는 N개 있음
		
		List<Computer> computerList = new ArrayList<>();
		computerList.add(new Computer(0));	// 0번 빈 컴퓨터 추가해놓기
		
		for (int i=1; i<=N; i++) {
			Computer computer = new Computer(i);
			computerList.add(computer);
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			// A가 B를 신뢰한다 => B를 해킹하면, A도 해킹할 수 있다.
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			Computer computerA = computerList.get(A);
			Computer computerB = computerList.get(B);
			
			computerB.connectedComputers.add(computerA);
		}
		
		// 입력 끝
		
		int[] hacking = new int[N+1];
		
		int max = Integer.MIN_VALUE;
		for (int i=1; i<=N; i++) {
			hacking[i] = bfs(computerList, i, N);
			max = Math.max(hacking[i], max);
		}
		
		
		
		for (int i=1; i<=N; i++) {
			if (hacking[i] == max) {
				sb.append(i).append(" ");	
			}
		}
		
		System.out.println(sb);
		
		
		
	}

	private static int bfs(List<Computer> computerList, int start, int N) {
		boolean[] visited = new boolean[N+1];
		Queue<Computer> queue = new LinkedList<>();	// 해킹할 컴퓨터를 담을 큐
		Computer startComputer = computerList.get(start);
		queue.add(startComputer);
		visited[start] = true;
		
		int count = 0;
		
		while (!queue.isEmpty()) {
			// 컴퓨터를 하나 해킹할때마다 카운트 올림
			Computer currentComputer = queue.poll();
			count++;
			
			
			for (int i=0; i < currentComputer.connectedComputers.size(); i++) {
				Computer nextComputer = currentComputer.connectedComputers.get(i);
				// 다음 컴퓨터를 해킹하지 않았더라면 해킹 큐에 추가함
				if (!visited[nextComputer.number]) {
					visited[nextComputer.number] = true;
					queue.add(nextComputer);
				}
			}
		}
		
		return count;
	}
}
