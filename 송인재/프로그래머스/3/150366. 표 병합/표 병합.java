import java.util.*;

class Solution {
    int[] rep;
    String[] values;
    
    public String[] solution(String[] commands) {
        rep = new int[50 * 50];
        values = new String[50 * 50];
        List<String> answerList = new ArrayList<>();
        
        for (int i = 0; i < rep.length; i++) {
            rep[i] = i;
        }
        
        for (String command : commands) {
            String result = handleCommand(command);
            
            if (result != null) {
                answerList.add(result);
            }
        }
        
        String[] answer = new String[answerList.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    String handleCommand(String command) {
        String[] parts = command.split(" ");
        String action = parts[0];
        
        switch (action) {
            case "UPDATE":
                if (parts.length == 3) {
                    updateAll(parts[1], parts[2]);
                    break;
                }
                
                int index = getIndex(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                
                updateOne(index, parts[3]);
                break;
            case "MERGE":
                int x = getIndex(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                int y = getIndex(Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
                
                union(x, y);
                
                break;
            case "UNMERGE":
                x = getIndex(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                
                unmerge(x);
                break;
            case "PRINT":
                index = getIndex(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                
                
                return print(index);
        }
        
        return null;
    }
    
    int getIndex(int row, int col) {
        return (row - 1) * 50 + col - 1;
    }
    
    void updateOne(int x, String value) {
        int repX = find(x);
        
        values[repX] = value;
    }
    
    void updateAll(String value1, String value2) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == null) {
                continue;
            }
            
            if (values[i].equals(value1)) {
                values[i] = value2;
            }
        }
    }
    
    int find(int x) {
        if (rep[x] != x) {
            rep[x] = find(rep[x]);
        }
        
        return rep[x];
    }
    
    void union(int x, int y) {
        int repX = find(x);
        int repY = find(y);
        
        if (repX == repY) {
            return;
        }
        
        rep[repY] = repX;
        
        if (values[repX] != null) {
            return;
        }
        
        if (values[repY] != null) {
            values[repX] = values[repY];
        }
    }
    
    void unmerge(int x) {
        int repX = find(x);
        String repValue = values[repX];
        
        for (int i = 0; i < rep.length; i++) {
            find(i);
        }
        
        for (int i = 0; i < rep.length; i++) {
            if (find(i) == repX) {
                rep[i] = i;
                values[i] = null;
            }
        }
        
        if (repValue != null) {
            values[x] = repValue;
        }
    }
    
    String print(int x) {
        int repX = find(x);
        
        return values[repX] == null ? "EMPTY" : values[repX];
    }
}