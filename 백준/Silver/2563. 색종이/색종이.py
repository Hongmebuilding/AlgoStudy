N = int(input())
arr = [[0 for _ in range(100)] for _ in range(100)]

for _ in range(N):
    w, l = map(int, input().split())
    for i in range (w-1, w-1+10):
        for j in range (l-1, l-1+10):
            arr[j][i] = 1

count = 0
for i in range(100):
    for j in range(100):
        if arr[j][i] == 1:
            count += 1
print(count)