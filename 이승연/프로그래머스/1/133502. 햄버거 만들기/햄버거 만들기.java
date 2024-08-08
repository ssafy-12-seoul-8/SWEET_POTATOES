import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();        
        
        for (int i = 0; i < ingredient.length; i++) {
            stack.add(ingredient[i]);
            
            int size = stack.size();
            // 길이가 4이상 일때만 햄버거 여부 check
            if (size >= 4) {
                if (stack.get(size - 1) == 1 &&
                    stack.get(size - 2) == 3 &&
                    stack.get(size - 3) == 2 &&
                    stack.get(size - 4) == 1
                ) {
                    answer++;
                    stack.pop(); stack.pop(); stack.pop(); stack.pop();
                }
            }
        }
        
        return answer;
        
    }

}