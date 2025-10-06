import java.util.*;

class Solution {

  int initLength;
  Set<Integer> needs;
  Set<Integer> picked;
  Set<Integer> needsFromPicked;
  int canSubmit;
  int max;
  int coin;
  int[] cards;

  public int solution(int coin, int[] cards) {
    initLength = cards.length / 3;
    needs = new HashSet<>();
    picked = new HashSet<>();
    needsFromPicked = new HashSet<>();
    canSubmit = 0;
    max = 0;
    this.coin = coin;
    this.cards = cards;
      
    for (int i = 0; i < initLength; i++) {
      if (needs.contains(cards[i])) {
        needs.remove(cards[i]);
          
        canSubmit++;
          
        continue;
      }
        
      int need = cards.length + 1 - cards[i];
        
      needs.add(need);
    }
      
    runRound(1, initLength);
      
    return max;
  }

  void runRound(int round, int index) {
    max = round;
      
    if (index >= cards.length) {
      return;
    }
      
    handleNum(cards[index]);
    handleNum(cards[index + 1]);
      
    if (canSubmit > 0) {
      canSubmit--;
        
      runRound(round + 1, index + 2);
        
      return;
    }
      
    if (coin < 2) {
      return;
    }
      
    useTwoCoins();
      
    if (canSubmit > 0) {
      canSubmit--;
        
      runRound(round + 1, index + 2);
    }
  }

  void handleNum(int num) {
    if (!needs.contains(num)) {
      picked.add(num);
      needsFromPicked.add(cards.length + 1 - num);
        
      return;
    }
      
    if (coin < 1) {
      return;
    }
      
    needs.remove(num);
      
    canSubmit++;
    coin--;
  }

  void useTwoCoins() {
    for (int pick : picked) {
      if (!needsFromPicked.contains(pick)) {
        continue;
      }
        
      needsFromPicked.remove(pick);
      needsFromPicked.remove(cards.length + 1 - pick);
        
      canSubmit++;
      coin -= 2;
        
        return;
    }
  }

}