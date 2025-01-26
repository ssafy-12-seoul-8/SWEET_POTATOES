import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	static boolean[] visited;
	static int[] time;
	
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	visited = new boolean[100001];
    	time = new int[100001];
    	
    	Deque<Integer> bfs = new LinkedList<>();
    	bfs.add(N);
    	visited[N] = true;
    	time[N] = 0;
    	
        while (!bfs.isEmpty()) {
        	
        	int curr = bfs.pollFirst();
        	
        	if (curr * 2 <= 100000 && !visited[curr * 2]) {
        		
        		visited[curr * 2] = true;
        		time[curr * 2] = time[curr];
        		bfs.addFirst(curr * 2);
        	}
        	
        	if (curr - 1 >= 0 && !visited[curr - 1]) {
        		
        		visited[curr - 1] = true;
        		time[curr - 1] = time[curr] + 1;
        		bfs.addLast(curr - 1);
        	}
        	
        	if (curr + 1 <= 100000 && !visited[curr + 1]) {
        		
        		visited[curr + 1] = true;
        		time[curr + 1] = time[curr] + 1;
        		bfs.addLast(curr + 1);
        	}
        }
        	
        System.out.println(time[K]);
    }
}