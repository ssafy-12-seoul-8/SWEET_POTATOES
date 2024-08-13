function solution(prices) {
    const answer = [];
    
    for (let i = 0; i < prices.length; i++) {
        let stack = 0;
        for (let j = i + 1; j < prices.length; j++) {
            stack++;
            if (prices[i] > prices[j]) {
                break;
            }
        }
        answer.push(stack);
    }
    
    return answer;
}