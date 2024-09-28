# [Gold IV] 암벽 등반 - 2412 

[문제 링크](https://www.acmicpc.net/problem/2412) 

### 성능 요약

메모리: 35304 KB, 시간: 520 ms

### 분류

너비 우선 탐색, 자료 구조, 그래프 이론, 그래프 탐색, 해시를 사용한 집합과 맵

### 제출 일자

2024년 9월 29일 01:20:50

### 문제 설명

<p>A rockslide has trapped Bessie in her cave, and she must scale a vertical rock wall if she is to escape!  Happily, Bessie is an accomplished rock climber.</p>

<p>Think of the rock wall as a two-dimensional plane, with an x (horizontal) and z (vertical) axis.  Bessie starts with her left front hoof at (0,0), and she needs to climb to the top of the wall, at z = T (1 <= T <= 200,000).</p>

<p>The wall has N (1 <= N <= 50,000) rocks that stick out and provide hoofholds for Bessie.  If Bessie is currently holding on to one of these hoofholds with her left front hoof, she can reach a new hoofhold only if it is at most 2 units away in its x coordinate and also at most 2 units away in its z coordinate from her current hold. Note that Bessie can move to a hoofhold above, beside, or below her, as long as its x and z coordinates are both within 2 units of her current hoofhold. When she moves, her front left hoof ends up on the new hoofhold.</p>

<p>Help Bessie determine if she can scale the wall (that is, if she can reach any hoofhold at height T), and if so, the minimum number of hoofholds she must use.</p>

### 입력 

 <ul>
	<li>Line 1: Two space-separated integers: N and T</li>
	<li>Lines 2..N+1: Each line contains two space-separated integers that represent the (x,z) coordinates of a hoofhold.  Each x coordinate will be in the range 0 .. 1,000,000, and each z coordinate will be in the range 0 .. T.  The initial foothold (0,0) does not appear in this list.</li>
</ul>

### 출력 

 <ul>
	<li>Line 1: The minimum number of steps required to reach the top or -1 if it is  impossible to reach the top.  The initial hoofhold at (0,0) does not  count as a step.</li>
</ul>

