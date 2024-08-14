function solution(players, callings) {
    const data = {};
    
    for (let i = 0; i < players.length; i++) {
        data[players[i]] = i;
    }
    
    for (let i = 0; i < callings.length; i++) {
        const backPlayer = callings[i];
        const frontPlayer = players[data[backPlayer] - 1];
        
        const backIndex = data[backPlayer] - 1;
        const frontIndex = data[frontPlayer] + 1;
        
        data[backPlayer] = backIndex;
        data[frontPlayer] = frontIndex;
        
        players[backIndex] = backPlayer;
        players[frontIndex] = frontPlayer;
    }
    
    return players;
}