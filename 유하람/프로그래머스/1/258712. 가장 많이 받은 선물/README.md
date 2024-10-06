# [level 1] 가장 많이 받은 선물 - 258712 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/258712) 

### 성능 요약

메모리: 97.3 MB, 시간: 13.00 ms

### 구분

코딩테스트 연습 > 2024 KAKAO WINTER INTERNSHIP

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2024년 10월 06일 16:32:15

### 문제 설명

<p>선물을 직접 전하기 힘들 때 카카오톡 선물하기 기능을 이용해 축하 선물을 보낼 수 있습니다. 당신의 친구들이 이번 달까지 선물을 주고받은 기록을 바탕으로 다음 달에 누가 선물을 많이 받을지 예측하려고 합니다.</p>

<ul>
<li>두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.

<ul>
<li>예를 들어 <code>A</code>가 <code>B</code>에게 선물을 5번 줬고, <code>B</code>가 <code>A</code>에게 선물을 3번 줬다면 다음 달엔 <code>A</code>가 <code>B</code>에게 선물을 하나 받습니다.</li>
</ul></li>
<li>두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.

<ul>
<li>선물 지수는 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값입니다.</li>
<li>예를 들어 <code>A</code>가 친구들에게 준 선물이 3개고 받은 선물이 10개라면 <code>A</code>의 선물 지수는 -7입니다. <code>B</code>가 친구들에게 준 선물이 3개고 받은 선물이 2개라면 <code>B</code>의 선물 지수는 1입니다. 만약 <code>A</code>와 <code>B</code>가 선물을 주고받은 적이 없거나 정확히 같은 수로 선물을 주고받았다면, 다음 달엔 <code>B</code>가 <code>A</code>에게 선물을 하나 받습니다.</li>
<li><strong>만약 두 사람의 선물 지수도 같다면 다음 달에 선물을 주고받지 않습니다.</strong></li>
</ul></li>
</ul>

<p>위에서 설명한 규칙대로 다음 달에 선물을 주고받을 때, 당신은 선물을 가장 많이 받을 친구가 받을 선물의 수를 알고 싶습니다.</p>

<p>친구들의 이름을 담은 1차원 문자열 배열 <code>friends</code> 이번 달까지 친구들이 주고받은 선물 기록을 담은 1차원 문자열 배열 <code>gifts</code>가 매개변수로 주어집니다. 이때, 다음달에 가장 많은 선물을 받는 친구가 받을 선물의 수를 return 하도록 solution 함수를 완성해 주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>2 ≤ <code>friends</code>의 길이 = 친구들의 수 ≤ 50

<ul>
<li><code>friends</code>의 원소는 친구의 이름을 의미하는 알파벳 소문자로 이루어진 길이가 10 이하인 문자열입니다.</li>
<li>이름이 같은 친구는 없습니다.</li>
</ul></li>
<li>1 ≤ <code>gifts</code>의 길이 ≤ 10,000

<ul>
<li><code>gifts</code>의 원소는 <code>"A B"</code>형태의 문자열입니다. <code>A</code>는 선물을 준 친구의 이름을 <code>B</code>는 선물을 받은 친구의 이름을 의미하며 공백 하나로 구분됩니다.</li>
<li><code>A</code>와 <code>B</code>는 <code>friends</code>의 원소이며 <code>A</code>와 <code>B</code>가 같은 이름인 경우는 존재하지 않습니다.</li>
</ul></li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>friends</th>
<th>gifts</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>["muzi", "ryan", "frodo", "neo"]</td>
<td>["muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"]</td>
<td>2</td>
</tr>
<tr>
<td>["joy", "brad", "alessandro", "conan", "david"]</td>
<td>["alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"]</td>
<td>4</td>
</tr>
<tr>
<td>["a", "b", "c"]</td>
<td>["a b", "b a", "c a", "a c", "a c", "c a"]</td>
<td>0</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<p>주고받은 선물과 선물 지수를 표로 나타내면 다음과 같습니다.</p>
<table class="table">
        <thead><tr>
<th>↓준 사람 \ 받은 사람→</th>
<th>muzi</th>
<th>ryan</th>
<th>frodo</th>
<th>neo</th>
</tr>
</thead>
        <tbody><tr>
<td>muzi</td>
<td>-</td>
<td>0</td>
<td>2</td>
<td>0</td>
</tr>
<tr>
<td>ryan</td>
<td>3</td>
<td>-</td>
<td>0</td>
<td>0</td>
</tr>
<tr>
<td>frodo</td>
<td>1</td>
<td>1</td>
<td>-</td>
<td>0</td>
</tr>
<tr>
<td>neo</td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>-</td>
</tr>
</tbody>
      </table><table class="table">
        <thead><tr>
<th>이름</th>
<th>준 선물</th>
<th>받은 선물</th>
<th>선물 지수</th>
</tr>
</thead>
        <tbody><tr>
<td>muzi</td>
<td>2</td>
<td>5</td>
<td>-3</td>
</tr>
<tr>
<td>ryan</td>
<td>3</td>
<td>1</td>
<td>2</td>
</tr>
<tr>
<td>frodo</td>
<td>2</td>
<td>2</td>
<td>0</td>
</tr>
<tr>
<td>neo</td>
<td>1</td>
<td>0</td>
<td>1</td>
</tr>
</tbody>
      </table>
<p><code>muzi</code>는 선물을 더 많이 줬던 <code>frodo</code>에게서 선물을 하나 받습니다.<br>
<code>ryan</code>은 선물을 더 많이 줬던 <code>muzi</code>에게서 선물을 하나 받고, 선물을 주고받지 않았던 <code>neo</code>보다 선물 지수가 커 선물을 하나 받습니다.<br>
<code>frodo</code>는 선물을 더 많이 줬던 <code>ryan</code>에게 선물을 하나 받습니다.<br>
<code>neo</code>는 선물을 더 많이 줬던 <code>muzi</code>에게서 선물을 하나 받고, 선물을 주고받지 않았던 <code>frodo</code>보다 선물 지수가 커 선물을 하나 받습니다.</p>

<p>다음달에 가장 선물을 많이 받는 사람은 <code>ryan</code>과 <code>neo</code>이고 2개의 선물을 받습니다. 따라서 2를 return 해야 합니다.</p>

<p><strong>입출력 예 #2</strong></p>

<p>주고받은 선물과 선물 지수를 표로 나타내면 다음과 같습니다.</p>
<table class="table">
        <thead><tr>
<th>↓준 사람 \ 받은 사람→</th>
<th>joy</th>
<th>brad</th>
<th>alessandro</th>
<th>conan</th>
<th>david</th>
</tr>
</thead>
        <tbody><tr>
<td>joy</td>
<td>-</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>0</td>
</tr>
<tr>
<td>brad</td>
<td>0</td>
<td>-</td>
<td>0</td>
<td>0</td>
<td>0</td>
</tr>
<tr>
<td>alessandro</td>
<td>1</td>
<td>1</td>
<td>-</td>
<td>1</td>
<td>1</td>
</tr>
<tr>
<td>conan</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>-</td>
<td>0</td>
</tr>
<tr>
<td>david</td>
<td>0</td>
<td>0</td>
<td>1</td>
<td>0</td>
<td>-</td>
</tr>
</tbody>
      </table><table class="table">
        <thead><tr>
<th>이름</th>
<th>준 선물</th>
<th>받은 선물</th>
<th>선물 지수</th>
</tr>
</thead>
        <tbody><tr>
<td>joy</td>
<td>0</td>
<td>1</td>
<td>-1</td>
</tr>
<tr>
<td>brad</td>
<td>0</td>
<td>1</td>
<td>-1</td>
</tr>
<tr>
<td>alessandro</td>
<td>4</td>
<td>1</td>
<td>3</td>
</tr>
<tr>
<td>conan</td>
<td>0</td>
<td>1</td>
<td>-1</td>
</tr>
<tr>
<td>david</td>
<td>1</td>
<td>1</td>
<td>0</td>
</tr>
</tbody>
      </table>
<p><code>alessandro</code>가 선물을 더 많이 줬던 <code>joy</code>, <code>brad</code>, <code>conan</code>에게서 선물을 3개 받습니다. 선물을 하나씩 주고받은 <code>david</code>보다 선물 지수가 커 선물을 하나 받습니다.<br>
<code>david</code>는 선물을 주고받지 않았던 <code>joy</code>, <code>brad</code>, <code>conan</code>보다 선물 지수가 커 다음 달에 선물을 3개 받습니다.<br>
<code>joy</code>, <code>brad</code>, <code>conan</code>은 선물을 받지 못합니다.</p>

<p>다음달에 가장 선물을 많이 받는 사람은 <code>alessandro</code>이고 4개의 선물을 받습니다. 따라서 4를 return 해야 합니다.</p>

<p><strong>입출력 예 #3</strong></p>

<p><code>a</code>와 <code>b</code>, <code>a</code>와 <code>c</code>, <code>b</code>와 <code>c</code> 사이에 서로 선물을 주고받은 수도 같고 세 사람의 선물 지수도 0으로 같아 다음 달엔 아무도 선물을 받지 못합니다. 따라서 0을 return 해야 합니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges