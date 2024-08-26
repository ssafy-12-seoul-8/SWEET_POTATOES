import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Map<Character, Integer> map = new HashMap<>();
		Map<Character,Integer> map2 = new HashMap<>();
		int sum=0;
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int len = str.length();
			for(int j=0;j<len;j++) {
				char ch = str.charAt(j);
				if (map.containsKey(ch)) {
					int a = map.get(ch);
					map.put(ch, a+pow(10,len-1-j));
				} else {
					map.put(ch, pow(10,len-1-j));
				}
			}
		}
		Set<Character> set = map.keySet();
		int len2 = set.size();
		char[] arr = new char[len2];
		int j=0;
		for(char k:set) {
			arr[j]=k;
			j+=1;
		}
		for(int i=len2-2;i>=0;i--) {
			for(int k=0;k<=i;k++) {
				if(map.get(arr[k])>map.get(arr[k+1])) {
					char tmp = arr[k];
					arr[k] = arr[k+1];
					arr[k+1] = tmp;
				}
			}
		}
		for(int i=0;i<len2;i++) {
			map2.put(arr[i],i+9-(len2-1));
		}
		for(int i=0;i<len2;i++) {
			sum+=map.get(arr[i])*map2.get(arr[i]);
		}
		System.out.println(sum);
	}
	public static int pow(int a,int b) {
		if (b==0)
			return 1;
		return a*pow(a,b-1);
	}
}
