import sys
sys.setrecursionlimit(10**6)

def dfs(i, j, n, rain):
  visited[i][j] = True

  di = [-1, 0, 1, 0]
  dj = [0, 1, 0, -1]

  for k in range(4):
    ni = i+di[k]
    nj = j+dj[k]

    if 0 <= ni < n and 0 <= nj < n:
      if not visited[ni][nj] and ground[ni][nj] > rain:
        dfs(ni, nj, n, rain)
        

  

n = int(input())

ground = [list(map(int, input().split())) for _ in range(n)]

maxheigh = 0
for i in range(n):
  maxheigh = max(maxheigh, max(ground[i]))


safegroundcnt = 0
for rain in range(0, maxheigh+1):
  visited = [[False]*n for _ in range(n)]
  temp = 0
  for i in range(n):
    for j in range(n):
      if not visited[i][j] and ground[i][j] > rain:
        dfs(i, j, n, rain)
        temp +=1

  safegroundcnt = max(safegroundcnt, temp)

print(safegroundcnt)