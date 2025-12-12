# Java Algorithm

---

## 배열 문제

### 가장 많이 등장하는 가장 작은 수 문제

- 풀이 : programmers/Q201393
- 문제 : 배열에서 가장 많이 등장하는 정수를 1차 정렬, 그 중 가장 작은 정수를 리턴하는 문제
1. 가장 많은 빈도를 구하기 위해 HashMap<Integer, Integer> 으로 중복을 제거하고, 카운팅을 값으로 저장
2. 정렬을 사용하기 위해 index 배열을 만든다.
3. 2차원 배열을 사용해 정렬하고자 하는 배열의 값을 순서쌍의 형태로 저장한다. 
4. index[] 배열에 주어진 배열의 값을 넣어준다.
5. Arrays.sort 함수를 사용하여 1차로 map의 value 값을 비교하여 빈도수를 정렬하고, 2차로 key 값을 비교하여 정렬한다.

<br />

### 반 별 점수의 합 구하기

- 풀이 : programmers/Q201394
- 문제 : 반 별로 점수를 합산한 후 반의 번호에 대해 오름차순으로 정렬하는 문제

HashMap 문제풀이
1. HashMap 으로 반 별 점수를 모두 합한다.
2. 2차원 배열을 만들 때 HashMap 의 키, 값을 넣어준다.
3. 2차원 배열을 정렬한다.

TreeMap 문제풀이
1. HashMap 으로 반 별 점수를 모두 합한다.
2. 2차원 배열을 만들 때 HashMap 의 키, 값을 넣어준다.

* treeMap 은 key 를 오름차순으로 정렬하여 값을 갖고 있다.

<br />

### 구성이 같은 문자열

- 풀이 : programmers/Q201395
- 문제 : 구성이 같은 문자열이 같을 때 하나읨 문자열이 다른 문자열을 포함하는지 여부를 푸는 문제

HashSet 문제풀이
- HashSet 은 요소 내용을 기준으로 동등성을 비교함 (equals(), hashCode())

1. HashSet<HashSet<Character>> set1 = new HashSet<>(); 을 만들어줌
2. strs1 의 배열 요소 당 HashSet 1개씩을 character 배열을 같는 HashSet 을 만듬
3. strs2 도 같은 방식으로 strs2 의 요소마다 HashSet 을 만들어준 후 
4. set1.contains(set2) 처럼 contains 함수로 요소의 동등성을 비교한 후 조건의 일치여부에 따라 답을 생성

<br />

## Stack 문제

- 풀이 : programmers/Q201398
- 문제 : 후위 연산식 계산하기

문제풀이
- 중위표기식 : 숫자 사이에 연산식이 들어가있는 식 ( 3 + 5 )
- 후위표기식 : 숫자 뒤에 연산식이 들어가있는 식 ( 3 5 + )

1. 연산을 하기 위한 Stack<Integer> 를 생성한다.
2. +, -, * 인 경우 연산을 수행할 함수를 작성한다.
3. 숫자인 경우 stack.push(), 연산자인 경우 stack.pop() 을 통해 숫자를 꺼낸다.
4. 연산식 수행 후 결과값을 stack.push() 한다.