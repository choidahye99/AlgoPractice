from collections import deque
import sys
read = sys.stdin.readline

#bfs
def bfs(v):
  q = deque()
  q.append(v)
  visit_check[v] = 1
  while q:
    v = q.popleft()
    print(v, end=" ")
    for i in range(1, n+1):
      if visit_check[i] == 0 and graph[v][i] == 1:
        q.append(i)
        visit_check[i] = 1

#dfs
def dfs(v):
  visit_check2[v] = 1
  print(v, end = " ")
  for i in range(1, n+1):
    if visit_check2[i] == 0 and graph[v][i] == 1:
      dfs(i)

n, m, v = map(int, read().split())

graph = [[0]*(n+1) for _ in range(n+1)]
visit_check = [0] * (n+1)
visit_check2 = [0] * (n+1)

for i in range(m):
  a, b = map(int, read().split())
  graph[a][b] = graph[b][a] = 1

dfs(v)
print()
bfs(v)