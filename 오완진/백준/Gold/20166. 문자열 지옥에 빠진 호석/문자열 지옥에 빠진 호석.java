import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N, M, K;
	static int[] dn = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dm = {-1, 0, 1, 1, 1, 0, -1, -1};
	static char[][] map;
	static List<String> words;
	static HashMap<String, Integer> canMake;

	public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	StringBuilder sb = new StringBuilder();
    	
    	N = sc.nextInt();
    	M = sc.nextInt();
    	K = sc.nextInt();
    	sc.nextLine();
    	
    	map = new char[N][M];
    	for (int n = 0; n < N; n++)
    		map[n] = sc.nextLine().toCharArray();

    	words = new ArrayList<>();
    	for (int k = 0; k < K; k++)
    		words.add(sc.nextLine());
    	
    	canMake = new HashMap<>();
    	for (int n = 0; n < N; n++)
    		for (int m = 0; m < M; m++)
    			getDp(new StringBuilder(Character.toString(map[n][m])), n, m, n, m);
    	
    	for (String word : words) {
    		if (canMake.containsKey(word))
    			sb.append(canMake.get(word)).append("\n");
    		else
    			sb.append(0).append("\n");
    	}
    	
    
    	System.out.println(sb);
    }
    
    static void getDp(StringBuilder str, int nStart, int mStart, int nNow, int mNow) {
    	
    	if (str.length() < 1 || str.length() > 5)
    		return;
    	
    	String key = new StringBuilder(str).toString();
    	if (canMake.containsKey(key))
    		canMake.put(key, canMake.get(key) + 1);
    	else
    		canMake.put(key, 1);
    	
    	for (int d = 0; d < 8; d++) {
    		int nNext = (nNow + dn[d] + N) % N;
    		int mNext = (mNow + dm[d] + M) % M;
    		
            str.append(Character.toString(map[nNext][mNext]));
            getDp(str, nStart, mStart, nNext, mNext);
            str.setLength(str.length() - 1);
    	}
    	
    }
}