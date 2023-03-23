import sys
sys.setrecursionlimit(10000)

def dfs(ground, visited, i, j, w, h):
    visited[i][j] = True

    di = [-1, -1, 0, 1, 1, 1, 0, -1]
    dj = [0, 1, 1, 1, 0, -1, -1, -1]

    for k in range(8):
        ni = i+di[k]
        nj = j+dj[k]

        if 0 <= ni < h and 0 <= nj < w:
            if not visited[ni][nj] and ground[ni][nj] == 1:
                dfs(ground, visited, ni, nj, w, h)



while True:
    w, h = map(int, input().split())

    if w == 0 and h == 0:
        break

    ground = [list(map(int, input().split())) for _ in range(h)]

    visited = [[False]*w for _ in range(h)]

    cnt = 0 #섬의 개수
    for i in range(h):
        for j in range(w):
            #아직 탐색하지 않은 섬이라면
            if not visited[i][j] and ground[i][j] == 1:
                dfs(ground, visited, i, j, w, h)
                cnt += 1

    print(cnt)