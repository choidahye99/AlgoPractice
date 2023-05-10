T = int(input())

for tc in range(1, T+1):
  n, k = map(int, input().split())

  array = []
  for i in range(n):
    mid, last, hw = map(int, input().split())
    total = mid*0.35 + last*0.45 + hw*0.2
    array.append(total)

  record = array[k-1]

  score = 1
  for i in range(n):
    if array[i] > record:
      score += 1

  gradedivisor = n/10

  gradecnt = 0
  while(score > 0):
    score -= gradedivisor
    gradecnt += 1

  result = ['A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']

  print(f'#{tc} {result[gradecnt-1]}')
  # print(f'#{tc} {answer}')