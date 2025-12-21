import sys

N = int(sys.stdin.readline())
R, G, B = 0,1,2
cost = []
for i in range(N):
    cost += [list(map(int, input().split()))] # r,g,b

dp = [[0]*3 for _ in range(N)]
for i in range(N):
    dp[i][R] =  cost[i][R] + min(dp[i-1][G], dp[i-1][B])
    dp[i][G] =  cost[i][G] + min(dp[i-1][R], dp[i-1][B])
    dp[i][B] =  cost[i][B] + min(dp[i-1][R], dp[i-1][G])
    
print(min(dp[N-1]))