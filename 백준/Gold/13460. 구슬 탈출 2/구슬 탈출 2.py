from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
board = [list(input().strip()) for _ in range(n)]

def move(r, c, dr, dc):
    count = 0
    while True:
        nr, nc = r + dr, c + dc
        if not (0 <= nr < n and 0 <= nc < m):
            break
        if board[nr][nc] == '#':
            break
        r, c = nr, nc
        count += 1
        if board[r][c] == 'O':
            return (r, c, count, True)
    return (r, c, count, False)

def solution():
    dr = [0, 0, 1, -1]
    dc = [1, -1, 0, 0]

    for i in range(n):
        for j in range(m):
            if board[i][j] == 'R':
                rr, rc = i, j
            if board[i][j] == 'B':
                br, bc = i, j

    q = deque()
    q.append((rr, rc, br, bc, 0))
    visited = set()
    visited.add((rr, rc, br, bc))

    while q:
        rr, rc, br, bc, cnt = q.popleft()
        if cnt >= 10:
            return -1

        for i in range(4):
            nrr, nrc, r_dist, r_hole = move(rr, rc, dr[i], dc[i])
            nbr, nbc, b_dist, b_hole = move(br, bc, dr[i], dc[i])

            if b_hole:
                continue
            if r_hole:
                return cnt + 1

            if (nrr, nrc) == (nbr, nbc):
                if r_dist > b_dist:
                    nrr -= dr[i]
                    nrc -= dc[i]
                else:
                    nbr -= dr[i]
                    nbc -= dc[i]

            if (nrr, nrc, nbr, nbc) not in visited:
                visited.add((nrr, nrc, nbr, nbc))
                q.append((nrr, nrc, nbr, nbc, cnt + 1))

    return -1

print(solution())
