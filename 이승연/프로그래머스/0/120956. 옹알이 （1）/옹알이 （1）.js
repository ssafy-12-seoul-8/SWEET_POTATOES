function solution(babbling) {
    const words = ["aya", "ye", "woo", "ma"];
    let answer = 0;
    
    for (let i = 0; i < babbling.length; i++) {
        let count = 0;
        let str = babbling[i];
        let visited = new Array(4).fill(0);
        
        while(count < 4) {
            for (let j = 0; j < words.length; j++) {
                if (visited[j] === 0 && str.indexOf(words[j]) === 0) {
                    str = str.replace(words[j], "");
                    visited[j] = 1;
                }
            }
            count++;
        }
        
        if (str.length === 0) {
            answer++;
        }
    }
    
    return answer;
}