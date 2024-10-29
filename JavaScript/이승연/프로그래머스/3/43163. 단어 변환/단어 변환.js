let min = Number.MAX_SAFE_INTEGER;

function solution(begin, target, words) {
    const map = {};
    
    words.push(begin);
    
    for (let i = 0; i < words.length; i++) {
        map[words[i]] = [];
        
        for (let j = 0; j < words.length; j++) {
            let count = 0;
            
            for (let k = 0; k < words[j].length; k++) {
                
                if (words[i][k] == words[j][k]) {
                    count++;
                }
            }
            
            if (count == (words[i].length - 1) && words[j] !== begin) {
                map[words[i]].push([words[j], 0]);
            }
        }
    }
    
    bfs(begin, target, map, 0);
    
    return min === Number.MAX_SAFE_INTEGER ? 0 : min;
}

function bfs(word, target, map, count) {
    if (word === target) {
        min = Math.min(min, count);
        // console.log(min);
        return;
    }
    
    if (count >= min) {
        return;
    }
    
    for (let i = 0; i < map[word].length; i++) {
        if (map[word][i][1] === 0) {
            map[word][i][1] = 1;
            bfs(map[word][i][0], target, map, count + 1);
            map[word][i][1] = 0;
        }
    }
}