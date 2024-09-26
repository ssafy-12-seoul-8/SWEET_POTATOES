import java.util.*;

class Solution {
    class Job(val start: Int, val process: Int)
    
    fun solution(jobs: Array<IntArray>): Int {
        var estimatedEnd = 0
        var total = 0
        val pq = PriorityQueue<Job>( compareBy { it.process } )
        
        jobs.sortWith( compareBy<IntArray> { it[0] }.thenBy { it[1] } )
        
        for (job in jobs) {
            while (!pq.isEmpty() && estimatedEnd < job[0]) {
                val working = pq.poll()
                estimatedEnd = Math.max(estimatedEnd, working.start) + working.process
                total += estimatedEnd - working.start
            }
            
            pq.add(Job(job[0], job[1]))
        }
        
        while (!pq.isEmpty()) {
            val working = pq.poll()
            estimatedEnd = Math.max(estimatedEnd, working.start) + working.process;
            total += estimatedEnd - working.start;
        }
        
        return total / jobs.size
    }
}