n = int(input()) #센서의 개수
k = int(input()) #집중국의 개수

sensor = list(map(int, input().split()))

sensor.sort()

length = []
for i in range(n-1):
  length.append(sensor[i+1] - sensor[i])

length.sort()

sum = 0
for i in range(len(length)-(k-1)):
  sum += length[i]

print(sum)