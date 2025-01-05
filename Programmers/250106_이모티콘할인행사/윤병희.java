import java.util.*;

class Solution {
    static int[] percents = {10, 20, 30, 40};
    static List<int[]> result = new ArrayList<>();
    static int[] emoticonPercent;
    static int[] emoticons;
    static int[][] users;

    public int[] solution(int[][] inputUsers, int[] inputEmoticons) {
        emoticons = inputEmoticons;
        users = inputUsers;
        emoticonPercent = new int[emoticons.length];

        recursion(0);
      // 결과값
        int[] resultValue = result.stream()
            .max((a, b) -> {
                if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            })
            .get();

        return new int[] {resultValue[0], resultValue[1]};
    }
//재귀
    static void recursion(int emoticonIndex) {
        if (emoticonIndex >= emoticons.length) {
          //판단호출
            judge();
            return;
        }

        for (int percent : percents) {
            emoticonPercent[emoticonIndex] = percent;
            recursion(emoticonIndex + 1);
        }
    }

  //판단함수
    static void judge() {
        int[] total = {0, 0};

        for (int[] user : users) {
            int purposePercent = user[0];
            int spendPrice = user[1];
            int userPrice = 0;

            for (int i = 0; i < emoticonPercent.length; i++) {
                if (emoticonPercent[i] >= purposePercent) {
                    userPrice += emoticons[i] * (100 - emoticonPercent[i]) / 100;
                }
            }

            if (userPrice >= spendPrice) {
                total[0]++;
            } else {
                total[1] += userPrice;
            }
        }

        result.add(total);
    }
}
