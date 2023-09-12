def solution(cacheSize, cities):
    answer = 0
    cache = []
    
    if cacheSize == 0:
        return len(cities)*5
    
    for city in cities:
        if city.lower() in cache:
            cache.remove(city.lower())
            cache.append(city.lower())
            answer += 1
        else:
            if len(cache) == cacheSize: cache.pop(0)
            cache.append(city.lower())
            answer += 5
            
    return answer