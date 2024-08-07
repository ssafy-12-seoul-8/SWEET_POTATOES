

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	static char[] ch;
	static int[] count;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for (int tc=0;tc<n;tc++) {
			String s = br.readLine();
			int len = s.length();
			count = new int[26];
			ch = new char[len];
			for (int i=0;i<len;i++) {
				int j = (int) s.charAt(i);
				j-=97;
				count[j]+=1;
			}
			btk(0,ch,len);
		}
		System.out.println(sb);

	}
	
	static void btk(int a,char[] c,int l) {
		if (a==l) {
			for(int i=0;i<l;i++) {
				sb.append(c[i]);
			}
			sb.append('\n');
			return;
		}
		for (int i=0;i<26;i++) {
			if (count[i]!=0) {
				count[i]-=1;
				char temp = (char) (i+97);
				c[a]=temp;
				btk(a+1,c,l);
				count[i]+=1;
			}
			
		}
	}
}