from collections import deque

n, k = map(int, input().split())

queue = deque()

queue.append([n, 0])
visited = [False]*(100001)

answer = 0
while queue:
  n, cnt = queue.popleft()
  visited[n] = True

  if n == k:
    answer = cnt
    break

  
    
  if n-1 >= 0 and not visited[n-1]:
    queue.append([n-1, cnt+1])
  if n+1 <= 100000 and not visited[n+1]:
    queue.append([n+1, cnt+1])
  if n*2 <= 100000 and not visited[n*2]:
    queue.append([n*2, cnt+1])


print(answer)