from collections import deque

def find_start_spot(i, j, maps):
    if maps[i][j] == 'S':
        return True
    return False

def find_lever(sx, sy, maps, dx, dy):
    queue = deque()
    visited = [[False]*len(maps[0]) for _ in range(len(maps))]
    
    queue.append([sx, sy, 0])
    visited[sx][sy] = True
    
    leverx = -1
    levery = -1
    count = -1
    
    while queue:
        nowx, nowy, cnt = queue.popleft()
        
        if maps[nowx][nowy] == 'L':
            leverx = nowx
            levery = nowy
            count = cnt
            break
        
        for i in range(4):
            nx = nowx+dx[i]
            ny = nowy+dy[i]
            
            if 0 <= nx < len(maps) and 0 <= ny < len(maps[0]) and not visited[nx][ny] and maps[nx][ny] != 'X':
                queue.append([nx, ny, cnt+1])
                visited[nx][ny] = True
                
    return [leverx, levery, count]   

def find_exit(x, y, maps, dx, dy):
    
    count = 0
    
    queue = deque()
    visited = [[False]*len(maps[0]) for _ in range(len(maps))]
    
    queue.append([x, y, count])
    visited[x][y] = True
    
    while queue:
        nowx, nowy, cnt = queue.popleft()
        
        if maps[nowx][nowy] == 'E':
            count = cnt
            break
        
        for i in range(4):
            nx = nowx+dx[i]
            ny = nowy+dy[i]
            
            if 0 <= nx < len(maps) and 0 <= ny < len(maps[0]) and not visited[nx][ny] and maps[nx][ny] != 'X':
                queue.append([nx, ny, cnt+1])
                visited[nx][ny] = True
    
    return count
            
    

def solution(maps):
    answer = 0
    ground = [['']*len(maps[0]) for _ in range(len(maps))]

    sx = -1
    sy = -1
    for i in range(len(maps)):
        for j in range(len(maps[i])):
            ground[i][j] = maps[i][j]
            if find_start_spot(i, j, maps):
                sx = i
                sy = j
    
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    nsx, nsy, answer = find_lever(sx, sy, maps, dx, dy)
    
    temp = find_exit(nsx, nsy, maps, dx, dy)
    
    if temp == 0:
        return -1
    else:
        answer += temp
    
    return answer