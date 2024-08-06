import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < arr.length; i++) {
			if (stack.isEmpty())
				stack.add(arr[i]);
			else if (arr[i] != stack.peek())
				stack.add(arr[i]);
			else continue;		// arr[i] == stack.peek()
		}
		
		int[] Arr = new int[stack.size()];

		for (int i = 0; i < stack.size(); i++)
			Arr[i] = stack.get(i);
		
		return Arr;
		
	}
}