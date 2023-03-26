from collections import deque

m, n = map(int, input().split())

tomatos = [list(map(int, input().split())) for _ in range(n)]

visited = [[False]*m for _ in range(n)]
queue = deque()

for i in range(n):
  for j in range(m):
    if tomatos[i][j] == 1:
      queue.append([i, j, 0])

di = [-1, 0, 1, 0]
dj = [0, 1, 0, -1]

answer = 0
while queue:
  i, j, cnt= queue.popleft()
  visited[i][j] = True

  for k in range(4):
    ni = i+di[k]
    nj = j+dj[k]

    if 0 <= ni < n and 0 <= nj < m:
      if not visited[ni][nj] and tomatos[ni][nj] == 0:
        tomatos[ni][nj] = 1
        queue.append([ni, nj, cnt+1])

  answer = cnt

zero = 0
for i in range(n):
  for j in range(m):
    if tomatos[i][j] == 0:
      zero += 1

if zero != 0:
  print(-1)
else:
  print(answer)
  