import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static List<Integer> arr;
	static boolean[] visited;
	
    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	
    	N = sc.nextInt();
    	M = sc.nextInt();
    	
    	arr = new ArrayList<>();
    	visited = new boolean[N+1];
    	    	
    	btk();
    }
    
    static void btk() {
    	
    	if (arr.size() == M) {
    		for (int num : arr)
    			System.out.print(num + " ");
    		System.out.println();
    		return;
    	}
    	
    	for (int i = 1; i <= N; i++) {
    		
    		if (!visited[i]) {
    			visited[i] = true;
    			arr.add(i);
    			btk();
    			arr.remove(arr.size() - 1);
    			visited[i] = false;
    		}
    	}
    	
    }
}