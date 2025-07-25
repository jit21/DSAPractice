import java.util.*;

public class LongestRegularBracketSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();

        Stack<Integer> stack = new Stack<>();
        int maxLen = 0;
        int count = 0;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    int openIndex = stack.pop();
                    int currentLen = i - openIndex + 1;

                    if (openIndex > 0) {
                        currentLen += dp[openIndex - 1]; // Merge with previous valid
                    }

                    dp[i] = currentLen;

                    if (currentLen > maxLen) {
                        maxLen = currentLen;
                        count = 1;
                    } else if (currentLen == maxLen) {
                        count++;
                    }
                }
            }
        }

        if (maxLen == 0) {
            System.out.println("0 1");
        } else {
            System.out.println(maxLen + " " + count);
        }
    }
}
