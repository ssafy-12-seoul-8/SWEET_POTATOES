import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

   static List<int[]> chicken = new ArrayList<>();
   static List<int[]> home = new ArrayList<>();
   
   static int N;
   static int M;
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      // N * N
      int[][] array = new int[N][N];
      
      
      for (int i = 0; i<N; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < N; j++) {
            int X = Integer.parseInt(st.nextToken());
            array[i][j] = X;
            int[] location = {i,j};
            
            // X 가 2면 치킨집에 추가함
            if (X==2) {      
               chicken.add(location);
            } else if (X==1) {   // 1이면 집에 추가함
               home.add(location);
            }
         }
      }
      
      
      // 각각의 집들이 가지는 '집과 가장 가까운 치킨집 사이의 거리 (치킨거리)'를 저장하는 배열
//      int[] 치킨거리 = new int[home.size()];
      
      PriorityQueue<Integer> 치킨거리 = new PriorityQueue<>(Collections.reverseOrder());
      
      // 1. 모든 집들은 '치킨거리'를 구해야 한다.
      // 치킨집에 한번씩 가보고, 그 중 가장 짧은 거리를 저장해야함
      
      for (int i=0; i < home.size(); i++) {
         int[] homeXY = home.get(i);
         
         int min = Integer.MAX_VALUE;
         
         for (int j = 0; j < chicken.size(); j++) {
            int[] chickenXY = chicken.get(j);
            
            min = Math.min(min, findRoute(homeXY, chickenXY));      // i 번째 집의 치킨거리
         }
         치킨거리.add(min);      // 치킨거리 큐에 저장
//         치킨거리[i] = min;      // 치킨거리 배열에 저장.
      }
      
      int count = chicken.size() - M;   // 치킨집이 4개, M이 3이면, 결국 1개만 지워야 함.
      
      // 폐업시키기 ㅠㅠ...
      while (count != 0) {
         System.out.println("폐업해라 얍");
         치킨거리.poll();
         count--;
      }
      
      // result 구하기
      int result = 0;
      while (!치킨거리.isEmpty()) {
         System.out.println("현재 결과값은 : " + result);
         result += 치킨거리.poll();
      }
      
      System.out.println(result);
      
      // 치킨거리 배열을 다 더하면, result값이 나와야 하는 구조.
      // 치킨거리 배열을 큰 순으로 정리해야함.
      
      
   }
   
   static int findRoute(int[] home, int[] chicken) {
      int x = Math.abs(home[0] - chicken[0]);
      int y = Math.abs(home[1] - chicken[1]);
      
      return x+y;
   }
}
