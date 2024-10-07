import java.util.*;

class Solution {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        val giveAndTake = Array(friends.size) { IntArray(friends.size) {0} }
        val friendsMap = mutableMapOf<String, Int>()
        val giftDegree = IntArray(friends.size)
        val received = IntArray(friends.size)
        
        for ((i, friend) in friends.withIndex()) {
            friendsMap[friend] = i
        }
        
        for (record in gifts) {
            val content = record.split(" ")
            val gived = friendsMap[content[0]]!!
            val received = friendsMap[content[1]]!!
            giveAndTake[gived][received]++
            giftDegree[gived]++
            giftDegree[received]--
        }
        
        for ((i, row) in giveAndTake.withIndex()) {
            for ((j, given) in row.withIndex()) {
                if (i == j) {
                    continue
                }
                
                if (given > giveAndTake[j][i]) {
                    received[i]++
                } else if (given < giveAndTake[j][i]) {
                    continue
                } else if (giftDegree[i] > giftDegree[j]) {
                    received[i]++
                } else if (giftDegree[j] < giftDegree[i]) {
                    received[j]++
                }
            }
        }
        
        return received.maxOrNull()!!
    }
}