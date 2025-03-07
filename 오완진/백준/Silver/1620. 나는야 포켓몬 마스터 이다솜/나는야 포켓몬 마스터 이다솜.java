import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        HashMap<Integer, String> dogamNum = new HashMap<>();
        HashMap<String, Integer> dogamStr = new HashMap<>();
        
        int idx = 1;
        for (int n = 1; n <= N; n++) {
        	String pokemon = br.readLine();
        	dogamNum.put(idx, pokemon);
        	dogamStr.put(pokemon, idx);
        	idx++;
        }
        
        for (int m = 1; m <= M; m++) {
        	String q = br.readLine();
            if (Character.isDigit(q.charAt(0)))
                sb.append(dogamNum.get(Integer.parseInt(q))).append("\n");
            else
                sb.append(dogamStr.get(q)).append("\n");
        }
        
        System.out.println(sb);
    }
}