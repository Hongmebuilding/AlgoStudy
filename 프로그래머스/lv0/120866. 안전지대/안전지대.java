import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        int dangerZones = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    dangerZones++;
                    for (int[] d : dir) { // 8
                        int ni = i + d[0]; // 3 + 0
                        int nj = j + d[1]; // 2 + 0 즉, 좌표
                        if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length && board[ni][nj] != 1) {
                            board[ni][nj] = -1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1) {
                    dangerZones++;
                }
            }
        }

        answer = board.length * board[0].length - dangerZones;

        return answer;
    }
}
