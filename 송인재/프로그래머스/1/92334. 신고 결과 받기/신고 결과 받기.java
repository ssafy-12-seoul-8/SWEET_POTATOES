import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reports = new HashMap<>();
        Map<String, Integer> reported = new HashMap<>();
        int[] result = new int[id_list.length];
        
        for (String id : id_list) {
            reports.put(id, new HashSet<>());
            reported.put(id, 0);
        }
        
        for (String reporting : report) {
            String[] targets = reporting.split(" ");
            String reporter = targets[0];
            String reportee = targets[1];
            
            boolean added = reports.get(reporter)
                .add(reportee);
            
            if (added) {
                reported.put(reportee, reported.get(reportee) + 1);
            }
        }
        
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            
            for (String reportee : reports.get(id)) {
                if (reported.get(reportee) >= k) {
                    result[i]++;
                }
            }
        }
        
        return result;
    }
}