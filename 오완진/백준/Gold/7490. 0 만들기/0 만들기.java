import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static String str;
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
        	
        	int N = Integer.parseInt(br.readLine());
        	List<String> results = new ArrayList<>();
        	btk(1, N, "1", results);
        	
        	for (String s : results)
        		sb.append(s).append("\n");
        	
        	if (tc != TC - 1)
        		sb.append("\n");
        }
        
        System.out.println(sb);
    }
    
    static void btk(int now, int N, String expr, List<String> results) {
    	
    	if (now == N) {
    		
    		if (cal(expr) == 0)
    			results.add(expr);
    		
    		return;
    	}
    	
    	int next = now + 1;
    	btk(next, N, expr + " " + next, results);
    	btk(next, N, expr + "+" + next, results);
    	btk(next, N, expr + "-" + next, results);
    }
    
    static int cal(String expr) {
    	
    	String s = expr.replace(" ", "");
    	int sum = 0;
    	int num = 0;
    	int sign = 1;
    	
    	for (int i = 0; i < s.length(); i++) {
    		
    		char c = s.charAt(i);
    		if (c == '+' || c == '-') {
    			sum += sign * num;
    			num = 0;
    			sign = (c == '+') ? 1 : -1;
    		} else
    			num = num * 10 + (c - '0');
    	}
    	
    	sum += sign * num;
    	return sum;
    }
}