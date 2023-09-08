def convert(n, k):
    BASE = "0123456789ABCDEF"
    
    div, mod = divmod(n, k)
    if div == 0:
        return BASE[mod]
    
    return convert(div, k) + BASE[mod]


def prime_check(x):
    
    if x == 1:
        return False
    
    for i in range(2, int(x**0.5)+1):
        if x % i == 0:
            return False
    
    return True


def solution(n, k):
    answer = 0
    
    print(convert(n, k))
    arr = list(convert(n, k).split('0'))
    print(arr)
    
    nums = []
    for num in arr:
        if num == '':
            continue
        
        nums.append(int(num))
    
    print(nums)
    
    for num in nums:
        if prime_check(num):
            answer += 1
            
    return answer