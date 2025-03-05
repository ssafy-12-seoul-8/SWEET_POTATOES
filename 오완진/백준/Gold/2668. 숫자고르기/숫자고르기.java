import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        boolean[] visited = new boolean[N + 1];
        
        for (int i = 1; i <= N; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            int current = i;
            
            while (!list.contains(current)) {
                list.add(current);
                current = arr[current];
            }
            
            if (current == i) {
                int idx = list.indexOf(current);
                for (int j = idx; j < list.size(); j++) {
                    visited[list.get(j)] = true;
                }
            }
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= N; i++)
            if (visited[i])
                answer.add(i);
        
        Collections.sort(answer);
        
        sb.append(answer.size()).append("\n");
        for (int num : answer)
            sb.append(num).append("\n");

        System.out.print(sb);
    }
}