def solution(record):
    answer = []
    sts = []
    states = {}
    
    for rec in record:
        temp = list(rec.split())
        
        if temp[0] == 'Enter':
            states[temp[1]] = temp[2]
            sts.append([temp[1], "님이 들어왔습니다."])
        elif temp[0] == 'Leave':
            sts.append([temp[1], "님이 나갔습니다."])
        else:
            states[temp[1]] = temp[2]
        
    for id, state in sts:
        total = states[id] + state
        
        answer.append(total)
    
    return answer