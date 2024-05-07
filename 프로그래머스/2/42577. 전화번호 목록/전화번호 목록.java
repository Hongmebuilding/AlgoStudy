import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 정렬하여 접두사 체크 효율성 높임
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}