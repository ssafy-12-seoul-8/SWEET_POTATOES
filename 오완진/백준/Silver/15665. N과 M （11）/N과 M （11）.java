import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N, M;
//	static int[] NN;
	static HashSet<Integer> keySet;
	static List<Integer> arr, keyArr;
	static Queue<Integer>[] NN;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	
    	N = sc.nextInt();
    	M = sc.nextInt();
    	
    	keySet = new HashSet<>();
    	for (int i = 0; i < N; i++)
    		keySet.add(sc.nextInt());
    		
    	keyArr = new ArrayList<>(keySet);
    	Collections.sort(keyArr);
    	
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
    	
    	for (int i = 0; i < keyArr.size(); i++) {
    		
    		int key = keyArr.get(i);
    		arr.add(key);
    		btk();
    		arr.remove(arr.size() - 1);
    	}
    	
    }
}