import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int[] count = new int[friends.length];
        HashMap<String, Friend> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer("");
        
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], new Friend(friends[i], friends));
        }
        
        for (int i = 0; i < gifts.length; i++) {
            st = new StringTokenizer(gifts[i]);
            String A = st.nextToken();
            String B = st.nextToken();
            
            HashMap<String, Integer> Amap = map.get(A).record;
            
            if (Amap.get(B) == null) {
                Amap.put(B, 1);
            } else {
                Amap.put(B, (Amap.get(B) + 1));
            }
            
            map.get(A).giveCount++;
            map.get(B).getCount++;
        }
        
        int answer = 0;
        
        // 선물을 주고 받은 기록이 있을 때
            // 선물을 주고 받은 수가 같을 때
                // 선물 지수가 같을 때 선물을 주고 받지 않음
                // 선물 지수가 큰 사람이 선물 지수가 작은 사람에게 선물 받기
            // 선물을 주고 받은 수가 같지 않을 때
                // 두 사람 중 더 많은 선물을 준 사람이 다음달에 선물을 받음
        // 선물을 주고 받은 기록이 없을 때
            // 선물 지수가 같을 때 선물을 주고 받지 않음
            // 선물 지수가 큰 사람이 선물 지수가 작은 사람에게 선물 받기
        
        for (int i = 0; i < friends.length; i++) {
            HashMap <String, Integer> friendMap = map.get(friends[i]).record;
            Iterator KeySetIterator = friendMap.keySet().iterator();
            
            while(KeySetIterator.hasNext()) {
                String key = KeySetIterator.next().toString();
                
                int Acount = friendMap.get(key);
                int Bcount = map.get(key).record.get(friends[i]);
                
                int A = map.get(friends[i]).giveCount - map.get(friends[i]).getCount;
                int B = map.get(key).giveCount - map.get(key).getCount;
                
                System.out.println(friends[i] + Acount + " " + key + Bcount);
                
                if (Acount != 0 || Bcount != 0) {
                    if (Acount == Bcount) {
                        if (A != B) {
                            if (A < B) {
                                int idx = Arrays.asList(friends).indexOf(key);
                                count[idx] += 1;
                            }
                            else {
                                count[i] += 1;
                            }
                        }
                    } else {
                        if (Acount < Bcount) {
                            int idx = Arrays.asList(friends).indexOf(key);
                            count[idx] += 1;
                        } else {
                            count[i] += 1;
                        }
                    }
                } else {
                    if (A != B) {
                        if (A < B) {
                            int idx = Arrays.asList(friends).indexOf(key);
                            count[idx] += 1;
                        }
                        else {
                            count[i] += 1;
                        }
                    }
                }
                
                map.get(key).record.remove(friends[i]);
            }
            
        }
        
        for (int i = 0; i < count.length; i++) {
            answer = Math.max(answer, count[i]);
        }
        
        return answer;
    }
}

class Friend {
    int giveCount; // 준 선물 수
    int getCount; // 받은 선물 수
    HashMap<String, Integer> record; // 선물을 준 목록
    
    Friend(String friend, String[] friends) {
        giveCount = 0;
        getCount = 0;
        HashMap<String, Integer> newRecord = new HashMap<>();
        
        for (int i = 0; i < friends.length; i++) {
            if (!friends[i].equals(friend)) {
                newRecord.put(friends[i], 0);
            }
        }
        
        record = newRecord;
    }
}