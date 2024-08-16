
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution
{
	static int[] heap;
	static int heapSize = 0;
    
    public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int t = 1; t <= T; t++)
		{
            System.out.print("#"+t+" ");
			
			// 연산의 수
			int n = sc.nextInt();
			
			heap = new int[n];
			
			heapSize = 0;
			
			for(int i=0 ; i<n ; i++) {
				
				// 연산 종류
				int oper = sc.nextInt();
				
				if(oper==1) {
					// 삽입
					int num = sc.nextInt();
					
					add(num);
					
				}else {
					// 삭제
					if(heap[1]==0) {
						System.out.print(-1);
						System.out.print(" ");
					}else {
						System.out.print(pop()+" ");
					}
					
				}	
			}
			System.out.println();
		}
	}
    
    static void swap(int i, int j) {
		
		int tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
		
	}
	
	static void add(int data) {
		heap[++heapSize] = data;
		
		int p = heapSize/2;
		int ch = heapSize;
		
		while(p >= 1 && heap[p] < heap[ch]) {
			swap(p,ch);
			
			ch = p;
			p = ch/2;
		}
		
	}
	
	static int pop() {
		
		int popItem = heap[1];
		
		heap[1] = heap[heapSize];
		heap[heapSize] = 0;
		heapSize--;
		
		int p =1;
		int ch = 2*p;
		
        if(ch+1 <= heapSize && heap[ch] < heap[ch+1]) {
				ch = ch+1;
			}
		
		while(ch <= heapSize && heap[p] < heap[ch]) {
			swap(p, ch);
			
			p = ch;
			ch = p*2;
			
			if(ch+1 <= heapSize && heap[ch] < heap[ch+1]) {
				ch = ch+1;
			}
			
		}

		return popItem;
	}
}