import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static int checkBracket(Stack<Character> stack, char bracket) {
    	// 여는 괄호 ~ 스택 추가
        if (bracket == '(' || bracket == '{' || bracket == '[' || bracket == '<') {
            stack.push(bracket);
            return 1;
        // 만약 빈 스택에 닫는 괄호? -> 0 반환
        } else if (stack.isEmpty()) return 0;
        
        // 닫는 괄호 ~ 스택 팝과 짝 확인
        char top = stack.pop();
        if ((bracket == ')' && top != '(') || (bracket == '}' && top != '{') ||
            (bracket == ']' && top != '[') || (bracket == '>' && top != '<')) {
            return 0;
        }
        
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for (int t = 1; t <= 10; t++) {
            int isValid = 1;
            int N = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            char[] charArr = str.toCharArray();
            Stack<Character> stack = new Stack<>();

            for (char c : charArr) {
                isValid = checkBracket(stack, c);
                if (isValid == 0) break;
            }

            // 종료 후에도 스택이 비어있지 않으면 -> 0 반환
            if (!stack.isEmpty()) isValid = 0;

            System.out.println("#" + t + " " + isValid);
        }
    }
    
}