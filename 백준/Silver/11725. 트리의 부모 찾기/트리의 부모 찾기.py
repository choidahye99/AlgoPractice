from collections import deque

n = int(input())
graph = [[] for _ in range(n+1)]

for _ in range(n-1):
  a, b = map(int, input().split())
  graph[a].append(b)
  graph[b].append(a)

parents = [[] for _ in range(n+1)]

queue = deque()
queue.append(1)
visited = [False]*(n+1)

while queue:
  v = queue.popleft()
  visited[v] = True
  for i in graph[v]:
    if not visited[i]:
      parents[v].append(i)
      queue.append(i)

children = [[] for _ in range(n+1)]
for i in range(1, len(parents)):
  for j in parents[i]:
    children[j].append(i)
    
for i in range(2, n+1):
  print(children[i][0])