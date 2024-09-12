import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		int count = 0;
		boolean isWord = false;
		
		for (int i=0; i<line.length(); i++) {
//			System.out.println(i + " 번째 글자 : " + line.charAt(i));
			if (isWord) {
//				System.out.println("글자입니다");
				if (line.charAt(i) == ' ') {
//					System.out.println("전환 : 글자 -> 공백");
//					count ++;
					isWord = false;
//					System.out.println("count : " + count);
				}
			} else {
//				System.out.println("공백입니다");
				if (line.charAt(i) != ' ') {
//					System.out.println("전환 : 공백 -> 글자");
					count++;
					isWord = true;
				}
			}
		}
			
		
		System.out.println(count);
	}
}
