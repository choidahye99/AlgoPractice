def solution(s):
    answer = []
    
    s = s.replace('{', '').replace('}', '')
    
    temp = list(map(int, s.split(',')))
    
    cnt = dict()
    for i in temp:
        if i in cnt:
            cnt[i] += 1
        else:
            cnt[i] = 1
    
    cnt = sorted(cnt.items(), key=lambda x: x[1], reverse=True)
    
    for i, enum in enumerate(cnt):
        answer.append(enum[0])
            
    return answer