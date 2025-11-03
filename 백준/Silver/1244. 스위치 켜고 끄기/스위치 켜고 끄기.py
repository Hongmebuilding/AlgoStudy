N = int(input())
arr = list(map(int, input().split()))
ppl = int(input())


def change(n):
    if arr[n] == 0:
        arr[n] = 1
    else: arr[n] = 0

def changeWoman(index):
    move = 1
    change(index)
    while True:
        if 0 <= index - move and index + move <= N-1 and arr[index - move] == arr[index + move]:
            change(index-move)
            change(index+move)
            move += 1
        else: break

for _ in range(ppl):
    s, n = map(int, input().split())
    if s == 1:
        for i in range(N//n):
            change(n*(i+1)-1)
    else:
        changeWoman(n-1)

for i in range(0, N, 20):
    print(*arr[i:i+20])
