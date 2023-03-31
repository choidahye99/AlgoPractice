from collections import deque

n = int(input())

graph = [[] for _ in range(n)]

for i in range(n):
  vlist = list(map(int, input().split()))
  for j in range(n):
    if vlist[j] == 1:
      graph[i].append(j)

answer = [[0]*n for _ in range(n)]

for i in range(n):
  for j in range(n):
  
    queue = deque()
    visited = [False]*n
    queue.append(i)
    
    while queue:
      v = queue.popleft()
      visited[v] = True
      if j in graph[v]:
        answer[i][j] = 1
        break
      
      for k in graph[v]:
        if not visited[k]:
          queue.append(k)

      
for row in answer:
    for col in row:
        print(col, end = " ")
    print()