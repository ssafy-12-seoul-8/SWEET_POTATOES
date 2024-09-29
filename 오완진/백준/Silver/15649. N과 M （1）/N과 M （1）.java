import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] arr;
	static boolean[] visited;
	
    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	
    	N = sc.nextInt();
    	M = sc.nextInt();
    	
    	arr = new int[M];
    	visited = new boolean[N+1];
    	    	
    	btk(0);
    }
    
    static void btk(int idx) {
    	
    	if (idx == M) {
    		for (int num : arr)
    			System.out.print(num + " ");
    		System.out.println();
    		return;
    	}
    	
    	for (int i = 1; i <= N; i++) {
    		
    		if (!visited[i]) {
    			visited[i] = true;
    			arr[idx] = i;
    			btk(idx + 1);
    			visited[i] = false;
    		}
    		
    	}
    	
    }
}