import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] NN;
	static List<Integer> arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	
    	N = sc.nextInt();
    	M = sc.nextInt();
    	
    	NN = new int[N];
    	for (int i = 0; i < N; i++)
    		NN[i] = sc.nextInt();
    	Arrays.sort(NN);
    		
    	arr = new ArrayList<>();
    	visited = new boolean[N+1];
    	    	
    	btk();
    	System.out.println(sb);
    }
    
    static void btk() {
    	
    	if (arr.size() == M) {
    		for (int num : arr)
    			sb.append(num).append(" ");
    		sb.append("\n");
    		return;
    	}
    	
    	for (int i = 0; i < N; i++) {
    		
//    		if (!visited[i]) {
//    			visited[i] = true;
    			arr.add(NN[i]);
    			btk();
    			arr.remove(arr.size() - 1);
//    			visited[i] = false;
//    		}
    	}
    	
    }
}