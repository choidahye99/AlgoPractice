def convert(n, base): #n : 나눌 수, base : 변환할 진법
    
    BASE = "0123456789ABCDEF"
    
    div, mod = divmod(n, base)
    
    if div == 0:
        return BASE[mod]
    else:
        return convert(div, base) + BASE[mod] 
    

def solution(n, t, m, p):
    answer = ''
    arr = []
    
    for i in range(t*m):
        conv = convert(i, n)
        for c in conv:
            arr.append(c)
            
    for i in range(p-1, t*m, m):
        answer += arr[i]
    
    return answer