import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
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
    	
    	NN = new Queue[10000];
    	for (int i = 0; i < 10000; i++)
    		NN[i] = new LinkedList<>();
    	
    	keySet = new HashSet<>();
    	for (int i = 0; i < N; i++) {
    		int num = sc.nextInt();
    		NN[num].add(1);
    		keySet.add(num);
    	}
    		
    	keyArr = new ArrayList<>(keySet);
    	Collections.sort(keyArr);
    	
    	arr = new ArrayList<>();
    	visited = new boolean[N+1];
    	    	
    	btk(0);
    	System.out.println(sb);
    }
    
    static void btk(int idx) {
    	
    	if (arr.size() == M) {
    		for (int num : arr)
    			sb.append(num).append(" ");
    		sb.append("\n");
    		return;
    	}
    	
    	for (int i = idx; i < keyArr.size(); i++) {
    		
    		int key = keyArr.get(i);
    		if (!NN[key].isEmpty()) {
    			NN[key].poll();
    			arr.add(key);
    			btk(i);
    			arr.remove(arr.size() - 1);
    			NN[key].add(1);
    		}
    	}
    	
    }
}