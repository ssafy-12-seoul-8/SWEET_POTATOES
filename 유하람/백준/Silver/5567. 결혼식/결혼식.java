import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static class person{
		int id;
		List<Integer> friend = new ArrayList<>();
		
		person(int id){
			this.id = id;
			persons[id] = this;
		}
	}
	
	static person[] persons;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();		
		int m = sc.nextInt();
		
		persons = new person[n+1];
		
		for(int i=1 ; i<=n ; i++) {
			person p = new person(i);
		}
		
		for(int i=0 ; i<m ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			persons[a].friend.add(b);
			persons[b].friend.add(a);
		}
		
		
		boolean[] check = new boolean[n+1];
		
		for(int p : persons[1].friend) {
			check[p] = true;
			for(int p2 : persons[p].friend) {
				if(p2!=1) {
					check[p2] = true;
				}
			}
		}
		
		int answer = 0;
		
		for(int i=0 ; i<=n ; i++) {
			if(check[i]) {
				answer++;
			}
		}
		
		System.out.println(answer);
		
	}
	

}
