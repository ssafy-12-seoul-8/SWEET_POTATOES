import java.util.Scanner;

class Trie {
	Trie[] child = new Trie[10];
	boolean isEnd = false;
}

public class Main {
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int TC = sc.nextInt();
    	for (int tc = 1; tc <= TC; tc++) {
    		
    		int N = sc.nextInt();
    		sc.nextLine();
    		
    		String[] phoneNumbers = new String[N];
    		for (int i = 0; i < N; i++)
    			phoneNumbers[i] = sc.nextLine();
    		
    		Trie root = new Trie();
    		boolean isConsistent = true;
    		
    		for (int i = 0; i < N; i++) {
    			if (!insert(root, phoneNumbers[i])) {
    				isConsistent = false;
    				break;
    			}
    		}
    		
    		System.out.println(isConsistent ? "YES" : "NO");
    	}
    	
    }
    
    static boolean insert(Trie root, String phoneNumber) {
    	
    	Trie currNode = root;
    	
    	for (char ch : phoneNumber.toCharArray()) {
    		int num = ch - '0';
    		if (currNode.child[num] == null)
    			currNode.child[num] = new Trie();

    		currNode = currNode.child[num];
    		
    		// 123 1234
    		if (currNode.isEnd) return false;
    	}
    	
    	// 123 123
        if (currNode.isEnd) return false;
    	
    	currNode.isEnd = true;
    	
    	// 1234 123
    	for (Trie child : currNode.child)
    	    if (child != null) return false;
    	
    	return true;
    }
}