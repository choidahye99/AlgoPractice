def numIntersection(A, B):
    n = 0   # A와 B의 교집합 원소 개수
    # A의 원소 개수 <= B의 원소 개수
    for x in set(A):
        if x in B:  # x가 A와 B 모두에 속하는 경우
            n += min(A.count(x), B.count(x))
    return n;

def solution(str1, str2):
    answer = 0
    # 모든 문자열을 소문자로 바꾸고 다중집합 생성
    str1 = str1.lower()
    str2 = str2.lower()
    A, B = [], []
    for i in range(len(str1) - 1):
        # 영문자인 경우에만 다중집합의 원소로 포함
        if str1[i].isalpha() and str1[i + 1].isalpha():
            A.append(str1[i] + str1[i + 1])
    for i in range(len(str2) - 1):
        if str2[i].isalpha() and str2[i + 1].isalpha():
            B.append(str2[i] + str2[i + 1])
    # A, B 모두가 공집합인 경우 자카드 유사도는 1
    if (not A) and (not B): return 65536
    # 교집합 원소의 개수 구하기
    n = numIntersection(A, B) if len(A) < len(B) else numIntersection(B, A)
    answer = n / (len(A) + len(B) - n)

    return int(answer*65536)