import java.util.*;

class Solution {
    
    class Car {
        
        String number;
        int enterAt;
        int cum;
        int status;
        
        Car(String number, int enterAt, int cum) {
            this.number = number;
            this.enterAt = enterAt;
            this.cum = cum;
            this.status = 0;
        }
        
        void handle(String time, String command) {
            String[] hhmm = time.split(":");
            int min = Integer.parseInt(hhmm[0]) * 60 + Integer.parseInt(hhmm[1]);
            
            switch (command) {
                case "IN":
                    carIn(min);
                    break;
                case "OUT":
                    carOut(min);
            }
        }
        
        void carIn(int min) {
            enterAt = min;
            status = 1;
        }
        
        void carOut(int min) {
            cum += min - enterAt;
            status = 0;
        }
        
    }
    
    public int[] solution(int[] fees, String[] records) {
        Map<String, Car> cars = new HashMap<>();
        Queue<String> pq = new PriorityQueue<>();
        Map<String, Integer> prices = new HashMap<>();
        
        for (String record : records) {
            String[] log = record.split(" ");
            String number = log[1];
            
            cars.putIfAbsent(number, new Car(number, 0, 0));
            Car car = cars.get(number);
            
            car.handle(log[0], log[2]);
        }
        
        for (Car car : cars.values()) {
            if (car.status == 1) {
                car.cum += 1439 - car.enterAt;
            }
            
            double totalTime = Math.max(0, car.cum - fees[0]);
            int unitTime = (int) Math.ceil(totalTime / fees[2]);
            int price = fees[1] + unitTime * fees[3];
            
            prices.put(car.number, price);
            pq.add(car.number);
        }
        
        int index = 0;
        int[] result = new int[pq.size()];
        
        while (!pq.isEmpty()) {
            String number = pq.poll();
            result[index++] = prices.get(number);
        }
        
        return result;
    }
}