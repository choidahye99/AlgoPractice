n = int(input())

arr = []
arr2 = []
for i in range(1, n+1):
  arr.append(int(input()))
  arr2.append(i)

arr.sort()

sum = 0
for i in range(len(arr)):
  sum += abs(arr[i]-arr2[i])

print(sum)