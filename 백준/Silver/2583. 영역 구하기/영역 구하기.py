import sys
sys.setrecursionlimit(10**6)

def dfs(i, j, n, m):
  global cnt
  visited[i][j] = True
  cnt += 1

  di = [-1, 0, 1, 0]
  dj = [0, 1, 0, -1]

  for k in range(4):
    ni = i+di[k]
    nj = j+dj[k]

    if 0<=ni<n and 0<=nj<m:
      if not visited[ni][nj] and graph[ni][nj] == 0:
        dfs(ni, nj, n, m)

n, m, k = map(int, input().split())

graph = [[0]*m for _ in range(n)]

for _ in range(k):
  x1, y1, x2, y2 = map(int, input().split())
  for i in range(y1, y2):
    for j in range(x1, x2):
      graph[i][j] = 1


visited = [[False]*m for _ in range(n)]

answer = []
ground = 0
global cnt
for i in range(n):
  for j in range(m):
    cnt = 0
    if not visited[i][j] and graph[i][j] == 0:
      dfs(i, j, n, m)
      answer.append(cnt)
      ground += 1


print(ground)
print(*sorted(answer))
    