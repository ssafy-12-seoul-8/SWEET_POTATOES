# [Silver I] 쿼드 트리 - 6576 

[문제 링크](https://www.acmicpc.net/problem/6576) 

### 성능 요약

메모리: 122008 KB, 시간: 168 ms

### 분류

분할 정복, 재귀

### 제출 일자

2025년 3월 22일 11:14:40

### 문제 설명

<p>고대 아즈텍 문명의 유적지에서 보물을 찾던 한신이는 긴 문장이 적혀있는 파피루스 두루마리를 우연히 발견하게 되었다. 그 종이의 문장들은 <em>B </em>와 <em>W</em> 그리고 <em>Q</em>처럼 생긴 3가지의 다른 문자로만 이루어져있었다.</p>

<p>암호학을 조금이나마 배웠던 한신이는 이 코드가 3000년전에 만들어진 아주 유명한 쿼드 트리 암호 구조라는 것을 알게되었다.</p>

<p>쿼드 트리 암호화를 이용하면 비밀스러운 그림이나 사진 (보물지도 같은)등을 다음과 방식을 이용하여 암호화 할수 있다. 만약에 그림 전체가 검은색이라면 <em>B</em>로, 만약 흰색이라면 <em>W</em>로 변환하고 검은부분과 흰부분이 같이 있다면 그림을 <em>Qxxxx</em>형식으로 x를 4개의 부분으로 재귀적으로 쪼개서 변환한다. (왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 순으로) 아즈텍 문명은 모든 그림은 2차 형식의 <em>n*n </em>픽셀로 되어 있으며 이때 <em>n</em>은 2의 제곱수이며 완벽한 쿼드 트리 구조로만 구성되어 있다.</p>

<p>예를들어 2*2 체스판을 암호화 하면 QWBBW로 나타낼 수 있으며, 4*4 체스판은 QQWBBWQWBBWQWBBWQWBBW으로 나타낼 수 있다.</p>

<p>자! 이제 우리 한신이가 이 쿼드 트리 문자열을 XBM 형식의 파일로 만들수 있도록 해독하는 프로그램을 작성해주시기 바랍니다.</p>

### 입력 

 <p>첫 번째 줄에는 정수 <em>n</em> (8 <= <em>n</em> <= 512)을 입력 받고 이 값은 행과 열의 픽셀 크기를 의미하며 <em>n</em>은 무조건 2의 제곱수로 입력된다.</p>

<p>두 번째 줄에는 B와 W, Q로만 이루어진 문자열이 입력되며 이 문자열은 사진을 쿼드 트리 구조의 <em>n</em>*<em>n 픽셀들로 암호화한 것이다.</em></p>

### 출력 

 <ul>
	<li>첫 번째 줄에는 "#define quadtree_width <em>n</em>"로 출력 되어야 하며 여기서 n은 가로 픽셀 크기를 의미한다. (이 사진은 <em>n*n </em>픽셀이다.)</li>
	<li>두 번째 줄에는 "#define quadtree_height <em>n</em>"로 출력 되는데 여기서 n은 세로 픽셀 크기를 의미한다.</li>
	<li>세 번째 줄에는 "static char quadtree_bits[] = {"가 출력된다.</li>
	<li>그리고 다음 n줄에는 사진 한줄의 픽셀값이 <em>n/8</em>개의 헥사값로 변환되어 출력된다.<br>
	<br>
	각 헥사값은 8비트로 8개의 픽셀이 왼쪽에서 오른쪽으로 변환되어 구성된다. (가장 왼쪽 비트 값은 1이고 맨 오른쪽 비트값은 128이다.) 이 헥사값은 0x<em>dd</em>형식으로 입력이 되며 여기서 d는 { 0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f }중 하나이다.<br>
	<br>
	예시 : 8 픽셀의 WBBBBWWB는 0x9e로 쓰인다.<br>
	(2+4+8+16+128 = 158 = 0x9e) 각 헥사값은 콤마(,)로 구분된다.</li>
</ul>

<ul>
	<li>마지막 줄은 "};"가 출력된다.</li>
</ul>

