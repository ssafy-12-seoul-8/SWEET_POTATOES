import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	// 디폴트 방향 : 오른쪽
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int N = sc.nextInt();
    	int[][] map = new int[N][N];
    	
    	int K = sc.nextInt();
    	for (int k = 0; k < K; k++)
    		map[sc.nextInt()-1][sc.nextInt()-1] = 2;
    	
    	int Q = sc.nextInt();
    	sc.nextLine();
    	Queue<Integer> query1 = new LinkedList<>();
    	Queue<Character> query2 = new LinkedList<>();
    	for (int q = 0; q < Q; q++) {
    		String[] part = sc.nextLine().split(" ");
    		query1.add(Integer.parseInt(part[0]));
    		query2.add(part[1].charAt(0));
    	}
    	
    	Deque<int[]> snake = new LinkedList<>();
    	snake.addFirst(new int[] {0, 0});
    	map[0][0] = 1;
    	
    	int dWay = 0;
    	int time = 0;
    	while (true) {
    		
    		time++;
    		
    		int[] head = snake.peekFirst();
    		int rNow = head[0];
    		int cNow = head[1];
    		
    		int rNext = rNow + dr[dWay];
    		int cNext = cNow + dc[dWay];
    		
    		// 맵 밖 or 뱀 자신 => 종료
    		if (rNext < 0 || N <= rNext || cNext < 0 || N <= cNext ||
    				map[rNext][cNext] == 1) break;
    		
    		head = new int[] {rNext, cNext};
    		
    		// 사과 체크
    		if (map[head[0]][head[1]] == 2) {
    			map[head[0]][head[1]] = 1;
    			snake.addFirst(head);
    		} else {
    			map[head[0]][head[1]] = 1;
    			snake.addFirst(head);
    			int[] tail = snake.pollLast();
    			map[tail[0]][tail[1]] = 0;
    		}
    		
    		// 방향 체크
    		if (!query1.isEmpty()) {
    			if (time == query1.peek()) {
    				query1.poll();
    				if (query2.poll() == 'L')
    					dWay = (dWay + 3) % 4;
    				else
    					dWay = (dWay + 1) % 4;
    			}
    		}
    		
//    		System.out.println(time);
//    		System.out.println(snake.peekFirst()[0] + " " + snake.peekFirst()[1]);
//    		System.out.println(snake.peekLast()[0] + " " + snake.peekLast()[1]);
//    		
//    		for (int r = 0; r < N; r++) {
//    			for (int c = 0; c < N; c++) {
//    				System.out.print(map[r][c] + " ");
//    			}
//    			System.out.println();
//    		}
//    		System.out.println();
    	}
    	
    	System.out.println(time);
    }
}